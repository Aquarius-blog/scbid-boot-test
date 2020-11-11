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
import com.scbid.manage.dao.CommonAttachmentDao;
import com.scbid.manage.entity.CommonAttachmentEntity;
import com.scbid.manage.service.CommonAttachmentService;


@Service("commonAttachmentService")
public class CommonAttachmentServiceImpl extends ServiceImpl<CommonAttachmentDao, CommonAttachmentEntity> implements CommonAttachmentService {

    @Override
    @TargetDataSource(name=DataSourceNames.SECOND)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CommonAttachmentEntity> page = this.selectPage(
                new Query<CommonAttachmentEntity>(params).getPage(),
                new EntityWrapper<CommonAttachmentEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	@TargetDataSource(name=DataSourceNames.SECOND)
	public List<CommonAttachmentEntity> commonAttachmentPage(Map<String, Object> params) {
		return baseMapper.commonAttachmentPage(params);
	}

}
