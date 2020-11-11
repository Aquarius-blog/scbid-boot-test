package com.scbid.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.scbid.common.utils.R;
import com.scbid.common.utils.SysLog;
import com.scbid.common.validator.ValidatorUtils;
import com.scbid.sys.entity.BondRoleEntity;
import com.scbid.sys.entity.BondUserEntity;
import com.scbid.sys.entity.BondUserMenuEntity;
import com.scbid.sys.service.BondRoleService;
import com.scbid.sys.service.BondUserMenuService;
import com.scbid.sys.service.BondUserService;

/**
 * 角色管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月8日 下午2:18:33
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {
	@Autowired
	private BondRoleService bondRoleService;
	@Autowired
	private BondUserMenuService bondUserMenuService;
	@Autowired
	private BondUserService bondUserService;
	/**
	 * 角色列表
	 */
	@RequestMapping("/list")
	// @RequiresPermissions("sys:role:list")
	public List<BondRoleEntity> list(@RequestParam Map<String, Object> params) {
		List<BondRoleEntity> roleList = bondRoleService.selectList(null);
		for (BondRoleEntity role : roleList) {
			BondRoleEntity parentMenuEntity = bondRoleService.selectById(role.getParentId());
			if (parentMenuEntity != null) {
				role.setParentName(parentMenuEntity.getRoleName());
			}
		}
		return roleList;
	}

	/**
	 * 角色列表
	 */
	@RequestMapping("/select")
	// @RequiresPermissions("sys:role:select")
	public R select() {
		List<BondRoleEntity> list = bondRoleService.selectList(null);
		return R.ok().put("list", list);
	}

	/**
	 * 角色信息
	 */
	@RequestMapping("/info/{roleId}")
	// @RequiresPermissions("sys:role:info")
	public R info(@PathVariable("roleId") Long roleId) {
		BondRoleEntity role = bondRoleService.selectById(roleId);
		// 查询角色对应的菜单
		Map<String, Object> columnMap = new HashMap<>();
		columnMap.put("ROLE_ID", roleId);
		List<BondUserEntity> users = bondUserService.selectByMap(columnMap);
		if (users != null && users.size() != 0) {
			List<Long> menuIdList = bondUserMenuService.queryMenuIdList(users.get(0).getUserId());
			role.setMenuIdList(menuIdList);
		}
		return R.ok().put("role", role);
	}

	/**
	 * 角色信息
	 */
	@RequestMapping("/userId/{userId}")
	// @RequiresPermissions("sys:role:info")
	public R userId(@PathVariable("userId") Long userId) {
		BondUserEntity user = bondUserService.selectById(userId);
		BondRoleEntity role = bondRoleService.selectById(user.getRoleId());
		// 查询角色对应的菜单
		List<Long> menuIdList = bondUserMenuService.queryMenuIdList(userId);
		role.setMenuIdList(menuIdList);
		return R.ok().put("role", role);
	}

	/**
	 * 保存角色
	 */
	@SysLog("保存角色")
	@RequestMapping("/save")
	@RequiresPermissions("sys:role:save")
	public R save(@RequestBody BondRoleEntity role) {
		ValidatorUtils.validateEntity(role);
		bondRoleService.save(role);
		return R.ok();
	}

	/**
	 * 修改角色
	 */
	@SysLog("修改角色")
	@RequestMapping("/update")
	@RequiresPermissions("sys:role:update")
	public R update(@RequestBody BondRoleEntity role) {
		ValidatorUtils.validateEntity(role);
		bondRoleService.update(role);
		return R.ok();
	}

	/**
	 * 修改角色
	 */
	@SysLog("修改角色")
	@RequestMapping("/updateByUserId")
	@RequiresPermissions("sys:role:update")
	public R updateByUserId(HttpServletRequest request) {
		String userIdStr = request.getParameter("userId");
		String roleStr = request.getParameter("role");
		BondRoleEntity bondRole = JSON.parseObject(roleStr, BondRoleEntity.class);
		ValidatorUtils.validateEntity(bondRole);
		bondUserMenuService.deleteBatch(Long.valueOf(userIdStr));
		List<BondUserMenuEntity> entityList = new ArrayList<BondUserMenuEntity>();
		for (Long menuId : bondRole.getMenuIdList()) {
			BondUserMenuEntity menu = new BondUserMenuEntity();
			menu.setMenuId(menuId);
			menu.setUserId(Long.valueOf(userIdStr));
			entityList.add(menu);
		}
		bondUserMenuService.insertBatch(entityList);
		return R.ok();
	}

	/**
	 * 删除角色
	 */
	@SysLog("删除角色")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:role:delete")
	public R delete(@RequestBody Long[] roleIds) {
		bondRoleService.deleteBatch(roleIds);
		return R.ok();
	}
}
