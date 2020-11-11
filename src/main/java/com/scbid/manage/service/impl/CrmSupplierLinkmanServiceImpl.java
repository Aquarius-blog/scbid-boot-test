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
import com.scbid.manage.dao.CrmSupplierLinkmanDao;
import com.scbid.manage.entity.CrmSupplierLinkmanEntity;
import com.scbid.manage.service.CrmSupplierLinkmanService;


@Service("crmSupplierLinkmanService")
public class CrmSupplierLinkmanServiceImpl extends ServiceImpl<CrmSupplierLinkmanDao, CrmSupplierLinkmanEntity> implements CrmSupplierLinkmanService {

    @Override
    @TargetDataSource(name=DataSourceNames.SECOND)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CrmSupplierLinkmanEntity> page = this.selectPage(
                new Query<CrmSupplierLinkmanEntity>(params).getPage(),
                new EntityWrapper<CrmSupplierLinkmanEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	@TargetDataSource(name=DataSourceNames.SECOND)
	public List<CrmSupplierLinkmanEntity> selectList() {
		return baseMapper.selectList(null);
	}

}
