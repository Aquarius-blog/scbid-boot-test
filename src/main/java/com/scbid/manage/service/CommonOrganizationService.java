package com.scbid.manage.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.common.utils.PageUtils;
import com.scbid.manage.entity.CommonOrganizationEntity;

/**
 * 
 * @author wangyun
 * @date 2018-05-24 12:11:03
 */
public interface CommonOrganizationService extends IService<CommonOrganizationEntity> {

	PageUtils queryPage(Map<String, Object> params);
	
	CommonOrganizationEntity selectById(String listId);
}
