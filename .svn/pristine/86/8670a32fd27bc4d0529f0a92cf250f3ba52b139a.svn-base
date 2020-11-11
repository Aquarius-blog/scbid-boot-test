package com.scbid.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.scbid.sys.entity.BondRoleEntity;

/**
 * 角色表
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-12 08:25:09
 */
@Mapper
public interface BondRoleDao extends BaseMapper<BondRoleEntity> {
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long parentId);	
}
