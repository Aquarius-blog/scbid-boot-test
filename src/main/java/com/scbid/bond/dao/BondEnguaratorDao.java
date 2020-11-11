package com.scbid.bond.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.scbid.bond.entity.BondEnguaratorEntity;

/**
 * 
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-14 13:00:02
 */
@Mapper
public interface BondEnguaratorDao extends BaseMapper<BondEnguaratorEntity> {

	List<BondEnguaratorEntity> queryPageGuarators(Pagination page, Map<String, Object> params);

	List<BondEnguaratorEntity> selectBatchGuaratorIds(Pagination page, Map<String, Object> params);
	
	BondEnguaratorEntity selectByGuaratorUuids(String guaratorUuid);
	
	 /** @Title: querGuaratorByOrderId 
	 * @Description: 根据orderId 查询收款单位
	 * @author: 胡棋文  
	 * @date: 2018年5月23日 下午2:21:13 
	 * @param orderId
	 * @return 
	 */
	BondEnguaratorEntity querGuaratorByOrderId(String orderId);
	
	/**
	 * @param params
	 * @return
	 */
	List<String> querGuarators(Map<String, Object> params);
	/**
	 * @param params
	 * @return
	 */
	List<BondEnguaratorEntity> queryListByMap(Map<String, Object> params);
	
}
