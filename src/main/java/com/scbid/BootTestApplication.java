package com.scbid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Title: BootTestApplication.java
 * @Description: BootTest项目启动类
 * @Package com.scbid.bond
 * @Author: 程云
 * @Date: 2020年03月20日
 * @Copyright: 四川国际招标有限责任公司 注意：本内容仅限于必朗科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.scbid.*.dao"})
//@EnableDiscoveryClient
@EnableFeignClients
public class BootTestApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(BootTestApplication.class, args);
	}
}
