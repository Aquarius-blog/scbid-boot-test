package com.scbid.invoice.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 发票数据表
 * 
 * @author wangyun
 * @date 2018-05-24 10:27:59
 */
@TableName("t_fpsqb")
public class FpsqbEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主申请单ID
	 */
	@TableId
	private String listId;
	/**
	 * 客户编码
	 */
	private String clientCode;
	/**
	 * 客户名称
	 */
	private String cliengName;
	/**
	 * 税号
	 */
	private String dutyParagraph;
	/**
	 * 地址电话
	 */
	private String addressPhone;
	/**
	 * 开户行账号
	 */
	private String bankNum;
	/**
	 * 申请日期
	 */
	private Date applyDate;
	/**
	 * 发票类别
	 */
	private String invoiceCategory;
	/**
	 * 审核人
	 */
	private String auditor;
	/**
	 * 商品编码
	 */
	private String goodCode;
	/**
	 * 商品名称
	 */
	private String goodName;
	/**
	 * 规格
	 */
	private String specifications;
	/**
	 * 单位
	 */
	private String company;
	/**
	 * 单价
	 */
	private Float unitPrice;
	/**
	 * 数量
	 */
	private Float number;
	/**
	 * 税率
	 */
	private Float taxRate;
	/**
	 * 价税合计
	 */
	private Float consult;
	/**
	 * 折扣金额
	 */
	private Float discountAmount;
	/**
	 * 业务员
	 */
	private String salesman;
	/**
	 * 单据明细ID
	 */
	private String invoiceDetailId;
	/**
	 * 分类编码
	 */
	private String typeCode;
	/**
	 * 开票状态
	 */
	private String invoiceStatus;
	/**
	 * 发票代码
	 */
	private String invoiceCode;
	/**
	 * 发票号码
	 */
	private String invoiceNumber;
	/**
	 * 发票备注
	 */
	private String invoiceRemark;
	/**
	 * 开票标识
	 */
	private Integer identification;
	/**
	 * PDF路径
	 */
	private String pdfbase64;
	/**
	 * PDF路径
	 */
	private String pdfPath;
	/**
	 * 开票日期
	 */
	private String billingDate;
	public String getListId() {
		return listId;
	}
	public void setListId(String listId) {
		this.listId = listId;
	}
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getCliengName() {
		return cliengName;
	}
	public void setCliengName(String cliengName) {
		this.cliengName = cliengName;
	}
	public String getDutyParagraph() {
		return dutyParagraph;
	}
	public void setDutyParagraph(String dutyParagraph) {
		this.dutyParagraph = dutyParagraph;
	}
	public String getAddressPhone() {
		return addressPhone;
	}
	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}
	public String getBankNum() {
		return bankNum;
	}
	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public String getInvoiceCategory() {
		return invoiceCategory;
	}
	public void setInvoiceCategory(String invoiceCategory) {
		this.invoiceCategory = invoiceCategory;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public String getGoodCode() {
		return goodCode;
	}
	public void setGoodCode(String goodCode) {
		this.goodCode = goodCode;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Float getNumber() {
		return number;
	}
	public void setNumber(Float number) {
		this.number = number;
	}
	public Float getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(Float taxRate) {
		this.taxRate = taxRate;
	}
	public Float getConsult() {
		return consult;
	}
	public void setConsult(Float consult) {
		this.consult = consult;
	}
	public Float getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Float discountAmount) {
		this.discountAmount = discountAmount;
	}
	public String getSalesman() {
		return salesman;
	}
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}
	public String getInvoiceDetailId() {
		return invoiceDetailId;
	}
	public void setInvoiceDetailId(String invoiceDetailId) {
		this.invoiceDetailId = invoiceDetailId;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getInvoiceStatus() {
		return invoiceStatus;
	}
	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	public String getInvoiceCode() {
		return invoiceCode;
	}
	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getInvoiceRemark() {
		return invoiceRemark;
	}
	public void setInvoiceRemark(String invoiceRemark) {
		this.invoiceRemark = invoiceRemark;
	}
	public Integer getIdentification() {
		return identification;
	}
	public void setIdentification(Integer identification) {
		this.identification = identification;
	}

	public String getPdfbase64() {
		return pdfbase64;
	}
	public void setPdfbase64(String pdfbase64) {
		this.pdfbase64 = pdfbase64;
	}
	public String getPdfPath() {
		return pdfPath;
	}
	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}
	public String getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(String billingDate) {
		this.billingDate = billingDate;
	}

}
