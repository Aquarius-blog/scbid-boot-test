package com.scbid.manage.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * @author wangyun
 * @date 2018-10-30 21:24:11
 */
@TableName("t_tender_implement_project_packages")
public class TenderImplemenProjectPackagesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String listId;
	/**
	 * 项目ID
	 */
	private String projectId;
	/**
	 * 类目ID
	 */
	private String vocationId;
	/**
	 * 收费方式
	 */
	private String chargeId;
	/**
	 * 分包委托金额
	 */
	private Long packagesMoney;
	/**
	 * 分包编号
	 */
	private String packagesNum;
	/**
	 * 分包名称
	 */
	private String packagesName;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 是否被删除0 为否，1为是
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
	 * 业主中标通知书URL地址
	 */
	private String clientBidNoticeUrl;
	/**
	 * 业主中标通知书编号
	 */
	private String clientBidNoticeNumber;
	/**
	 * 中标通知书URL地址
	 */
	private String supplierBidNoticeUrl;
	/**
	 * 供应商中标通知书编号
	 */
	private String supplierBidNoticeNumber;
	/**
	 * 确认函URL
	 */
	private String bidSureUrl;
	/**
	 * 中标通知书确认时间
	 */
	private String bidNoticeTime;
	/**
	 * 分包状态
	 */
	private Integer bidType;
	/**
	 * 是否生成保证金账号
	 */
	private Integer isAccount;
	/**
	 * 上浮或者下浮
	 */
	private Integer isUp;
	/**
	 * 上下浮比例
	 */
	private Integer proportion;
	/**
	 * 定额每包的服务费金额
	 */
	private Long quotaMoney;
	/**
	 * 创建人ID
	 */
	private String creatorId;
	/**
	 * 标书售价
	 */
	private Long moneyNumber;
	/**
	 * 项目服务费用
	 */
	private Double serviceCharge;
	/**
	 * 保证金金额
	 */
	private Long bondMoney;
	/**
	 * 比例
	 */
	private Double scale;
	/**
	 * 其他
	 */
	private String other;
	/**
	 * 收费方式显示
	 */
	private String chargeShowStr;
	/**
	 * 分包最高限价
	 */
	private Long maxMoney;
	/**
	 * 排序号
	 */
	private Integer showSort;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 数量
	 */
	private String number;

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
	 * 设置：项目ID
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：项目ID
	 */
	public String getProjectId() {
		return projectId;
	}
	/**
	 * 设置：类目ID
	 */
	public void setVocationId(String vocationId) {
		this.vocationId = vocationId;
	}
	/**
	 * 获取：类目ID
	 */
	public String getVocationId() {
		return vocationId;
	}
	/**
	 * 设置：收费方式
	 */
	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}
	/**
	 * 获取：收费方式
	 */
	public String getChargeId() {
		return chargeId;
	}
	/**
	 * 设置：分包委托金额
	 */
	public void setPackagesMoney(Long packagesMoney) {
		this.packagesMoney = packagesMoney;
	}
	/**
	 * 获取：分包委托金额
	 */
	public Long getPackagesMoney() {
		return packagesMoney;
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
	 * 设置：是否被删除0 为否，1为是
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：是否被删除0 为否，1为是
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
	 * 设置：业主中标通知书URL地址
	 */
	public void setClientBidNoticeUrl(String clientBidNoticeUrl) {
		this.clientBidNoticeUrl = clientBidNoticeUrl;
	}
	/**
	 * 获取：业主中标通知书URL地址
	 */
	public String getClientBidNoticeUrl() {
		return clientBidNoticeUrl;
	}
	/**
	 * 设置：业主中标通知书编号
	 */
	public void setClientBidNoticeNumber(String clientBidNoticeNumber) {
		this.clientBidNoticeNumber = clientBidNoticeNumber;
	}
	/**
	 * 获取：业主中标通知书编号
	 */
	public String getClientBidNoticeNumber() {
		return clientBidNoticeNumber;
	}
	/**
	 * 设置：中标通知书URL地址
	 */
	public void setSupplierBidNoticeUrl(String supplierBidNoticeUrl) {
		this.supplierBidNoticeUrl = supplierBidNoticeUrl;
	}
	/**
	 * 获取：中标通知书URL地址
	 */
	public String getSupplierBidNoticeUrl() {
		return supplierBidNoticeUrl;
	}
	/**
	 * 设置：供应商中标通知书编号
	 */
	public void setSupplierBidNoticeNumber(String supplierBidNoticeNumber) {
		this.supplierBidNoticeNumber = supplierBidNoticeNumber;
	}
	/**
	 * 获取：供应商中标通知书编号
	 */
	public String getSupplierBidNoticeNumber() {
		return supplierBidNoticeNumber;
	}
	/**
	 * 设置：确认函URL
	 */
	public void setBidSureUrl(String bidSureUrl) {
		this.bidSureUrl = bidSureUrl;
	}
	/**
	 * 获取：确认函URL
	 */
	public String getBidSureUrl() {
		return bidSureUrl;
	}
	/**
	 * 设置：中标通知书确认时间
	 */
	public void setBidNoticeTime(String bidNoticeTime) {
		this.bidNoticeTime = bidNoticeTime;
	}
	/**
	 * 获取：中标通知书确认时间
	 */
	public String getBidNoticeTime() {
		return bidNoticeTime;
	}
	/**
	 * 设置：分包状态
	 */
	public void setBidType(Integer bidType) {
		this.bidType = bidType;
	}
	/**
	 * 获取：分包状态
	 */
	public Integer getBidType() {
		return bidType;
	}
	/**
	 * 设置：是否生成保证金账号
	 */
	public void setIsAccount(Integer isAccount) {
		this.isAccount = isAccount;
	}
	/**
	 * 获取：是否生成保证金账号
	 */
	public Integer getIsAccount() {
		return isAccount;
	}
	/**
	 * 设置：上浮或者下浮
	 */
	public void setIsUp(Integer isUp) {
		this.isUp = isUp;
	}
	/**
	 * 获取：上浮或者下浮
	 */
	public Integer getIsUp() {
		return isUp;
	}
	/**
	 * 设置：上下浮比例
	 */
	public void setProportion(Integer proportion) {
		this.proportion = proportion;
	}
	/**
	 * 获取：上下浮比例
	 */
	public Integer getProportion() {
		return proportion;
	}
	/**
	 * 设置：定额每包的服务费金额
	 */
	public void setQuotaMoney(Long quotaMoney) {
		this.quotaMoney = quotaMoney;
	}
	/**
	 * 获取：定额每包的服务费金额
	 */
	public Long getQuotaMoney() {
		return quotaMoney;
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
	 * 设置：标书售价
	 */
	public void setMoneyNumber(Long moneyNumber) {
		this.moneyNumber = moneyNumber;
	}
	/**
	 * 获取：标书售价
	 */
	public Long getMoneyNumber() {
		return moneyNumber;
	}
	/**
	 * 设置：项目服务费用
	 */
	public void setServiceCharge(Double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	/**
	 * 获取：项目服务费用
	 */
	public Double getServiceCharge() {
		return serviceCharge;
	}
	/**
	 * 设置：保证金金额
	 */
	public void setBondMoney(Long bondMoney) {
		this.bondMoney = bondMoney;
	}
	/**
	 * 获取：保证金金额
	 */
	public Long getBondMoney() {
		return bondMoney;
	}
	/**
	 * 设置：比例
	 */
	public void setScale(Double scale) {
		this.scale = scale;
	}
	/**
	 * 获取：比例
	 */
	public Double getScale() {
		return scale;
	}
	/**
	 * 设置：其他
	 */
	public void setOther(String other) {
		this.other = other;
	}
	/**
	 * 获取：其他
	 */
	public String getOther() {
		return other;
	}
	/**
	 * 设置：收费方式显示
	 */
	public void setChargeShowStr(String chargeShowStr) {
		this.chargeShowStr = chargeShowStr;
	}
	/**
	 * 获取：收费方式显示
	 */
	public String getChargeShowStr() {
		return chargeShowStr;
	}
	/**
	 * 设置：分包最高限价
	 */
	public void setMaxMoney(Long maxMoney) {
		this.maxMoney = maxMoney;
	}
	/**
	 * 获取：分包最高限价
	 */
	public Long getMaxMoney() {
		return maxMoney;
	}
	/**
	 * 设置：排序号
	 */
	public void setShowSort(Integer showSort) {
		this.showSort = showSort;
	}
	/**
	 * 获取：排序号
	 */
	public Integer getShowSort() {
		return showSort;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置：数量
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 获取：数量
	 */
	public String getNumber() {
		return number;
	}
}
