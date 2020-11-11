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
import com.scbid.manage.entity.SaleOrderManagementEntity;
import com.scbid.manage.service.SaleOrderManagementService;
import com.scbid.sys.controller.AbstractController;

/**
 * 
 * @author wangyun
 * @date 2018-10-26 10:20:05
 */
@RestController
@RequestMapping("manage/saleordermanagement")
public class SaleOrderManagementController extends AbstractController {
    @Autowired
    private SaleOrderManagementService saleOrderManagementService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("manage:saleordermanagement:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = saleOrderManagementService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{listId}")
    //@RequiresPermissions("manage:saleordermanagement:info")
    public R info(@PathVariable("listId") String listId){
			SaleOrderManagementEntity saleOrderManagement = saleOrderManagementService.selectById(listId);

        return R.ok().put("saleOrderManagement", saleOrderManagement);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("manage:saleordermanagement:save")
    public R save(@RequestBody SaleOrderManagementEntity saleOrderManagement){
			saleOrderManagementService.insert(saleOrderManagement);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("manage:saleordermanagement:update")
    public R update(@RequestBody SaleOrderManagementEntity saleOrderManagement){
			saleOrderManagementService.updateById(saleOrderManagement);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("manage:saleordermanagement:delete")
    public R delete(@RequestBody String[] listIds){
			saleOrderManagementService.deleteBatchIds(Arrays.asList(listIds));

        return R.ok();
    }
    
    /**
     * 导入
     */
    @RequestMapping("/import")
    //@RequiresPermissions("manage:saleordermanagement:import")
    public R importFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }
    
    /**
     * 导出
     */
    @RequestMapping("/export")
    //@RequiresPermissions("manage:saleordermanagement:export")
    public R exportFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }

}
