package com.scbid.bond.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.scbid.sys.controller.AbstractController;

import com.scbid.bond.entity.BondOrderFileEntity;
import com.scbid.bond.service.BondOrderFileService;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.R;

/**
 * 
 * @author wangyun
 * @date 2019-06-25 09:33:49
 */
@RestController
@RequestMapping("bond/bondorderfile")
public class BondOrderFileController extends AbstractController {
    @Autowired
    private BondOrderFileService bondOrderFileService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("bond:bondorderfile:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bondOrderFileService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{fileId}")
    //@RequiresPermissions("bond:bondorderfile:info")
    public R info(@PathVariable("fileId") Integer fileId){
			BondOrderFileEntity bondOrderFile = bondOrderFileService.selectById(fileId);

        return R.ok().put("bondOrderFile", bondOrderFile);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("bond:bondorderfile:save")
    public R save(@RequestBody BondOrderFileEntity bondOrderFile){
			bondOrderFileService.insert(bondOrderFile);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("bond:bondorderfile:update")
    public R update(@RequestBody BondOrderFileEntity bondOrderFile){
			bondOrderFileService.updateById(bondOrderFile);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("bond:bondorderfile:delete")
    public R delete(@RequestBody Integer[] fileIds){
			bondOrderFileService.deleteBatchIds(Arrays.asList(fileIds));

        return R.ok();
    }
    
    /**
     * 导入
     */
    @RequestMapping("/import")
    //@RequiresPermissions("bond:bondorderfile:import")
    public R importFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }
    
    /**
     * 导出
     */
    @RequestMapping("/export")
    //@RequiresPermissions("bond:bondorderfile:export")
    public R exportFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }

}
