package com.scbid.sys.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;
import com.scbid.sys.dao.BondLogDao;
import com.scbid.sys.entity.BondLogEntity;
import com.scbid.sys.service.BondLogService;


@Service("bondLogService")
public class BondLogServiceImpl extends ServiceImpl<BondLogDao, BondLogEntity> implements BondLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BondLogEntity> page = this.selectPage(
                new Query<BondLogEntity>(params).getPage(),
                new EntityWrapper<BondLogEntity>()
        );

        return new PageUtils(page);
    }

}
