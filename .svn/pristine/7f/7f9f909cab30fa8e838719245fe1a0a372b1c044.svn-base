package com.scbid.sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;
import com.scbid.sys.dao.BondUserMenuDao;
import com.scbid.sys.entity.BondUserMenuEntity;
import com.scbid.sys.service.BondUserMenuService;

@Service("bondUserMenuService")
public class BondUserMenuServiceImpl extends ServiceImpl<BondUserMenuDao, BondUserMenuEntity> implements BondUserMenuService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<BondUserMenuEntity> page = this.selectPage(new Query<BondUserMenuEntity>(params).getPage(), new EntityWrapper<BondUserMenuEntity>());

		return new PageUtils(page);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveOrUpdate(Long userId, List<Long> menuIdList) {
		// 先删除角色与菜单关系
		deleteBatch(userId);

		if (menuIdList == null || menuIdList.size() == 0) {
			return;
		}

		// 保存角色与菜单关系
		List<BondUserMenuEntity> list = new ArrayList<BondUserMenuEntity>(menuIdList.size());
		for (Long menuId : menuIdList) {
			BondUserMenuEntity sysRoleMenuEntity = new BondUserMenuEntity();
			sysRoleMenuEntity.setMenuId(menuId);
			sysRoleMenuEntity.setUserId(userId);

			list.add(sysRoleMenuEntity);
		}
		this.insertBatch(list);

	}

	@Override
	public List<Long> queryMenuIdList(Long userId) {
		return baseMapper.queryMenuIdList(userId);
	}

	@Override
	public int deleteBatch(Long userId) {
		return baseMapper.deleteBatch(userId);
	}

}
