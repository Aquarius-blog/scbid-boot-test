package com.scbid.sys.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.common.utils.DateUtils;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;
import com.scbid.sys.dao.BondRoleDao;
import com.scbid.sys.entity.BondRoleEntity;
import com.scbid.sys.entity.BondUserEntity;
import com.scbid.sys.entity.BondUserMenuEntity;
import com.scbid.sys.service.BondRoleService;
import com.scbid.sys.service.BondUserMenuService;
import com.scbid.sys.service.BondUserService;

@Service("bondRoleService")
public class BondRoleServiceImpl extends ServiceImpl<BondRoleDao, BondRoleEntity> implements BondRoleService {

	@Autowired
	private BondUserService bondUserService;

	@Autowired
	private BondUserMenuService bondUserMenuService;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<BondRoleEntity> page = this.selectPage(new Query<BondRoleEntity>(params).getPage(), new EntityWrapper<BondRoleEntity>());

		return new PageUtils(page);
	}

	@Override
	@Transactional(rollbackFor = Exception.class) // 事务控制
	public void save(BondRoleEntity role) {
		role.setCreateTime(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
		this.insert(role);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(BondRoleEntity role) {
		this.updateById(role);
		// 查询角色下没有权限的账号初始化权限
		Map<String, Object> columnMap = new HashMap<>();
		columnMap.put("ROLE_ID", role.getRoleId());
		List<BondUserEntity> users = bondUserService.selectByMap(columnMap);
		for (BondUserEntity user : users) {
			List<BondUserMenuEntity> entityList = new ArrayList<BondUserMenuEntity>();
			List<Long> list = bondUserMenuService.queryMenuIdList(user.getUserId());
			if (list == null || list.size() == 0) {
				for (Long menuId : role.getMenuIdList()) {
					BondUserMenuEntity entity = new BondUserMenuEntity();
					entity.setUserId(user.getUserId());
					entity.setMenuId(menuId);
					entityList.add(entity);
				}
			}
			if (entityList != null && entityList.size() > 0) {
				bondUserMenuService.insertBatch(entityList);
			}
		}

	}

	@Override
	public void deleteBatch(Long[] roleIds) {
		// 删除角色
		this.deleteBatchIds(Arrays.asList(roleIds));
	}

	@Override
	public List<Long> queryRoleIdList(Long parentId) {
		return baseMapper.queryRoleIdList(parentId);
	}

}
