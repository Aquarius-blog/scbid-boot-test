package com.scbid.manage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.scbid.manage.entity.CrmSupplierAccountEntity;

/**
 * 
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-17 16:27:11
 */
@Mapper
public interface CrmSupplierAccountDao extends BaseMapper<CrmSupplierAccountEntity> {
	List<CrmSupplierAccountEntity> crmSupplierAccountPage(Pagination page, Map<String, Object> params);
	
	CrmSupplierAccountEntity selectSupplierByListId (String listId);

	CrmSupplierAccountEntity selectSupplierBySupplierId(String supplierId);
}
