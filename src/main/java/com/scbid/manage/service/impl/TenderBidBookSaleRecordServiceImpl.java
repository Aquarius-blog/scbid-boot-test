package com.scbid.manage.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.common.datasources.DataSourceNames;
import com.scbid.common.datasources.TargetDataSource;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;
import com.scbid.manage.dao.TenderBidBookSaleRecordDao;
import com.scbid.manage.entity.TenderBidBookSaleRecordEntity;
import com.scbid.manage.service.TenderBidBookSaleRecordService;

@Service("tenderBidBookSaleRecordService")
public class TenderBidBookSaleRecordServiceImpl extends ServiceImpl<TenderBidBookSaleRecordDao, TenderBidBookSaleRecordEntity> implements TenderBidBookSaleRecordService {

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public PageUtils queryPage(Map<String, Object> params) {
		Page<TenderBidBookSaleRecordEntity> page = this.selectPage(new Query<TenderBidBookSaleRecordEntity>(params).getPage(), new EntityWrapper<TenderBidBookSaleRecordEntity>());

		return new PageUtils(page);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public List<TenderBidBookSaleRecordEntity> selectList() {
		return baseMapper.selectList(null);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public PageUtils bidBookSaleRecordPage(Map<String, Object> params) {
		Page<TenderBidBookSaleRecordEntity> page = new Query<TenderBidBookSaleRecordEntity>(params).getPage();
		page.setRecords(baseMapper.tenderBidBookSaleRecordPage(page, params));
		return new PageUtils(page);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public List<TenderBidBookSaleRecordEntity> selectBatchIds(List<String> idList) {
		return baseMapper.selectBatchIds(idList);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public boolean updatePayTheDeposit(Map<String, Object> params) {
		return baseMapper.updatePayTheDeposit(params);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public List<TenderBidBookSaleRecordEntity> selectByMapIn(Map<String, Object> params) {
		return baseMapper.selectByMapIn(params);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public List<TenderBidBookSaleRecordEntity> selectSalesByOrderId(String orderListId) {
		return baseMapper.selectSalesByOrderId(orderListId);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public boolean updateStatusById(Integer bondStatus, String listId) {
		Map<String, Object> map = new HashMap<>();
		map.put("bondStatus", bondStatus);
		map.put("listId", listId);
		return baseMapper.updateStatusById(map);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public boolean updateBondData(String listId, Integer bondStatus, String bondOrderNo, BigDecimal bondOrderMoney,BigDecimal bondFees) {
		Map<String, Object> map = new HashMap<>();
		map.put("bondStatus", bondStatus);
		map.put("bondOrderNo", bondOrderNo);
		map.put("bondOrderMoney", bondOrderMoney);
		map.put("bondFees", bondFees);
		map.put("listId", listId);
		return baseMapper.updateBondData(map);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public TenderBidBookSaleRecordEntity selectSaleByParams(Map<String, Object> params) {
		return baseMapper.selectSaleByParams(params);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public TenderBidBookSaleRecordEntity slectSlaeByBondOrderNo(String bondOrderNo) {
		return baseMapper.slectSlaeByBondOrderNo(bondOrderNo);
	}
}
