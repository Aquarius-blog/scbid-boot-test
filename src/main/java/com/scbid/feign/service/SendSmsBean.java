package com.scbid.feign.service;

public class SendSmsBean {
	
	//电话号
	String phoneNumber;
	//公司签名
	String signName;
	//短信模板
	String templateCode;
	//项目名称
	String projectName;
	//订单编号
	String orderNo;
	//担保机构
	String guaratorName;
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSignName() {
		return signName;
	}
	public void setSignName(String signName) {
		this.signName = signName;
	}
	public String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getGuaratorName() {
		return guaratorName;
	}
	public void setGuaratorName(String guaratorName) {
		this.guaratorName = guaratorName;
	}
	
	

}
