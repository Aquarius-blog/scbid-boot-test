package com.scbid.bond.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.bond.entity.BondEnagencyEntity;
import com.scbid.bond.entity.BondProjectEntity;
import com.scbid.common.utils.PageUtils;
import com.scbid.manage.entity.SaleProjectEntity;
import com.scbid.manage.entity.TenderBidBookSaleRecordEntity;

/**
 * 
 * @author wangyun
 * @date 2018-05-14 13:00:02
 */
public interface BondProjectService extends IService<BondProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    /**
   	 * @Title: findSupplierProjectByUser
   	 * @Description: 通过当前登录人获取对应的供应商项目列表
   	 * @author: chengyun
        * @param projectName 
   	 * @date: 2018年5月16日 上午10:10:58
   	 * @param otherFeeId
   	 * @return
   	 */
     PageUtils findSupplierProjectByUser(Map<String, Object> params);

    
    /** @Title: queryGuaranteeProjectList 
     * @Description: 账号担保项目列表
     * @author: 胡棋文  
     * @date: 2018年5月22日 上午11:16:36 
     * @param params
     * @return 
     */
    PageUtils queryGuaranteeProjectList(Map<String, Object> params);

    
    /** @Title: queryGuaranteeProjecttByorderId 
     * @Description: 通过orderId 查订单项目
     * @author: 胡棋文  
     * @date: 2018年5月22日 上午11:21:17 
     * @param orderId
     * @return 
     */
    BondProjectEntity  queryGuaranteeProjecttByorderId(String orderId);
    
    PageUtils queryPageProjects(Map<String, Object> params);
    /**
      * @author: wangyun
      * @param entUuid 代理机构UUID
      * @param projectMap 选择的项目列表
      * @param saleRecords 确认保函的项目列表	
      * @return
     */
	boolean guarantee(List<BondEnagencyEntity> agencys, Map<String, SaleProjectEntity> projectMap, List<TenderBidBookSaleRecordEntity> saleRecords);

	PageUtils selectBatchProjectIds(Map<String, Object> params);


	
	 /**
     * 通过订单拿到项目
     *  @author: chengyun
     */
   List<BondProjectEntity> findProjectByOrder(Map<String, Object> params);
	
}

