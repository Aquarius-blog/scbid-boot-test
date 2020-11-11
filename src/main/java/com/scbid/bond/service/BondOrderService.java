package com.scbid.bond.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.bond.entity.BondEnguaratorEntity;
import com.scbid.bond.entity.BondOrderEntity;
import com.scbid.common.config.ScbidOssBean;
import com.scbid.common.utils.PageUtils;
import com.scbid.manage.entity.TenderBidBookSaleRecordEntity;

/**
 * 
 * @author wangyun
 * @date 2018-05-14 13:00:02
 */
public interface BondOrderService extends IService<BondOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    
    /** @Title: updateOrderEntityByUrl 
     * @Description: TODO
     * @author: 胡棋文  
     * @date: 2018年5月23日 下午3:02:07 
     * @param url
     * @param orderId
     * @return 
     */
    Boolean updateOrderEntityByUrl(List<ScbidOssBean> ossBeans,String orderId) throws Exception;

    PageUtils guaranteeOrderList(Map<String, Object> params);


	PageUtils queryPageOrders(Map<String, Object> params);
	
	
	/** @Title: selectOrdersByOrderNo 
	 * @Description: 根据订单编号查询所有
	 * @author: 胡棋文  
	 * @date: 2018年6月8日 上午10:15:37 
	 * @param orderNo
	 * @return 
	 */
	BondOrderEntity selectByOrderNo(String orderNo);
	
	
	 /**
	 * @Title: findSupplierDepositByUser
	 * @Description: 通过代理商保函列表列表
	 * @author: chengyun
	 * @date: 2018年5月16日 上午10:10:58
	 * @param otherFeeId
	 * @return
	 */
    PageUtils findSupplierOrderByUser(Map<String, Object> params);

    /**
     * @param orderManageEntity
     * @param bondOrderEntity
     * @return
     */
	boolean insertBondOrder(TenderBidBookSaleRecordEntity saleRecordEntity, BondOrderEntity bondOrderEntity);

	/**
	 * @param list
	 * @param guarator
	 * @return
	 */
	boolean updateGuarator(List<BondOrderEntity> list, BondEnguaratorEntity guarator) throws Exception;

	/**
	 * @param params
	 * @return
	 */
	BondOrderEntity selectOrderByParams(Map<String, Object> params);
    
   
}

