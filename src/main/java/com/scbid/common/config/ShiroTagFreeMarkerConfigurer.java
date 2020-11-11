package com.scbid.common.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jagregory.shiro.freemarker.ShiroTags;

import freemarker.template.Configuration;
/**
 * 集成Shiro标签
 */
@Component
public class ShiroTagFreeMarkerConfigurer implements InitializingBean {
	@Autowired
	private Configuration configuration;

	@Override
	public void afterPropertiesSet() throws Exception {
		// 加上这句后，可以在页面上使用shiro标签
		configuration.setSharedVariable("shiro", new ShiroTags());
	}

}
