package com.scbid.bond.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scbid.bond.entity.BondEnagencyEntity;
import com.scbid.bond.entity.BondEnguaratorEntity;
import com.scbid.bond.entity.BondEnsupplierEntity;
import com.scbid.bond.entity.BondOrderEntity;
import com.scbid.bond.entity.BondOrderItemEntity;
import com.scbid.bond.entity.BondProjectEntity;
import com.scbid.bond.service.BondEnagencyService;
import com.scbid.bond.service.BondEnguaratorService;
import com.scbid.bond.service.BondEnsupplierService;
import com.scbid.bond.service.BondOrderItemService;
import com.scbid.bond.service.BondOrderService;
import com.scbid.bond.service.BondProjectService;
import com.scbid.sys.controller.AbstractController;

@Controller
@RequestMapping("bond/templates")
public class TemplatesController extends AbstractController{
	
	@Autowired
	private BondOrderService bondOrderService;
	@Autowired
	private BondEnagencyService bondEnagencyService;
	@Autowired
	private BondEnguaratorService bondEnguaratorService;
	@Autowired
	private BondEnsupplierService bondEnsupplierService;
	@Autowired
	private BondOrderItemService bondOrderItemService;
	@Autowired
	private BondProjectService bondProjectService;
	/**
	 *  成都银行申请模板
	  * @Title: applicationTable
	  * @Description: TODO
	  * @author: wangyun
	  * @date: 2018年5月23日 上午11:06:05
	 */
	@RequestMapping("/cdyh/applicationTable")
	private String applicationTable(String orderId, ModelMap map) {
		BondOrderEntity bondOrder = bondOrderService.selectById(orderId);// 订单信息
		BondEnagencyEntity enagencyEntity = bondEnagencyService.selectById(bondOrder.getAgencyId());// 代理商信息
		if (enagencyEntity==null) {
			return null;
		}
		BondEnguaratorEntity enguaratorEntity = bondEnguaratorService.selectById(bondOrder.getGuaratorId());// 担保机构信息
		if (enguaratorEntity==null) {
			return null;
		}
		BondEnsupplierEntity ensupplierEntity = bondEnsupplierService.selectById(bondOrder.getSupplierId());// 供应商信息
		Map<String, Object> columnMap = new HashMap<String, Object>();
		columnMap.put("order_id", bondOrder.getOrderId());
		List<BondOrderItemEntity> itemList = bondOrderItemService.selectByMap(columnMap);
		List<Long> projectIds = new ArrayList<Long>();
		for (BondOrderItemEntity orderItem : itemList) {
			projectIds.add(orderItem.getProjectId());
		}
		List<BondProjectEntity> projects = bondProjectService.selectBatchIds(projectIds);
		BondProjectEntity bondProject = new BondProjectEntity();
		for (BondProjectEntity project : projects) {
			bondProject = project;
		}
		map.addAttribute("bondOrder",bondOrder);
		map.addAttribute("bondEnagency",enagencyEntity);
		map.addAttribute("bondEnguarator",enguaratorEntity);//担保机构
		map.addAttribute("bondEnsupplier",ensupplierEntity);//供应商
		map.addAttribute("bondProject",bondProject);
		
		return "modules/cdyh/applicationTableForId";
	}
	
	/**
	 *  成都银行凭证模板
	  * @Title: applicationTable
	  * @Description: TODO
	  * @author: wangyun
	  * @date: 2018年5月23日 上午11:06:05
	 */
	@RequestMapping("/cdyh/voucherTable")
	private String voucherTable(String orderId, ModelMap map) {
		BondOrderEntity bondOrder = bondOrderService.selectById(orderId);// 订单信息
		BondEnagencyEntity enagencyEntity = bondEnagencyService.selectById(bondOrder.getAgencyId());// 代理商信息
		if (enagencyEntity==null) {
			return null;
		}
		BondEnguaratorEntity enguaratorEntity = bondEnguaratorService.selectById(bondOrder.getGuaratorId());// 担保机构信息
		if (enguaratorEntity==null) {
			return null;
		}
		BondEnsupplierEntity ensupplierEntity = bondEnsupplierService.selectById(bondOrder.getSupplierId());// 供应商信息
		Map<String, Object> columnMap = new HashMap<String, Object>();
		columnMap.put("order_id", bondOrder.getOrderId());
		List<BondOrderItemEntity> itemList = bondOrderItemService.selectByMap(columnMap);
		List<Long> projectIds = new ArrayList<Long>();
		for (BondOrderItemEntity orderItem : itemList) {
			projectIds.add(orderItem.getProjectId());
		}
		List<BondProjectEntity> projects = bondProjectService.selectBatchIds(projectIds);
		BondProjectEntity bondProject = new BondProjectEntity();
		for (BondProjectEntity project : projects) {
			bondProject = project;
		}
		map.addAttribute("bondOrder",bondOrder);
		map.addAttribute("bondEnagency",enagencyEntity);
		map.addAttribute("bondEnguarator",enguaratorEntity);//担保机构
		map.addAttribute("bondEnsupplier",ensupplierEntity);//供应商
		map.addAttribute("bondProject",bondProject);
		
		return "modules/cdyh/orderDocuments";
	}
								
	
}
