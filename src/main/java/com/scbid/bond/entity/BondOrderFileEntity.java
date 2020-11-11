package com.scbid.bond.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * @author wangyun
 * @date 2019-06-25 09:33:49
 */
@TableName("t_bond_order_file")
public class BondOrderFileEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer fileId;
	/**
	 * 订单主键ID
	 */
	private Integer orderId;
	/**
	 * 订单凭证
	 */
	private String orderVoucher;

	/**
	 * 设置：
	 */
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	/**
	 * 获取：
	 */
	public Integer getFileId() {
		return fileId;
	}
	/**
	 * 设置：订单主键ID
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单主键ID
	 */
	public Integer getOrderId() {
		return orderId;
	}
	/**
	 * 设置：订单凭证
	 */
	public void setOrderVoucher(String orderVoucher) {
		this.orderVoucher = orderVoucher;
	}
	/**
	 * 获取：订单凭证
	 */
	public String getOrderVoucher() {
		return orderVoucher;
	}
}
