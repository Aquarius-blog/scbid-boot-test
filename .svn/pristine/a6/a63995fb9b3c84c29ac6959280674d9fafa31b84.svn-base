package com.scbid.sys.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.common.utils.PageUtils;
import com.scbid.sys.entity.BondMenuEntity;

/**
 * 菜单管理
 *
 * @author wangyun
 * @email 278812723
 * @date 2018-05-11 11:45:12
 */
public interface BondMenuService extends IService<BondMenuEntity> {

    PageUtils queryPage(Map<String, Object> params);

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 * @param menuIdList  用户菜单ID
	 */
	List<BondMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList);

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<BondMenuEntity> queryListParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<BondMenuEntity> queryNotButtonList();
	
	/**
	 * 获取获取全部菜单列表
	 * @return
	 */
	List<BondMenuEntity> getUserMenuList();
	
	/**
	 * 获取用户菜单列表
	 */
	List<BondMenuEntity> getUserMenuList(Long userId);

	/**
	 * 删除
	 */
	void delete(Long menuId);
	/**
	 * 查询菜单树
	 * @param parentId
	 * @return
	 */
	List<BondMenuEntity> selectAllList(Long parentId);

	void insertMenu(BondMenuEntity bondMenu);

	void updateMenu(BondMenuEntity bondMenu);
}

