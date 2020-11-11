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
import com.scbid.manage.dao.CrmSupplierAccountDao;
import com.scbid.manage.entity.CrmSupplierAccountEntity;
import com.scbid.manage.service.CrmSupplierAccountService;

@Service("crmSupplierAccountService")
public class CrmSupplierAccountServiceImpl extends ServiceImpl<CrmSupplierAccountDao, CrmSupplierAccountEntity> implements CrmSupplierAccountService {

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public PageUtils queryPage(Map<String, Object> params) {
		Page<CrmSupplierAccountEntity> page = this.selectPage(new Query<CrmSupplierAccountEntity>(params).getPage(), new EntityWrapper<CrmSupplierAccountEntity>());

		return new PageUtils(page);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public List<CrmSupplierAccountEntity> selectList() {
		return baseMapper.selectList(null);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public CrmSupplierAccountEntity selectSupplierByListId(String listId) {
		return baseMapper.selectSupplierByListId(listId);
	}

	@Override
	@TargetDataSource(name = DataSourceNames.SECOND)
	public CrmSupplierAccountEntity selectSupplierBySupplierId(String supplierId) {
		return baseMapper.selectSupplierBySupplierId(supplierId);
	}

}
