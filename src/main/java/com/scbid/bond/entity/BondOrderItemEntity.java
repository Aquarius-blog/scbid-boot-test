package com.scbid.bond.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * @author wangyun
 * @date 2018-05-14 13:00:02
 */
@TableName("t_bond_order_item")
public class BondOrderItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单明细表主键Id
	 */
	@TableId
	private Long orderItemId;
	/**
	 * 订单主键ID
	 */
	private Long orderId;
	/**
	 * 项目主键ID
	 */
	private Long projectId;
	/**
	 * 订单明细创建时间
	 */
	private String orderItemDate;

	/**
	 * 设置：订单明细表主键Id
	 */
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	/**
	 * 获取：订单明细表主键Id
	 */
	public Long getOrderItemId() {
		return orderItemId;
	}
	/**
	 * 设置：订单主键ID
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单主键ID
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * 设置：项目主键ID
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：项目主键ID
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * 设置：订单明细创建时间
	 */
	public void setOrderItemDate(String orderItemDate) {
		this.orderItemDate = orderItemDate;
	}
	/**
	 * 获取：订单明细创建时间
	 */
	public String getOrderItemDate() {
		return orderItemDate;
	}
}
