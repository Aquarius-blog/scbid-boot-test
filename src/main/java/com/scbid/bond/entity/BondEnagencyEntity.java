package com.scbid.bond.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * @author wangyun
 * @date 2018-05-14 13:00:02
 */
@TableName("t_bond_ent_agency")
public class BondEnagencyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 代理机构主键ID
	 */
	@TableId
	private Long agencyId;
	/**
	 * 担保机构UUID
	 */
	private String agencyUuid;
	/**
	 * 公司规模 0微型，1小型，2中型，3大型
	 */
	private Integer agencyScale;
	/**
	 * 代理机构全称
	 */
	private String agencyName;
	/**
	 * 代理机构公司电话
	 */
	private String agencyPhone;
	/**
	 * 代理机构公司邮编
	 */
	private String agencyPostcode;
	/**
	 * 代理机构公司注册资本
	 */
	private String agencyCapital;
	/**
	 * 代理机构执性质
	 */
	private Integer agencySort;
	/**
	 * 代理机构传真
	 */
	private String agencyFaxes;
	/**
	 * 代理机构纳税人识别号
	 */
	private String agencyTaxpayerNo;
	/**
	 * 银行账号
	 */
	private String agencyBankNumber;
	/**
	 * 供应商公司地址
	 */
	private String agencyAddress;
	/**
	 * 执照号图片
	 */
	private String agencyLicenseImg;
	/**
	 * 执照号
	 */
	private Integer agencyLicenseNo;
	/**
	 * 行业
	 */
	private String agencyIndustry;
	/**
	 * 法人代表
	 */
	private String agencyLegalPepre;
	/**
	 * 公司成立日期
	 */
	private String agencyEstabDate;
	/**
	 * 营业期限
	 */
	private String agencyOpenatingPeriod;
	/**
	 * 注册地址
	 */
	private String agencyRegAdress;
	/**
	 * 公司类型
	 */
	private String agencyCompanyType;
	/**
	 * 开户行
	 */
	private String agencyBankAccount;
	/**
	 * 注册证号
	 */
	private Integer agencyRegNumber;
	/**
	 * 法人电话
	 */
	private String agencyLegalPhone;
	/**
	 * 备注
	 */
	private String agencyRemarks;
	/**
	 * 代理机构状态
	 */
	private Integer agencyStatus;
	/**
	 * 代理机构创建时间
	 */
	private String agencyDate;
	/**
	 * 代理机构监管人id
	 */
	private Integer agencyUserId;
	/**
	 * 最后修改人
	 */
	private String updateUesrName;
	/**
	 * 最后修改时间
	 */
	private String updateDate;

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
	 * 设置：担保机构UUID
	 */
	public void setAgencyUuid(String agencyUuid) {
		this.agencyUuid = agencyUuid;
	}
	/**
	 * 获取：担保机构UUID
	 */
	public String getAgencyUuid() {
		return agencyUuid;
	}
	/**
	 * 设置：公司规模 0微型，1小型，2中型，3大型
	 */
	public void setAgencyScale(Integer agencyScale) {
		this.agencyScale = agencyScale;
	}
	/**
	 * 获取：公司规模 0微型，1小型，2中型，3大型
	 */
	public Integer getAgencyScale() {
		return agencyScale;
	}
	/**
	 * 设置：代理机构全称
	 */
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	/**
	 * 获取：代理机构全称
	 */
	public String getAgencyName() {
		return agencyName;
	}
	/**
	 * 设置：代理机构公司电话
	 */
	public void setAgencyPhone(String agencyPhone) {
		this.agencyPhone = agencyPhone;
	}
	/**
	 * 获取：代理机构公司电话
	 */
	public String getAgencyPhone() {
		return agencyPhone;
	}
	/**
	 * 设置：代理机构公司邮编
	 */
	public void setAgencyPostcode(String agencyPostcode) {
		this.agencyPostcode = agencyPostcode;
	}
	/**
	 * 获取：代理机构公司邮编
	 */
	public String getAgencyPostcode() {
		return agencyPostcode;
	}
	/**
	 * 设置：代理机构公司注册资本
	 */
	public void setAgencyCapital(String agencyCapital) {
		this.agencyCapital = agencyCapital;
	}
	/**
	 * 获取：代理机构公司注册资本
	 */
	public String getAgencyCapital() {
		return agencyCapital;
	}
	/**
	 * 设置：代理机构执性质
	 */
	public void setAgencySort(Integer agencySort) {
		this.agencySort = agencySort;
	}
	/**
	 * 获取：代理机构执性质
	 */
	public Integer getAgencySort() {
		return agencySort;
	}
	/**
	 * 设置：代理机构传真
	 */
	public void setAgencyFaxes(String agencyFaxes) {
		this.agencyFaxes = agencyFaxes;
	}
	/**
	 * 获取：代理机构传真
	 */
	public String getAgencyFaxes() {
		return agencyFaxes;
	}
	/**
	 * 设置：代理机构纳税人识别号
	 */
	public void setAgencyTaxpayerNo(String agencyTaxpayerNo) {
		this.agencyTaxpayerNo = agencyTaxpayerNo;
	}
	/**
	 * 获取：代理机构纳税人识别号
	 */
	public String getAgencyTaxpayerNo() {
		return agencyTaxpayerNo;
	}
	/**
	 * 设置：银行账号
	 */
	public void setAgencyBankNumber(String agencyBankNumber) {
		this.agencyBankNumber = agencyBankNumber;
	}
	/**
	 * 获取：银行账号
	 */
	public String getAgencyBankNumber() {
		return agencyBankNumber;
	}
	/**
	 * 设置：供应商公司地址
	 */
	public void setAgencyAddress(String agencyAddress) {
		this.agencyAddress = agencyAddress;
	}
	/**
	 * 获取：供应商公司地址
	 */
	public String getAgencyAddress() {
		return agencyAddress;
	}
	/**
	 * 设置：执照号图片
	 */
	public void setAgencyLicenseImg(String agencyLicenseImg) {
		this.agencyLicenseImg = agencyLicenseImg;
	}
	/**
	 * 获取：执照号图片
	 */
	public String getAgencyLicenseImg() {
		return agencyLicenseImg;
	}
	/**
	 * 设置：执照号
	 */
	public void setAgencyLicenseNo(Integer agencyLicenseNo) {
		this.agencyLicenseNo = agencyLicenseNo;
	}
	/**
	 * 获取：执照号
	 */
	public Integer getAgencyLicenseNo() {
		return agencyLicenseNo;
	}
	/**
	 * 设置：行业
	 */
	public void setAgencyIndustry(String agencyIndustry) {
		this.agencyIndustry = agencyIndustry;
	}
	/**
	 * 获取：行业
	 */
	public String getAgencyIndustry() {
		return agencyIndustry;
	}
	/**
	 * 设置：法人代表
	 */
	public void setAgencyLegalPepre(String agencyLegalPepre) {
		this.agencyLegalPepre = agencyLegalPepre;
	}
	/**
	 * 获取：法人代表
	 */
	public String getAgencyLegalPepre() {
		return agencyLegalPepre;
	}
	/**
	 * 设置：公司成立日期
	 */
	public void setAgencyEstabDate(String agencyEstabDate) {
		this.agencyEstabDate = agencyEstabDate;
	}
	/**
	 * 获取：公司成立日期
	 */
	public String getAgencyEstabDate() {
		return agencyEstabDate;
	}
	/**
	 * 设置：营业期限
	 */
	public void setAgencyOpenatingPeriod(String agencyOpenatingPeriod) {
		this.agencyOpenatingPeriod = agencyOpenatingPeriod;
	}
	/**
	 * 获取：营业期限
	 */
	public String getAgencyOpenatingPeriod() {
		return agencyOpenatingPeriod;
	}
	/**
	 * 设置：注册地址
	 */
	public void setAgencyRegAdress(String agencyRegAdress) {
		this.agencyRegAdress = agencyRegAdress;
	}
	/**
	 * 获取：注册地址
	 */
	public String getAgencyRegAdress() {
		return agencyRegAdress;
	}
	/**
	 * 设置：公司类型
	 */
	public void setAgencyCompanyType(String agencyCompanyType) {
		this.agencyCompanyType = agencyCompanyType;
	}
	/**
	 * 获取：公司类型
	 */
	public String getAgencyCompanyType() {
		return agencyCompanyType;
	}
	/**
	 * 设置：开户行
	 */
	public void setAgencyBankAccount(String agencyBankAccount) {
		this.agencyBankAccount = agencyBankAccount;
	}
	/**
	 * 获取：开户行
	 */
	public String getAgencyBankAccount() {
		return agencyBankAccount;
	}
	/**
	 * 设置：注册证号
	 */
	public void setAgencyRegNumber(Integer agencyRegNumber) {
		this.agencyRegNumber = agencyRegNumber;
	}
	/**
	 * 获取：注册证号
	 */
	public Integer getAgencyRegNumber() {
		return agencyRegNumber;
	}
	/**
	 * 设置：法人电话
	 */
	public void setAgencyLegalPhone(String agencyLegalPhone) {
		this.agencyLegalPhone = agencyLegalPhone;
	}
	/**
	 * 获取：法人电话
	 */
	public String getAgencyLegalPhone() {
		return agencyLegalPhone;
	}
	/**
	 * 设置：备注
	 */
	public void setAgencyRemarks(String agencyRemarks) {
		this.agencyRemarks = agencyRemarks;
	}
	/**
	 * 获取：备注
	 */
	public String getAgencyRemarks() {
		return agencyRemarks;
	}
	/**
	 * 设置：代理机构状态
	 */
	public void setAgencyStatus(Integer agencyStatus) {
		this.agencyStatus = agencyStatus;
	}
	/**
	 * 获取：代理机构状态
	 */
	public Integer getAgencyStatus() {
		return agencyStatus;
	}
	/**
	 * 设置：代理机构创建时间
	 */
	public void setAgencyDate(String agencyDate) {
		this.agencyDate = agencyDate;
	}
	/**
	 * 获取：代理机构创建时间
	 */
	public String getAgencyDate() {
		return agencyDate;
	}
	/**
	 * 设置：代理机构监管人id
	 */
	public void setAgencyUserId(Integer agencyUserId) {
		this.agencyUserId = agencyUserId;
	}
	/**
	 * 获取：代理机构监管人id
	 */
	public Integer getAgencyUserId() {
		return agencyUserId;
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
