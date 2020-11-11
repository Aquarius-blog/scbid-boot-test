package com.scbid.manage.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色
 * @author wangyun
 * @date 2018-12-18 14:51:27
 */
@TableName("t_common_attachment")
public class CommonAttachmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private String listId;
	/**
	 * 参数名称
	 */
	private String param;
	/**
	 * 业务ID
	 */
	private String businessId;
	/**
	 * 文件名称
	 */
	private String attachmentName;
	/**
	 * 后缀名
	 */
	private String suffixName;
	/**
	 * URL地址
	 */
	private String fieldId;
	/**
	 * 
	 */
	private Integer isDelete;
	/**
	 * 
	 */
	private String operator;
	/**
	 * 
	 */
	private String operateTime;
	/**
	 * 
	 */
	private String creater;
	/**
	 * 
	 */
	private String createTime;
	/**
	 * 
	 */
	private String domainAuth;
	/**
	 * 创建人ID
	 */
	private String creatorId;
	/**
	 * 模板ID
	 */
	private String templateId;
	/**
	 * 线上线下制作类型
	 */
	private Integer makeType;
	/**
	 * 多个文件标识符
	 */
	private String moreFile;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 设置：主键id
	 */
	public void setListId(String listId) {
		this.listId = listId;
	}
	/**
	 * 获取：主键id
	 */
	public String getListId() {
		return listId;
	}
	/**
	 * 设置：参数名称
	 */
	public void setParam(String param) {
		this.param = param;
	}
	/**
	 * 获取：参数名称
	 */
	public String getParam() {
		return param;
	}
	/**
	 * 设置：业务ID
	 */
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	/**
	 * 获取：业务ID
	 */
	public String getBusinessId() {
		return businessId;
	}
	/**
	 * 设置：文件名称
	 */
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	/**
	 * 获取：文件名称
	 */
	public String getAttachmentName() {
		return attachmentName;
	}
	/**
	 * 设置：后缀名
	 */
	public void setSuffixName(String suffixName) {
		this.suffixName = suffixName;
	}
	/**
	 * 获取：后缀名
	 */
	public String getSuffixName() {
		return suffixName;
	}
	/**
	 * 设置：URL地址
	 */
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	/**
	 * 获取：URL地址
	 */
	public String getFieldId() {
		return fieldId;
	}
	/**
	 * 设置：
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
	/**
	 * 设置：
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**
	 * 获取：
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * 设置：
	 */
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
	/**
	 * 获取：
	 */
	public String getOperateTime() {
		return operateTime;
	}
	/**
	 * 设置：
	 */
	public void setCreater(String creater) {
		this.creater = creater;
	}
	/**
	 * 获取：
	 */
	public String getCreater() {
		return creater;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public String getCreateTime() {
		return createTime;
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
	/**
	 * 设置：模板ID
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	/**
	 * 获取：模板ID
	 */
	public String getTemplateId() {
		return templateId;
	}
	/**
	 * 设置：线上线下制作类型
	 */
	public void setMakeType(Integer makeType) {
		this.makeType = makeType;
	}
	/**
	 * 获取：线上线下制作类型
	 */
	public Integer getMakeType() {
		return makeType;
	}
	/**
	 * 设置：多个文件标识符
	 */
	public void setMoreFile(String moreFile) {
		this.moreFile = moreFile;
	}
	/**
	 * 获取：多个文件标识符
	 */
	public String getMoreFile() {
		return moreFile;
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
}
