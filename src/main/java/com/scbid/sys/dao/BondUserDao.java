package com.scbid.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.scbid.sys.entity.BondUserEntity;

/**
 * 系统用户
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-12 08:13:13
 */
@Mapper
public interface BondUserDao extends BaseMapper<BondUserEntity> {

	List<BondUserEntity> findByPage(Pagination page, Map<String, Object> params);

	List<BondUserEntity> findByPage(Map<String, Object> params);

	List<BondUserEntity> queryUserByRoleIds(Map<String, Object> params);

	/**
	 * 查询用户的所有权限
	 * 
	 * @param userId
	 *            用户ID
	 */
	List<String> queryAllPerms(Long roleId);

	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long roleId);

	/**
	 * 根据登录名，查询系统用户
	 */
	BondUserEntity queryByLoginNo(String loginNo);

	/**
	 * 查询所有user
	 * 
	 * @author chengyun
	 */
	List<BondUserEntity> selectAll();
	/**
	 * @param entUuid
	 * @return
	 */
	BondUserEntity selectUserByEntUuid(String entUuid);

}
