package com.scbid.bond.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.bond.entity.BondOrderItemEntity;
import com.scbid.common.utils.PageUtils;

/**
 * 
 * @author wangyun
 * @date 2018-05-14 13:00:02
 */
public interface BondOrderItemService extends IService<BondOrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);

	List<BondOrderItemEntity> selectBatchOrderIds(Map<String, Object> newParams);

}

