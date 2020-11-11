package com.scbid.manage.controller;

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

import com.scbid.manage.entity.CommonAttachmentEntity;
import com.scbid.manage.service.CommonAttachmentService;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.R;

/**
 * 用户角色
 * @author wangyun
 * @date 2018-12-18 14:51:27
 */
@RestController
@RequestMapping("manage/commonattachment")
public class CommonAttachmentController extends AbstractController {
    @Autowired
    private CommonAttachmentService commonAttachmentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("manage:commonattachment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = commonAttachmentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{listId}")
    //@RequiresPermissions("manage:commonattachment:info")
    public R info(@PathVariable("listId") String listId){
			CommonAttachmentEntity commonAttachment = commonAttachmentService.selectById(listId);

        return R.ok().put("commonAttachment", commonAttachment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("manage:commonattachment:save")
    public R save(@RequestBody CommonAttachmentEntity commonAttachment){
			commonAttachmentService.insert(commonAttachment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("manage:commonattachment:update")
    public R update(@RequestBody CommonAttachmentEntity commonAttachment){
			commonAttachmentService.updateById(commonAttachment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("manage:commonattachment:delete")
    public R delete(@RequestBody String[] listIds){
			commonAttachmentService.deleteBatchIds(Arrays.asList(listIds));

        return R.ok();
    }
    
    /**
     * 导入
     */
    @RequestMapping("/import")
    //@RequiresPermissions("manage:commonattachment:import")
    public R importFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }
    
    /**
     * 导出
     */
    @RequestMapping("/export")
    //@RequiresPermissions("manage:commonattachment:export")
    public R exportFile(@RequestParam Map<String, Object> params){

        return R.ok();
    }

}
