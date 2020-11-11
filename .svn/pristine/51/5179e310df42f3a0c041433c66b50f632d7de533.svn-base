package com.scbid.common.datasources;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

/**
 * 配置多数据源
 */
@Component
@ConfigurationProperties(prefix = "hikari")
public class DBProperties {

	private HikariDataSource first;
	private HikariDataSource second;
	private HikariDataSource third;
	public HikariDataSource getFirst() {
		return first;
	}
	public void setFirst(HikariDataSource first) {
		this.first = first;
	}
	public HikariDataSource getSecond() {
		return second;
	}
	public void setSecond(HikariDataSource second) {
		this.second = second;
	}
	public HikariDataSource getThird() {
		return third;
	}
	public void setThird(HikariDataSource third) {
		this.third = third;
	}

}
