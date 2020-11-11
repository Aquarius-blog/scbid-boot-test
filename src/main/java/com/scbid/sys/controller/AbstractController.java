package com.scbid.sys.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.scbid.sys.entity.BondUserEntity;
import com.scbid.sys.service.BondRoleService;
import com.scbid.sys.service.BondUserService;

/**
 * @Title: AbstractController.java
 * @Description: Controller公共组件
 * @Package com.scbid.bond.controller
 * @Author: wangyun
 * @Date: 2018年5月11日
 * @Copyright: 四川国际招标有限责任公司 注意：本内容仅限于必朗科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public abstract class AbstractController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 权限
	 */
	@Autowired
	protected BondRoleService bondRoleService;
	
	@Autowired
	protected BondUserService bondUserService;
	

	protected BondUserEntity getUser() {
		return (BondUserEntity) SecurityUtils.getSubject().getPrincipal();
	}
	/**
	 * 当前获取用户id
	 * 
	 * @return
	 */
	protected Long getUserId() {
		return getUser().getUserId();
	}
	/**
	 * 当前获取用户角色
	 * 
	 * @return
	 */
	protected Long getRoleId() {
		return getUser().getRoleId();
	}
	/**
	 * 当前获取用户所属公司
	 * 
	 * @return
	 */
	protected String getEntUuid() {
		return getUser().getEntUuid();
	}

	/**
	 * 判断是否存在子权限
	 * 
	 * @return
	 */
	protected boolean checkRoleIds() {
		List<Long> subnodes = bondRoleService.queryRoleIdList(getRoleId());
		if (subnodes != null && subnodes.size() != 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 查询权限角色
	 * 
	 * @return
	 */
	protected List<Long> queryRoleIds() {
		// 查询权限角色
		List<Long> roleIds = new ArrayList<>();
		roleIds.add(getRoleId());
		List<Long> subnodes = bondRoleService.queryRoleIdList(getRoleId());
		if (subnodes != null && subnodes.size() != 0) {
			roleIds.addAll(subnodes);//
		}
		return roleIds;
	}
}
