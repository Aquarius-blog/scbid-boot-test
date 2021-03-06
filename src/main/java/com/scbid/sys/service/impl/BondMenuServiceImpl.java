package com.scbid.sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.common.utils.Constant;
import com.scbid.common.utils.Constant.MenuType;
import com.scbid.common.utils.MapUtils;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;
import com.scbid.sys.dao.BondMenuDao;
import com.scbid.sys.entity.BondMenuEntity;
import com.scbid.sys.service.BondMenuService;
import com.scbid.sys.service.BondUserMenuService;
import com.scbid.sys.service.BondUserService;

@Service("bondMenuService")
public class BondMenuServiceImpl extends ServiceImpl<BondMenuDao, BondMenuEntity> implements BondMenuService {

	@Autowired
	private BondUserService bondUserService;
	@Autowired
	private BondUserMenuService bondUserMenuService;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<BondMenuEntity> page = this.selectPage(new Query<BondMenuEntity>(params).getPage(), new EntityWrapper<BondMenuEntity>());

		return new PageUtils(page);
	}

	@Override
	public List<BondMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList) {
		List<BondMenuEntity> menuList = queryListParentId(parentId);
		if (menuIdList == null) {
			return menuList;
		}

		List<BondMenuEntity> userMenuList = new ArrayList<BondMenuEntity>();
		for (BondMenuEntity menu : menuList) {
			if (menuIdList.contains(menu.getMenuId())) {
				userMenuList.add(menu);
			}
		}
		return userMenuList;
	}

	@Override
	public List<BondMenuEntity> queryListParentId(Long parentId) {
		return baseMapper.queryListParentId(parentId);
	}

	@Override
	public List<BondMenuEntity> queryNotButtonList() {
		return baseMapper.queryNotButtonList();
	}

	@Override
	public List<BondMenuEntity> getUserMenuList() {
		return getAllMenuList(null);
	}
	
	@Override
	public List<BondMenuEntity> getUserMenuList(Long roleId) {
		// 用户菜单列表
		List<Long> menuIdList = bondUserService.queryAllMenuId(roleId);
		return getAllMenuList(menuIdList);
	}

	@Override
	public void delete(Long menuId) {
		//删除菜单
		this.deleteById(menuId);
		//删除菜单与角色关联
		bondUserMenuService.deleteByMap(new MapUtils().put("menu_id", menuId));

	}

	/**
	 * 获取所有菜单列表
	 */
	private List<BondMenuEntity> getAllMenuList(List<Long> menuIdList) {
		// 查询根菜单列表
		List<BondMenuEntity> menuList = queryListParentId(0L, menuIdList);
		// 递归获取子菜单
		getMenuTreeList(menuList, menuIdList);

		return menuList;
	}

	/**
	 * 递归
	 */
	private List<BondMenuEntity> getMenuTreeList(List<BondMenuEntity> menuList, List<Long> menuIdList) {
		List<BondMenuEntity> subMenuList = new ArrayList<BondMenuEntity>();

		for (BondMenuEntity entity : menuList) {
			// 目录
			if (entity.getType() == Constant.MenuType.CATALOG.getValue()) {
				entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
			}
			subMenuList.add(entity);
		}

		return subMenuList;
	}

	@Override
	public List<BondMenuEntity> selectAllList(Long parentId) {
		// 查询根菜单列表
		List<BondMenuEntity> menuList = queryListParentId(0L);
		List<Long> menuIdList = new ArrayList<Long>();
		for (BondMenuEntity entity : menuList) {
			menuIdList.add(entity.getMenuId());
		}
		// 递归获取子菜单
		getMenuTreeList(menuList, menuIdList);
		return menuList;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)//事务控制
	public void insertMenu(BondMenuEntity bondMenu) {
		
		baseMapper.insert(bondMenu);
		Long menuId = bondMenu.getMenuId();
		
		//查看按钮
		BondMenuEntity selectButton = new BondMenuEntity();
		selectButton.setParentId(menuId);
		selectButton.setName("查看");
		selectButton.setType(MenuType.BUTTON.getValue());
		selectButton.setOrderNum(0);
		baseMapper.insert(selectButton);
		//新增按钮
		BondMenuEntity saveButton = new BondMenuEntity();
		saveButton.setParentId(menuId);
		saveButton.setName("新增");
		saveButton.setType(MenuType.BUTTON.getValue());
		saveButton.setOrderNum(1);
		baseMapper.insert(saveButton);
		//修改按钮
		BondMenuEntity updateButton = new BondMenuEntity();
		updateButton.setParentId(menuId);
		updateButton.setName("修改");
		updateButton.setType(MenuType.BUTTON.getValue());
		updateButton.setOrderNum(2);
		baseMapper.insert(updateButton);
		//删除按钮
		BondMenuEntity deleteButton = new BondMenuEntity();
		deleteButton.setParentId(menuId);
		deleteButton.setName("删除");
		deleteButton.setType(MenuType.BUTTON.getValue());
		deleteButton.setOrderNum(3);
		baseMapper.insert(deleteButton);
		//导入按钮
		BondMenuEntity importButton = new BondMenuEntity();
		importButton.setParentId(menuId);
		importButton.setName("导入");
		importButton.setType(MenuType.BUTTON.getValue());
		importButton.setOrderNum(4);
		baseMapper.insert(importButton);
		//导出按钮
		BondMenuEntity exportButton = new BondMenuEntity();
		exportButton.setParentId(menuId);
		exportButton.setName("导出");
		exportButton.setType(MenuType.BUTTON.getValue());
		exportButton.setOrderNum(5);
		baseMapper.insert(exportButton);
		
	}

	@Override
	@Transactional(rollbackFor = Exception.class)//事务控制
	public void updateMenu(BondMenuEntity bondMenu) {
		
		List<BondMenuEntity> list = baseMapper.queryListParentId(bondMenu.getMenuId());
		
		List<String> buttons = new ArrayList<String>();
		for (BondMenuEntity menu : list) {
			buttons.add(menu.getName());
		}
		
		List<String> diffrents  = new ArrayList<String>();
		for (String button : Constant.buttons) {
			if (!buttons.contains(button)) {
				diffrents.add(button);
			}
		}
		for (String button : diffrents) {
			BondMenuEntity menuButton = new BondMenuEntity();
			menuButton.setParentId(bondMenu.getMenuId());
			menuButton.setName(button);
			menuButton.setType(MenuType.BUTTON.getValue());
			menuButton.setOrderNum(1);
			baseMapper.insert(menuButton);
		}
		
		baseMapper.updateAllColumnById(bondMenu);
		
	}

}
