package com.scbid.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.scbid.sys.entity.BondUserRoleEntity;

/**
 * 用户与角色对应关系
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-12 08:25:09
 */
@Mapper
public interface BondUserRoleDao extends BaseMapper<BondUserRoleEntity> {
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);


	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long userId);
}
