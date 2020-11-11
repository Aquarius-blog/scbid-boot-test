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
import com.scbid.manage.dao.SaleOrderManagementDao;
import com.scbid.manage.entity.SaleOrderManagementEntity;
import com.scbid.manage.service.SaleOrderManagementService;

@Service("saleOrderManagementService")
public class SaleOrderManagementServiceImpl extends ServiceImpl<SaleOrderManagementDao, SaleOrderManagementEntity> implements SaleOrderManagementService {

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public PageUtils queryPage(Map<String, Object> params) {
		Page<SaleOrderManagementEntity> page = this.selectPage(new Query<SaleOrderManagementEntity>(params).getPage(), new EntityWrapper<SaleOrderManagementEntity>());

		return new PageUtils(page);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public SaleOrderManagementEntity queryOrderByOrderCode(String orderCode) {
		return baseMapper.queryOrderByOrderCode(orderCode);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public boolean updateEntityById(SaleOrderManagementEntity entity) {
		return updateById(entity);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public SaleOrderManagementEntity selectById(String listId) {
		return baseMapper.selectById(listId);
	}
}
