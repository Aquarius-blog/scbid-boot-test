package com.scbid.sys.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scbid.common.utils.Constant;
import com.scbid.sys.dao.BondMenuDao;
import com.scbid.sys.dao.BondUserDao;
import com.scbid.sys.dao.BondUserTokenDao;
import com.scbid.sys.entity.BondMenuEntity;
import com.scbid.sys.entity.BondUserEntity;
import com.scbid.sys.entity.BondUserTokenEntity;
import com.scbid.sys.service.ShiroService;

@Service
public class ShiroServiceImpl implements ShiroService {
	@Autowired
	private BondMenuDao bondMenuDao;
	@Autowired
	private BondUserDao bondUserDao;
	@Autowired
	private BondUserTokenDao bondUserTokenDao;

	@Override
	public Set<String> getUserPermissions(long userId) {
		List<String> permsList;
		BondUserEntity user = bondUserDao.selectById(userId);
		// 系统管理员，拥有最高权限
		if (user.getRoleId() == Constant.RoleType.SYSTEM_ADMIN.getValue()) {
			List<BondMenuEntity> menuList = bondMenuDao.selectList(null);
			permsList = new ArrayList<>(menuList.size());
			for (BondMenuEntity menu : menuList) {
				permsList.add(menu.getPerms());
			}
		} else {
			permsList = bondUserDao.queryAllPerms(userId);
		}
		// 用户权限列表
		Set<String> permsSet = new HashSet<>();
		for (String perms : permsList) {
			if (StringUtils.isBlank(perms)) {
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}
		return permsSet;
	}

	@Override
	public BondUserTokenEntity queryByToken(String token) {
		return bondUserTokenDao.queryByToken(token);
	}

	@Override
	public BondUserEntity queryUser(Long userId) {
		return bondUserDao.selectById(userId);
	}
}
