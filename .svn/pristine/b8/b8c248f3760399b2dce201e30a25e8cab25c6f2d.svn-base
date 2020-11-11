package com.scbid.invoice.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.common.utils.PageUtils;
import com.scbid.invoice.entity.FpsqbEntity;

/**
 * 
 * @author wangyun
 * @date 2018-05-24 10:27:59
 */
public interface FpsqbService extends IService<FpsqbEntity> {

    PageUtils queryPage(Map<String, Object> params);

	FpsqbEntity selectById(String listId);
	
	Integer insertInvoiceBean(FpsqbEntity entity);

	FpsqbEntity getInvoice(String listId);
}

