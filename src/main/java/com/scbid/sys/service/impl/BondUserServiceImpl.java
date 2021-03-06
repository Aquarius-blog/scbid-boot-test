package com.scbid.sys.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.bond.entity.BondEnagencyEntity;
import com.scbid.common.utils.Constant;
import com.scbid.common.utils.DateUtils;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;
import com.scbid.manage.entity.AccountEntity;
import com.scbid.manage.entity.CrmSupplierAccountEntity;
import com.scbid.sys.dao.BondUserDao;
import com.scbid.sys.entity.BondUserEntity;
import com.scbid.sys.service.BondUserRoleService;
import com.scbid.sys.service.BondUserService;

@Service("bondUserService")
public class BondUserServiceImpl extends ServiceImpl<BondUserDao, BondUserEntity> implements BondUserService {

	@Autowired
	private BondUserRoleService bondUserRoleService;
	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<BondUserEntity> page = this.selectPage(new Query<BondUserEntity>(params).getPage(), new EntityWrapper<BondUserEntity>());
		return new PageUtils(page);
	}

	@Override
	public PageUtils findByPage(Map<String, Object> params) {

		Page<BondUserEntity> page = new Query<BondUserEntity>(params).getPage();

		page.setRecords(baseMapper.findByPage(page, params));

		return new PageUtils(page);
	}

	@Override
	public List<Long> queryAllMenuId(Long roleId) {
		return baseMapper.queryAllMenuId(roleId);
	}

	@Override
	public List<String> queryAllPerms(Long roleId) {
		return baseMapper.queryAllPerms(roleId);
	}

	@Override
	public BondUserEntity queryByLoginNo(String loginNo) {
		return baseMapper.queryByLoginNo(loginNo);
	}

	@Override
	@Transactional(rollbackFor = Exception.class) // 事务控制
	public void save(BondUserEntity user, BondUserEntity loginUser) {
		user.setUserTime(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
		user.setPassword(new Md5Hash(user.getPassword()).toHex());
		user.setRoleId(Long.valueOf(user.getRoleIdList().get(0)));
		user.setEntUuid(user.getDeptId());

		// 记录新增人信息
		user.setUpdateUesrName(loginUser.getUserSurname());
		user.setUpdateDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
		this.insert(user);

		// 检查角色是否越权
		checkRole(user);

		// 保存用户与角色关系
		bondUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());

	}

	@Override
	@Transactional(rollbackFor = Exception.class) // 事务控制
	public void update(BondUserEntity user, BondUserEntity loginUser) {
		if (StringUtils.isBlank(user.getPassword())) {
			user.setPassword(null);
		} else {
			user.setPassword(new Md5Hash(user.getPassword()).toHex());
		}
		// 记录修人信息
		user.setUpdateUesrName(loginUser.getUserSurname());
		user.setUpdateDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
		this.updateById(user);

		// 检查角色是否越权
		checkRole(user);

		// 保存用户与角色关系
		bondUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());

	}

	@Override
	public void deleteBatch(Long[] userId) {
		this.deleteBatchIds(Arrays.asList(userId));
	}

	@Override
	public boolean updatePassword(Long userId, String password, String newPassword) {
		BondUserEntity userEntity = new BondUserEntity();
		userEntity.setPassword(newPassword);
		return this.update(userEntity, new EntityWrapper<BondUserEntity>().eq("user_id", userId).eq("password", password));
	}

	/**
	 * 检查角色是否越权
	 */
	private void checkRole(BondUserEntity user) {
		if (user.getRoleIdList() == null || user.getRoleIdList().size() == 0) {
			return;
		}
		// 如果不是超级管理员，则需要判断用户的角色是否自己创建
		if (user.getRoleId() == Constant.RoleType.SYSTEM_ADMIN.getValue()) {
			return;
		}

		// 查询用户创建的角色列表
		// List<Long> roleIdList =
		// bondRoleService.queryRoleIdList(user.getRoleId());

		// 判断是否越权
		// if (!roleIdList.containsAll(user.getRoleIdList())) {
		// throw new RRException("新增用户所选角色，不是本人创建");
		// }
	}

	@Override
	@Transactional(rollbackFor = Exception.class) // 事务控制
	public boolean importAccounts(BondEnagencyEntity enagencyEntity, BondUserEntity loginUser, List<AccountEntity> accounts) {
		for (AccountEntity account : accounts) {
			BondUserEntity entity = new BondUserEntity();

			entity.setEntUuid(enagencyEntity.getAgencyUuid());// 代理机构主键
			entity.setRoleId(Long.valueOf(Constant.RoleType.SUPER_ADMIN.getValue()));// 角色
			entity.setLoginNo(account.getAccountName());// 登录名称
			entity.setPassword(account.getPassword());// 密码
			entity.setUserSurname(account.getUsername());// 真实姓名
			entity.setUserEmail(account.getEmail());// 邮箱
			if (StringUtils.isNotEmpty(account.getPhone())) {
				entity.setUserMobile(account.getPhone());// 手机号
			} else {
				entity.setUserMobile(account.getTelPhone());// 座机号
			}
			entity.setUserStatus(Constant.ScheduleStatus.PAUSE.getValue());// 账号状态正常
			entity.setUserTime(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));// 创建时间
			entity.setUpdateUesrName(loginUser.getUserSurname());// 修改人姓名
			entity.setUpdateDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));// 修改时间
			baseMapper.insert(entity);
		}
		return true;
	}

	@Override
	@Transactional(rollbackFor = Exception.class) // 事务控制
	public boolean importSupplier(BondUserEntity loginUser, List<CrmSupplierAccountEntity> accounts) {
		for (CrmSupplierAccountEntity account : accounts) {
			BondUserEntity entity = new BondUserEntity();
			entity.setRoleId(Long.valueOf(Constant.RoleType.SUPPLIER_ADMIN.getValue()));// 角色
			entity.setLoginNo(account.getUsername());// 登录名称
			entity.setEntUuid(account.getSupplierId());// 供应商主键
			entity.setPassword(account.getPassword());// 密码
			entity.setUserSurname(account.getUsername());// 真实姓名
			entity.setUserStatus(Constant.ScheduleStatus.PAUSE.getValue());// 账号状态正常
			entity.setUserTime(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));// 创建时间
			if (loginUser != null) {
				entity.setUpdateUesrName(loginUser.getUserSurname());// 修改人姓名
			}
			entity.setUpdateDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));// 修改时间
			baseMapper.insert(entity);
		}
		return true;
	}

	@Override
	public List<BondUserEntity> selectAll() {
		List<BondUserEntity> BondUserList = baseMapper.selectAll();
		return BondUserList;
	}

	@Override
	public List<BondUserEntity> queryListByMap(Map<String, Object> params) {

		return baseMapper.queryUserByRoleIds(params);
	}

	@Override
	public List<BondUserEntity> queryUserList(Map<String, Object> params) {

		return baseMapper.findByPage(params);
	}

	@Override
	public BondUserEntity selectUserByEntUuid(String entUuid) {
		return baseMapper.selectUserByEntUuid(entUuid);
	}

}
