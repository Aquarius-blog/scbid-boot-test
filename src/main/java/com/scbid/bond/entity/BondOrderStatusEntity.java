package com.scbid.bond.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * @author wangyun
 * @date 2018-05-14 13:00:02
 */
@TableName("t_bond_order_status")
public class BondOrderStatusEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单状态记录主键ID
	 */
	@TableId
	private Long orderStatusId;
	/**
	 * 订单主键ID
	 */
	private Long orderId;
	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 订单状态
	 */
	private Integer orderStatus;
	/**
	 * 订单状态记录创建时间
	 */
	private String orderStatusDate;
	/**
	 * 最后修改人
	 */
	private String updateUesrName;
	/**
	 * 最后修改时间
	 */
	private String updateDate;

	/**
	 * 设置：订单状态记录主键ID
	 */
	public void setOrderStatusId(Long orderStatusId) {
		this.orderStatusId = orderStatusId;
	}
	/**
	 * 获取：订单状态记录主键ID
	 */
	public Long getOrderStatusId() {
		return orderStatusId;
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
	 * 设置：订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：订单状态
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * 获取：订单状态
	 */
	public Integer getOrderStatus() {
		return orderStatus;
	}
	/**
	 * 设置：订单状态记录创建时间
	 */
	public void setOrderStatusDate(String orderStatusDate) {
		this.orderStatusDate = orderStatusDate;
	}
	/**
	 * 获取：订单状态记录创建时间
	 */
	public String getOrderStatusDate() {
		return orderStatusDate;
	}
	/**
	 * 设置：最后修改人
	 */
	public void setUpdateUesrName(String updateUesrName) {
		this.updateUesrName = updateUesrName;
	}
	/**
	 * 获取：最后修改人
	 */
	public String getUpdateUesrName() {
		return updateUesrName;
	}
	/**
	 * 设置：最后修改时间
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：最后修改时间
	 */
	public String getUpdateDate() {
		return updateDate;
	}
}
