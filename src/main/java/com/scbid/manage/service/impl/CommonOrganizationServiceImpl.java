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
import com.scbid.manage.dao.CommonOrganizationDao;
import com.scbid.manage.entity.CommonOrganizationEntity;
import com.scbid.manage.service.CommonOrganizationService;

@Service("commonOrganizationService")
public class CommonOrganizationServiceImpl extends ServiceImpl<CommonOrganizationDao, CommonOrganizationEntity> implements CommonOrganizationService {

    @Override
    @TargetDataSource(name=DataSourceNames.SECOND)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CommonOrganizationEntity> page = this.selectPage(
                new Query<CommonOrganizationEntity>(params).getPage(),
                new EntityWrapper<CommonOrganizationEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	@TargetDataSource(name=DataSourceNames.SECOND)
	public CommonOrganizationEntity selectById(String listId) {
		return baseMapper.selectById(listId);
	}

}
