package com.scbid.manage.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.R;
import com.scbid.manage.entity.AccountEntity;
import com.scbid.manage.service.AccountService;
import com.scbid.sys.controller.AbstractController;

/**
 * 供应商
 * @author wangyun
 * @date 2018-05-14 15:48:47
 */
@RestController
@RequestMapping("manage/account")
public class AccountController extends AbstractController {
    @Autowired
    private AccountService accountService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("manage:account:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = accountService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{listId}")
    //@RequiresPermissions("manage:account:info")
    public R info(@PathVariable("listId") String listId){
			AccountEntity account = accountService.selectById(listId);

        return R.ok().put("account", account);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("manage:account:save")
    public R save(@RequestBody AccountEntity account){
			accountService.insert(account);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("manage:account:update")
    public R update(@RequestBody AccountEntity account){
			accountService.updateById(account);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("manage:account:delete")
    public R delete(@RequestBody String[] listIds){
			accountService.deleteBatchIds(Arrays.asList(listIds));

        return R.ok();
    }
    
    /**
     * 导入
     */
    @RequestMapping("/import")
    //@RequiresPermissions("manage:account:import")
    public R importFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }
    
    /**
     * 导出
     */
    @RequestMapping("/export")
    //@RequiresPermissions("manage:account:export")
    public R exportFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }

}
