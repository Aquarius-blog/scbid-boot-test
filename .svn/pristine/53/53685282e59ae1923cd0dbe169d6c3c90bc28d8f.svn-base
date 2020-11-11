package com.scbid.manage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.scbid.manage.entity.CommonOrganizationEntity;

/**
 * 
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-24 12:11:03
 */
@Mapper
public interface CommonOrganizationDao extends BaseMapper<CommonOrganizationEntity> {
	List<CommonOrganizationEntity> commonOrganizationPage(Pagination page, Map<String, Object> params);
}
