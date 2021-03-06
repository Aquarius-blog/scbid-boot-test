package com.scbid.bond.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * @author wangyun
 * @date 2018-05-14 13:00:02
 */
@TableName("t_bond_order")
public class BondOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单主键ID
	 */
	@TableId
	private Long orderId;
	/**
	 * 供应商主键ID
	 */
	private Long supplierId;

	/**
	 * 供应商主键UUId
	 */
	private String supplierUuid;

	/**
	 * 企业中征码(贷款卡号)
	 */
	private String eigenCode;

	/**
	 * 代理机构主键ID
	 */
	private Long agencyId;
	/**
	 * 担保机构主键ID
	 */
	private Long guaratorId;

	/**
	 * 发票唯一标识
	 */
	private String invoiceUuid;

	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 订单金额
	 */
	private BigDecimal orderMoney;
	/**
	 * 订单类型
	 */
	private Integer orderType;

	/**
	 * 订单状态(1:审核不通过； 2审核通过；3已支付（待审核）)
	 */
	private Integer orderStatus;
	/**
	 * 支付类型
	 */
	private Integer payType;
	/**
	 * 订单创建时间
	 */
	private String orderDate;
	/**
	 * 最后修改人
	 */
	private String updateUesrName;
	/**
	 * 最后修改时间
	 */
	private String updateDate;

	/**
	 * 单位负责人
	 */
	private String person;
	/**
	 * 单位负责人电话
	 */
	private String telephone;

	/**
	 * 售卖主键
	 */
	private String saleOrderId;
	/**
	 * 项目id
	 */
	private String projectId;
	/**
	 * 项目编号
	 */
	private String projectCode;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 项目分包主键
	 */
	private String packageId;
	/**
	 * 分包编号
	 */
	private String packagesNum;
	/**
	 * 分包名称
	 */
	private String packagesName;
	/**
	 * 保证金金额
	 */
	private BigDecimal bondMoney;
	/**
	 * 投标保函咨询服务收费
	 */
	private BigDecimal bondFees;

	@TableField(exist = false)
	private String supplierName;

	@TableField(exist = false)
	private String agencyName;

	@TableField(exist = false)
	private String guaratorName;

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
	 * 设置：供应商主键ID
	 */
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	/**
	 * 获取：供应商主键ID
	 */
	public Long getSupplierId() {
		return supplierId;
	}

	public String getSupplierUuid() {
		return supplierUuid;
	}
	public void setSupplierUuid(String supplierUuid) {
		this.supplierUuid = supplierUuid;
	}
	/**
	 * 设置：代理机构主键ID
	 */
	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}
	/**
	 * 获取：代理机构主键ID
	 */
	public Long getAgencyId() {
		return agencyId;
	}
	/**
	 * 设置：担保机构主键ID
	 */
	public void setGuaratorId(Long guaratorId) {
		this.guaratorId = guaratorId;
	}
	/**
	 * 获取：担保机构主键ID
	 */
	public Long getGuaratorId() {
		return guaratorId;
	}

	public String getInvoiceUuid() {
		return invoiceUuid;
	}
	public void setInvoiceUuid(String invoiceUuid) {
		this.invoiceUuid = invoiceUuid;
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
	 * 设置：订单金额
	 */
	public void setOrderMoney(BigDecimal orderMoney) {
		this.orderMoney = orderMoney;
	}
	/**
	 * 获取：订单金额
	 */
	public BigDecimal getOrderMoney() {
		return orderMoney;
	}
	/**
	 * 设置：订单类型
	 */
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	/**
	 * 获取：订单类型
	 */
	public Integer getOrderType() {
		return orderType;
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
	 * 设置：支付类型
	 */
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	/**
	 * 获取：支付类型
	 */
	public Integer getPayType() {
		return payType;
	}
	/**
	 * 设置：订单创建时间
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * 获取：订单创建时间
	 */
	public String getOrderDate() {
		return orderDate;
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

	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getGuaratorName() {
		return guaratorName;
	}
	public void setGuaratorName(String guaratorName) {
		this.guaratorName = guaratorName;
	}
	public String getEigenCode() {
		return eigenCode;
	}
	public void setEigenCode(String eigenCode) {
		this.eigenCode = eigenCode;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * 设置：售卖主键
	 */
	public void setSaleOrderId(String saleOrderId) {
		this.saleOrderId = saleOrderId;
	}
	/**
	 * 获取：售卖主键
	 */
	public String getSaleOrderId() {
		return saleOrderId;
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
	 * 设置：项目编号
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	/**
	 * 获取：项目编号
	 */
	public String getProjectCode() {
		return projectCode;
	}
	/**
	 * 设置：项目名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置：项目分包主键
	 */
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	/**
	 * 获取：项目分包主键
	 */
	public String getPackageId() {
		return packageId;
	}
	/**
	 * 设置：分包编号
	 */
	public void setPackagesNum(String packagesNum) {
		this.packagesNum = packagesNum;
	}
	/**
	 * 获取：分包编号
	 */
	public String getPackagesNum() {
		return packagesNum;
	}
	/**
	 * 设置：分包名称
	 */
	public void setPackagesName(String packagesName) {
		this.packagesName = packagesName;
	}
	/**
	 * 获取：分包名称
	 */
	public String getPackagesName() {
		return packagesName;
	}
	/**
	 * 设置：保证金金额
	 */
	public void setBondMoney(BigDecimal bondMoney) {
		this.bondMoney = bondMoney;
	}
	/**
	 * 获取：保证金金额
	 */
	public BigDecimal getBondMoney() {
		return bondMoney;
	}
	public BigDecimal getBondFees() {
		return bondFees;
	}
	public void setBondFees(BigDecimal bondFees) {
		this.bondFees = bondFees;
	}

}
