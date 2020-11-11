package com.scbid.manage.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.common.utils.PageUtils;
import com.scbid.manage.entity.SaleOrderManagementEntity;

/**
 * 
 * @author wangyun
 * @date 2018-10-26 10:20:05
 */
public interface SaleOrderManagementService extends IService<SaleOrderManagementEntity> {

	PageUtils queryPage(Map<String, Object> params);

	SaleOrderManagementEntity queryOrderByOrderCode(String orderCode);

	boolean updateEntityById(SaleOrderManagementEntity entity);
	
	SaleOrderManagementEntity selectById(String listId);
}
