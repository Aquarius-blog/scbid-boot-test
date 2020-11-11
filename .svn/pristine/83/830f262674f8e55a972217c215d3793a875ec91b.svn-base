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
@TableName("t_bond_project")
public class BondProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long projectId;
	/**
	 * 分包 主键ID
	 */
	private String packageId;
	/**
	 * 全局唯一项目主键UUID 与OA系统对接
	 */
	private String projectUuid;
	/**
	 * 供应商uuid 与oa 系统对接
	 */
	private String supplierUuid;
	/**
	 * 供应商名称
	 */
	@TableField(exist=false)
	private String supplierName;
	/**
	 * 代理机构主键ID
	 */
	private Long agencyId;
	/**
	 * 代理机构名称
	 */
	@TableField(exist=false)
	private String agencyName;
	/**
	 * 担保机构名称
	 */
	@TableField(exist=false)
	private String guaratorName;
	

	/**
	 * 项目编码
	 */
	private String projectCode;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 项目类型
	 */
	private Integer projectType;
	/**
	 * 项目金额
	 */
	private BigDecimal projectMoney;
	/**
	 * 项目状态
	 */
	private Integer projectStatus;
	/**
	 * 项目创建时间
	 */
	private String projectDate;
	/**
	 * 项目监管人
	 */
	private Integer projectUserId;
	/**
	 * 项目监管人
	 */
	@TableField(exist=false)
	private String projectUserName;
	
	/**
	 * 最后修改时间
	 */
	private String updateDate;
	/**
	 * 最后修改人
	 */
	private String updateUesrName;

	/**
	 * 设置：
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * 设置：分包 主键ID
	 */
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	/**
	 * 获取：分包 主键ID
	 */
	public String getPackageId() {
		return packageId;
	}
	/**
	 * 设置：全局唯一项目主键UUID 与OA系统对接
	 */
	public void setProjectUuid(String projectUuid) {
		this.projectUuid = projectUuid;
	}
	/**
	 * 获取：全局唯一项目主键UUID 与OA系统对接
	 */
	public String getProjectUuid() {
		return projectUuid;
	}
	/**
	 * 设置：供应商uuid 与oa 系统对接
	 */
	public void setSupplierUuid(String supplierUuid) {
		this.supplierUuid = supplierUuid;
	}
	
	/**
	 * 获取：供应商uuid 与oa 系统对接
	 */
	public String getSupplierUuid() {
		return supplierUuid;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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
	
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	/**
	 * 设置：项目编码
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	/**
	 * 获取：项目编码
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
	 * 设置：项目类型
	 */
	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}
	/**
	 * 获取：项目类型
	 */
	public Integer getProjectType() {
		return projectType;
	}
	/**
	 * 设置：项目金额
	 */
	public void setProjectMoney(BigDecimal projectMoney) {
		this.projectMoney = projectMoney;
	}
	
	public String getGuaratorName() {
		return guaratorName;
	}
	public void setGuaratorName(String guaratorName) {
		this.guaratorName = guaratorName;
	}
	/**
	 * 获取：项目金额
	 */
	public BigDecimal getProjectMoney() {
		return projectMoney;
	}
	/**
	 * 设置：项目状态
	 */
	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}
	/**
	 * 获取：项目状态
	 */
	public Integer getProjectStatus() {
		return projectStatus;
	}
	/**
	 * 设置：项目创建时间
	 */
	public void setProjectDate(String projectDate) {
		this.projectDate = projectDate;
	}
	/**
	 * 获取：项目创建时间
	 */
	public String getProjectDate() {
		return projectDate;
	}
	/**
	 * 设置：项目监管人
	 */
	public void setProjectUserId(Integer projectUserId) {
		this.projectUserId = projectUserId;
	}
	/**
	 * 获取：项目监管人
	 */
	public Integer getProjectUserId() {
		return projectUserId;
	}
	
	public String getProjectUserName() {
		return projectUserName;
	}
	public void setProjectUserName(String projectUserName) {
		this.projectUserName = projectUserName;
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
}
