package com.scbid.bond.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scbid.bond.entity.BondEnguaratorEntity;
import com.scbid.bond.entity.BondOrderEntity;
import com.scbid.bond.entity.BondOrderItemEntity;
import com.scbid.bond.service.BondEnguaratorService;
import com.scbid.bond.service.BondEnsupplierService;
import com.scbid.bond.service.BondOrderItemService;
import com.scbid.bond.service.BondOrderService;
import com.scbid.bond.service.BondProjectService;
import com.scbid.common.utils.Constant;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.R;
import com.scbid.sys.controller.AbstractController;

/**
 * 
 * @Title: BondEnguaratorController.java
 * @Description: 担保机构
 * @Package com.scbid.bond.controller
 * @Author: wangyun
 * @Date: 2018年5月14日
 * @Copyright: 四川国际招标有限责任公司 注意：本内容仅限于必朗科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@RestController
@RequestMapping("bond/bondenguarator")
public class BondEnguaratorController extends AbstractController {

	@Autowired
	private BondEnguaratorService bondEnguaratorService;

	@Autowired
	private BondOrderService bondOrderService;

	@Autowired
	private BondOrderItemService bondOrderItemService;
	/**
	 * 供应商服务类
	 */
	@Autowired
	private BondEnsupplierService bondEnsupplierService;

	@Autowired
	private BondProjectService bondProjectService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	// @RequiresPermissions("bond:bondenguarator:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = bondEnguaratorService.queryPage(params);

		return R.ok().put("page", page);
	}

	@RequestMapping("/select")
	// @RequiresPermissions("bond:bondenguarator:select")
	public R select() {
		List<BondEnguaratorEntity> list = bondEnguaratorService.selectByMap(null);
		return R.ok().put("bondEnguarators", list);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{guaratorId}")
	// @RequiresPermissions("bond:bondenguarator:info")
	public R info(@PathVariable("guaratorId") Long guaratorId) {
		BondEnguaratorEntity bondEnguarator = bondEnguaratorService.selectById(guaratorId);

		return R.ok().put("bondEnguarator", bondEnguarator);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	// @RequiresPermissions("bond:bondenguarator:save")
	public R save(@RequestBody BondEnguaratorEntity bondEnguarator) {
		bondEnguaratorService.insert(bondEnguarator);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	// @RequiresPermissions("bond:bondenguarator:update")
	public R update(@RequestBody BondEnguaratorEntity bondEnguarator) {
		bondEnguaratorService.updateById(bondEnguarator);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	// @RequiresPermissions("bond:bondenguarator:delete")
	public R delete(@RequestBody Long[] guaratorIds) {
		bondEnguaratorService.deleteBatchIds(Arrays.asList(guaratorIds));

		return R.ok();
	}

	/**
	 * 导入
	 */
	@RequestMapping("/import")
	// @RequiresPermissions("bond:bondenguarator:import")
	public R importFile(@RequestParam Map<String, Object> params) {

		return R.ok();
	}

	/**
	 * 导出
	 */
	@RequestMapping("/export")
	// @RequiresPermissions("bond:bondenguarator:export")
	public R exportFile(@RequestParam Map<String, Object> params) {

		return R.ok();
	}

	/**
	 * @Title: guaranteeOrderList
	 * @Description: 担保订单列表
	 * @author: 胡棋文
	 * @date: 2018年5月24日 上午10:41:48
	 * @param params
	 * @return
	 */
	@RequestMapping("/guaranteeOrderList")
	public R guaranteeOrderList(@RequestParam Map<String, Object> params) {
		PageUtils orders = new PageUtils();
		// 系统管理员权限查询所有订单信息
		if (Constant.RoleType.SYSTEM_ADMIN.getValue() == getRoleId()) {
			orders = bondOrderService.queryPageOrders(params);
			return R.ok().put("page", orders);
		} else {
			List<Long> guaratorIds = new ArrayList<>();
			Map<String, Object> columnMap = new HashMap<String, Object>();
			columnMap.put("GUARATOR_UUID", getEntUuid());
			List<BondEnguaratorEntity> list = bondEnguaratorService.selectByMap(columnMap);
			if (list == null || list.size() == 0) {
				return R.ok(getUser().getEntName() + "担保机构信息不存在");
			}
			for (BondEnguaratorEntity entity : list) {
				// 查询是否存在子机构
				columnMap = new HashMap<String, Object>();
				columnMap.put("PARENT_ID", entity.getGuaratorId());
				list = bondEnguaratorService.selectByMap(columnMap);
				if (list != null && list.size() > 0) {
					for (BondEnguaratorEntity guarator : list) {
						guaratorIds.add(guarator.getGuaratorId());
					}
				}
				guaratorIds.add(entity.getGuaratorId());
			}
			params.put("guaratorIds", guaratorIds);
			orders = bondOrderService.queryPageOrders(params);
			return R.ok().put("page", orders);
		}
	}

	/**
	 * 担保供应商列表
	 */
	@RequestMapping("/queryGuaranteeSupplier")
	public R queryGuaranteeSupplier(@RequestParam Map<String, Object> params) {
		PageUtils suppliers = new PageUtils();
		if (Constant.RoleType.SYSTEM_ADMIN.getValue() == getRoleId()) {
			suppliers = bondEnsupplierService.queryGuaranteeSupplier(params);
		} else {
			Map<String, Object> newParams = new HashMap<String, Object>();
			newParams.put("guarator_uuid", getEntUuid());
			List<BondEnguaratorEntity> list = bondEnguaratorService.selectByMap(newParams);
			if (list == null || list.size() == 0) {
				return R.ok(getUser().getEntName() + "担保机构信息不存在");
			}
			newParams = new HashMap<String, Object>();
			for (BondEnguaratorEntity entity : list) {
				newParams.put("guarator_id", entity.getGuaratorId());
			}
			List<Long> supplierIds = new ArrayList<Long>();
			List<BondOrderEntity> orders = bondOrderService.selectByMap(newParams);
			for (BondOrderEntity order : orders) {
				if (order.getSupplierId() != null) {
					supplierIds.add(Long.valueOf(order.getSupplierId()));
				}
			}
			if (supplierIds.isEmpty()) {
				return R.ok().put("page", suppliers);
			}
			params.put("supplierIds", supplierIds);
			suppliers = bondEnsupplierService.selectBatchSupplierIds(params);
		}
		return R.ok().put("page", suppliers);
	}

	/**
	 * 担保项目列表
	 */
	@RequestMapping("/guaranteeProjectList")
	public R guaranteeProjectList(@RequestParam Map<String, Object> params) {
		PageUtils projects = new PageUtils();
		if (Constant.RoleType.SYSTEM_ADMIN.getValue() == getRoleId()) {
			projects = bondProjectService.queryPageProjects(params);
			return R.ok().put("page", projects);
		}

		Map<String, Object> newParams = new HashMap<String, Object>();
		newParams.put("guarator_uuid", getEntUuid());
		List<BondEnguaratorEntity> list = bondEnguaratorService.selectByMap(newParams);
		if (list == null || list.size() == 0) {
			return R.ok(getUser().getEntName() + "担保机构信息不存在");
		}
		newParams = new HashMap<String, Object>();
		for (BondEnguaratorEntity entity : list) {
			newParams.put("guarator_id", entity.getGuaratorId());
		}
		List<Long> orderIds = new ArrayList<Long>();
		List<BondOrderEntity> orders = bondOrderService.selectByMap(newParams);
		for (BondOrderEntity order : orders) {
			orderIds.add(order.getOrderId());
		}
		newParams = new HashMap<String, Object>();
		newParams.put("orderIds", orderIds);
		List<BondOrderItemEntity> itemEntities = bondOrderItemService.selectBatchOrderIds(newParams);
		List<Long> projectIds = new ArrayList<Long>();
		for (BondOrderItemEntity orderItem : itemEntities) {
			projectIds.add(orderItem.getProjectId());
		}
		params.put("projectIds", projectIds);
		projects = bondProjectService.selectBatchProjectIds(params);
		return R.ok().put("page", projects);
	}

}
