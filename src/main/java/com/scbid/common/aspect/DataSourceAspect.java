package com.scbid.common.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.scbid.common.datasources.DataSourceNames;
import com.scbid.common.datasources.DynamicDataSource;
import com.scbid.common.datasources.TargetDataSource;

/**
 * 多数据源，切面处理类
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Pointcut("@annotation(com.scbid.common.datasources.TargetDataSource)")
	public void dataSourcePointCut() {

	}

	@Around("dataSourcePointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();

		TargetDataSource ds = method.getAnnotation(TargetDataSource.class);
		if (ds == null) {
			DynamicDataSource.setDataSource(DataSourceNames.FIRST);
			logger.info("当前使用的数据源为111：" + DataSourceNames.FIRST);
		} else {
			DynamicDataSource.setDataSource(ds.name());
			logger.info("当前使用的数据源为222：" + ds.name());
		}
		try {
			return point.proceed();
		} finally {
			DynamicDataSource.clearDataSource();
			logger.info("关闭数据源");
		}
	}

	@After("dataSourcePointCut()")
	public void clearDataSource(JoinPoint point) {
		DynamicDataSource.clearDataSource();
	}

	@Override
	public int getOrder() {
		return 1;
	}
	
	public static void main(String[] args) {
		String a = "1";
		String b = "2";
		String c = "12";
		String d = a+b;
		String e = "1"+"2";
		System.out.println(c == d);
		System.out.println(e == d);
		System.out.println(c == e);
		
		StringBuffer stringBuffer = new StringBuffer("aaa");
		StringBuffer stringBuffer2 = new StringBuffer("aaa");
		System.out.println(stringBuffer == stringBuffer2); // false
		System.out.println(stringBuffer.equals(stringBuffer2)); // false
		
	}
}
