package com.scbid.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.scbid.sys.entity.BondUserMenuEntity;

/**
 * 用户与菜单对应关系
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-12 10:31:01
 */
@Mapper
public interface BondUserMenuDao extends BaseMapper<BondUserMenuEntity> {
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long userId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long userId);
}
