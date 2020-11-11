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
import com.scbid.manage.entity.SaleProjectEntity;
import com.scbid.manage.service.SaleProjectService;
import com.scbid.sys.controller.AbstractController;

/**
 * 
 * @author wangyun
 * @date 2018-05-18 11:33:03
 */
@RestController
@RequestMapping("manage/saleproject")
public class SaleProjectController extends AbstractController {
    @Autowired
    private SaleProjectService saleProjectService;
    
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("manage:saleproject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = saleProjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{listId}")
    //@RequiresPermissions("manage:saleproject:info")
    public R info(@PathVariable("listId") String listId){
			SaleProjectEntity saleProject = saleProjectService.selectById(listId);

        return R.ok().put("saleProject", saleProject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("manage:saleproject:save")
    public R save(@RequestBody SaleProjectEntity saleProject){
			saleProjectService.insert(saleProject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("manage:saleproject:update")
    public R update(@RequestBody SaleProjectEntity saleProject){
			saleProjectService.updateById(saleProject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("manage:saleproject:delete")
    public R delete(@RequestBody String[] listIds){
			saleProjectService.deleteBatchIds(Arrays.asList(listIds));

        return R.ok();
    }
    
    /**
     * 导入
     */
    @RequestMapping("/import")
    //@RequiresPermissions("manage:saleproject:import")
    public R importFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }
    
    /**
     * 导出
     */
    @RequestMapping("/export")
    //@RequiresPermissions("manage:saleproject:export")
    public R exportFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }
}
