package com.scbid.manage.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * OA 系统标书售卖数据表
 * 
 * @author wangyun
 * @date 2018-05-17 16:28:02
 */
@TableName("t_tender_bid_book_sale_record")
public class TenderBidBookSaleRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String listId;
	/**
	 * 是否被删除
	 */
	private Integer isDelete;
	/**
	 * 操作人
	 */
	private String operator;
	/**
	 * 操作时间
	 */
	private String operateTime;
	/**
	 * 创建人
	 */
	private String creater;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 域权限
	 */
	private String domainAuth;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 项目id
	 */
	private String projectId;

	/**
	 * 分包id
	 */
	private String packageId;
	/**
	 * 供应商id
	 */
	private String supplierId;

	/**
	 * 供应商联系人id
	 */
	private String supplierLinkmanId;

	/**
	 * 发票号
	 */
	private String invoiceNumber;
	/**
	 * 信息类型,线上售卖还是线下售卖
	 */
	private Integer type;
	/**
	 * 发票号
	 */
	private String receiptNumber;
	/**
	 * 是否缴纳保证金
	 */
	private Integer isPayTheDeposit;
	/**
	 * 保证金来源
	 */
	private Integer marginSource;
	/**
	 * 标书款来源
	 */
	private Integer tenderNewSource;
	/**
	 * 保证金来源的其他选择
	 */
	private String marginOther;
	/**
	 * 标书款来源的其他
	 */
	private String tenderNewOther;
	/**
	 * 保证金金额
	 */
	private Double depositAmount;
	/**
	 * 是否是待处理
	 */
	private Integer isPending;
	/**
	 * 标书款来源其他
	 */
	private String enderNewOther;
	/**
	 * 创建人ID
	 */
	private String creatorId;
	/**
	 * 是否生成了退还单【BLWhetherEnum】
	 */
	private Integer billsStatus;
	/**
	 * 是否参加开标 BLWhetherEnum
	 */
	private Integer isJoinOpenBid;
	/**
	 * 保证金交易流水
	 */
	private String channelSerialNo;
	/**
	 * 支付方式 PayTypeEnum
	 */
	private Integer payStyle;
	/**
	 * 
	 */
	private String saleOrderId;

	/**
	 * 订单保函状态
	 */
	private Integer bondStatus;

	/**
	 * 保函订单编号
	 */
	private String bondOrderNo;
	/**
	 * 保函订单金额
	 */
	private BigDecimal bondOrderMoney;
	/**
	 * 投标保函咨询服务收费
	 */
	private BigDecimal bondFees;

	/**
	 * 项目名称
	 */
	@TableField(exist = false)
	private String projectName;
	/**
	 * 供应商
	 */
	@TableField(exist = false)
	private String supplierName;
	/**
	 * 供应商联系人
	 */
	@TableField(exist = false)
	private String supplierLinkman;
	/**
	 * 订单编号
	 */
	@TableField(exist = false)
	private String saleOrder;

	/**
	 * 设置：主键
	 */
	public void setListId(String listId) {
		this.listId = listId;
	}
	/**
	 * 获取：主键
	 */
	public String getListId() {
		return listId;
	}
	/**
	 * 设置：是否被删除
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：是否被删除
	 */
	public Integer getIsDelete() {
		return isDelete;
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
	 * 设置：域权限
	 */
	public void setDomainAuth(String domainAuth) {
		this.domainAuth = domainAuth;
	}
	/**
	 * 获取：域权限
	 */
	public String getDomainAuth() {
		return domainAuth;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：项目id
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：项目id
	 */
	public String getProjectId() {
		return projectId;
	}
	/**
	 * 设置：分包id
	 */
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	/**
	 * 获取：分包id
	 */
	public String getPackageId() {
		return packageId;
	}
	/**
	 * 设置：供应商id
	 */
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	/**
	 * 获取：供应商id
	 */
	public String getSupplierId() {
		return supplierId;
	}
	/**
	 * 设置：供应商联系人id
	 */
	public void setSupplierLinkmanId(String supplierLinkmanId) {
		this.supplierLinkmanId = supplierLinkmanId;
	}
	/**
	 * 获取：供应商联系人id
	 */
	public String getSupplierLinkmanId() {
		return supplierLinkmanId;
	}
	/**
	 * 设置：发票号
	 */
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	/**
	 * 获取：发票号
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	/**
	 * 设置：信息类型,线上售卖还是线下售卖
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：信息类型,线上售卖还是线下售卖
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：发票号
	 */
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	/**
	 * 获取：发票号
	 */
	public String getReceiptNumber() {
		return receiptNumber;
	}
	/**
	 * 设置：是否缴纳保证金
	 */
	public void setIsPayTheDeposit(Integer isPayTheDeposit) {
		this.isPayTheDeposit = isPayTheDeposit;
	}
	/**
	 * 获取：是否缴纳保证金
	 */
	public Integer getIsPayTheDeposit() {
		return isPayTheDeposit;
	}
	/**
	 * 设置：保证金来源
	 */
	public void setMarginSource(Integer marginSource) {
		this.marginSource = marginSource;
	}
	/**
	 * 获取：保证金来源
	 */
	public Integer getMarginSource() {
		return marginSource;
	}
	/**
	 * 设置：标书款来源
	 */
	public void setTenderNewSource(Integer tenderNewSource) {
		this.tenderNewSource = tenderNewSource;
	}
	/**
	 * 获取：标书款来源
	 */
	public Integer getTenderNewSource() {
		return tenderNewSource;
	}
	/**
	 * 设置：保证金来源的其他选择
	 */
	public void setMarginOther(String marginOther) {
		this.marginOther = marginOther;
	}
	/**
	 * 获取：保证金来源的其他选择
	 */
	public String getMarginOther() {
		return marginOther;
	}
	/**
	 * 设置：标书款来源的其他
	 */
	public void setTenderNewOther(String tenderNewOther) {
		this.tenderNewOther = tenderNewOther;
	}
	/**
	 * 获取：标书款来源的其他
	 */
	public String getTenderNewOther() {
		return tenderNewOther;
	}
	/**
	 * 设置：保证金金额
	 */
	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}
	/**
	 * 获取：保证金金额
	 */
	public Double getDepositAmount() {
		return depositAmount;
	}
	/**
	 * 设置：是否是待处理
	 */
	public void setIsPending(Integer isPending) {
		this.isPending = isPending;
	}
	/**
	 * 获取：是否是待处理
	 */
	public Integer getIsPending() {
		return isPending;
	}
	/**
	 * 设置：标书款来源其他
	 */
	public void setEnderNewOther(String enderNewOther) {
		this.enderNewOther = enderNewOther;
	}
	/**
	 * 获取：标书款来源其他
	 */
	public String getEnderNewOther() {
		return enderNewOther;
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
	 * 设置：是否生成了退还单【BLWhetherEnum】
	 */
	public void setBillsStatus(Integer billsStatus) {
		this.billsStatus = billsStatus;
	}
	/**
	 * 获取：是否生成了退还单【BLWhetherEnum】
	 */
	public Integer getBillsStatus() {
		return billsStatus;
	}
	/**
	 * 设置：是否参加开标 BLWhetherEnum
	 */
	public void setIsJoinOpenBid(Integer isJoinOpenBid) {
		this.isJoinOpenBid = isJoinOpenBid;
	}
	/**
	 * 获取：是否参加开标 BLWhetherEnum
	 */
	public Integer getIsJoinOpenBid() {
		return isJoinOpenBid;
	}
	/**
	 * 设置：保证金交易流水
	 */
	public void setChannelSerialNo(String channelSerialNo) {
		this.channelSerialNo = channelSerialNo;
	}
	/**
	 * 获取：保证金交易流水
	 */
	public String getChannelSerialNo() {
		return channelSerialNo;
	}
	/**
	 * 设置：支付方式 PayTypeEnum
	 */
	public void setPayStyle(Integer payStyle) {
		this.payStyle = payStyle;
	}
	/**
	 * 获取：支付方式 PayTypeEnum
	 */
	public Integer getPayStyle() {
		return payStyle;
	}
	/**
	 * 设置：
	 */
	public void setSaleOrderId(String saleOrderId) {
		this.saleOrderId = saleOrderId;
	}
	/**
	 * 获取：
	 */
	public String getSaleOrderId() {
		return saleOrderId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierLinkman() {
		return supplierLinkman;
	}
	public void setSupplierLinkman(String supplierLinkman) {
		this.supplierLinkman = supplierLinkman;
	}
	public String getSaleOrder() {
		return saleOrder;
	}
	public void setSaleOrder(String saleOrder) {
		this.saleOrder = saleOrder;
	}
	public Integer getBondStatus() {
		return bondStatus;
	}
	public void setBondStatus(Integer bondStatus) {
		this.bondStatus = bondStatus;
	}
	public String getBondOrderNo() {
		return bondOrderNo;
	}
	public void setBondOrderNo(String bondOrderNo) {
		this.bondOrderNo = bondOrderNo;
	}
	public BigDecimal getBondOrderMoney() {
		return bondOrderMoney;
	}
	public void setBondOrderMoney(BigDecimal bondOrderMoney) {
		this.bondOrderMoney = bondOrderMoney;
	}
	public BigDecimal getBondFees() {
		return bondFees;
	}
	public void setBondFees(BigDecimal bondFees) {
		this.bondFees = bondFees;
	}

}
