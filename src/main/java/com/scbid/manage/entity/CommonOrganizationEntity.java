package com.scbid.manage.entity;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * @author wangyun
 * @date 2018-05-24 12:11:03
 */
@TableName("t_common_organization")
public class CommonOrganizationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String listId;
	/**
	 * 是否被删除1 为否，2为是
	 */
	private Long isDelete;
	/**
	 * 操作人id
	 */
	private String operator;
	/**
	 * 操作时间
	 */
	private Date operateTime;
	/**
	 * 创建人
	 */
	private String creater;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 公司ID
	 */
	private String companyId;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 上级id
	 */
	private String upId;
	/**
	 * 
	 */
	private String domainAuth;
	/**
	 * 创建人ID
	 */
	private String creatorId;

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
	 * 设置：是否被删除1 为否，2为是
	 */
	public void setIsDelete(Long isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：是否被删除1 为否，2为是
	 */
	public Long getIsDelete() {
		return isDelete;
	}
	/**
	 * 设置：操作人id
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**
	 * 获取：操作人id
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * 设置：操作时间
	 */
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	/**
	 * 获取：操作时间
	 */
	public Date getOperateTime() {
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
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：公司ID
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	/**
	 * 获取：公司ID
	 */
	public String getCompanyId() {
		return companyId;
	}
	/**
	 * 设置：部门名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：部门名称
	 */
	public String getName() {
		return name;
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
	 * 设置：上级id
	 */
	public void setUpId(String upId) {
		this.upId = upId;
	}
	/**
	 * 获取：上级id
	 */
	public String getUpId() {
		return upId;
	}
	/**
	 * 设置：
	 */
	public void setDomainAuth(String domainAuth) {
		this.domainAuth = domainAuth;
	}
	/**
	 * 获取：
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
}
