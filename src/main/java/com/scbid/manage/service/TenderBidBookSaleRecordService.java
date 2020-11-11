package com.scbid.manage.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.common.utils.PageUtils;
import com.scbid.manage.entity.TenderBidBookSaleRecordEntity;

/**
 * 
 * @author wangyun
 * @date 2018-05-17 16:28:02
 */
public interface TenderBidBookSaleRecordService extends IService<TenderBidBookSaleRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    List<TenderBidBookSaleRecordEntity> selectList();

	PageUtils bidBookSaleRecordPage(Map<String, Object> params);
	
	List<TenderBidBookSaleRecordEntity> selectBatchIds(List<String> idList);

	boolean updatePayTheDeposit(Map<String, Object> params);

	List<TenderBidBookSaleRecordEntity> selectByMapIn(Map<String, Object> params);

	List<TenderBidBookSaleRecordEntity> selectSalesByOrderId(String orderListId);
	
	TenderBidBookSaleRecordEntity selectSaleByParams(Map<String, Object> params);
	
	boolean updateStatusById(Integer status, String listId);
	
	boolean updateBondData(String listId,Integer bondStatus,String bondOrderNo,BigDecimal bondOrderMoney,BigDecimal bondFees);

	TenderBidBookSaleRecordEntity slectSlaeByBondOrderNo(String bondOrderNo);
}

