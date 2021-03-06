package com.scbid.bond.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.scbid.bond.entity.BondProjectEntity;
/**
 * 
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-14 13:00:02
 */
@Mapper
public interface BondProjectDao extends BaseMapper<BondProjectEntity> {

	
	
	/** @Title: queryGuaranteeProjectt 
	 * @Description:  通过orderId 查订单项目
	 * @author: 胡棋文  
	 * @date: 2018年5月22日 上午11:20:37 
	 * @param orderId
	 * @return 
	 */
	BondProjectEntity queryGuaranteeProjecttByorderId(String orderId);
	
	
	List<BondProjectEntity> queryPageProjects(Pagination page, Map<String, Object> params);

	/**
	 * 
	 * 
	 * @author 程云
	 * @date 2018-05-15 13:00:01
	 */
	List<BondProjectEntity> findSupplierProjectByUser(Pagination page,Map<String, Object> params);
	
	/** @Title: queryGuaranteeProjectList 
	 * @Description: 角色担保项目列表
	 * @author: 胡棋文  
	 * @date: 2018年5月22日 上午11:22:32 
	 * @param page
	 * @param params
	 * @return 
	 */
	List<BondProjectEntity> queryGuaranteeProjectList(Pagination page,Map<String, Object> params);


	List<BondProjectEntity> selectBatchProjectIds(Pagination page, Map<String, Object> params);
	
	/**
	 * @author 程云
	 * @date 2018-06-01 19:00:01
	 */
	List<BondProjectEntity> findProjectByOrder(Map<String, Object> params);
}
