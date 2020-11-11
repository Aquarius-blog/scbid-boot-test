package com.scbid.bond.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.bond.entity.BondEnagencyEntity;
import com.scbid.common.utils.PageUtils;

/**
 * 
 * @author wangyun
 * @date 2018-05-14 13:00:02
 */
public interface BondEnagencyService extends IService<BondEnagencyEntity> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * @author chengyun 查询所有代理商
	 */
	List<BondEnagencyEntity> selectAll();

	PageUtils queryPageAgencys(Map<String, Object> params);

	PageUtils selectBatchAgencyIds(Map<String, Object> params);

	BondEnagencyEntity selectByAgencyUuid(String agencyUuid);

}
