package com.scbid.bond.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * @author wangyun
 * @date 2018-05-14 13:00:02
 */
@TableName("t_bond_ent_guarator")
public class BondEnguaratorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 担保机构主键ID
	 */
	@TableId
	private Long guaratorId;

	@TableId
	private Long parentId;

	/**
	 * 全局uuid
	 */
	private String guaratorUuid;

	/**
	 * 担保机构类型 0:银行1:担保结构
	 */
	private String guaratorType;

	/**
	 * 担保机构全称
	 */
	private String guaratorName;
	/**
	 * 公司规模 0微型，1小型，2中型，3大型
	 */
	private Integer guaratorScale;
	/**
	 * 担保机构公司电话
	 */
	private String guaratorPhone;
	/**
	 * 担保机构公司邮箱
	 */
	private String guaratorEmail;
	/**
	 * 担保机构执照号
	 */
	private String guaratorLicenseNo;
	/**
	 * 担保机构执照号图片
	 */
	private String guaratorLicenseImg;
	/**
	 * 公司注册资本
	 */
	private String guaratorCapital;
	/**
	 * 邮编
	 */
	private String guaratorPostcode;
	/**
	 * 公司性质
	 */
	private Integer guaratorSort;
	/**
	 * 纳税人识别号
	 */
	private String guaratorTaxpayerNo;
	/**
	 * 注册证号
	 */
	private String guaratorRegNumber;
	/**
	 * 法人电话
	 */
	private String guaratorLegalPhone;
	/**
	 * 传真
	 */
	private String guaratorFaxes;
	/**
	 * 开户行
	 */
	private String guaratorBankAccount;
	/**
	 * 银行账号
	 */
	private String guaratorBankNumber;
	/**
	 * 公司地址
	 */
	private String guaratorAddress;
	/**
	 * 行业
	 */
	private Integer guaratorIndustry;
	/**
	 * 法人代表
	 */
	private String guaratorLegalPepre;
	/**
	 * 建立时间
	 */
	private String guaratorEstabDate;
	/**
	 * 营业期限
	 */
	private String guaratorOpenatingPeriod;
	/**
	 * 注册地址
	 */
	private String guaratorRegAdress;
	/**
	 * 公司类型
	 */
	private String guaratorCompanyType;
	/**
	 * 担保机构状态
	 */
	private Integer guaratorStatus;
	/**
	 * 备注
	 */
	private String guaratorRemarks;
	/**
	 * 担保机构创建时间
	 */
	private String guaratorDate;
	/**
	 * 担保机构监管人
	 */
	private Long guaratorUserId;
	/**
	 * 最后修改人
	 */
	private String updateUesrName;
	/**
	 * 最后修改时间
	 */
	private String updateDate;

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

	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 设置：全局uuid
	 */
	public void setGuaratorUuid(String guaratorUuid) {
		this.guaratorUuid = guaratorUuid;
	}
	/**
	 * 获取：全局uuid
	 */
	public String getGuaratorUuid() {
		return guaratorUuid;
	}

	public String getGuaratorType() {
		return guaratorType;
	}
	public void setGuaratorType(String guaratorType) {
		this.guaratorType = guaratorType;
	}
	public String getGuaratorEmail() {
		return guaratorEmail;
	}
	public void setGuaratorEmail(String guaratorEmail) {
		this.guaratorEmail = guaratorEmail;
	}
	/**
	 * 设置：担保机构全称
	 */
	public void setGuaratorName(String guaratorName) {
		this.guaratorName = guaratorName;
	}
	/**
	 * 获取：担保机构全称
	 */
	public String getGuaratorName() {
		return guaratorName;
	}
	/**
	 * 设置：公司规模 0微型，1小型，2中型，3大型
	 */
	public void setGuaratorScale(Integer guaratorScale) {
		this.guaratorScale = guaratorScale;
	}
	/**
	 * 获取：公司规模 0微型，1小型，2中型，3大型
	 */
	public Integer getGuaratorScale() {
		return guaratorScale;
	}
	/**
	 * 设置：担保机构公司电话
	 */
	public void setGuaratorPhone(String guaratorPhone) {
		this.guaratorPhone = guaratorPhone;
	}
	/**
	 * 获取：担保机构公司电话
	 */
	public String getGuaratorPhone() {
		return guaratorPhone;
	}
	/**
	 * 设置：担保机构执照号
	 */
	public void setGuaratorLicenseNo(String guaratorLicenseNo) {
		this.guaratorLicenseNo = guaratorLicenseNo;
	}
	/**
	 * 获取：担保机构执照号
	 */
	public String getGuaratorLicenseNo() {
		return guaratorLicenseNo;
	}
	/**
	 * 设置：担保机构执照号图片
	 */
	public void setGuaratorLicenseImg(String guaratorLicenseImg) {
		this.guaratorLicenseImg = guaratorLicenseImg;
	}
	/**
	 * 获取：担保机构执照号图片
	 */
	public String getGuaratorLicenseImg() {
		return guaratorLicenseImg;
	}
	/**
	 * 设置：公司注册资本
	 */
	public void setGuaratorCapital(String guaratorCapital) {
		this.guaratorCapital = guaratorCapital;
	}
	/**
	 * 获取：公司注册资本
	 */
	public String getGuaratorCapital() {
		return guaratorCapital;
	}
	/**
	 * 设置：邮编
	 */
	public void setGuaratorPostcode(String guaratorPostcode) {
		this.guaratorPostcode = guaratorPostcode;
	}
	/**
	 * 获取：邮编
	 */
	public String getGuaratorPostcode() {
		return guaratorPostcode;
	}
	/**
	 * 设置：公司性质
	 */
	public void setGuaratorSort(Integer guaratorSort) {
		this.guaratorSort = guaratorSort;
	}
	/**
	 * 获取：公司性质
	 */
	public Integer getGuaratorSort() {
		return guaratorSort;
	}
	/**
	 * 设置：纳税人识别号
	 */
	public void setGuaratorTaxpayerNo(String guaratorTaxpayerNo) {
		this.guaratorTaxpayerNo = guaratorTaxpayerNo;
	}
	/**
	 * 获取：纳税人识别号
	 */
	public String getGuaratorTaxpayerNo() {
		return guaratorTaxpayerNo;
	}
	/**
	 * 设置：注册证号
	 */
	public void setGuaratorRegNumber(String guaratorRegNumber) {
		this.guaratorRegNumber = guaratorRegNumber;
	}
	/**
	 * 获取：注册证号
	 */
	public String getGuaratorRegNumber() {
		return guaratorRegNumber;
	}
	/**
	 * 设置：法人电话
	 */
	public void setGuaratorLegalPhone(String guaratorLegalPhone) {
		this.guaratorLegalPhone = guaratorLegalPhone;
	}
	/**
	 * 获取：法人电话
	 */
	public String getGuaratorLegalPhone() {
		return guaratorLegalPhone;
	}
	/**
	 * 设置：传真
	 */
	public void setGuaratorFaxes(String guaratorFaxes) {
		this.guaratorFaxes = guaratorFaxes;
	}
	/**
	 * 获取：传真
	 */
	public String getGuaratorFaxes() {
		return guaratorFaxes;
	}
	/**
	 * 设置：开户行
	 */
	public void setGuaratorBankAccount(String guaratorBankAccount) {
		this.guaratorBankAccount = guaratorBankAccount;
	}
	/**
	 * 获取：开户行
	 */
	public String getGuaratorBankAccount() {
		return guaratorBankAccount;
	}
	/**
	 * 设置：银行账号
	 */
	public void setGuaratorBankNumber(String guaratorBankNumber) {
		this.guaratorBankNumber = guaratorBankNumber;
	}
	/**
	 * 获取：银行账号
	 */
	public String getGuaratorBankNumber() {
		return guaratorBankNumber;
	}
	/**
	 * 设置：公司地址
	 */
	public void setGuaratorAddress(String guaratorAddress) {
		this.guaratorAddress = guaratorAddress;
	}
	/**
	 * 获取：公司地址
	 */
	public String getGuaratorAddress() {
		return guaratorAddress;
	}
	/**
	 * 设置：行业
	 */
	public void setGuaratorIndustry(Integer guaratorIndustry) {
		this.guaratorIndustry = guaratorIndustry;
	}
	/**
	 * 获取：行业
	 */
	public Integer getGuaratorIndustry() {
		return guaratorIndustry;
	}
	/**
	 * 设置：法人代表
	 */
	public void setGuaratorLegalPepre(String guaratorLegalPepre) {
		this.guaratorLegalPepre = guaratorLegalPepre;
	}
	/**
	 * 获取：法人代表
	 */
	public String getGuaratorLegalPepre() {
		return guaratorLegalPepre;
	}
	/**
	 * 设置：建立时间
	 */
	public void setGuaratorEstabDate(String guaratorEstabDate) {
		this.guaratorEstabDate = guaratorEstabDate;
	}
	/**
	 * 获取：建立时间
	 */
	public String getGuaratorEstabDate() {
		return guaratorEstabDate;
	}
	/**
	 * 设置：营业期限
	 */
	public void setGuaratorOpenatingPeriod(String guaratorOpenatingPeriod) {
		this.guaratorOpenatingPeriod = guaratorOpenatingPeriod;
	}
	/**
	 * 获取：营业期限
	 */
	public String getGuaratorOpenatingPeriod() {
		return guaratorOpenatingPeriod;
	}
	/**
	 * 设置：注册地址
	 */
	public void setGuaratorRegAdress(String guaratorRegAdress) {
		this.guaratorRegAdress = guaratorRegAdress;
	}
	/**
	 * 获取：注册地址
	 */
	public String getGuaratorRegAdress() {
		return guaratorRegAdress;
	}
	/**
	 * 设置：公司类型
	 */
	public void setGuaratorCompanyType(String guaratorCompanyType) {
		this.guaratorCompanyType = guaratorCompanyType;
	}
	/**
	 * 获取：公司类型
	 */
	public String getGuaratorCompanyType() {
		return guaratorCompanyType;
	}
	/**
	 * 设置：担保机构状态
	 */
	public void setGuaratorStatus(Integer guaratorStatus) {
		this.guaratorStatus = guaratorStatus;
	}
	/**
	 * 获取：担保机构状态
	 */
	public Integer getGuaratorStatus() {
		return guaratorStatus;
	}
	/**
	 * 设置：备注
	 */
	public void setGuaratorRemarks(String guaratorRemarks) {
		this.guaratorRemarks = guaratorRemarks;
	}
	/**
	 * 获取：备注
	 */
	public String getGuaratorRemarks() {
		return guaratorRemarks;
	}
	/**
	 * 设置：担保机构创建时间
	 */
	public void setGuaratorDate(String guaratorDate) {
		this.guaratorDate = guaratorDate;
	}
	/**
	 * 获取：担保机构创建时间
	 */
	public String getGuaratorDate() {
		return guaratorDate;
	}
	/**
	 * 设置：担保机构监管人
	 */
	public void setGuaratorUserId(Long guaratorUserId) {
		this.guaratorUserId = guaratorUserId;
	}
	/**
	 * 获取：担保机构监管人
	 */
	public Long getGuaratorUserId() {
		return guaratorUserId;
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
