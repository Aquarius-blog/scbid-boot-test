package com.scbid.bond.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.scbid.bond.entity.BondEnsupplierEntity;

/**
 * 
 * 
 * @author 程云
 * @email 278812723
 * @date 2018-05-14 13:00:01
 */
@Mapper
public interface BondEnsupplierDao extends BaseMapper<BondEnsupplierEntity> {

	/**
	 * @author 程云
	 * @date 2018-05-15 13:00:01
	 */
	List<BondEnsupplierEntity> findSupplierByUser(Pagination page, Map<String, Object> params);

	/**
	 * @Title: queryGuaranteeSupplier
	 * @Description: 担保供应商列表
	 * @author: 胡棋文
	 * @date: 2018年5月24日 上午10:48:04
	 * @param page
	 * @param params
	 * @return
	 */
	List<BondEnsupplierEntity> queryGuaranteeSupplier(Pagination page, Map<String, Object> params);

	// List<BondEnsupplierEntity> findAllSupplier(Pagination page,Map<String,
	// Object> params);

	List<BondEnsupplierEntity> queryPageEnsuppliers(Pagination page, Map<String, Object> params);

	List<BondEnsupplierEntity> selectBatchSupplierIds(Pagination page, Map<String, Object> params);

	List<BondEnsupplierEntity> selectBatchUuids(Pagination page, Map<String, Object> params);
	/**
	 * @param supplierUuid
	 * @return
	 */
	BondEnsupplierEntity selectSupplierBySupplierUuid(String supplierUuid);
}
