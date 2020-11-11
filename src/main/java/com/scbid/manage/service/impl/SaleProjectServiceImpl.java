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
import com.scbid.manage.dao.SaleProjectDao;
import com.scbid.manage.entity.SaleProjectEntity;
import com.scbid.manage.service.SaleProjectService;


@Service("saleProjectService")
public class SaleProjectServiceImpl extends ServiceImpl<SaleProjectDao, SaleProjectEntity> implements SaleProjectService {

    @Override
    @TargetDataSource(name=DataSourceNames.SECOND)
    public PageUtils queryPage(Map<String, Object> params) {
    	
    	String projectName = (String) params.get("projectName");
    	
        Page<SaleProjectEntity> page = this.selectPage(
                new Query<SaleProjectEntity>(params).getPage(),
                new EntityWrapper<SaleProjectEntity>().like("PROJECT_NAME", projectName)
        );

        return new PageUtils(page);
    }

	@Override
	@TargetDataSource(name=DataSourceNames.SECOND)
	public List<SaleProjectEntity> selectBatchIds(List<String> idList) {
		return baseMapper.selectBatchIds(idList);
	}

}
