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
import com.scbid.manage.entity.TenderImplemenProjectEntity;
import com.scbid.manage.service.TenderImplemenProjectService;
import com.scbid.sys.controller.AbstractController;

/**
 * 
 * @author wangyun
 * @date 2018-05-18 15:14:41
 */
@RestController
@RequestMapping("manage/tenderimplemenproject")
public class TenderImplemenprojectController extends AbstractController {
    @Autowired
    private TenderImplemenProjectService tenderImplemenProjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("manage:tenderimplemenproject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tenderImplemenProjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{listId}")
    //@RequiresPermissions("manage:tenderimplemenproject:info")
    public R info(@PathVariable("listId") String listId){
			TenderImplemenProjectEntity tenderImplemenproject = tenderImplemenProjectService.selectById(listId);

        return R.ok().put("tenderImplemenproject", tenderImplemenproject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("manage:tenderimplemenproject:save")
    public R save(@RequestBody TenderImplemenProjectEntity tenderImplemenproject){
    	tenderImplemenProjectService.insert(tenderImplemenproject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("manage:tenderimplemenproject:update")
    public R update(@RequestBody TenderImplemenProjectEntity tenderImplemenproject){
    	tenderImplemenProjectService.updateById(tenderImplemenproject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("manage:tenderimplemenproject:delete")
    public R delete(@RequestBody String[] listIds){
    	tenderImplemenProjectService.deleteBatchIds(Arrays.asList(listIds));

        return R.ok();
    }
    
    /**
     * 导入
     */
    @RequestMapping("/import")
    //@RequiresPermissions("manage:tenderimplemenproject:import")
    public R importFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }
    
    /**
     * 导出
     */
    @RequestMapping("/export")
    //@RequiresPermissions("manage:tenderimplemenproject:export")
    public R exportFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }

}
