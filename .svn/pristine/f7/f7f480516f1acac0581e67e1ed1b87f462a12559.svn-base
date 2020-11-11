package com.scbid.manage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.scbid.manage.entity.SaleProjectEntity;

/**
 * 
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-18 11:33:03
 */
@Mapper
public interface SaleProjectDao extends BaseMapper<SaleProjectEntity> {
	List<SaleProjectEntity> saleProjectPage(Pagination page, Map<String, Object> params);
}
