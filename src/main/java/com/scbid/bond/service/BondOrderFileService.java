package com.scbid.bond.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.bond.entity.BondOrderFileEntity;
import com.scbid.common.utils.PageUtils;

/**
 * 
 * @author wangyun
 * @date 2019-06-25 09:33:49
 */
public interface BondOrderFileService extends IService<BondOrderFileEntity> {

	PageUtils queryPage(Map<String, Object> params);

	List<BondOrderFileEntity> queryList(Long orderId);
}
