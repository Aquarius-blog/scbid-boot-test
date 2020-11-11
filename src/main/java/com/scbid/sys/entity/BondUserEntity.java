package com.scbid.sys.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 系统用户
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-12 08:13:13
 */
@TableName("t_bond_user")
public class BondUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long userId;
	/**
	 * 角色ID
	 */
	private Long roleId;
	
	/**
	 * 角色名称
	 */
	@TableField(exist=false)
	private String roleName;
	
	/**
	 * 企业UUID主键
	 */
	private String entUuid;
	/**
	 * 公司名称主键
	 */
	@TableField(exist=false)
	private String entName;
	
	
	@TableField(exist=false)
	private String deptName;
	
	
	@TableField(exist=false)
	private String deptId;
	
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	/**
	 * 身份标识
	 */
	private String loginNo;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 用户岗位
	 */
	private String userJob;
	/**
	 * 盐
	 */
	private String salt;
	/**
	 * 用户名姓
	 */
	private String userSurname;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 邮箱
	 */
	private String userEmail;
	/**
	 * 手机号
	 */
	private String userMobile;
	/**
	 * 状态 0：禁用 1：正常
	 */
	private Integer userStatus;
	/**
	 * 创建时间
	 */
	private String userTime;
	/**
	 * 最后修改人姓名
	 */
	private String updateUesrName;
	/**
	 * 最后修改时间
	 */
	private String updateDate;

	/**
	 * 角色ID列表
	 */
	@TableField(exist = false)
	private List<Long> roleIdList;

	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：角色ID
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：角色ID
	 */
	public Long getRoleId() {
		return roleId;
	}
	
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * 设置：企业UUID主键
	 */
	public void setEntUuid(String entUuid) {
		this.entUuid = entUuid;
	}
	/**
	 * 获取：企业UUID主键
	 */
	public String getEntUuid() {
		return entUuid;
	}
	
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	/**
	 * 设置：
	 */
	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}
	/**
	 * 获取：
	 */
	public String getLoginNo() {
		return loginNo;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：用户岗位
	 */
	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}
	/**
	 * 获取：用户岗位
	 */
	public String getUserJob() {
		return userJob;
	}
	/**
	 * 设置：盐
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * 获取：盐
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * 设置：用户名姓
	 */
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	/**
	 * 获取：用户名姓
	 */
	public String getUserSurname() {
		return userSurname;
	}
	/**
	 * 设置：用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：邮箱
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 * 获取：邮箱
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * 设置：手机号
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getUserMobile() {
		return userMobile;
	}
	/**
	 * 设置：状态 0：禁用 1：正常
	 */
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	/**
	 * 获取：状态 0：禁用 1：正常
	 */
	public Integer getUserStatus() {
		return userStatus;
	}
	/**
	 * 设置：创建时间
	 */
	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}
	/**
	 * 获取：创建时间
	 */
	public String getUserTime() {
		return userTime;
	}
	/**
	 * 设置：最后修改人姓名
	 */
	public void setUpdateUesrName(String updateUesrName) {
		this.updateUesrName = updateUesrName;
	}
	/**
	 * 获取：最后修改人姓名
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
	public List<Long> getRoleIdList() {
		return roleIdList;
	}
	public void setRoleIdList(List<Long> roleIdList) {
		this.roleIdList = roleIdList;
	}
	@Override
	public String toString() {
		return "BondUserEntity [userId=" + userId + ", roleId=" + roleId + ", roleName=" + roleName + ", entUuid="
				+ entUuid + ", entName=" + entName + ", deptName=" + deptName + ", deptId=" + deptId + ", loginNo="
				+ loginNo + ", password=" + password + ", userJob=" + userJob + ", salt=" + salt + ", userSurname="
				+ userSurname + ", userName=" + userName + ", userEmail=" + userEmail + ", userMobile=" + userMobile
				+ ", userStatus=" + userStatus + ", userTime=" + userTime + ", updateUesrName=" + updateUesrName
				+ ", updateDate=" + updateDate + ", roleIdList=" + roleIdList + "]";
	}
	

}
