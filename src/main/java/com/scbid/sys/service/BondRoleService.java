package com.scbid.sys.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.common.utils.PageUtils;
import com.scbid.sys.entity.BondRoleEntity;

/**
 * 角色表
 *
 * @author wangyun
 * @email 278812723
 * @date 2018-05-12 08:25:09
 */
public interface BondRoleService extends IService<BondRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    void save(BondRoleEntity role);

	void update(BondRoleEntity role);

	void deleteBatch(Long[] roleIds);

	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long parentId);
}

