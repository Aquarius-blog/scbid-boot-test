package com.scbid.common.utils;

import java.io.Serializable;

/**
 * @Title: BLKeyValueBean.java
 * @Description: 键值Bean
 * @Package com.bloom.common.bean
 * @Author: 李星江
 * @Date: 2016年12月19日 下午2:04:21
 * @Copyright: 成都必朗科技有限公司 注意：本内容仅限于必朗科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class BLKeyValueBean implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = -2363382024322501547L;
	/** 键 */
	private String name;
	/** 值 */
	private Integer value;

	public BLKeyValueBean() {
	}

	public BLKeyValueBean(String name, Integer value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
