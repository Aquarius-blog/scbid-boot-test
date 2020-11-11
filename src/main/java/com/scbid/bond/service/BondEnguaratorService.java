package com.scbid.bond.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.bond.entity.BondEnguaratorEntity;
import com.scbid.common.utils.PageUtils;

/**
 * 
 * @author wangyun
 * @date 2018-05-14 13:00:02
 */
public interface BondEnguaratorService extends IService<BondEnguaratorEntity> {

    PageUtils queryPage(Map<String, Object> params);

	PageUtils queryPageGuarators(Map<String, Object> params);
	
	PageUtils selectBatchGuaratorIds(Map<String, Object> params);
	
	BondEnguaratorEntity selectByGuaratorUuids(String guaratorUuid);
	
	BondEnguaratorEntity querGuaratorByOrderId(String orderId);
	
	List<BondEnguaratorEntity> queryListByMap(Map<String, Object> newParams);
}

