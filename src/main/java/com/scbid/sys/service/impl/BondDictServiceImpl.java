package com.scbid.sys.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;
import com.scbid.sys.dao.BondDictDao;
import com.scbid.sys.entity.BondDictEntity;
import com.scbid.sys.service.BondDictService;


@Service("bondDictService")
public class BondDictServiceImpl extends ServiceImpl<BondDictDao, BondDictEntity> implements BondDictService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BondDictEntity> page = this.selectPage(
                new Query<BondDictEntity>(params).getPage(),
                new EntityWrapper<BondDictEntity>()
        );

        return new PageUtils(page);
    }

}
