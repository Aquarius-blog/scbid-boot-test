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
import com.scbid.manage.entity.TenderImplemenProjectPackagesEntity;
import com.scbid.manage.service.TenderImplemenProjectPackagesService;
import com.scbid.sys.controller.AbstractController;

/**
 * 
 * @author wangyun
 * @date 2018-10-30 21:24:11
 */
@RestController
@RequestMapping("manage/tenderImplemenProjectPackages")
public class TenderImplemenProjectPackagesController extends AbstractController {
    @Autowired
    private TenderImplemenProjectPackagesService tenderImplemenProjectPackagesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("manage:tenderImplemenProjectPackages:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tenderImplemenProjectPackagesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{listId}")
    //@RequiresPermissions("manage:tenderImplemenProjectPackages:info")
    public R info(@PathVariable("listId") String listId){
			TenderImplemenProjectPackagesEntity tenderImplemenProjectPackages = tenderImplemenProjectPackagesService.selectById(listId);

        return R.ok().put("tenderImplemenProjectPackages", tenderImplemenProjectPackages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("manage:tenderImplemenProjectPackages:save")
    public R save(@RequestBody TenderImplemenProjectPackagesEntity tenderImplemenProjectPackages){
			tenderImplemenProjectPackagesService.insert(tenderImplemenProjectPackages);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("manage:tenderImplemenProjectPackages:update")
    public R update(@RequestBody TenderImplemenProjectPackagesEntity tenderImplemenProjectPackages){
			tenderImplemenProjectPackagesService.updateById(tenderImplemenProjectPackages);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("manage:tenderImplemenProjectPackages:delete")
    public R delete(@RequestBody String[] listIds){
			tenderImplemenProjectPackagesService.deleteBatchIds(Arrays.asList(listIds));

        return R.ok();
    }
    
    /**
     * 导入
     */
    @RequestMapping("/import")
    //@RequiresPermissions("manage:tenderImplemenProjectPackages:import")
    public R importFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }
    
    /**
     * 导出
     */
    @RequestMapping("/export")
    //@RequiresPermissions("manage:tenderImplemenProjectPackages:export")
    public R exportFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }

}
