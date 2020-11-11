package com.scbid.invoice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.scbid.invoice.entity.FpsqbEntity;

/**
 * 
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-24 10:27:59
 */
@Mapper
public interface FpsqbDao extends BaseMapper<FpsqbEntity> {
	List<FpsqbEntity> fpsqbPage(Pagination page, Map<String, Object> params);

	Integer insertInvoiceBean(FpsqbEntity invoiceBean);

	FpsqbEntity getInvoice(String listId);
}
