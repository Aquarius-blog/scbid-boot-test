package com.scbid.bond.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.scbid.bond.entity.BondEnguaratorEntity;
import com.scbid.bond.entity.BondEnsupplierEntity;
import com.scbid.bond.entity.BondOrderEntity;
import com.scbid.bond.entity.BondOrderFileEntity;
import com.scbid.bond.entity.BondProjectEntity;
import com.scbid.bond.service.BondEnguaratorService;
import com.scbid.bond.service.BondEnsupplierService;
import com.scbid.bond.service.BondOrderFileService;
import com.scbid.bond.service.BondOrderService;
import com.scbid.bond.service.BondProjectService;
import com.scbid.common.config.AliyunOSSUtils;
import com.scbid.common.config.AliyunOssConfig;
import com.scbid.common.config.ScbidOssBean;
import com.scbid.common.utils.DateUtils;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.R;
import com.scbid.feign.service.SendSmsBean;
import com.scbid.manage.entity.SaleOrderBondStatusEnum;
import com.scbid.manage.entity.TenderBidBookSaleRecordEntity;
import com.scbid.manage.service.TenderBidBookSaleRecordService;
import com.scbid.sys.controller.AbstractController;
import com.scbid.sys.entity.BondUserEntity;
import com.scbid.sys.service.BondUserService;

/**
 * 保证金订单
 * 
 * @Title: BondOrderController.java
 * @Description: TODO
 * @Package com.scbid.bond.controller
 * @Author: wangyun
 * @Date: 2018年5月14日
 * @Copyright: 四川国际招标有限责任公司 注意：本内容仅限于必朗科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@RestController
@RequestMapping("bond/bondorder")
public class BondOrderController extends AbstractController {
	@Autowired
	private BondOrderService bondOrderService;

	@Autowired
	private TenderBidBookSaleRecordService tenderBidBookSaleRecordService;

	// 产品名称:云通信短信API产品,开发者无需替换
	static final String product = "Dysmsapi";
	// 产品域名,开发者无需替换
	static final String domain = "dysmsapi.aliyuncs.com";

	// TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
	static final String accessKeyId = "LTAI9Ize2lTo2Rc8";
	static final String accessKeySecret = "JRnrD1UVoXCoqIQHDkSDk00Wuk8f0T";

	/*
	 * 担保机构
	 */
	@Autowired
	private BondEnguaratorService bondEnguaratorService;
	@Autowired
	private BondProjectService bondProjectService;
	@Autowired
	private BondUserService bondUserService;
	@Autowired
	private BondEnsupplierService bondEnsupplierService;
	@Autowired
	private BondOrderFileService bondOrderFileService;
	@Autowired
	private AliyunOssConfig aliyunOssConfig;
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	// @RequiresPermissions("bond:bondorder:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = bondOrderService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{orderId}")
	// @RequiresPermissions("bond:bondorder:info")
	public R info(@PathVariable("orderId") Long orderId) {
		BondOrderEntity bondOrder = bondOrderService.selectById(orderId);

		// 查询对应的担保机构
		BondEnguaratorEntity enguarator = bondEnguaratorService.selectById(bondOrder.getGuaratorId());
		if (enguarator != null) {
			bondOrder.setGuaratorName(enguarator.getGuaratorName());
		}

		return R.ok().put("bondOrder", bondOrder);
	}

	/**
	 * chengyun 保存
	 */
	@RequestMapping("/save")
	// @RequiresPermissions("bond:bondorder:save")
	public R save(@RequestBody BondOrderEntity bondOrder) {
		if (bondOrder != null) {
			bondOrder.setOrderDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
			bondOrder.setUpdateDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
			bondOrder.setUpdateUesrName(getUser().getUserName());
			bondOrderService.insert(bondOrder);
		}

		return R.ok();
	}

	/**
	 * 查询供应商担保机构列表
	 * 
	 * @author: huqiwen
	 */
	@RequestMapping("/selectOrdersByOrderNo")
	@ResponseBody
	// @RequiresPermissions("bond:bondensupplier:list")
	public R selectOrdersByOrderNo(String orderNo) {
		BondOrderEntity byOrderNo = bondOrderService.selectByOrderNo(orderNo);

		return R.ok().put("bondOrder", byOrderNo);
	}

	/**
	 * 修改
	 * 
	 * @author: chengyun
	 */
	@RequestMapping("/update")
	// @RequiresPermissions("bond:bondorder:update")
	public R update(@RequestBody BondOrderEntity bondOrder) {
		if (bondOrder != null) {
			bondOrder.setUpdateDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
			bondOrder.setUpdateUesrName(getUser().getUserName());
			bondOrderService.updateById(bondOrder);
		}
		return R.ok();
	}
	/**
	 * 审核(如果审核通过则发送短信给供应商)
	 * 
	 * @author: chengyun
	 */
	@RequestMapping("/auditOperation")
	// @RequiresPermissions("bond:bondorder:update")
	public R auditOperation(@RequestBody BondOrderEntity bondOrder) {
		if (bondOrder != null) {
			bondOrder.setUpdateDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
			bondOrder.setUpdateUesrName(getUser().getUserName());
			bondOrderService.updateById(bondOrder);

			// 审核通过才需要发短信
			if (bondOrder.getOrderStatus() == 2) {
				// 得到对应供应商电话
				Long supplierId = bondOrder.getSupplierId();
				BondEnsupplierEntity bondEnsupplier = bondEnsupplierService.selectById(supplierId);
				BondUserEntity bondUser = bondUserService.selectById(bondEnsupplier.getSupplierUserId());
				String userMobile = bondUser.getUserMobile();
				SendSmsBean sendSmsBean = new SendSmsBean();
				if (userMobile != null) {
					sendSmsBean.setPhoneNumber(userMobile);
				}
				sendSmsBean.setSignName("四川国际招标有限责任公司");// 公司签名
				sendSmsBean.setTemplateCode("SMS_136395725");// 短信模板
				// 通过订单查询对应项目以及担保机构名称
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("orderId", bondOrder.getOrderId());
				List<BondProjectEntity> projectList = bondProjectService.findProjectByOrder(params);
				String projectNames = "";
				for (BondProjectEntity bondProjectEntity : projectList) {
					String projectName = bondProjectEntity.getProjectName();
					projectNames += projectName;
					projectNames += ";";

				}
				sendSmsBean.setProjectName(projectNames);
				// 订单编号
				sendSmsBean.setOrderNo(bondOrder.getOrderNo());
				// 担保机构
				String guaratorName = bondOrder.getGuaratorName();
				sendSmsBean.setGuaratorName(guaratorName);
				// 调用短信接口
				// SendSmsResponse sendSmsResponse =
				// utilsService.sendSms(sendSmsBean);
			}

		}
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	// @RequiresPermissions("bond:bondorder:delete")
	public R delete(@RequestBody Long[] orderIds) {
		List<BondOrderEntity> list = bondOrderService.selectBatchIds(Arrays.asList(orderIds));
		for (BondOrderEntity entity : list) {
			entity.setUpdateUesrName(getUser().getUserSurname());
			entity.setUpdateDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
		}
		bondOrderService.updateBatchById(list);

		return R.ok();
	}

	/**
	 * 导入
	 */
	@RequestMapping("/import")
	// @RequiresPermissions("bond:bondorder:import")
	public R importFile(@RequestParam Map<String, Object> params) {

		return R.ok();
	}

	/**
	 * 导出
	 */
	@RequestMapping("/export")
	// @RequiresPermissions("bond:bondorder:export")
	public R exportFile(@RequestParam Map<String, Object> params) {

		return R.ok();
	}

	/**
	 * @Title: indexVoucher
	 * @Description: 保证金凭证页面动态生成(已过时)
	 * @author: 胡棋文
	 * @date: 2018年5月24日 上午10:42:14
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/indexVoucher")
	public R indexVoucher(String orderId) {
		// 拿到保证金订单
		BondOrderEntity orderMode = bondOrderService.selectById(orderId);
		// 拿到该项目
		BondProjectEntity projecttByorderId = bondProjectService.queryGuaranteeProjecttByorderId(orderId);
		if (orderMode.getOrderNo() == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("orderMoney", orderMode.getOrderMoney());// 订单金额
			map.put("orderNo", orderMode.getOrderNo());// 订单编号
			map.put("projectName", projecttByorderId.getProjectName());// 项目名称
			map.put("projectNum", projecttByorderId.getProjectCode());// 项目编号
			map.put("userName", getUser().getLoginNo());// 制表人

		} catch (Exception e) {
			return R.error(1, "请重新生成凭证！");
		}

		return R.ok().put("bondEnsupplier", map);
	}

	/**
	 * @param request
	 * @return
	 */
	@RequestMapping("/acceptHandle")
	public R acceptHandle(HttpServletRequest request) {
		String orderId = request.getParameter("orderId");
		String flag = request.getParameter("flag");
		BondOrderEntity orderEntity = bondOrderService.selectById(orderId);
		BondEnguaratorEntity enguarator = bondEnguaratorService.selectById(orderEntity.getGuaratorId());
		orderEntity.setGuaratorName(enguarator.getGuaratorName());
		TenderBidBookSaleRecordEntity saleOrder = tenderBidBookSaleRecordService.slectSlaeByBondOrderNo(orderEntity.getOrderNo());
		if (saleOrder != null && orderEntity != null) {
			if ("true".equals(flag)) {
				orderEntity.setOrderStatus(SaleOrderBondStatusEnum.TO_BE_UPLOADED.getValue());
				tenderBidBookSaleRecordService.updateStatusById(SaleOrderBondStatusEnum.TO_BE_UPLOADED.getValue(), saleOrder.getListId());
				bondOrderService.updateById(orderEntity);
				sendAcceptHandleSms(true, orderEntity);// 发送短信
				return R.ok("已经接受办理申请！");
			} else {
				orderEntity.setOrderStatus(SaleOrderBondStatusEnum.TO_BE_CANCEL.getValue());
				tenderBidBookSaleRecordService.updateStatusById(SaleOrderBondStatusEnum.TO_BE_CANCEL.getValue(), saleOrder.getListId());
				bondOrderService.updateById(orderEntity);
				sendAcceptHandleSms(false, orderEntity);// 发送短信
				return R.ok("取消办理申请！");
			}
		} else {
			return R.error("没有需要办理的订单！");
		}

	}

	/**
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/uploadBond")
	public R uploadBond(HttpServletRequest request, @RequestParam("file") List<MultipartFile> files) {
		String orderId = request.getParameter("orderId");
		AliyunOSSUtils aliyunOSSUtils = new AliyunOSSUtils(aliyunOssConfig);
		if (StringUtils.isNotEmpty(orderId) && files != null) {
			List<ScbidOssBean> ossBeans = new ArrayList<>();
			for (MultipartFile entity : files) {
				if (entity != null && !entity.isEmpty()) {
					ScbidOssBean bean = aliyunOSSUtils.fileIdUpload(entity);
					ossBeans.add(bean);
				}
			}
			Map<String, Object> map = new HashMap<>();
			map.put("ossBean", ossBeans.get(0));
			return R.ok(map);
		} else {
			return R.error("保函扫描文件上传未选择对应的项目！");
		}
	}

	/**
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/submitUploadBond")
	public R submitUploadBond(HttpServletRequest request) {
		String orderId = request.getParameter("orderId");
		String json = request.getParameter("ossBeans");
		List<ScbidOssBean> ossBeans = JSONArray.parseArray(json, ScbidOssBean.class);
		if (ossBeans != null && ossBeans.size() > 0) {
			Boolean bool;
			try {
				bool = bondOrderService.updateOrderEntityByUrl(ossBeans, orderId);
				if (bool) {
					BondOrderEntity orderEntity = bondOrderService.selectById(orderId);
					BondEnguaratorEntity enguarator = bondEnguaratorService.selectById(orderEntity.getGuaratorId());
					orderEntity.setGuaratorName(enguarator.getGuaratorName());
					TenderBidBookSaleRecordEntity saleOrder = tenderBidBookSaleRecordService.slectSlaeByBondOrderNo(orderEntity.getOrderNo());
					tenderBidBookSaleRecordService.updateStatusById(SaleOrderBondStatusEnum.TO_BE_PAID.getValue(), saleOrder.getListId());
					sendUploadBondSms(orderEntity);// 发送短信
					return R.ok("保函扫描文件上传成功！");
				} else {
					return R.error("保函扫描文件上传失败！");
				}
			} catch (Exception e) {
				return R.error("保函扫描文件上传失败！");
			}

		} else {
			return R.error("保函扫描文件上传文件为空！");
		}
	}

	/**
	 * @param request
	 * @param guaratorId
	 * @param orderIds
	 * @return
	 */
	@RequestMapping("/saveChangeGuarator")
	public R saveChangeGuarator(HttpServletRequest request) {
		String orderIds = request.getParameter("orderIds");
		String guaratorUuid = request.getParameter("guaratorUuid");
		List<BondOrderEntity> list = bondOrderService.selectBatchIds(Arrays.asList(orderIds));
		BondEnguaratorEntity guarator = bondEnguaratorService.selectByGuaratorUuids(guaratorUuid);
		try {
			bondOrderService.updateGuarator(list, guarator);
			return R.ok("任务分配完成!");
		} catch (Exception e) {
			return R.error("分配失败!");
		}
	}
	/**
	 * @param request
	 * @return
	 */
	@RequestMapping("/openOrderFileId")
	public R openOrderFileId(HttpServletRequest request) {
		String orderId = request.getParameter("orderId");
		List<BondOrderFileEntity> list = bondOrderFileService.queryList(Long.parseLong(orderId));
		if (list != null && list.size() != 0) {
			List<JSONObject> urls = new ArrayList<>();
			Map<String, Object> map = new HashMap<>();
			for (BondOrderFileEntity fileEntity : list) {
				AliyunOSSUtils aliyunOSSUtils = new AliyunOSSUtils(aliyunOssConfig);
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
			return R.error("订单没有上传保函凭证");
		}
	}

	/**
	 * @param falg
	 * @param orderEntity
	 */
	private void sendAcceptHandleSms(Boolean falg, BondOrderEntity orderEntity) {
		JSONObject json = new JSONObject();
		SendSmsBean sendSmsBean = new SendSmsBean();
		sendSmsBean.setPhoneNumber(orderEntity.getTelephone());
		sendSmsBean.setSignName("四川国际招标有限责任公司");// 公司签名

		if (falg) {
			sendSmsBean.setTemplateCode("SMS_152695054");// 短信模板
			json.put("projectName", orderEntity.getProjectName());
			json.put("orderNo", orderEntity.getOrderNo());
			json.put("guaratorName", orderEntity.getGuaratorName());
		} else {
			sendSmsBean.setTemplateCode("SMS_152695030");// 短信模板
			json.put("projectName", orderEntity.getProjectName());
			json.put("orderNo", orderEntity.getOrderNo());
			json.put("guaratorName", orderEntity.getGuaratorName());
		}
		sendSms(sendSmsBean, json.toString());
	}

	/**
	 * @param orderEntity
	 */
	private void sendUploadBondSms(BondOrderEntity orderEntity) {
		JSONObject json = new JSONObject();
		SendSmsBean sendSmsBean = new SendSmsBean();
		sendSmsBean.setPhoneNumber(orderEntity.getTelephone());
		sendSmsBean.setSignName("四川国际招标有限责任公司");// 公司签名
		sendSmsBean.setTemplateCode("SMS_152695027");// 短信模板
		json.put("projectName", orderEntity.getProjectName());
		json.put("company", "四川国际招标有限责任公司");
		json.put("webUrl", "http://sale.scbid.net");
		sendSms(sendSmsBean, json.toString());
	}

	/**
	 * 
	 * @param sendSmsBean
	 * @return
	 * @throws ClientException
	 */
	private SendSmsResponse sendSms(SendSmsBean sendSmsBean, String context) {
		// 可自助调整超时时间
		// hint 此处可能会抛出异常，注意catch
		SendSmsResponse sendSmsResponse = null;
		try {
			System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
			System.setProperty("sun.net.client.defaultReadTimeout", "10000");

			// 初始化acsClient,暂不支持region化
			IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
			IAcsClient acsClient = new DefaultAcsClient(profile);

			// 组装请求对象-具体描述见控制台-文档部分内容
			SendSmsRequest request = new SendSmsRequest();
			// 必填:待发送手机号
			request.setPhoneNumbers(sendSmsBean.getPhoneNumber());
			// 必填:短信签名-可在短信控制台中找到
			request.setSignName(sendSmsBean.getSignName());
			// 必填:短信模板-可在短信控制台中找到
			request.setTemplateCode(sendSmsBean.getTemplateCode());
			request.setTemplateParam(context);
			// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
			request.setOutId("yourOutId");
			sendSmsResponse = acsClient.getAcsResponse(request);
		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sendSmsResponse;
	}
}
