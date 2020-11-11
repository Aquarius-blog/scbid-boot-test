package com.scbid.bond.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.scbid.bond.entity.BondOrderEntity;

/**
 * 
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-14 13:00:02
 */
@Mapper
public interface BondOrderDao extends BaseMapper<BondOrderEntity> {
	/**
	 * @param page
	 * @param params
	 * @return
	 */
	List<BondOrderEntity> queryPageOrders(Pagination page, Map<String, Object> params);
	
	/** @Title: guaranteeOrderList 
	 * @Description: 担保订单列表
	 * @author: 胡棋文  
	 * @date: 2018年5月22日 上午11:47:13 
	 * @param page
	 * @param params
	 * @return 
	 */
	List<BondOrderEntity> guaranteeOrderList(Pagination page,Map<String, Object> params);	
	
	/**
	 * 
	 * 
	 * @author 程云
	 * @date 2018-05-15 13:00:01
	 */
	List<BondOrderEntity> findSupplierOrderByUser(Pagination page,Map<String, Object> params);

	/** @Title: selectOrdersByOrderNo 
	 * @Description:根据订单编号查询所有
	 * @author: 胡棋文  
	 * @date: 2018年6月8日 上午10:24:19 
	 * @param orderNo
	 * @return 
	 */

	void updateOrderStatus(Integer orderStatus, String orderId);


	BondOrderEntity selectByOrderNo(String orderNo);

	/**
	 * @param params
	 * @return
	 */
	BondOrderEntity selectOrderByParams(Map<String, Object> params);
	
		
}
