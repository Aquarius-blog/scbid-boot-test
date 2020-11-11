package com.scbid.manage.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.common.datasources.DataSourceNames;
import com.scbid.common.datasources.TargetDataSource;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;
import com.scbid.manage.dao.TenderImplemenProjectPackagesDao;
import com.scbid.manage.entity.TenderImplemenProjectPackagesEntity;
import com.scbid.manage.service.TenderImplemenProjectPackagesService;

@Service("tenderImplemenProjectPackagesService")
public class TenderImplemenProjectPackagesServiceImpl extends ServiceImpl<TenderImplemenProjectPackagesDao, TenderImplemenProjectPackagesEntity> implements TenderImplemenProjectPackagesService {

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public PageUtils queryPage(Map<String, Object> params) {
		Page<TenderImplemenProjectPackagesEntity> page = this.selectPage(new Query<TenderImplemenProjectPackagesEntity>(params).getPage(), new EntityWrapper<TenderImplemenProjectPackagesEntity>());

		return new PageUtils(page);
	}
	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public TenderImplemenProjectPackagesEntity selectById(String listId) {
		return baseMapper.selectById(listId);
	}
}
