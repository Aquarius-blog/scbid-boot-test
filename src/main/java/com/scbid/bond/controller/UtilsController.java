package com.scbid.bond.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scbid.common.utils.Constant.OssBucket;
import com.scbid.common.utils.Constant.OssType;
import com.scbid.feign.service.ScbidOssBean;
import com.scbid.feign.service.UtilsService;
import com.scbid.invoice.entity.FpsqbEntity;
import com.scbid.invoice.service.FpsqbService;

@Controller
@RequestMapping("utils")
public class UtilsController {
	
	@Autowired
	private FpsqbService fpsqbService;

	@Autowired
	UtilsService utilsService;
	
	
	@RequestMapping("/getInvoiceUrl")
	public String getInvoiceUrl(String listId, ModelMap map) {
		FpsqbEntity fpsqb = fpsqbService.getInvoice(listId);
		String flag = "error";
		String message = null;
		if (fpsqb == null) {
			message =  "发票数据不存在...";
		}
		message = "还未生成发票,等等系统反馈...";
		if (StringUtils.isNotEmpty(fpsqb.getPdfPath())) {
			ScbidOssBean ossBean = new ScbidOssBean();
			ossBean.setBucket(OssBucket.scbid_invoice.getValue());
			ossBean.setFileId(fpsqb.getPdfPath());
			ossBean.setType(OssType.getUrl.getValue());
			try {
				message = utilsService.oss(ossBean);
				//message = restTemplate.patchForObject("http://UTILS-ADMIN", ossMap, String.class);ribbon访问模式
				//message = HttpUtil.sendPost(utilsUrl + "/oss", ossMap);//HttpUtil 访问模式
				if (StringUtils.isNotEmpty(message)) {
					flag = "success";
				}else {
					message = "查询文件失败..";
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		map.addAttribute("flag", flag);
		map.addAttribute("message", message);
		return "modules/supplier/oss-return";
	}
	
	@RequestMapping("/upload")
	public String upload(String listId, ModelMap map) {
		String flag = "error";
		String message = null;
		if (StringUtils.isNotEmpty(listId)) {
			ScbidOssBean ossBean = new ScbidOssBean();
			ossBean.setBucket(OssBucket.scbid_invoice.getValue());
			ossBean.setType(OssType.getUrl.getValue());
			try {
				message = utilsService.oss(ossBean);
				//message = restTemplate.patchForObject("http://UTILS-ADMIN/oss", ossMap, String.class);
				//message = HttpUtil.sendPost(utilsUrl + "/oss", ossMap);
				if (StringUtils.isNotEmpty(message)) {
					flag = "success";
					FpsqbEntity fpsqb = fpsqbService.getInvoice(listId);
					fpsqb.setPdfPath(message);
				}else {
					message = "查询文件失败..";
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		map.addAttribute("flag", flag);
		map.addAttribute("message", message);
		return "modules/supplier/oss-return";
	}
	/**
	  * @Title: getPostSignature
	  * @Description: 获取oss签证
	  * @author: wangyun
	  * @date: 2018年5月31日 下午5:03:10
	  * @param bucket
	  * @param menu
	  * @return
	 */
	@RequestMapping(value = "/oss/getPostSignature", method = {RequestMethod.POST, RequestMethod.GET})
	public Map<String, String> getPostSignature(@RequestParam(value = "menu") String menu) {
		Map<String, String> map = utilsService.getPostSignature(OssBucket.scbid_dev.getValue());
		return map;
	}
}
