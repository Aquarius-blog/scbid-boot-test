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
import com.scbid.manage.entity.TenderBidBookSaleRecordEntity;
import com.scbid.manage.service.TenderBidBookSaleRecordService;
import com.scbid.sys.controller.AbstractController;

/**
 * 
 * @author wangyun
 * @date 2018-05-18 14:18:38
 */
@RestController
@RequestMapping("manage/tenderbidbooksalerecord")
public class TenderBidBookSaleRecordController extends AbstractController {
    @Autowired
    private TenderBidBookSaleRecordService tenderBidBookSaleRecordService;
    
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("manage:tenderbidbooksalerecord:list")
    public R list(@RequestParam Map<String, Object> params){
       // PageUtils page = tenderBidBookSaleRecordService.queryPage(params);
    	PageUtils page = tenderBidBookSaleRecordService.bidBookSaleRecordPage(params);
    	 
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{listId}")
    //@RequiresPermissions("manage:tenderbidbooksalerecord:info")
    public R info(@PathVariable("listId") String listId){
			TenderBidBookSaleRecordEntity tenderBidBookSaleRecord = tenderBidBookSaleRecordService.selectById(listId);

        return R.ok().put("tenderBidBookSaleRecord", tenderBidBookSaleRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("manage:tenderbidbooksalerecord:save")
    public R save(@RequestBody TenderBidBookSaleRecordEntity tenderBidBookSaleRecord){
			tenderBidBookSaleRecordService.insert(tenderBidBookSaleRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("manage:tenderbidbooksalerecord:update")
    public R update(@RequestBody TenderBidBookSaleRecordEntity tenderBidBookSaleRecord){
			tenderBidBookSaleRecordService.updateById(tenderBidBookSaleRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("manage:tenderbidbooksalerecord:delete")
    public R delete(@RequestBody String[] listIds){
			tenderBidBookSaleRecordService.deleteBatchIds(Arrays.asList(listIds));

        return R.ok();
    }
    
    /**
     * 导入
     */
    @RequestMapping("/import")
    //@RequiresPermissions("manage:tenderbidbooksalerecord:import")
    public R importFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }
    
    /**
     * 导出
     */
    @RequestMapping("/export")
    //@RequiresPermissions("manage:tenderbidbooksalerecord:export")
    public R exportFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }

}
