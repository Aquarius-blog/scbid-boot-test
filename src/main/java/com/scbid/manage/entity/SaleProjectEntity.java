package com.scbid.manage.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * @author wangyun
 * @date 2018-05-18 11:33:03
 */
@TableName("t_sale_project")
public class SaleProjectEntity implements Serializable {
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
	private Date createTime;
	/**
	 * 操作时间 
	 */
	private Date operateTime;
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
	 * 采购项目编号
	 */
	private String code;
	/**
	 * 项目ID
	 */
	private String projectId;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 标书售卖开始时间
	 */
	private Date bidBookStartTime;
	/**
	 * 标书售卖结束时间
	 */
	private Date bidBookEndTime;
	/**
	 * 售卖方式[BidBookStyleEnum]
	 */
	private Integer bidBookStyle;
	/**
	 * 标书售价
	 */
	private Integer bidBookPrice;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 项目性质
	 */
	private Integer projectNature;
	/**
	 * 采购方式
	 */
	private Integer purchaseWay;
	/**
	 * 售卖方式[ApprovalSaleEnum]
	 */
	private String saleStyle;
	/**
	 * 开标时间
	 */
	private Date openBidTime;
	/**
	 * 保证金收取截止时间
	 */
	private Date bzjEndTime;
	/**
	 * 老OA ID
	 */
	private String infoId;
	/**
	 * 
	 */
	private String purchaseFileUrl;
	/**
	 * 
	 */
	private String attachmentUrl;
	/**
	 * 是否允许邮寄
	 */
	private Integer isAllowedToMail;

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
	 * 设置：采购项目编号
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：采购项目编号
	 */
	public String getCode() {
		return code;
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
	 * 设置：标书售卖开始时间
	 */
	public void setBidBookStartTime(Date bidBookStartTime) {
		this.bidBookStartTime = bidBookStartTime;
	}
	/**
	 * 获取：标书售卖开始时间
	 */
	public Date getBidBookStartTime() {
		return bidBookStartTime;
	}
	/**
	 * 设置：标书售卖结束时间
	 */
	public void setBidBookEndTime(Date bidBookEndTime) {
		this.bidBookEndTime = bidBookEndTime;
	}
	/**
	 * 获取：标书售卖结束时间
	 */
	public Date getBidBookEndTime() {
		return bidBookEndTime;
	}
	/**
	 * 设置：售卖方式[BidBookStyleEnum]
	 */
	public void setBidBookStyle(Integer bidBookStyle) {
		this.bidBookStyle = bidBookStyle;
	}
	/**
	 * 获取：售卖方式[BidBookStyleEnum]
	 */
	public Integer getBidBookStyle() {
		return bidBookStyle;
	}
	/**
	 * 设置：标书售价
	 */
	public void setBidBookPrice(Integer bidBookPrice) {
		this.bidBookPrice = bidBookPrice;
	}
	/**
	 * 获取：标书售价
	 */
	public Integer getBidBookPrice() {
		return bidBookPrice;
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
	 * 设置：项目性质
	 */
	public void setProjectNature(Integer projectNature) {
		this.projectNature = projectNature;
	}
	/**
	 * 获取：项目性质
	 */
	public Integer getProjectNature() {
		return projectNature;
	}
	/**
	 * 设置：采购方式
	 */
	public void setPurchaseWay(Integer purchaseWay) {
		this.purchaseWay = purchaseWay;
	}
	/**
	 * 获取：采购方式
	 */
	public Integer getPurchaseWay() {
		return purchaseWay;
	}
	/**
	 * 设置：售卖方式[ApprovalSaleEnum]
	 */
	public void setSaleStyle(String saleStyle) {
		this.saleStyle = saleStyle;
	}
	/**
	 * 获取：售卖方式[ApprovalSaleEnum]
	 */
	public String getSaleStyle() {
		return saleStyle;
	}
	/**
	 * 设置：开标时间
	 */
	public void setOpenBidTime(Date openBidTime) {
		this.openBidTime = openBidTime;
	}
	/**
	 * 获取：开标时间
	 */
	public Date getOpenBidTime() {
		return openBidTime;
	}
	/**
	 * 设置：保证金收取截止时间
	 */
	public void setBzjEndTime(Date bzjEndTime) {
		this.bzjEndTime = bzjEndTime;
	}
	/**
	 * 获取：保证金收取截止时间
	 */
	public Date getBzjEndTime() {
		return bzjEndTime;
	}
	/**
	 * 设置：老OA ID
	 */
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	/**
	 * 获取：老OA ID
	 */
	public String getInfoId() {
		return infoId;
	}
	/**
	 * 设置：
	 */
	public void setPurchaseFileUrl(String purchaseFileUrl) {
		this.purchaseFileUrl = purchaseFileUrl;
	}
	/**
	 * 获取：
	 */
	public String getPurchaseFileUrl() {
		return purchaseFileUrl;
	}
	/**
	 * 设置：
	 */
	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}
	/**
	 * 获取：
	 */
	public String getAttachmentUrl() {
		return attachmentUrl;
	}
	/**
	 * 设置：是否允许邮寄
	 */
	public void setIsAllowedToMail(Integer isAllowedToMail) {
		this.isAllowedToMail = isAllowedToMail;
	}
	/**
	 * 获取：是否允许邮寄
	 */
	public Integer getIsAllowedToMail() {
		return isAllowedToMail;
	}
}
