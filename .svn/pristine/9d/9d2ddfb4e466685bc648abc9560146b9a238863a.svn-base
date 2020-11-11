package com.scbid.manage.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.common.utils.PageUtils;
import com.scbid.manage.entity.SaleProjectEntity;

/**
 * 
 * @author wangyun
 * @date 2018-05-18 11:33:03
 */
public interface SaleProjectService extends IService<SaleProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    List<SaleProjectEntity> selectBatchIds(List<String> idList);
}

