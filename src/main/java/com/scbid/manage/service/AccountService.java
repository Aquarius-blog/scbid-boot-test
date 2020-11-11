package com.scbid.manage.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.common.utils.PageUtils;
import com.scbid.manage.entity.AccountEntity;

/**
 * 
 * @author wangyun
 * @date 2018-05-14 15:48:47
 */
public interface AccountService extends IService<AccountEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    List<AccountEntity> selectList();
    
    AccountEntity selectById(String listId);
}

