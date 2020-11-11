package com.scbid.manage.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * @author wangyun
 * @date 2018-10-26 10:20:05
 */
@TableName("t_sale_order_management")
public class SaleOrderManagementEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 数据库ID
	 */
	@TableId
	private String listId;
	/**
	 * 创建人
	 */
	private String creater;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 操作时间
	 */
	private String operateTime;
	/**
	 * 操作人
	 */
	private String operator;
	/**
	 * 是否删除[BLDeleteEnum]
	 */
	private Integer isDelete;
	/**
	 * 状态[BLStatusEnum]
	 */
	private String domainAuth;
	/**
	 * 创建人ID
	 */
	private String creatorId;
	/**
	 * 账户id
	 */
	private String accountListid;
	/**
	 * 订单编号
	 */
	private String orderCode;
	/**
	 * 订单编号
	 */
	private Integer isPayment;
	/**
	 * 订单状态
	 */
	private Integer status;

	/**
	 * 订单结束时间
	 */
	private String endTime;
	/**
	 * 
	 */
	private Long money;
	/**
	 * 供应商ID
	 */
	private String supplierId;
	/**
	 * 
	 */
	private String linkmanId;
	/**
	 * 邮寄地址
	 */
	private String postageAddress;
	/**
	 * 
	 */
	private Integer isRefund;
	/**
	 * 
	 */
	private Integer isInvoiceValid;

	/**
	 * 设置：数据库ID
	 */
	public void setListId(String listId) {
		this.listId = listId;
	}
	/**
	 * 获取：数据库ID
	 */
	public String getListId() {
		return listId;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreater(String creater) {
		this.creater = creater;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreater() {
		return creater;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：操作时间
	 */
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
	/**
	 * 获取：操作时间
	 */
	public String getOperateTime() {
		return operateTime;
	}
	/**
	 * 设置：操作人
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**
	 * 获取：操作人
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * 设置：是否删除[BLDeleteEnum]
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：是否删除[BLDeleteEnum]
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
	/**
	 * 设置：状态[BLStatusEnum]
	 */
	public void setDomainAuth(String domainAuth) {
		this.domainAuth = domainAuth;
	}
	/**
	 * 获取：状态[BLStatusEnum]
	 */
	public String getDomainAuth() {
		return domainAuth;
	}
	/**
	 * 设置：创建人ID
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	/**
	 * 获取：创建人ID
	 */
	public String getCreatorId() {
		return creatorId;
	}
	/**
	 * 设置：账户id
	 */
	public void setAccountListid(String accountListid) {
		this.accountListid = accountListid;
	}
	/**
	 * 获取：账户id
	 */
	public String getAccountListid() {
		return accountListid;
	}
	/**
	 * 设置：订单编号
	 */
	public void setOrderCode(String ordercode) {
		this.orderCode = ordercode;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderCode() {
		return orderCode;
	}
	/**
	 * 设置：订单编号
	 */
	public void setIsPayment(Integer isPayment) {
		this.isPayment = isPayment;
	}
	/**
	 * 获取：订单编号
	 */
	public Integer getIsPayment() {
		return isPayment;
	}
	/**
	 * 设置：订单状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：订单状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：订单结束时间
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：订单结束时间
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 设置：
	 */
	public void setMoney(Long money) {
		this.money = money;
	}
	/**
	 * 获取：
	 */
	public Long getMoney() {
		return money;
	}
	/**
	 * 设置：供应商ID
	 */
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	/**
	 * 获取：供应商ID
	 */
	public String getSupplierId() {
		return supplierId;
	}
	/**
	 * 设置：
	 */
	public void setLinkmanId(String linkmanId) {
		this.linkmanId = linkmanId;
	}
	/**
	 * 获取：
	 */
	public String getLinkmanId() {
		return linkmanId;
	}
	/**
	 * 设置：邮寄地址
	 */
	public void setPostageAddress(String postageAddress) {
		this.postageAddress = postageAddress;
	}
	/**
	 * 获取：邮寄地址
	 */
	public String getPostageAddress() {
		return postageAddress;
	}
	/**
	 * 设置：
	 */
	public void setIsRefund(Integer isRefund) {
		this.isRefund = isRefund;
	}
	/**
	 * 获取：
	 */
	public Integer getIsRefund() {
		return isRefund;
	}
	/**
	 * 设置：
	 */
	public void setIsInvoiceValid(Integer isInvoiceValid) {
		this.isInvoiceValid = isInvoiceValid;
	}
	/**
	 * 获取：
	 */
	public Integer getIsInvoiceValid() {
		return isInvoiceValid;
	}
}
