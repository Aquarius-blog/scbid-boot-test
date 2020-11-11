package com.scbid.manage.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * @author wangyun
 * @date 2018-05-18 15:14:41
 */
@TableName("t_tender_implement_project")
public class TenderImplemenProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String listId;
	/**
	 * 开标类型
	 */
	private Integer bidType;
	/**
	 * 标前资料是否下载
	 */
	private Integer dataType;
	/**
	 * 上下浮比例
	 */
	private Integer proportion;
	/**
	 * 上浮或者下浮
	 */
	private Integer isUp;
	/**
	 * 风险备注
	 */
	private String riskRemark;
	/**
	 * 归档状态
	 */
	private Integer archivesStatus;
	/**
	 *  项目类型
	 */
	private Integer projectType;
	/**
	 * 项目性质
	 */
	private Integer projectNature;
	/**
	 * 客户联系人ID
	 */
	private String clientLinkmanId;
	/**
	 * 收费标准ID
	 */
	private String chargeId;
	/**
	 * 付费类型
	 */
	private Integer payType;
	/**
	 * 客户id
	 */
	private String clientId;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 项目负责人ID
	 */
	private String responsibleId;
	/**
	 * 变更公告步骤ID
	 */
	private String changeStepId;
	/**
	 * 当前阶段ID
	 */
	private String stepId;
	/**
	 * 财政批复号，项目备案号
	 */
	private String projectRecord;
	/**
	 * 其他要求
	 */
	private String otherRequire;
	/**
	 * 项目要求及技术
	 */
	private String projectRequire;
	/**
	 * 特殊要求说明
	 */
	private String specialRemark;
	/**
	 * 评分办法类型
	 */
	private Integer judgeType;
	/**
	 * 资金来源类型
	 */
	private Integer fundsType;
	/**
	 * 区域ID
	 */
	private String areaId;
	/**
	 * 类目ID
	 */
	private String vocationId;
	/**
	 * 采购方式
	 */
	private Integer buyWay;
	/**
	 * 采购类别
	 */
	private Integer buyType;
	/**
	 * 风险预警
	 */
	private Integer isRisk;
	/**
	 * 合同编号
	 */
	private String contractNumber;
	/**
	 * 立项时间
	 */
	private String produceTime;
	/**
	 * 项目金额
	 */
	private Long projectMoney;
	/**
	 * 开标地址
	 */
	private String bidAddress;
	/**
	 * 开标时间
	 */
	private String bidTime;
	/**
	 * 投标地址
	 */
	private String tenderAddress;
	/**
	 * 投标时间
	 */
	private String tenderTime;
	/**
	 * 标书发售地址
	 */
	private String tenderBookSaleAddress;
	/**
	 * 标书发售开始时间
	 */
	private String tenderBookSaleStartTime;
	/**
	 * 标书发售截止时间
	 */
	private String tenderBookSaleEndTime;
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
	 * 采购项目编号
	 */
	private String projectCode;
	/**
	 * 立项表ID
	 */
	private String approvalId;
	/**
	 * 开标类型
	 */
	private Integer bidOpeningType;
	/**
	 * 保证金收取截止时间
	 */
	private Date collateralEndTime;
	/**
	 * 业主时候收回投标文件
	 */
	private Integer backType;
	/**
	 * 论证与否
	 */
	private Integer isEx;
	/**
	 * 业主确认函上传时间
	 */
	private String uploadConfirmTime;
	/**
	 * 通知书发放状态
	 */
	private Integer noticeStatus;
	/**
	 * 中标通知书发布时间
	 */
	private String bidNoticeAnnounceTime;
	/**
	 * 标书售卖时间
	 */
	private String sellingTime;
	/**
	 * 中标通知书确认时间
	 */
	private String bidNoticeSureTime;
	/**
	 * 定额每包的服务费金额
	 */
	private Long quotaMoney;
	/**
	 * 项目等级ID
	 */
	private String projectLevelId;
	/**
	 * 创建人ID
	 */
	private String creatorId;
	/**
	 * 协助人
	 */
	private String helpPeopleIds;
	/**
	 * 再次立项次数
	 */
	private Integer againNum;
	/**
	 * 再次立项的原始数据ID
	 */
	private String againApprovalParentId;
	/**
	 * 是否暂停项目 BLWhetherEnum
	 */
	private Integer stopProject;
	/**
	 * 收费方式
	 */
	private Integer chargeType;
	/**
	 * 标书售卖方式
	 */
	private Integer saleType;
	/**
	 * 结果公告时间 
	 */
	private String resultAnnounceTime;
	/**
	 * 招标次数
	 */
	private Integer bidNum;
	/**
	 * 采购文件业主确认函文件ID（t_project_file）
	 */
	private String procurementConfirmFileId;
	/**
	 * 
	 */
	private String procurementDocumentConfirmUrl;
	/**
	 * 专家抽取类型
	 */
	private Integer expertType;
	/**
	 * 招标公告发布时间
	 */
	private String biddingAnnouncementTime;
	/**
	 * 结果预公告发布时间
	 */
	private String resultsPreTime;
	/**
	 * 投标文件递交截止时间
	 */
	private String bidFileCutOffTime;
	/**
	 * 比例
	 */
	private Double scale;
	/**
	 * 比例
	 */
	private String other;
	/**
	 * 中标通知书审核时间
	 */
	private String bidNoticeCheckTime;
	/**
	 * 有无委托协议
	 */
	private Integer entrustStatus;
	/**
	 * 有无财政批复
	 */
	private Integer financeStatus;
	/**
	 * 有无进口批复
	 */
	private Integer importedStatus;
	/**
	 * 补齐时间
	 */
	private String completeTime;
	/**
	 * 业绩归属人ID
	 */
	private String achievementId;
	/**
	 * 用款计划号
	 */
	private String palnNumber;
	/**
	 * 有无自筹资金证明
	 */
	private Integer fundStatus;
	/**
	 * 最后补齐时间
	 */
	private String lastTime;
	/**
	 * 标书价格[人民币]
	 */
	private Long bookPriceCny;
	/**
	 * 标书价格【美元】
	 */
	private Long bookPriceUsd;
	/**
	 * 标书费用收获方式【BLWETHERENUM】,是表示按包、否表示按项目
	 */
	private Integer bookCostGetWay;
	/**
	 * 招标文件制作方式【ImplementMakeSaleEnum】
	 */
	private Integer makeStatus;
	/**
	 * 公告变更类型[文件变更或者项目信息变更]
	 */
	private String noticeChangeType;
	/**
	 * 
	 */
	private String owner;
	/**
	 * 行政区域
	 */
	private String adminArea;
	/**
	 * 财务项目编号
	 */
	private String financeCode;
	/**
	 * 定标日期
	 */
	private String calibrationTime;
	/**
	 * 是否上传采购文件业主确认函 BLWhetherEnum
	 */
	private Integer isUploadFileConfirm;
	/**
	 * 未上传采购文件业主确认函情况说明
	 */
	private String statusStatement;
	/**
	 * 
	 */
	private Integer notifySupplier;
	/**
	 * 变更公告内容
	 */
	private String noticeChangeContent;
	/**
	 * 变更的公告类型
	 */
	private Integer noticeType;
	/**
	 * 是否生成标前资料 BLWhetherEnum
	 */
	private Integer preBidData;
	/**
	 * 资格性审查人员类型
	 */
	private Integer qualificationUserType;
	/**
	 * 标识是否PPP项目
	 */
	private Integer isPppProject;
	/**
	 * 标识采购文件是否已审核
	 */
	private Integer isCheckBuyFile;
	/**
	 * 是否转交技服审核【只用于采购文件审核】
	 */
	private Integer isTransferTechnicalCheck;
	/**
	 * 资格预审公告链接
	 */
	private String qualificationPreNoticeLink;
	/**
	 * 是否采购本国货物和服务
	 */
	private Integer domesticProcurement;
	/**
	 * 公示链接
	 */
	private String publicityNoticeLink;
	/**
	 * 单一来源采购方式的原因及说明
	 */
	private String reasonsExplanations;
	/**
	 * 采购品目
	 */
	private String purchaseHeading;
	/**
	 * 行业划分
	 */
	private String industryDivision;
	/**
	 * 通知专家到场时间
	 */
	private String noticeExpertTime;
	/**
	 * 项目所属市、州
	 */
	private String cityId;
	/**
	 * 项目所属县、区
	 */
	private String countyId;
	/**
	 * 是否协议或定点采购
	 */
	private Integer isAgreementFixed;
	/**
	 * 公示截止日期
	 */
	private String publicityNoticeEndTime;
	/**
	 * 报价次数
	 */
	private Integer offerNum;
	/**
	 * 是否允许联合体
	 */
	private Integer consortium;
	/**
	 * 投标文件递交开始止时间 
	 */
	private String bidFileCutOnTime;
	/**
	 * 项目经理ID
	 */
	private String projectManager;
	/**
	 * 监督办公室
	 */
	private String superviseOfficeRoom;
	/**
	 * 监督办公室电话
	 */
	private String supervisePhone;
	/**
	 * 监督办公室地址
	 */
	private String superviseAddress;
	/**
	 * 监督办公室邮编
	 */
	private String supervisePostcode;
	/**
	 * 监督办公室ID
	 */
	private String superviseOfficeRoomId;
	/**
	 * 主开发人员ID
	 */
	private String mainDevelopUserid;
	/**
	 * 主开发人员比例
	 */
	private Double mainBrokerage;
	/**
	 * 当前办理人员ID
	 */
	private String currentUserId;
	/**
	 * 选择其他时的备注
	 */
	private String payTypeRemark;
	/**
	 * 是否全部退完
	 */
	private Integer isAllReturn;

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
	 * 设置：开标类型
	 */
	public void setBidType(Integer bidType) {
		this.bidType = bidType;
	}
	/**
	 * 获取：开标类型
	 */
	public Integer getBidType() {
		return bidType;
	}
	/**
	 * 设置：标前资料是否下载
	 */
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}
	/**
	 * 获取：标前资料是否下载
	 */
	public Integer getDataType() {
		return dataType;
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
	 * 设置：风险备注
	 */
	public void setRiskRemark(String riskRemark) {
		this.riskRemark = riskRemark;
	}
	/**
	 * 获取：风险备注
	 */
	public String getRiskRemark() {
		return riskRemark;
	}
	/**
	 * 设置：归档状态
	 */
	public void setArchivesStatus(Integer archivesStatus) {
		this.archivesStatus = archivesStatus;
	}
	/**
	 * 获取：归档状态
	 */
	public Integer getArchivesStatus() {
		return archivesStatus;
	}
	/**
	 * 设置： 项目类型
	 */
	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}
	/**
	 * 获取： 项目类型
	 */
	public Integer getProjectType() {
		return projectType;
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
	 * 设置：客户联系人ID
	 */
	public void setClientLinkmanId(String clientLinkmanId) {
		this.clientLinkmanId = clientLinkmanId;
	}
	/**
	 * 获取：客户联系人ID
	 */
	public String getClientLinkmanId() {
		return clientLinkmanId;
	}
	/**
	 * 设置：收费标准ID
	 */
	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}
	/**
	 * 获取：收费标准ID
	 */
	public String getChargeId() {
		return chargeId;
	}
	/**
	 * 设置：付费类型
	 */
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	/**
	 * 获取：付费类型
	 */
	public Integer getPayType() {
		return payType;
	}
	/**
	 * 设置：客户id
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * 获取：客户id
	 */
	public String getClientId() {
		return clientId;
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
	 * 设置：项目负责人ID
	 */
	public void setResponsibleId(String responsibleId) {
		this.responsibleId = responsibleId;
	}
	/**
	 * 获取：项目负责人ID
	 */
	public String getResponsibleId() {
		return responsibleId;
	}
	/**
	 * 设置：变更公告步骤ID
	 */
	public void setChangeStepId(String changeStepId) {
		this.changeStepId = changeStepId;
	}
	/**
	 * 获取：变更公告步骤ID
	 */
	public String getChangeStepId() {
		return changeStepId;
	}
	/**
	 * 设置：当前阶段ID
	 */
	public void setStepId(String stepId) {
		this.stepId = stepId;
	}
	/**
	 * 获取：当前阶段ID
	 */
	public String getStepId() {
		return stepId;
	}
	/**
	 * 设置：财政批复号，项目备案号
	 */
	public void setProjectRecord(String projectRecord) {
		this.projectRecord = projectRecord;
	}
	/**
	 * 获取：财政批复号，项目备案号
	 */
	public String getProjectRecord() {
		return projectRecord;
	}
	/**
	 * 设置：其他要求
	 */
	public void setOtherRequire(String otherRequire) {
		this.otherRequire = otherRequire;
	}
	/**
	 * 获取：其他要求
	 */
	public String getOtherRequire() {
		return otherRequire;
	}
	/**
	 * 设置：项目要求及技术
	 */
	public void setProjectRequire(String projectRequire) {
		this.projectRequire = projectRequire;
	}
	/**
	 * 获取：项目要求及技术
	 */
	public String getProjectRequire() {
		return projectRequire;
	}
	/**
	 * 设置：特殊要求说明
	 */
	public void setSpecialRemark(String specialRemark) {
		this.specialRemark = specialRemark;
	}
	/**
	 * 获取：特殊要求说明
	 */
	public String getSpecialRemark() {
		return specialRemark;
	}
	/**
	 * 设置：评分办法类型
	 */
	public void setJudgeType(Integer judgeType) {
		this.judgeType = judgeType;
	}
	/**
	 * 获取：评分办法类型
	 */
	public Integer getJudgeType() {
		return judgeType;
	}
	/**
	 * 设置：资金来源类型
	 */
	public void setFundsType(Integer fundsType) {
		this.fundsType = fundsType;
	}
	/**
	 * 获取：资金来源类型
	 */
	public Integer getFundsType() {
		return fundsType;
	}
	/**
	 * 设置：区域ID
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：区域ID
	 */
	public String getAreaId() {
		return areaId;
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
	 * 设置：采购方式
	 */
	public void setBuyWay(Integer buyWay) {
		this.buyWay = buyWay;
	}
	/**
	 * 获取：采购方式
	 */
	public Integer getBuyWay() {
		return buyWay;
	}
	/**
	 * 设置：采购类别
	 */
	public void setBuyType(Integer buyType) {
		this.buyType = buyType;
	}
	/**
	 * 获取：采购类别
	 */
	public Integer getBuyType() {
		return buyType;
	}
	/**
	 * 设置：风险预警
	 */
	public void setIsRisk(Integer isRisk) {
		this.isRisk = isRisk;
	}
	/**
	 * 获取：风险预警
	 */
	public Integer getIsRisk() {
		return isRisk;
	}
	/**
	 * 设置：合同编号
	 */
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	/**
	 * 获取：合同编号
	 */
	public String getContractNumber() {
		return contractNumber;
	}
	/**
	 * 设置：立项时间
	 */
	public void setProduceTime(String produceTime) {
		this.produceTime = produceTime;
	}
	/**
	 * 获取：立项时间
	 */
	public String getProduceTime() {
		return produceTime;
	}
	/**
	 * 设置：项目金额
	 */
	public void setProjectMoney(Long projectMoney) {
		this.projectMoney = projectMoney;
	}
	/**
	 * 获取：项目金额
	 */
	public Long getProjectMoney() {
		return projectMoney;
	}
	/**
	 * 设置：开标地址
	 */
	public void setBidAddress(String bidAddress) {
		this.bidAddress = bidAddress;
	}
	/**
	 * 获取：开标地址
	 */
	public String getBidAddress() {
		return bidAddress;
	}
	/**
	 * 设置：开标时间
	 */
	public void setBidTime(String bidTime) {
		this.bidTime = bidTime;
	}
	/**
	 * 获取：开标时间
	 */
	public String getBidTime() {
		return bidTime;
	}
	/**
	 * 设置：投标地址
	 */
	public void setTenderAddress(String tenderAddress) {
		this.tenderAddress = tenderAddress;
	}
	/**
	 * 获取：投标地址
	 */
	public String getTenderAddress() {
		return tenderAddress;
	}
	/**
	 * 设置：投标时间
	 */
	public void setTenderTime(String tenderTime) {
		this.tenderTime = tenderTime;
	}
	/**
	 * 获取：投标时间
	 */
	public String getTenderTime() {
		return tenderTime;
	}
	/**
	 * 设置：标书发售地址
	 */
	public void setTenderBookSaleAddress(String tenderBookSaleAddress) {
		this.tenderBookSaleAddress = tenderBookSaleAddress;
	}
	/**
	 * 获取：标书发售地址
	 */
	public String getTenderBookSaleAddress() {
		return tenderBookSaleAddress;
	}
	/**
	 * 设置：标书发售开始时间
	 */
	public void setTenderBookSaleStartTime(String tenderBookSaleStartTime) {
		this.tenderBookSaleStartTime = tenderBookSaleStartTime;
	}
	/**
	 * 获取：标书发售开始时间
	 */
	public String getTenderBookSaleStartTime() {
		return tenderBookSaleStartTime;
	}
	/**
	 * 设置：标书发售截止时间
	 */
	public void setTenderBookSaleEndTime(String tenderBookSaleEndTime) {
		this.tenderBookSaleEndTime = tenderBookSaleEndTime;
	}
	/**
	 * 获取：标书发售截止时间
	 */
	public String getTenderBookSaleEndTime() {
		return tenderBookSaleEndTime;
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
	 * 设置：采购项目编号
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	/**
	 * 获取：采购项目编号
	 */
	public String getProjectCode() {
		return projectCode;
	}
	/**
	 * 设置：立项表ID
	 */
	public void setApprovalId(String approvalId) {
		this.approvalId = approvalId;
	}
	/**
	 * 获取：立项表ID
	 */
	public String getApprovalId() {
		return approvalId;
	}
	/**
	 * 设置：开标类型
	 */
	public void setBidOpeningType(Integer bidOpeningType) {
		this.bidOpeningType = bidOpeningType;
	}
	/**
	 * 获取：开标类型
	 */
	public Integer getBidOpeningType() {
		return bidOpeningType;
	}
	/**
	 * 设置：保证金收取截止时间
	 */
	public void setCollateralEndTime(Date collateralEndTime) {
		this.collateralEndTime = collateralEndTime;
	}
	/**
	 * 获取：保证金收取截止时间
	 */
	public Date getCollateralEndTime() {
		return collateralEndTime;
	}
	/**
	 * 设置：业主时候收回投标文件
	 */
	public void setBackType(Integer backType) {
		this.backType = backType;
	}
	/**
	 * 获取：业主时候收回投标文件
	 */
	public Integer getBackType() {
		return backType;
	}
	/**
	 * 设置：论证与否
	 */
	public void setIsEx(Integer isEx) {
		this.isEx = isEx;
	}
	/**
	 * 获取：论证与否
	 */
	public Integer getIsEx() {
		return isEx;
	}
	/**
	 * 设置：业主确认函上传时间
	 */
	public void setUploadConfirmTime(String uploadConfirmTime) {
		this.uploadConfirmTime = uploadConfirmTime;
	}
	/**
	 * 获取：业主确认函上传时间
	 */
	public String getUploadConfirmTime() {
		return uploadConfirmTime;
	}
	/**
	 * 设置：通知书发放状态
	 */
	public void setNoticeStatus(Integer noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
	/**
	 * 获取：通知书发放状态
	 */
	public Integer getNoticeStatus() {
		return noticeStatus;
	}
	/**
	 * 设置：中标通知书发布时间
	 */
	public void setBidNoticeAnnounceTime(String bidNoticeAnnounceTime) {
		this.bidNoticeAnnounceTime = bidNoticeAnnounceTime;
	}
	/**
	 * 获取：中标通知书发布时间
	 */
	public String getBidNoticeAnnounceTime() {
		return bidNoticeAnnounceTime;
	}
	/**
	 * 设置：标书售卖时间
	 */
	public void setSellingTime(String sellingTime) {
		this.sellingTime = sellingTime;
	}
	/**
	 * 获取：标书售卖时间
	 */
	public String getSellingTime() {
		return sellingTime;
	}
	/**
	 * 设置：中标通知书确认时间
	 */
	public void setBidNoticeSureTime(String bidNoticeSureTime) {
		this.bidNoticeSureTime = bidNoticeSureTime;
	}
	/**
	 * 获取：中标通知书确认时间
	 */
	public String getBidNoticeSureTime() {
		return bidNoticeSureTime;
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
	 * 设置：项目等级ID
	 */
	public void setProjectLevelId(String projectLevelId) {
		this.projectLevelId = projectLevelId;
	}
	/**
	 * 获取：项目等级ID
	 */
	public String getProjectLevelId() {
		return projectLevelId;
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
	 * 设置：协助人
	 */
	public void setHelpPeopleIds(String helpPeopleIds) {
		this.helpPeopleIds = helpPeopleIds;
	}
	/**
	 * 获取：协助人
	 */
	public String getHelpPeopleIds() {
		return helpPeopleIds;
	}
	/**
	 * 设置：再次立项次数
	 */
	public void setAgainNum(Integer againNum) {
		this.againNum = againNum;
	}
	/**
	 * 获取：再次立项次数
	 */
	public Integer getAgainNum() {
		return againNum;
	}
	/**
	 * 设置：再次立项的原始数据ID
	 */
	public void setAgainApprovalParentId(String againApprovalParentId) {
		this.againApprovalParentId = againApprovalParentId;
	}
	/**
	 * 获取：再次立项的原始数据ID
	 */
	public String getAgainApprovalParentId() {
		return againApprovalParentId;
	}
	/**
	 * 设置：是否暂停项目 BLWhetherEnum
	 */
	public void setStopProject(Integer stopProject) {
		this.stopProject = stopProject;
	}
	/**
	 * 获取：是否暂停项目 BLWhetherEnum
	 */
	public Integer getStopProject() {
		return stopProject;
	}
	/**
	 * 设置：收费方式
	 */
	public void setChargeType(Integer chargeType) {
		this.chargeType = chargeType;
	}
	/**
	 * 获取：收费方式
	 */
	public Integer getChargeType() {
		return chargeType;
	}
	/**
	 * 设置：标书售卖方式
	 */
	public void setSaleType(Integer saleType) {
		this.saleType = saleType;
	}
	/**
	 * 获取：标书售卖方式
	 */
	public Integer getSaleType() {
		return saleType;
	}
	/**
	 * 设置：结果公告时间 
	 */
	public void setResultAnnounceTime(String resultAnnounceTime) {
		this.resultAnnounceTime = resultAnnounceTime;
	}
	/**
	 * 获取：结果公告时间 
	 */
	public String getResultAnnounceTime() {
		return resultAnnounceTime;
	}
	/**
	 * 设置：招标次数
	 */
	public void setBidNum(Integer bidNum) {
		this.bidNum = bidNum;
	}
	/**
	 * 获取：招标次数
	 */
	public Integer getBidNum() {
		return bidNum;
	}
	/**
	 * 设置：采购文件业主确认函文件ID（t_project_file）
	 */
	public void setProcurementConfirmFileId(String procurementConfirmFileId) {
		this.procurementConfirmFileId = procurementConfirmFileId;
	}
	/**
	 * 获取：采购文件业主确认函文件ID（t_project_file）
	 */
	public String getProcurementConfirmFileId() {
		return procurementConfirmFileId;
	}
	/**
	 * 设置：
	 */
	public void setProcurementDocumentConfirmUrl(String procurementDocumentConfirmUrl) {
		this.procurementDocumentConfirmUrl = procurementDocumentConfirmUrl;
	}
	/**
	 * 获取：
	 */
	public String getProcurementDocumentConfirmUrl() {
		return procurementDocumentConfirmUrl;
	}
	/**
	 * 设置：专家抽取类型
	 */
	public void setExpertType(Integer expertType) {
		this.expertType = expertType;
	}
	/**
	 * 获取：专家抽取类型
	 */
	public Integer getExpertType() {
		return expertType;
	}
	/**
	 * 设置：招标公告发布时间
	 */
	public void setBiddingAnnouncementTime(String biddingAnnouncementTime) {
		this.biddingAnnouncementTime = biddingAnnouncementTime;
	}
	/**
	 * 获取：招标公告发布时间
	 */
	public String getBiddingAnnouncementTime() {
		return biddingAnnouncementTime;
	}
	/**
	 * 设置：结果预公告发布时间
	 */
	public void setResultsPreTime(String resultsPreTime) {
		this.resultsPreTime = resultsPreTime;
	}
	/**
	 * 获取：结果预公告发布时间
	 */
	public String getResultsPreTime() {
		return resultsPreTime;
	}
	/**
	 * 设置：投标文件递交截止时间
	 */
	public void setBidFileCutOffTime(String bidFileCutOffTime) {
		this.bidFileCutOffTime = bidFileCutOffTime;
	}
	/**
	 * 获取：投标文件递交截止时间
	 */
	public String getBidFileCutOffTime() {
		return bidFileCutOffTime;
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
	 * 设置：比例
	 */
	public void setOther(String other) {
		this.other = other;
	}
	/**
	 * 获取：比例
	 */
	public String getOther() {
		return other;
	}
	/**
	 * 设置：中标通知书审核时间
	 */
	public void setBidNoticeCheckTime(String bidNoticeCheckTime) {
		this.bidNoticeCheckTime = bidNoticeCheckTime;
	}
	/**
	 * 获取：中标通知书审核时间
	 */
	public String getBidNoticeCheckTime() {
		return bidNoticeCheckTime;
	}
	/**
	 * 设置：有无委托协议
	 */
	public void setEntrustStatus(Integer entrustStatus) {
		this.entrustStatus = entrustStatus;
	}
	/**
	 * 获取：有无委托协议
	 */
	public Integer getEntrustStatus() {
		return entrustStatus;
	}
	/**
	 * 设置：有无财政批复
	 */
	public void setFinanceStatus(Integer financeStatus) {
		this.financeStatus = financeStatus;
	}
	/**
	 * 获取：有无财政批复
	 */
	public Integer getFinanceStatus() {
		return financeStatus;
	}
	/**
	 * 设置：有无进口批复
	 */
	public void setImportedStatus(Integer importedStatus) {
		this.importedStatus = importedStatus;
	}
	/**
	 * 获取：有无进口批复
	 */
	public Integer getImportedStatus() {
		return importedStatus;
	}
	/**
	 * 设置：补齐时间
	 */
	public void setCompleteTime(String completeTime) {
		this.completeTime = completeTime;
	}
	/**
	 * 获取：补齐时间
	 */
	public String getCompleteTime() {
		return completeTime;
	}
	/**
	 * 设置：业绩归属人ID
	 */
	public void setAchievementId(String achievementId) {
		this.achievementId = achievementId;
	}
	/**
	 * 获取：业绩归属人ID
	 */
	public String getAchievementId() {
		return achievementId;
	}
	/**
	 * 设置：用款计划号
	 */
	public void setPalnNumber(String palnNumber) {
		this.palnNumber = palnNumber;
	}
	/**
	 * 获取：用款计划号
	 */
	public String getPalnNumber() {
		return palnNumber;
	}
	/**
	 * 设置：有无自筹资金证明
	 */
	public void setFundStatus(Integer fundStatus) {
		this.fundStatus = fundStatus;
	}
	/**
	 * 获取：有无自筹资金证明
	 */
	public Integer getFundStatus() {
		return fundStatus;
	}
	/**
	 * 设置：最后补齐时间
	 */
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	/**
	 * 获取：最后补齐时间
	 */
	public String getLastTime() {
		return lastTime;
	}
	/**
	 * 设置：标书价格[人民币]
	 */
	public void setBookPriceCny(Long bookPriceCny) {
		this.bookPriceCny = bookPriceCny;
	}
	/**
	 * 获取：标书价格[人民币]
	 */
	public Long getBookPriceCny() {
		return bookPriceCny;
	}
	/**
	 * 设置：标书价格【美元】
	 */
	public void setBookPriceUsd(Long bookPriceUsd) {
		this.bookPriceUsd = bookPriceUsd;
	}
	/**
	 * 获取：标书价格【美元】
	 */
	public Long getBookPriceUsd() {
		return bookPriceUsd;
	}
	/**
	 * 设置：标书费用收获方式【BLWETHERENUM】,是表示按包、否表示按项目
	 */
	public void setBookCostGetWay(Integer bookCostGetWay) {
		this.bookCostGetWay = bookCostGetWay;
	}
	/**
	 * 获取：标书费用收获方式【BLWETHERENUM】,是表示按包、否表示按项目
	 */
	public Integer getBookCostGetWay() {
		return bookCostGetWay;
	}
	/**
	 * 设置：招标文件制作方式【ImplementMakeSaleEnum】
	 */
	public void setMakeStatus(Integer makeStatus) {
		this.makeStatus = makeStatus;
	}
	/**
	 * 获取：招标文件制作方式【ImplementMakeSaleEnum】
	 */
	public Integer getMakeStatus() {
		return makeStatus;
	}
	/**
	 * 设置：公告变更类型[文件变更或者项目信息变更]
	 */
	public void setNoticeChangeType(String noticeChangeType) {
		this.noticeChangeType = noticeChangeType;
	}
	/**
	 * 获取：公告变更类型[文件变更或者项目信息变更]
	 */
	public String getNoticeChangeType() {
		return noticeChangeType;
	}
	/**
	 * 设置：
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * 获取：
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * 设置：行政区域
	 */
	public void setAdminArea(String adminArea) {
		this.adminArea = adminArea;
	}
	/**
	 * 获取：行政区域
	 */
	public String getAdminArea() {
		return adminArea;
	}
	/**
	 * 设置：财务项目编号
	 */
	public void setFinanceCode(String financeCode) {
		this.financeCode = financeCode;
	}
	/**
	 * 获取：财务项目编号
	 */
	public String getFinanceCode() {
		return financeCode;
	}
	/**
	 * 设置：定标日期
	 */
	public void setCalibrationTime(String calibrationTime) {
		this.calibrationTime = calibrationTime;
	}
	/**
	 * 获取：定标日期
	 */
	public String getCalibrationTime() {
		return calibrationTime;
	}
	/**
	 * 设置：是否上传采购文件业主确认函 BLWhetherEnum
	 */
	public void setIsUploadFileConfirm(Integer isUploadFileConfirm) {
		this.isUploadFileConfirm = isUploadFileConfirm;
	}
	/**
	 * 获取：是否上传采购文件业主确认函 BLWhetherEnum
	 */
	public Integer getIsUploadFileConfirm() {
		return isUploadFileConfirm;
	}
	/**
	 * 设置：未上传采购文件业主确认函情况说明
	 */
	public void setStatusStatement(String statusStatement) {
		this.statusStatement = statusStatement;
	}
	/**
	 * 获取：未上传采购文件业主确认函情况说明
	 */
	public String getStatusStatement() {
		return statusStatement;
	}
	/**
	 * 设置：
	 */
	public void setNotifySupplier(Integer notifySupplier) {
		this.notifySupplier = notifySupplier;
	}
	/**
	 * 获取：
	 */
	public Integer getNotifySupplier() {
		return notifySupplier;
	}
	/**
	 * 设置：变更公告内容
	 */
	public void setNoticeChangeContent(String noticeChangeContent) {
		this.noticeChangeContent = noticeChangeContent;
	}
	/**
	 * 获取：变更公告内容
	 */
	public String getNoticeChangeContent() {
		return noticeChangeContent;
	}
	/**
	 * 设置：变更的公告类型
	 */
	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}
	/**
	 * 获取：变更的公告类型
	 */
	public Integer getNoticeType() {
		return noticeType;
	}
	/**
	 * 设置：是否生成标前资料 BLWhetherEnum
	 */
	public void setPreBidData(Integer preBidData) {
		this.preBidData = preBidData;
	}
	/**
	 * 获取：是否生成标前资料 BLWhetherEnum
	 */
	public Integer getPreBidData() {
		return preBidData;
	}
	/**
	 * 设置：资格性审查人员类型
	 */
	public void setQualificationUserType(Integer qualificationUserType) {
		this.qualificationUserType = qualificationUserType;
	}
	/**
	 * 获取：资格性审查人员类型
	 */
	public Integer getQualificationUserType() {
		return qualificationUserType;
	}
	/**
	 * 设置：标识是否PPP项目
	 */
	public void setIsPppProject(Integer isPppProject) {
		this.isPppProject = isPppProject;
	}
	/**
	 * 获取：标识是否PPP项目
	 */
	public Integer getIsPppProject() {
		return isPppProject;
	}
	/**
	 * 设置：标识采购文件是否已审核
	 */
	public void setIsCheckBuyFile(Integer isCheckBuyFile) {
		this.isCheckBuyFile = isCheckBuyFile;
	}
	/**
	 * 获取：标识采购文件是否已审核
	 */
	public Integer getIsCheckBuyFile() {
		return isCheckBuyFile;
	}
	/**
	 * 设置：是否转交技服审核【只用于采购文件审核】
	 */
	public void setIsTransferTechnicalCheck(Integer isTransferTechnicalCheck) {
		this.isTransferTechnicalCheck = isTransferTechnicalCheck;
	}
	/**
	 * 获取：是否转交技服审核【只用于采购文件审核】
	 */
	public Integer getIsTransferTechnicalCheck() {
		return isTransferTechnicalCheck;
	}
	/**
	 * 设置：资格预审公告链接
	 */
	public void setQualificationPreNoticeLink(String qualificationPreNoticeLink) {
		this.qualificationPreNoticeLink = qualificationPreNoticeLink;
	}
	/**
	 * 获取：资格预审公告链接
	 */
	public String getQualificationPreNoticeLink() {
		return qualificationPreNoticeLink;
	}
	/**
	 * 设置：是否采购本国货物和服务
	 */
	public void setDomesticProcurement(Integer domesticProcurement) {
		this.domesticProcurement = domesticProcurement;
	}
	/**
	 * 获取：是否采购本国货物和服务
	 */
	public Integer getDomesticProcurement() {
		return domesticProcurement;
	}
	/**
	 * 设置：公示链接
	 */
	public void setPublicityNoticeLink(String publicityNoticeLink) {
		this.publicityNoticeLink = publicityNoticeLink;
	}
	/**
	 * 获取：公示链接
	 */
	public String getPublicityNoticeLink() {
		return publicityNoticeLink;
	}
	/**
	 * 设置：单一来源采购方式的原因及说明
	 */
	public void setReasonsExplanations(String reasonsExplanations) {
		this.reasonsExplanations = reasonsExplanations;
	}
	/**
	 * 获取：单一来源采购方式的原因及说明
	 */
	public String getReasonsExplanations() {
		return reasonsExplanations;
	}
	/**
	 * 设置：采购品目
	 */
	public void setPurchaseHeading(String purchaseHeading) {
		this.purchaseHeading = purchaseHeading;
	}
	/**
	 * 获取：采购品目
	 */
	public String getPurchaseHeading() {
		return purchaseHeading;
	}
	/**
	 * 设置：行业划分
	 */
	public void setIndustryDivision(String industryDivision) {
		this.industryDivision = industryDivision;
	}
	/**
	 * 获取：行业划分
	 */
	public String getIndustryDivision() {
		return industryDivision;
	}
	/**
	 * 设置：通知专家到场时间
	 */
	public void setNoticeExpertTime(String noticeExpertTime) {
		this.noticeExpertTime = noticeExpertTime;
	}
	/**
	 * 获取：通知专家到场时间
	 */
	public String getNoticeExpertTime() {
		return noticeExpertTime;
	}
	/**
	 * 设置：项目所属市、州
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：项目所属市、州
	 */
	public String getCityId() {
		return cityId;
	}
	/**
	 * 设置：项目所属县、区
	 */
	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}
	/**
	 * 获取：项目所属县、区
	 */
	public String getCountyId() {
		return countyId;
	}
	/**
	 * 设置：是否协议或定点采购
	 */
	public void setIsAgreementFixed(Integer isAgreementFixed) {
		this.isAgreementFixed = isAgreementFixed;
	}
	/**
	 * 获取：是否协议或定点采购
	 */
	public Integer getIsAgreementFixed() {
		return isAgreementFixed;
	}
	/**
	 * 设置：公示截止日期
	 */
	public void setPublicityNoticeEndTime(String publicityNoticeEndTime) {
		this.publicityNoticeEndTime = publicityNoticeEndTime;
	}
	/**
	 * 获取：公示截止日期
	 */
	public String getPublicityNoticeEndTime() {
		return publicityNoticeEndTime;
	}
	/**
	 * 设置：报价次数
	 */
	public void setOfferNum(Integer offerNum) {
		this.offerNum = offerNum;
	}
	/**
	 * 获取：报价次数
	 */
	public Integer getOfferNum() {
		return offerNum;
	}
	/**
	 * 设置：是否允许联合体
	 */
	public void setConsortium(Integer consortium) {
		this.consortium = consortium;
	}
	/**
	 * 获取：是否允许联合体
	 */
	public Integer getConsortium() {
		return consortium;
	}
	/**
	 * 设置：投标文件递交开始止时间 
	 */
	public void setBidFileCutOnTime(String bidFileCutOnTime) {
		this.bidFileCutOnTime = bidFileCutOnTime;
	}
	/**
	 * 获取：投标文件递交开始止时间 
	 */
	public String getBidFileCutOnTime() {
		return bidFileCutOnTime;
	}
	/**
	 * 设置：项目经理ID
	 */
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	/**
	 * 获取：项目经理ID
	 */
	public String getProjectManager() {
		return projectManager;
	}
	/**
	 * 设置：监督办公室
	 */
	public void setSuperviseOfficeRoom(String superviseOfficeRoom) {
		this.superviseOfficeRoom = superviseOfficeRoom;
	}
	/**
	 * 获取：监督办公室
	 */
	public String getSuperviseOfficeRoom() {
		return superviseOfficeRoom;
	}
	/**
	 * 设置：监督办公室电话
	 */
	public void setSupervisePhone(String supervisePhone) {
		this.supervisePhone = supervisePhone;
	}
	/**
	 * 获取：监督办公室电话
	 */
	public String getSupervisePhone() {
		return supervisePhone;
	}
	/**
	 * 设置：监督办公室地址
	 */
	public void setSuperviseAddress(String superviseAddress) {
		this.superviseAddress = superviseAddress;
	}
	/**
	 * 获取：监督办公室地址
	 */
	public String getSuperviseAddress() {
		return superviseAddress;
	}
	/**
	 * 设置：监督办公室邮编
	 */
	public void setSupervisePostcode(String supervisePostcode) {
		this.supervisePostcode = supervisePostcode;
	}
	/**
	 * 获取：监督办公室邮编
	 */
	public String getSupervisePostcode() {
		return supervisePostcode;
	}
	/**
	 * 设置：监督办公室ID
	 */
	public void setSuperviseOfficeRoomId(String superviseOfficeRoomId) {
		this.superviseOfficeRoomId = superviseOfficeRoomId;
	}
	/**
	 * 获取：监督办公室ID
	 */
	public String getSuperviseOfficeRoomId() {
		return superviseOfficeRoomId;
	}
	/**
	 * 设置：主开发人员ID
	 */
	public void setMainDevelopUserid(String mainDevelopUserid) {
		this.mainDevelopUserid = mainDevelopUserid;
	}
	/**
	 * 获取：主开发人员ID
	 */
	public String getMainDevelopUserid() {
		return mainDevelopUserid;
	}
	/**
	 * 设置：主开发人员比例
	 */
	public void setMainBrokerage(Double mainBrokerage) {
		this.mainBrokerage = mainBrokerage;
	}
	/**
	 * 获取：主开发人员比例
	 */
	public Double getMainBrokerage() {
		return mainBrokerage;
	}
	/**
	 * 设置：当前办理人员ID
	 */
	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}
	/**
	 * 获取：当前办理人员ID
	 */
	public String getCurrentUserId() {
		return currentUserId;
	}
	/**
	 * 设置：选择其他时的备注
	 */
	public void setPayTypeRemark(String payTypeRemark) {
		this.payTypeRemark = payTypeRemark;
	}
	/**
	 * 获取：选择其他时的备注
	 */
	public String getPayTypeRemark() {
		return payTypeRemark;
	}
	/**
	 * 设置：是否全部退完
	 */
	public void setIsAllReturn(Integer isAllReturn) {
		this.isAllReturn = isAllReturn;
	}
	/**
	 * 获取：是否全部退完
	 */
	public Integer getIsAllReturn() {
		return isAllReturn;
	}
}
