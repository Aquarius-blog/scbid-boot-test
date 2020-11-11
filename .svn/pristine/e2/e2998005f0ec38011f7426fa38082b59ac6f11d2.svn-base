package com.scbid.manage.service.impl;

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
import com.scbid.manage.dao.TenderImplemenProjectDao;
import com.scbid.manage.entity.TenderImplemenProjectEntity;
import com.scbid.manage.service.TenderImplemenProjectService;

@Service("tenderImplemenProjectService")
public class TenderImplemenProjectServiceImpl extends ServiceImpl<TenderImplemenProjectDao, TenderImplemenProjectEntity> implements TenderImplemenProjectService {

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public PageUtils queryPage(Map<String, Object> params) {
		Page<TenderImplemenProjectEntity> page = this.selectPage(new Query<TenderImplemenProjectEntity>(params).getPage(), new EntityWrapper<TenderImplemenProjectEntity>());

		return new PageUtils(page);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public List<TenderImplemenProjectEntity> selectBatchIds(List<String> idList) {
		return baseMapper.selectBatchIds(idList);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public TenderImplemenProjectEntity selectById(String listId) {
		return baseMapper.selectById(listId);
	}

}
