package com.scbid.sys.dao;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.scbid.sys.entity.BondMenuEntity;

/**
 * 菜单管理
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-11 11:45:12
 */
public interface BondMenuDao extends BaseMapper<BondMenuEntity> {
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<BondMenuEntity> queryListParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<BondMenuEntity> queryNotButtonList();
}
