package com.scbid.invoice.controller;

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
import com.scbid.invoice.entity.FpsqbEntity;
import com.scbid.invoice.service.FpsqbService;
import com.scbid.sys.controller.AbstractController;

/**
 * 
 * @author wangyun
 * @date 2018-05-24 10:27:59
 */
@RestController
@RequestMapping("invoice/fpsqb")
public class FpsqbController extends AbstractController {
    @Autowired
    private FpsqbService fpsqbService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("invoice:fpsqb:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fpsqbService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{listId}")
    //@RequiresPermissions("invoice:fpsqb:info")
    public R info(@PathVariable("listId") String listId){
			FpsqbEntity fpsqb = fpsqbService.selectById(listId);

        return R.ok().put("fpsqb", fpsqb);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("invoice:fpsqb:save")
    public R save(@RequestBody FpsqbEntity fpsqb){
			fpsqbService.insert(fpsqb);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("invoice:fpsqb:update")
    public R update(@RequestBody FpsqbEntity fpsqb){
			fpsqbService.updateById(fpsqb);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("invoice:fpsqb:delete")
    public R delete(@RequestBody String[] listIds ){
			fpsqbService.deleteBatchIds(Arrays.asList(listIds));

        return R.ok();
    }
    
    /**
     * 导入
     */
    @RequestMapping("/import")
    //@RequiresPermissions("invoice:fpsqb:import")
    public R importFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }
    
    /**
     * 导出
     */
    @RequestMapping("/export")
    //@RequiresPermissions("invoice:fpsqb:export")
    public R exportFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }

}
