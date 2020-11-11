package com.scbid.sys.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.scbid.bond.entity.BondEnagencyEntity;
import com.scbid.common.utils.PageUtils;
import com.scbid.manage.entity.AccountEntity;
import com.scbid.manage.entity.CrmSupplierAccountEntity;
import com.scbid.sys.entity.BondUserEntity;

/**
 * 系统用户
 *
 * @author wangyun
 * @email 278812723
 * @date 2018-05-12 08:13:13
 */
public interface BondUserService extends IService<BondUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    PageUtils findByPage(Map<String, Object> params);
    
    List<BondUserEntity> queryUserList(Map<String, Object> params);
    
    /**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	List<String> queryAllPerms(Long roleId);
	
	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long roleId);

	/**
	 * 根据用户名，查询系统用户
	 */
	BondUserEntity queryByLoginNo(String loginNo);
	
	BondUserEntity selectUserByEntUuid(String entUuid);

	/**
	 * 保存用户
	 */
	void save(BondUserEntity user,BondUserEntity loginUser);
	
	/**
	 * 修改用户
	 */
	void update(BondUserEntity user,BondUserEntity loginUser);
	
	/**
	 * 删除用户
	 */
	void deleteBatch(Long[] userIds);

	/**
	 * 修改密码
	 * @param userId       用户ID
	 * @param password     原密码
	 * @param newPassword  新密码
	 */
	boolean updatePassword(Long userId, String password, String newPassword);

	/**
	 * 导入管理员账号信息
	  * @Title: importAccounts
	  * @Description: TODO
	  * @author: wangyun
	  * @date: 2018年5月14日 下午4:07:48
	  * @return
	 */
	boolean importAccounts(BondEnagencyEntity enagencyEntity,BondUserEntity loginUser,List<AccountEntity> accounts);
	/**
	 * 导入供应商账号信息
	  * @Title: importSupplier
	  * @Description: TODO
	  * @author: wangyun
	  * @date: 2018年5月14日 下午4:08:13
	 */
	boolean importSupplier(BondUserEntity loginUser,List<CrmSupplierAccountEntity> accounts);
	
	/**
	 * 查询所有user
	 * @author: chengyun
	 */
	List<BondUserEntity> selectAll();
	
	/**
	 * @param params
	 * @return
	 */
	List<BondUserEntity> queryListByMap(Map<String, Object> params);
}

