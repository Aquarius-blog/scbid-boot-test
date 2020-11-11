package com.scbid.api.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.scbid.bond.entity.BondEnguaratorEntity;
import com.scbid.bond.entity.BondEnsupplierEntity;
import com.scbid.bond.entity.BondOrderEntity;
import com.scbid.bond.entity.BondOrderFileEntity;
import com.scbid.bond.service.BondEnguaratorService;
import com.scbid.bond.service.BondEnsupplierService;
import com.scbid.bond.service.BondOrderFileService;
import com.scbid.bond.service.BondOrderService;
import com.scbid.common.config.AliyunOSSUtils;
import com.scbid.common.config.AliyunOssConfig;
import com.scbid.common.utils.BLUUIDUitls;
import com.scbid.common.utils.DateUtils;
import com.scbid.common.utils.R;
import com.scbid.manage.entity.CommonAttachmentEntity;
import com.scbid.manage.entity.CrmSupplierAccountEntity;
import com.scbid.manage.entity.CrmSupplierEntity;
import com.scbid.manage.entity.SaleOrderBondStatusEnum;
import com.scbid.manage.entity.SaleOrderManagementEntity;
import com.scbid.manage.entity.TenderBidBookSaleRecordEntity;
import com.scbid.manage.entity.TenderImplemenProjectEntity;
import com.scbid.manage.entity.TenderImplemenProjectPackagesEntity;
import com.scbid.manage.service.CommonAttachmentService;
import com.scbid.manage.service.CrmSupplierAccountService;
import com.scbid.manage.service.CrmSupplierService;
import com.scbid.manage.service.SaleOrderManagementService;
import com.scbid.manage.service.TenderBidBookSaleRecordService;
import com.scbid.manage.service.TenderImplemenProjectPackagesService;
import com.scbid.manage.service.TenderImplemenProjectService;
import com.scbid.sys.controller.AbstractController;
import com.scbid.sys.entity.BondUserEntity;
@RestController
@RequestMapping("bond/api")
public class BondApiController extends AbstractController {
	@Autowired
	private SaleOrderManagementService saleOrderManagementService;
	@Autowired
	private TenderImplemenProjectService tenderImplemenProjectService;
	@Autowired
	private TenderImplemenProjectPackagesService tenderImplemenProjectPackagesService;

	@Autowired
	private TenderBidBookSaleRecordService tenderBidBookSaleRecordService;

	@Autowired
	private BondOrderService bondOrderService;

	@Autowired
	private BondEnguaratorService bondEnguaratorService;

	/**
	 * 供应商服务类
	 */
	@Autowired
	private BondEnsupplierService bondEnsupplierService;

	@Autowired
	private CrmSupplierAccountService crmSupplierAccountService;

	@Autowired
	private CrmSupplierService crmSupplierService;

	@Autowired
	private AliyunOssConfig aliyunOssConfig;

	@Autowired
	private CommonAttachmentService commonAttachmentService;

	@Autowired
	private BondOrderFileService bondOrderFileService;
	/**
	 * 填写申请资料页面数据信息提交
	 * 
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/saveApplication", method = {RequestMethod.POST, RequestMethod.GET})
	public R saveApplication(@RequestParam Map<String, Object> params) {
		logger.info("saveApplication保函申请数据信息新增");
		String business = (String) params.get("business");// 订单ID
		String saleOrderId = (String) params.get("saleOrderId");// 订单ID
		String saleOrderNo = (String) params.get("saleOrderNo");// 订单编号
		String projectId = (String) params.get("projectId");// 项目
		String packageId = (String) params.get("packageId");// 分包
		String supplierId = (String) params.get("supplierId");// 供应商
		String eigenCode = (String) params.get("eigenCode");// 企业中征码(贷款卡号)
		String orderMoney = (String) params.get("orderMoney");// 保函申请金额
		String person = (String) params.get("person");// 单位负责人
		String telephone = (String) params.get("telephone");// 单位负责人电话

		// 检查订单是否存在saleOrderNo格式不正确只能做单独查询

		SaleOrderManagementEntity saleOrder = saleOrderManagementService.queryOrderByOrderCode(saleOrderNo);
		if (saleOrder == null) {
			return R.error("保函申请订单查询失败!");
		}
		// 检查项目是否存在
		TenderImplemenProjectEntity project = tenderImplemenProjectService.selectById(projectId);
		if (project == null) {
			return R.error("保函申请订单项目查询失败!");
		}
		// 检查分包是否存在
		TenderImplemenProjectPackagesEntity projectPackage = tenderImplemenProjectPackagesService.selectById(packageId);
		if (projectPackage == null) {
			return R.error("保函申请订单分包查询失败!");
		}
		// 修改售卖成功后的订单记录为申请
		TenderBidBookSaleRecordEntity saleRecordEntity = tenderBidBookSaleRecordService.selectSaleByParams(params);
		if (saleRecordEntity == null) {
			return R.error("保函申请订单售卖记录查询失败!");
		}

		// 比较金额单位为万元

		BigDecimal bondMoney = new BigDecimal(orderMoney);

		BigDecimal bondFees = calculationBondMoney(bondMoney);// 投标保函咨询服务收费标准
		// 保存供应商申请信息

		BondOrderEntity bondOrderEntity = new BondOrderEntity();
		String bondOrderNo = BLUUIDUitls.generateUUID();
		bondOrderEntity.setOrderNo(bondOrderNo);
		bondOrderEntity.setEigenCode(eigenCode);
		bondOrderEntity.setOrderMoney(bondMoney);
		bondOrderEntity.setBondFees(bondFees);
		bondOrderEntity.setPerson(person);
		bondOrderEntity.setTelephone(telephone);

		bondOrderEntity.setSaleOrderId(saleOrderId);
		bondOrderEntity.setProjectId(projectId);
		bondOrderEntity.setProjectCode(project.getProjectCode());
		bondOrderEntity.setProjectName(project.getProjectName());
		bondOrderEntity.setPackageId(packageId);
		bondOrderEntity.setPackagesNum(projectPackage.getPackagesNum());
		bondOrderEntity.setPackagesName(projectPackage.getPackagesName());
		bondOrderEntity.setBondMoney(bondMoney);
		bondOrderEntity.setSupplierUuid(supplierId);

		// 非商业投标保函申请
		if ("0".equals(business)) {
			logger.info("非商业投标保函申请");
			return bankBond(params, bondOrderEntity, saleRecordEntity, bondFees);
		}
		// 商业投标保函申请
		else if ("1".equals(business)) {
			logger.info("商业投标保函申请");
			return businessBond(params, bondOrderEntity, saleRecordEntity, bondFees);
		} else {
			logger.info("不存在的保函申请类型");
			return R.error("不存在的保函申请类型");
		}
	}

	/**
	 * 非商业投标保函申请 银行投标保函（线上提交申请，线下提交资料）
	 * 
	 * @param params
	 * @param bondOrderEntity
	 * @param saleRecordEntity
	 * @param bondFees
	 * @return
	 */
	private R bankBond(Map<String, Object> params, BondOrderEntity bondOrderEntity, TenderBidBookSaleRecordEntity saleRecordEntity, BigDecimal bondFees) {
		Map<String, Object> map = new HashMap<>();
		// 担保机构
		Map<String, Object> queryParams = new HashMap<>();
		Map<String, Object> newParams = new HashMap<>();
		newParams.put("GUARATOR_TYPE", "0");// 商业担保结构
		newParams.put("PARENT_ID", "0");// 商业担保结构
		List<BondEnguaratorEntity> guarators = bondEnguaratorService.selectByMap(newParams);
		if (guarators == null || guarators.size() == 0) {
			return R.error("暂无银行投标保函担保机构");
		}
		Random random = new Random();// 担保机构角色中随机
		int index = random.nextInt(guarators.size());
		BondEnguaratorEntity guarator = guarators.get(index);
		bondOrderEntity.setGuaratorId(guarator.getGuaratorId());
		bondOrderEntity.setAgencyId(1L);
		BondUserEntity user = bondUserService.selectUserByEntUuid(bondOrderEntity.getSupplierUuid());
		BondEnsupplierEntity ensupplierEntity = bondEnsupplierService.selectSupplierBySupplierUuid(bondOrderEntity.getSupplierUuid());
		if (user == null) {
			CrmSupplierAccountEntity accountEntity = crmSupplierAccountService.selectSupplierBySupplierId(bondOrderEntity.getSupplierUuid());
			List<CrmSupplierAccountEntity> accountEntities = new ArrayList<CrmSupplierAccountEntity>();
			if (accountEntity != null) {
				accountEntities.add(accountEntity);
			}
			bondUserService.importSupplier(getUser(), accountEntities);
		}
		if (ensupplierEntity == null) {
			CrmSupplierEntity supplierEntity = crmSupplierService.selectById(bondOrderEntity.getSupplierUuid());
			if (supplierEntity != null) {
				// businesslicenseurl
				// 查询营业执照号
				queryParams = new HashMap<>();
				queryParams.put("param", 3);
				queryParams.put("businessId", bondOrderEntity.getSupplierUuid());
				List<CommonAttachmentEntity> entities = commonAttachmentService.commonAttachmentPage(queryParams);
				for (CommonAttachmentEntity entity : entities) {
					supplierEntity.setBusinesslicenseurl(entity.getFieldId());
				}
				List<CrmSupplierEntity> crmSuppliers = new ArrayList<CrmSupplierEntity>();
				crmSuppliers.add(supplierEntity);
				bondEnsupplierService.importCrmSupplier(crmSuppliers);
			}
		}

		BondEnsupplierEntity entity = bondEnsupplierService.selectSupplierBySupplierUuid(bondOrderEntity.getSupplierUuid());
		bondOrderEntity.setSupplierId(entity.getSupplierId());

		bondOrderEntity.setOrderStatus(SaleOrderBondStatusEnum.TO_BE_TREATED.getValue());

		BondOrderEntity orderEntity = bondOrderService.selectOrderByParams(params);
		if (orderEntity != null) {
			if (SaleOrderBondStatusEnum.TO_BE_CANCEL.getValue() != orderEntity.getOrderStatus()) {
				return R.error("此订单已经申请过保函办理业务");
			} else {
				bondOrderEntity.setOrderId(orderEntity.getOrderId());
				bondOrderEntity.setOrderDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));// 订单创建时间
				bondOrderEntity.setUpdateDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
				bondOrderService.updateById(bondOrderEntity);
				tenderBidBookSaleRecordService.updateBondData(saleRecordEntity.getListId(), SaleOrderBondStatusEnum.TO_BE_TREATED.getValue(), bondOrderEntity.getOrderNo(), bondOrderEntity.getOrderMoney(), bondFees);

				map.put("code", 0);
				map.put("msg", "保函再次申请数据信息修改成功");
				map.put("guarator", guarator);
				return R.ok(map);
			}
		} else {
			if (bondOrderService.insertBondOrder(saleRecordEntity, bondOrderEntity)) {
				tenderBidBookSaleRecordService.updateBondData(saleRecordEntity.getListId(), SaleOrderBondStatusEnum.TO_BE_TREATED.getValue(), bondOrderEntity.getOrderNo(), bondOrderEntity.getOrderMoney(), bondFees);
				map.put("code", 0);
				map.put("msg", "保函申请数据信息新增成功");
				map.put("guarator", guarator);
				return R.ok(map);
			} else {
				return R.error("保函申请数据信息新增失败");
			}
		}
	}

	/**
	 * 商业投标保函申请 商业投标保函（全流程线上办理）
	 * 
	 * @param params
	 * @param bondOrderEntity
	 * @param saleRecordEntity
	 * @param bondFees
	 * @return
	 */
	private R businessBond(Map<String, Object> params, BondOrderEntity bondOrderEntity, TenderBidBookSaleRecordEntity saleRecordEntity, BigDecimal bondFees) {
		// 查询入驻的担保机构集合（分配订单）
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> newParams = new HashMap<>();
		newParams.put("GUARATOR_TYPE", "1");// 商业担保结构
		newParams.put("PARENT_ID", "0");// 商业担保结构
		List<BondEnguaratorEntity> guarators = bondEnguaratorService.selectByMap(newParams);
		if (guarators == null || guarators.size() == 0) {
			return R.error("暂无商业投标保函担保机构");
		}

		Map<String, Integer> sortMap = new HashMap<>();
		for (BondEnguaratorEntity guarator : guarators) {
			Map<String, Object> columnMap = new HashMap<>();
			columnMap.put("GUARATOR_ID", guarator.getGuaratorId());
			List<BondOrderEntity> orders = bondOrderService.selectByMap(columnMap);
			sortMap.put(String.valueOf(guarator.getGuaratorId()), orders.size());
		}
		sortByValue(sortMap, false);// 根据map的value升序

		bondOrderEntity.setGuaratorId(Long.valueOf(getKeyOrNull(sortMap)));
		BondEnguaratorEntity guarator = bondEnguaratorService.selectById(bondOrderEntity.getGuaratorId());
		Map<String, Object> queryParams = new HashMap<>();
		bondOrderEntity.setAgencyId(1L);
		//
		BondUserEntity user = bondUserService.selectUserByEntUuid(bondOrderEntity.getSupplierUuid());
		BondEnsupplierEntity ensupplierEntity = bondEnsupplierService.selectSupplierBySupplierUuid(bondOrderEntity.getSupplierUuid());
		if (user == null) {
			CrmSupplierAccountEntity accountEntity = crmSupplierAccountService.selectSupplierBySupplierId(bondOrderEntity.getSupplierUuid());
			List<CrmSupplierAccountEntity> accountEntities = new ArrayList<CrmSupplierAccountEntity>();
			if (accountEntity != null) {
				accountEntities.add(accountEntity);
			}
			bondUserService.importSupplier(getUser(), accountEntities);
		}
		if (ensupplierEntity == null) {
			CrmSupplierEntity supplierEntity = crmSupplierService.selectById(bondOrderEntity.getSupplierUuid());
			if (supplierEntity != null) {
				// businesslicenseurl
				// 查询营业执照号
				queryParams = new HashMap<>();
				queryParams.put("param", 3);
				queryParams.put("businessId", bondOrderEntity.getSupplierUuid());
				List<CommonAttachmentEntity> entities = commonAttachmentService.commonAttachmentPage(queryParams);
				for (CommonAttachmentEntity entity : entities) {
					supplierEntity.setBusinesslicenseurl(entity.getFieldId());
				}
				List<CrmSupplierEntity> crmSuppliers = new ArrayList<CrmSupplierEntity>();
				crmSuppliers.add(supplierEntity);
				bondEnsupplierService.importCrmSupplier(crmSuppliers);
			}
		}

		BondEnsupplierEntity entity = bondEnsupplierService.selectSupplierBySupplierUuid(bondOrderEntity.getSupplierUuid());
		bondOrderEntity.setSupplierId(entity.getSupplierId());

		bondOrderEntity.setOrderStatus(SaleOrderBondStatusEnum.TO_BE_TREATED.getValue());

		BondOrderEntity orderEntity = bondOrderService.selectOrderByParams(params);
		if (orderEntity != null) {
			if (SaleOrderBondStatusEnum.TO_BE_CANCEL.getValue() != orderEntity.getOrderStatus()) {
				return R.error("此订单已经申请过保函办理业务");
			} else {
				bondOrderEntity.setOrderId(orderEntity.getOrderId());
				bondOrderEntity.setOrderDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));// 订单创建时间
				bondOrderEntity.setUpdateDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
				bondOrderService.updateById(bondOrderEntity);
				tenderBidBookSaleRecordService.updateBondData(saleRecordEntity.getListId(), SaleOrderBondStatusEnum.TO_BE_TREATED.getValue(), bondOrderEntity.getOrderNo(), bondOrderEntity.getOrderMoney(), bondFees);
				map.put("code", 0);
				map.put("msg", "保函再次申请数据信息修改成功");
				map.put("guarator", guarator);
				return R.ok(map);
			}
		} else {
			if (bondOrderService.insertBondOrder(saleRecordEntity, bondOrderEntity)) {
				tenderBidBookSaleRecordService.updateBondData(saleRecordEntity.getListId(), SaleOrderBondStatusEnum.TO_BE_TREATED.getValue(), bondOrderEntity.getOrderNo(), bondOrderEntity.getOrderMoney(), bondFees);
				map.put("code", 0);
				map.put("msg", "保函申请数据信息新增成功");
				map.put("guarator", guarator);
				return R.ok(map);
			} else {
				return R.error("保函申请数据信息新增失败");
			}
		}
	}

	/**
	 * 投标保函咨询服务收费标准
	 * 
	 * @param bondMoney
	 * @return
	 */
	private BigDecimal calculationBondMoney(BigDecimal bondMoney) {
		BigDecimal bondFees = new BigDecimal(0);
		BigDecimal bondMoneyTemp = bondMoney.divide(new BigDecimal(10000), 2, RoundingMode.HALF_UP);// 单位万元
		if (bondMoneyTemp.intValue() < 10) {// 1.0%，保底200元
			bondFees = bondMoney.multiply(new BigDecimal(0.01));
			if (bondFees.intValue() < 300) {
				bondFees = new BigDecimal(300);
			}
		}
		// 10—100（含100） 0.8%
		else if (10 <= bondMoneyTemp.intValue() && bondMoneyTemp.intValue() < 100) {
			bondFees = new BigDecimal(100000).multiply(new BigDecimal(0.01));
			BigDecimal subtractMoney = bondMoneyTemp.subtract(new BigDecimal(10));
			bondFees = bondFees.add(subtractMoney.multiply(new BigDecimal(10000)).multiply(new BigDecimal(0.008)));
		} // 100—500（含500） 0.6%
		else if (100 <= bondMoneyTemp.intValue() && bondMoneyTemp.intValue() < 500) {
			bondFees = new BigDecimal(1000000).multiply(new BigDecimal(0.008));
			BigDecimal subtractMoney = bondMoneyTemp.subtract(new BigDecimal(100));
			bondFees = bondFees.add(subtractMoney.multiply(new BigDecimal(10000)).multiply(new BigDecimal(0.006)));
		} // 500-5000（含5000） 0.4%
		else if (500 <= bondMoneyTemp.intValue() && bondMoneyTemp.intValue() < 5000) {
			bondFees = new BigDecimal(5000000).multiply(new BigDecimal(0.006));
			BigDecimal subtractMoney = bondMoneyTemp.subtract(new BigDecimal(500));
			bondFees = bondFees.add(subtractMoney.multiply(new BigDecimal(10000)).multiply(new BigDecimal(0.004)));
		}
		// 5000-10000（含5000）0.2%
		else {
			bondFees = new BigDecimal(50000000).multiply(new BigDecimal(0.004));
			BigDecimal subtractMoney = bondMoneyTemp.subtract(new BigDecimal(5000));
			bondFees = bondFees.add(subtractMoney.multiply(new BigDecimal(10000)).multiply(new BigDecimal(0.002)));
		}
		return bondFees;

	}

	/**
	 * 下载保函扫描件
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/dowonldVoucher", method = {RequestMethod.POST, RequestMethod.GET})
	public R dowonldVoucher(@RequestParam Map<String, Object> params) {
		// String saleOrderId = (String) params.get("saleOrderId");// 订单ID
		// String projectId = (String) params.get("projectId");// 项目ID
		// String packageId = (String) params.get("packageId");// 分包ID
		String bondOrderNo = (String) params.get("bondOrderNo");// 保函订单编号
		BondOrderEntity orderEntity = bondOrderService.selectByOrderNo(bondOrderNo);
		if (orderEntity != null) {
			AliyunOSSUtils aliyunOSSUtils = new AliyunOSSUtils(aliyunOssConfig);
			List<BondOrderFileEntity> list = bondOrderFileService.queryList(orderEntity.getOrderId());
			List<JSONObject> urls = new ArrayList<>();
			Map<String, Object> map = new HashMap<>();
			for (BondOrderFileEntity fileEntity : list) {
				String url = aliyunOSSUtils.getUrl(fileEntity.getOrderVoucher());
				String fileSuffix = AliyunOSSUtils.getExtensionName(fileEntity.getOrderVoucher());
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("url", url);
				jsonObject.put("name", fileEntity.getOrderVoucher());
				jsonObject.put("fileSuffix", fileSuffix);
				urls.add(jsonObject);
			}
			map.put("urls", urls);
			return R.ok(map);
		} else {
			return R.error("此订单还未申请过保函办理业务");
		}
	}

	/**
	 * 根据map的key排序
	 * 
	 * @param map
	 *            待排序的map
	 * @param isDesc
	 *            是否降序，true：降序，false：升序
	 * @return 排序好的map
	 * @author zero 2019/04/08
	 */
	public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map, boolean isDesc) {
		Map<K, V> result = Maps.newLinkedHashMap();
		if (isDesc) {
			map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		} else {
			map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		}
		return result;
	}

	/**
	 * 根据map的value排序
	 * 
	 * @param map
	 *            待排序的map
	 * @param isDesc
	 *            是否降序，true：降序，false：升序
	 * @return 排序好的map
	 * @author zero 2019/04/08
	 */
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, boolean isDesc) {
		Map<K, V> result = Maps.newLinkedHashMap();
		if (isDesc) {
			map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue().reversed()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		} else {
			map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		}
		return result;
	}

	/**
	 * 获取map中第一个key值
	 *
	 * @param map
	 *            数据源
	 * @return
	 */
	public static String getKeyOrNull(Map<String, Integer> map) {
		String obj = null;
		for (Entry<String, Integer> entry : map.entrySet()) {
			obj = entry.getKey();
			if (obj != null) {
				break;
			}
		}
		return obj;
	}

	/**
	 * 获取map中第一个数据值
	 *
	 * @param map
	 *            数据源
	 * @return
	 */
	public static Object getFirstOrNull(Map<String, Integer> map) {
		Object obj = null;
		for (Entry<String, Integer> entry : map.entrySet()) {
			obj = entry.getValue();
			if (obj != null) {
				break;
			}
		}
		return obj;
	}
}
