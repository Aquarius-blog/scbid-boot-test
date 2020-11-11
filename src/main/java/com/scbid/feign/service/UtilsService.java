package com.scbid.feign.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;

@FeignClient("utils-service")
public interface UtilsService {

	/**
	 * @Title: oss
	 * @Description: TODO
	 * @author: wangyun
	 * @date: 2018年5月30日 上午10:19:28
	 * @param ossBean
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/oss")
	String oss(@RequestBody ScbidOssBean ossBean);
	/**
	 * @Title: getPostSignature
	 * @Description: TODO
	 * @author: wangyun
	 * @date: 2018年5月30日 上午10:19:33
	 * @param bucket
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/oss/getPostSignature")
	Map<String, String> getPostSignature(@RequestParam(value = "bucket") String bucket);

	/**
	 * @Title: sendSms
	 * @author: chengyun
	 * @date: 2018年6月01日 上午10:19:33
	 * @return
	 */
	@RequestMapping(value = "/sendSms")
	SendSmsResponse sendSms(@RequestBody SendSmsBean sendSmsBean);
}
