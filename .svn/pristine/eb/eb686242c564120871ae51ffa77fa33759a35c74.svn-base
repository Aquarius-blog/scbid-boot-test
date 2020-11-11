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

import com.scbid.bond.entity.BondOrderItemEntity;
import com.scbid.bond.service.BondOrderItemService;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.R;
import com.scbid.sys.controller.AbstractController;

/**
 * 订单明细
 * @author wangyun
 * @date 2018-05-14 13:00:02
 */
@RestController
@RequestMapping("bond/bondorderitem")
public class BondOrderItemController extends AbstractController {
    @Autowired
    private BondOrderItemService bondOrderItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("bond:bondorderitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bondOrderItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{orderItemId}")
    //@RequiresPermissions("bond:bondorderitem:info")
    public R info(@PathVariable("orderItemId") Integer orderItemId){
			BondOrderItemEntity bondOrderItem = bondOrderItemService.selectById(orderItemId);

        return R.ok().put("bondOrderItem", bondOrderItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bond:bondorderitem:save")
    public R save(@RequestBody BondOrderItemEntity bondOrderItem){
			bondOrderItemService.insert(bondOrderItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bond:bondorderitem:update")
    public R update(@RequestBody BondOrderItemEntity bondOrderItem){
			bondOrderItemService.updateById(bondOrderItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bond:bondorderitem:delete")
    public R delete(@RequestBody Integer[] orderItemIds){
			bondOrderItemService.deleteBatchIds(Arrays.asList(orderItemIds));

        return R.ok();
    }
    
    /**
     * 导入
     */
    @RequestMapping("/import")
    //@RequiresPermissions("bond:bondorderitem:import")
    public R importFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }
    
    /**
     * 导出
     */
    @RequestMapping("/export")
    //@RequiresPermissions("bond:bondorderitem:export")
    public R exportFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }

}
