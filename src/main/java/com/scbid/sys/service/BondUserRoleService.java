package com.scbid.sys.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.common.utils.PageUtils;
import com.scbid.sys.entity.BondUserRoleEntity;

/**
 * 用户与角色对应关系
 *
 * @author wangyun
 * @email 278812723
 * @date 2018-05-12 08:25:09
 */
public interface BondUserRoleService extends IService<BondUserRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 新增和修改
     * @param userId
     * @param roleIdList
     */
    void saveOrUpdate(Long userId, List<Long> roleIdList);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long userId);
}

