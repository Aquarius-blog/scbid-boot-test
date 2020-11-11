package com.scbid.bond.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.bond.dao.BondOrderFileDao;
import com.scbid.bond.entity.BondOrderFileEntity;
import com.scbid.bond.service.BondOrderFileService;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;

@Service("bondOrderFileService")
public class BondOrderFileServiceImpl extends ServiceImpl<BondOrderFileDao, BondOrderFileEntity> implements BondOrderFileService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<BondOrderFileEntity> page = this.selectPage(new Query<BondOrderFileEntity>(params).getPage(), new EntityWrapper<BondOrderFileEntity>());

		return new PageUtils(page);
	}

	@Override
	public List<BondOrderFileEntity> queryList(Long orderId) {
		Wrapper<BondOrderFileEntity> wrapper = new EntityWrapper<BondOrderFileEntity>();
		wrapper.eq("order_id", orderId);
		return baseMapper.selectList(wrapper);
	}

}
