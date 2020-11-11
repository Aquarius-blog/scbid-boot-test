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
import com.scbid.manage.dao.CrmSupplierDao;
import com.scbid.manage.entity.CrmSupplierEntity;
import com.scbid.manage.service.CrmSupplierService;


@Service("crmSupplierService")
public class CrmSupplierServiceImpl extends ServiceImpl<CrmSupplierDao, CrmSupplierEntity> implements CrmSupplierService {

    @Override
    @TargetDataSource(name=DataSourceNames.SECOND)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CrmSupplierEntity> page = this.selectPage(
                new Query<CrmSupplierEntity>(params).getPage(),
                new EntityWrapper<CrmSupplierEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	@TargetDataSource(name=DataSourceNames.SECOND)
	public List<CrmSupplierEntity> selectList() {
		return baseMapper.selectList(null);
	}

	@Override
	@TargetDataSource(name=DataSourceNames.SECOND)
	public CrmSupplierEntity selectById(String listId) {
		return baseMapper.selectById(listId);
	}

}
