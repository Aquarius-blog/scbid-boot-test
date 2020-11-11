package com.scbid.bond.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.bond.dao.BondOrderStatusDao;
import com.scbid.bond.entity.BondOrderStatusEntity;
import com.scbid.bond.service.BondOrderStatusService;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;


@Service("bondOrderStatusService")
public class BondOrderStatusServiceImpl extends ServiceImpl<BondOrderStatusDao, BondOrderStatusEntity> implements BondOrderStatusService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BondOrderStatusEntity> page = this.selectPage(
                new Query<BondOrderStatusEntity>(params).getPage(),
                new EntityWrapper<BondOrderStatusEntity>()
        );

        return new PageUtils(page);
    }

}
