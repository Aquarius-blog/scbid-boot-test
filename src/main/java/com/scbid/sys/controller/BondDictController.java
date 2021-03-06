package com.scbid.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.R;
import com.scbid.sys.entity.BondDictEntity;
import com.scbid.sys.service.BondDictService;

/**
 * 数据字典表
 * @author wangyun
 * @date 2018-05-14 13:00:03
 */
@RestController
@RequestMapping("sys/dict")
public class BondDictController extends AbstractController {
    @Autowired
    private BondDictService bondDictService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bondDictService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{dictId}")
    public R info(@PathVariable("dictId") Long dictId){
			BondDictEntity bondDict = bondDictService.selectById(dictId);

        return R.ok().put("bondDict", bondDict);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bond:bonddict:save")
    public R save(@RequestBody BondDictEntity bondDict){
			bondDictService.insert(bondDict);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("bond:bonddict:update")
    public R update(@RequestBody BondDictEntity bondDict){
			bondDictService.updateById(bondDict);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bond:bonddict:delete")
    public R delete(@RequestBody Long[] dictIds){
			bondDictService.deleteBatchIds(Arrays.asList(dictIds));

        return R.ok();
    }

}
