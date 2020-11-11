package com.scbid.manage.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.common.utils.PageUtils;
import com.scbid.manage.entity.TenderImplemenProjectEntity;
import com.scbid.manage.entity.TenderImplemenProjectPackagesEntity;

/**
 * 
 * @author wangyun
 * @date 2018-10-30 21:24:11
 */
public interface TenderImplemenProjectPackagesService extends IService<TenderImplemenProjectPackagesEntity> {

	PageUtils queryPage(Map<String, Object> params);

	TenderImplemenProjectPackagesEntity selectById(String listId);
}
