package com.scbid.manage.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.common.utils.PageUtils;
import com.scbid.manage.entity.CommonAttachmentEntity;

/**
 * 用户角色
 * 
 * @author wangyun
 * @date 2018-12-18 14:51:27
 */
public interface CommonAttachmentService extends IService<CommonAttachmentEntity> {

	PageUtils queryPage(Map<String, Object> params);

	List<CommonAttachmentEntity> commonAttachmentPage(Map<String, Object> params);

}
