package com.scbid.bond.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.bond.entity.BondEnsupplierEntity;
import com.scbid.bond.entity.BondOrderEntity;
import com.scbid.common.utils.PageUtils;
import com.scbid.manage.entity.CrmSupplierEntity;

/**
 * 供应商服务
 * 
 * @author wangyun
 * @date 2018-05-14 13:00:01
 */
public interface BondEnsupplierService extends IService<BondEnsupplierEntity> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * @Title: findSupplierByUser
	 * @Description: 通过当前登录人获取对应的
	 * @author: chengyun
	 * @date: 2018年4月44日 上午10:10:58
	 * @param otherFeeId
	 * @return
	 */

	// delete();

	/**
	 * @Title: queryGuaranteeSupplier
	 * @Description: 担保供应商列表
	 * @author: 胡棋文
	 * @date: 2018年5月24日 上午10:47:11
	 * @param params
	 * @return
	 */
	PageUtils queryGuaranteeSupplier(Map<String, Object> params);

	List<Long> bondProject(Long supplierId, Long guaratorId, List<BondOrderEntity> orders, BigDecimal orderMoney);

	boolean importCrmSupplier(List<CrmSupplierEntity> crmSuppliers);

	/**
	 * @Title: findSupplierByUser
	 * @Description: 通过当前登录人获取对应的
	 * @author: chengyun
	 * @date: 2018年4月44日 上午10:10:58
	 * @param otherFeeId
	 * @return
	 */
	PageUtils findSupplierByUser(Map<String, Object> params);
	/**
	 * @Title: selectAllSupplier
	 * @Description: 查询所有供应商
	 * @author: chengyun
	 * @date: 2018年5月23日 上午10:10:58
	 * @return
	 */
	// PageUtils findAllSupplier(Map<String, Object> params);

	PageUtils selectBatchSupplierIds(Map<String, Object> params);

	PageUtils selectBatchUuids(Map<String, Object> params);
	/**
	 * @param supplierUuid
	 * @return
	 */
	BondEnsupplierEntity selectSupplierBySupplierUuid(String supplierUuid);

}
