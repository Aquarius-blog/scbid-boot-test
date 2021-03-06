package com.scbid.sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.common.utils.MapUtils;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;
import com.scbid.sys.dao.BondUserRoleDao;
import com.scbid.sys.entity.BondUserRoleEntity;
import com.scbid.sys.service.BondUserRoleService;

@Service("bondUserRoleService")
public class BondUserRoleServiceImpl extends ServiceImpl<BondUserRoleDao, BondUserRoleEntity> implements BondUserRoleService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<BondUserRoleEntity> page = this.selectPage(new Query<BondUserRoleEntity>(params).getPage(), new EntityWrapper<BondUserRoleEntity>());

		return new PageUtils(page);
	}

	@Override
	public void saveOrUpdate(Long userId, List<Long> roleIdList) {
		// 先删除用户与角色关系
		this.deleteByMap(new MapUtils().put("user_id", userId));
		
		if (roleIdList == null || roleIdList.size() == 0) {
			return;
		}

		// 保存用户与角色关系
		List<BondUserRoleEntity> list = new ArrayList<>(roleIdList.size());
		for (Long roleId : roleIdList) {
			BondUserRoleEntity sysUserRoleEntity = new BondUserRoleEntity();
			sysUserRoleEntity.setUserId(userId);
			sysUserRoleEntity.setRoleId(roleId);

			list.add(sysUserRoleEntity);
		}
		this.insertBatch(list);
	}

	@Override
	public List<Long> queryRoleIdList(Long userId) {
		return baseMapper.queryRoleIdList(userId);
	}

	@Override
	public int deleteBatch(Long userId) {
		return baseMapper.deleteBatch(userId);
	}

}
