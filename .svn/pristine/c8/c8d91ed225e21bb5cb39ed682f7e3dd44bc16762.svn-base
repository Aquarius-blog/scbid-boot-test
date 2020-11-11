package com.scbid.invoice.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.common.datasources.DataSourceNames;
import com.scbid.common.datasources.TargetDataSource;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;
import com.scbid.invoice.dao.FpsqbDao;
import com.scbid.invoice.entity.FpsqbEntity;
import com.scbid.invoice.service.FpsqbService;

@Service("fpsqbService")
public class FpsqbServiceImpl extends ServiceImpl<FpsqbDao, FpsqbEntity> implements FpsqbService {

	@Override
	@TargetDataSource(name = DataSourceNames.THIRD)
	public PageUtils queryPage(Map<String, Object> params) {
		Page<FpsqbEntity> page = this.selectPage(new Query<FpsqbEntity>(params).getPage(), new EntityWrapper<FpsqbEntity>());

		return new PageUtils(page);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.THIRD)
	public Integer insertInvoiceBean(FpsqbEntity invoiceBean) {
		return baseMapper.insertInvoiceBean(invoiceBean);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.THIRD)
	public FpsqbEntity selectById(String listId) {
		return baseMapper.selectById(listId);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.THIRD)
	public FpsqbEntity getInvoice(String listId) {
		return baseMapper.getInvoice(listId);
	}
}
