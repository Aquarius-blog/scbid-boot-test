package com.scbid.sys.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scbid.common.exception.RRException;
import com.scbid.common.utils.Constant;
import com.scbid.common.utils.Constant.MenuType;
import com.scbid.common.utils.R;
import com.scbid.sys.entity.BondMenuEntity;
import com.scbid.sys.service.BondMenuService;
import com.scbid.sys.service.ShiroService;




/**
 * 菜单管理
 *
 * @author wangyun
 * @email 278812723
 * @date 2018-05-11 11:45:12
 */
@RestController
@RequestMapping("sys/menu")
public class SysMenuController extends AbstractController {
    @Autowired
    private BondMenuService bondMenuService;
    @Autowired
	private ShiroService shiroService;
    /**
	 * 导航菜单
	 */
	@GetMapping("/nav")
	public R nav(){
		List<BondMenuEntity> menuList = new ArrayList<BondMenuEntity>();
		if (Constant.RoleType.SYSTEM_ADMIN.getValue()==getRoleId()) {
			//管理员获取全部菜单不包含按钮
			menuList = bondMenuService.getUserMenuList();
		}else{
			//非管理员获取分配的菜单信息不包含按钮
			menuList = bondMenuService.getUserMenuList(getUserId());
		}
		//获取用户权限列表
		Set<String> permissions = shiroService.getUserPermissions(getUserId());
		return R.ok().put("menuList", menuList).put("permissions", permissions);
	}
	
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:menu:list")
    public List<BondMenuEntity> list(@RequestParam Map<String, Object> params){
    	List<BondMenuEntity> menuList = bondMenuService.selectList(null);
		for(BondMenuEntity sysMenuEntity : menuList){
			BondMenuEntity parentMenuEntity = bondMenuService.selectById(sysMenuEntity.getParentId());
			if(parentMenuEntity != null){
				sysMenuEntity.setParentName(parentMenuEntity.getName());
			}
		}
		return menuList;
    }

    
    /**
	 * 选择菜单(添加、修改菜单)
	 */
	@RequestMapping("/select")
	//@RequiresPermissions("sys:menu:select")
	public R select(){
		//查询列表数据
		List<BondMenuEntity> menuList = bondMenuService.getUserMenuList();
		
		//添加顶级菜单
		BondMenuEntity root = new BondMenuEntity();
		root.setMenuId(0L);
		root.setName("一级菜单");
		root.setParentId(-1L);
		root.setOpen(true);
		menuList.add(root);
		
		return R.ok().put("menuList", menuList);
	}

    /**
     * 信息
     */
    @RequestMapping("/info/{menuId}")
    //@RequiresPermissions("sys:menu:info")
    public R info(@PathVariable("menuId") Long menuId){
        BondMenuEntity bondMenu = bondMenuService.selectById(menuId);
        BondMenuEntity parentMenu = bondMenuService.selectById(bondMenu.getParentId());
        if (parentMenu!=null) {
        	bondMenu.setParentName(parentMenu.getName());
		}
        return R.ok().put("bondMenu", bondMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:menu:save")
    public R save(@RequestBody BondMenuEntity bondMenu){
    	
    	//数据校验
    	verifyForm(bondMenu);
    	
    	//若为新增菜单
    	if (MenuType.MENU.getValue()==bondMenu.getType()) {
    		 bondMenuService.insertMenu(bondMenu);
		}
    	//若为新增按钮
    	else if (MenuType.BUTTON.getValue()==bondMenu.getType()) {
    		 bondMenuService.insert(bondMenu);
		}
    	//若为新增目录
    	else if (MenuType.CATALOG.getValue()==bondMenu.getType()) {
    		 bondMenuService.insert(bondMenu);
		}else{
			return R.error();
		}
    	
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:menu:update")
    public R update(@RequestBody BondMenuEntity bondMenu){
    	//数据校验
    	verifyForm(bondMenu);
    	//若为修改菜单
    	if (MenuType.MENU.getValue()==bondMenu.getType()) {
    		 bondMenuService.updateMenu(bondMenu);
		}
    	//若为修改按钮
    	else if (MenuType.BUTTON.getValue()==bondMenu.getType()) {
    		bondMenuService.updateAllColumnById(bondMenu);//全部更新
		}
    	//若为修改目录
    	else if (MenuType.CATALOG.getValue()==bondMenu.getType()) {
    		bondMenuService.updateAllColumnById(bondMenu);//全部更新
		}else{
			return R.error();
		}
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:menu:delete")
    public R delete(@RequestBody Long[] menuIds){
        bondMenuService.deleteBatchIds(Arrays.asList(menuIds));

        return R.ok();
    }
	/**
	 * 验证参数是否正确
	 */
	private void verifyForm(BondMenuEntity menu){
		if(StringUtils.isBlank(menu.getName())){
			throw new RRException("菜单名称不能为空");
		}
		
		if(menu.getParentId() == null){
			throw new RRException("上级菜单不能为空");
		}
		
		//菜单
		if(menu.getType() == Constant.MenuType.MENU.getValue()){
			if(StringUtils.isBlank(menu.getUrl())){
				throw new RRException("菜单URL不能为空");
			}
		}
		
		//上级菜单类型
		int parentType = Constant.MenuType.CATALOG.getValue();
		if(menu.getParentId() != 0){
			BondMenuEntity parentMenu = bondMenuService.selectById(menu.getParentId());
			parentType = parentMenu.getType();
		}
		
		//目录、菜单
		if(menu.getType() == Constant.MenuType.CATALOG.getValue() ||
				menu.getType() == Constant.MenuType.MENU.getValue()){
			if(parentType != Constant.MenuType.CATALOG.getValue()){
				throw new RRException("上级菜单只能为目录类型");
			}
			return ;
		}
		
		//按钮
		if(menu.getType() == Constant.MenuType.BUTTON.getValue()){
			if(parentType != Constant.MenuType.MENU.getValue()){
				throw new RRException("上级菜单只能为菜单类型");
			}
			return ;
		}
	}
}
