package com.scbid.sys.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.common.utils.PageUtils;
import com.scbid.sys.entity.BondLogEntity;

/**
 * 系统日志
 *
 * @author wangyun
 * @email 278812723
 * @date 2018-05-12 08:25:10
 */
public interface BondLogService extends IService<BondLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

