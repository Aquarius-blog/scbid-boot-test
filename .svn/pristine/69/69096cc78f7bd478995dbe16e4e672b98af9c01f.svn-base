package com.scbid.bond.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.bond.dao.BondOrderItemDao;
import com.scbid.bond.entity.BondOrderItemEntity;
import com.scbid.bond.service.BondOrderItemService;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;


@Service("bondOrderItemService")
public class BondOrderItemServiceImpl extends ServiceImpl<BondOrderItemDao, BondOrderItemEntity> implements BondOrderItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BondOrderItemEntity> page = this.selectPage(
                new Query<BondOrderItemEntity>(params).getPage(),
                new EntityWrapper<BondOrderItemEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<BondOrderItemEntity> selectBatchOrderIds(Map<String, Object> newParams) {
		return baseMapper.selectBatchOrderIds(newParams);
	}

}
