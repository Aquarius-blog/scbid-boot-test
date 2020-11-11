package com.scbid.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Title: BLAliyunOssConfig.java
 * @Description: 阿里云OSS配置工具类
 * @Package com.bloom.common.core.aliyun.oss
 * @Author:wangyun
 * @Date: 2017年1月3日 下午8:23:54
 * @Copyright: 成都必朗科技有限公司 注意：本内容仅限于必朗科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@Component
public class AliyunOssConfig {
	/**
	 * 外网访问地址
	 */
	@Value("${aliyun.oss.extranet.endpoint}")
	private String extranetEndpoint;
	/**
	 * 内外访问地址
	 */
	@Value("${aliyun.oss.endpoint}")
	private String endpoint;
	/**
	 * 内外访问地址key
	 */
	@Value("${aliyun.oss.access.key}")
	private String accessKey;
	/**
	 * 内外访问地址secret
	 */
	@Value("${aliyun.oss.access.secret}")
	private String accessSecret;
	
	/**
	 * 内外访问地址bucket
	 */
	@Value("${aliyun.oss.access.bucket}")
	private String bucket;
	
	
	public String getExtranetEndpoint() {
		return extranetEndpoint;
	}
	public void setExtranetEndpoint(String extranetEndpoint) {
		this.extranetEndpoint = extranetEndpoint;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getAccessKey() {
		return accessKey;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	public String getAccessSecret() {
		return accessSecret;
	}
	public void setAccessSecret(String accessSecret) {
		this.accessSecret = accessSecret;
	}
	public String getBucket() {
		return bucket;
	}
	public void setBucket(String bucket) {
		this.bucket = bucket;
	}
	
	
}
