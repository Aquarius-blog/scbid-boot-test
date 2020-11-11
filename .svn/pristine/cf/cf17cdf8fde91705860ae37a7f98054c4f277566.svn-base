package com.scbid.bond.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.bond.dao.BondEnguaratorDao;
import com.scbid.bond.entity.BondEnguaratorEntity;
import com.scbid.bond.service.BondEnguaratorService;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;

@Service("bondEnguaratorService")
public class BondEnguaratorServiceImpl extends ServiceImpl<BondEnguaratorDao, BondEnguaratorEntity> implements BondEnguaratorService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<BondEnguaratorEntity> page = this.selectPage(new Query<BondEnguaratorEntity>(params).getPage(), new EntityWrapper<BondEnguaratorEntity>());

		return new PageUtils(page);
	}

	@Override
	public PageUtils queryPageGuarators(Map<String, Object> params) {
		Page<BondEnguaratorEntity> page = new Query<BondEnguaratorEntity>(params).getPage();
		page.setRecords(baseMapper.queryPageGuarators(page, params));
		return new PageUtils(page);
	}

	@Override
	public PageUtils selectBatchGuaratorIds(Map<String, Object> params) {
		Page<BondEnguaratorEntity> page = new Query<BondEnguaratorEntity>(params).getPage();
		page.setRecords(baseMapper.selectBatchGuaratorIds(page, params));
		return new PageUtils(page);
	}

	@Override
	public BondEnguaratorEntity querGuaratorByOrderId(String orderId) {

		return null;
	}

	@Override
	public BondEnguaratorEntity selectByGuaratorUuids(String guaratorUuid) {
		return baseMapper.selectByGuaratorUuids(guaratorUuid);
	}

	@Override
	public List<BondEnguaratorEntity> queryListByMap(Map<String, Object> params) {
		return baseMapper.queryListByMap(params);
	}

}
