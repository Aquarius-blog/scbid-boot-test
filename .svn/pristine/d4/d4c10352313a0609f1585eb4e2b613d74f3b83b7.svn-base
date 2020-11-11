package com.scbid.sys.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.common.utils.PageUtils;
import com.scbid.sys.entity.BondUserMenuEntity;

/**
 * 角色与菜单对应关系
 *
 * @author wangyun
 * @email 278812723
 * @date 2018-05-12 10:31:01
 */
public interface BondUserMenuService extends IService<BondUserMenuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    void saveOrUpdate(Long userId, List<Long> menuIdList);
    
    /**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long userId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long userId);
}

