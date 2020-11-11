package com.scbid.manage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.scbid.manage.entity.SaleOrderManagementEntity;

/**
 * 
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-10-26 10:20:05
 */
@Mapper
public interface SaleOrderManagementDao extends BaseMapper<SaleOrderManagementEntity> {
	List<SaleOrderManagementEntity> saleOrderManagementPage(Pagination page, Map<String, Object> params);

	SaleOrderManagementEntity queryOrderByOrderCode(String orderCode);

}
