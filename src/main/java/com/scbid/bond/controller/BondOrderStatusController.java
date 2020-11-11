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

import com.scbid.bond.entity.BondOrderStatusEntity;
import com.scbid.bond.service.BondOrderStatusService;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.R;
import com.scbid.sys.controller.AbstractController;

/**
 * 订单历史状态
 * @author wangyun
 * @date 2018-05-14 13:00:02
 */
@RestController
@RequestMapping("bond/bondorderstatus")
public class BondOrderStatusController extends AbstractController {
    @Autowired
    private BondOrderStatusService bondOrderStatusService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bondOrderStatusService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{orderStatusId}")
    public R info(@PathVariable("orderStatusId") Integer orderStatusId){
			BondOrderStatusEntity bondOrderStatus = bondOrderStatusService.selectById(orderStatusId);

        return R.ok().put("bondOrderStatus", bondOrderStatus);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bond:bondorderstatus:save")
    public R save(@RequestBody BondOrderStatusEntity bondOrderStatus){
			bondOrderStatusService.insert(bondOrderStatus);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bond:bondorderstatus:update")
    public R update(@RequestBody BondOrderStatusEntity bondOrderStatus){
			bondOrderStatusService.updateById(bondOrderStatus);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bond:bondorderstatus:delete")
    public R delete(@RequestBody Integer[] orderStatusIds){
			bondOrderStatusService.deleteBatchIds(Arrays.asList(orderStatusIds));

        return R.ok();
    }
    
    /**
     * 导入
     */
    @RequestMapping("/import")
    public R importFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }
    
    /**
     * 导出
     */
    @RequestMapping("/export")
    public R exportFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }

}
