package com.scbid.manage.entity;

import java.util.ArrayList;
import java.util.List;

import com.scbid.common.utils.BLKeyValueBean;
import com.scbid.common.utils.BLValidateUtils;

/**
 * @Title: SaleOrderStatusEnum.java
 * @Description: 订单状态枚举
 * @Package com.bloom.scbid.sale.order.enums
 * @Author: 方明
 * @Date: 2017年8月14日 上午9:04:51
 */
public enum SaleOrderBondStatusEnum {

	/**
	 * 待处理
	 */
	TO_BE_TREATED("待处理", 1),
	/**
	 * 待上传
	 */
	TO_BE_UPLOADED("待上传", 2),
	/**
	 * 待支付
	 */
	TO_BE_PAID("待支付", 3),
	/**
	 * 已完成
	 */
	COMPLETED("已完成", 4),
	/**
	 * 取消处理
	 */
	TO_BE_CANCEL("取消处理", 500);

	/** 描述 */
	private String name;
	/** 枚举值 */
	private Integer value;

	private SaleOrderBondStatusEnum(String name, Integer value) {
		this.name = name;
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	/**
	 * @Title: getEnum
	 * @Description: 根据枚举值获取枚举
	 * @author: 罗成
	 * @date: 2017年2月6日 下午6:00:14
	 * @param value
	 * @return
	 */
	public static SaleOrderBondStatusEnum getEnum(Integer value) {
		SaleOrderBondStatusEnum resultEnum = null;
		SaleOrderBondStatusEnum[] enumArr = SaleOrderBondStatusEnum.values();
		// 判断是否为空
		if (BLValidateUtils.isArrayNotEmpty(enumArr)) {
			for (SaleOrderBondStatusEnum BLWhetherEnum : enumArr) {
				if (BLWhetherEnum.getValue() == value) {
					resultEnum = BLWhetherEnum;
					break;
				}
			}
		}
		return resultEnum;
	}

	/**
	 * @Title: getEnumByName
	 * @Description: 根据枚举名获取枚举
	 * @author: 罗成
	 * @date: 2017年2月6日 下午6:00:21
	 * @param name
	 * @return
	 */
	public static SaleOrderBondStatusEnum getEnumByName(String name) {
		SaleOrderBondStatusEnum resultEnum = null;
		SaleOrderBondStatusEnum[] enumArr = SaleOrderBondStatusEnum.values();
		// 判断是否为空
		if (BLValidateUtils.isArrayNotEmpty(enumArr)) {
			for (SaleOrderBondStatusEnum BLWhetherEnum : enumArr) {
				if (BLWhetherEnum.getName().equals(name)) {
					resultEnum = BLWhetherEnum;
					break;
				}
			}
		}
		return resultEnum;
	}

	/**
	 * @Title: toList
	 * @Description: 将枚举类转换为list
	 * @author: 罗成
	 * @date: 2017年2月6日 下午6:00:29
	 * @return
	 */
	public static List<BLKeyValueBean> toList() {
		SaleOrderBondStatusEnum[] enumArr = SaleOrderBondStatusEnum.values();
		List<BLKeyValueBean> resultList = new ArrayList<>();
		// 判断是否为空
		if (BLValidateUtils.isArrayNotEmpty(enumArr)) {
			BLKeyValueBean keyValueBean;
			for (SaleOrderBondStatusEnum auditStatusEnum : enumArr) {
				keyValueBean = new BLKeyValueBean(auditStatusEnum.getName(), auditStatusEnum.getValue());
				resultList.add(keyValueBean);
			}
		}
		return resultList;
	}
}
