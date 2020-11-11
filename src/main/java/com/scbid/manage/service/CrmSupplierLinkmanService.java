package com.scbid.manage.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.common.utils.PageUtils;
import com.scbid.manage.entity.CrmSupplierLinkmanEntity;

/**
 * 
 * @author wangyun
 * @date 2018-05-17 16:27:22
 */
public interface CrmSupplierLinkmanService extends IService<CrmSupplierLinkmanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    List<CrmSupplierLinkmanEntity> selectList();
}

