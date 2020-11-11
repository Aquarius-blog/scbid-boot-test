package com.scbid.common.datasources;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 配置多数据源
 */
@Configuration
@EnableScheduling
public class DynamicDataSourceConfig {

	@Autowired
    private DBProperties properties;
	
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		//按照目标数据源名称和目标数据源对象的映射存放在Map中
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceNames.FIRST, properties.getFirst());
        targetDataSources.put(DataSourceNames.SECOND, properties.getSecond());
        targetDataSources.put(DataSourceNames.THIRD, properties.getThird());
        //采用是想AbstractRoutingDataSource的对象包装多数据源
        DynamicDataSource dataSource = new DynamicDataSource(properties.getFirst(),targetDataSources);
        return dataSource;
	}
	
	@Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
