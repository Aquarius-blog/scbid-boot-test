package com.scbid.bond.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scbid.bond.entity.BondEnagencyEntity;
import com.scbid.bond.entity.BondProjectEntity;
import com.scbid.bond.service.BondEnagencyService;
import com.scbid.bond.service.BondProjectService;
import com.scbid.common.utils.Constant;
import com.scbid.common.utils.DateUtils;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.R;
import com.scbid.sys.controller.AbstractController;
import com.scbid.sys.entity.BondUserEntity;
import com.scbid.sys.service.BondUserService;

/**
 * 供应商购买项目
 * 
 * @author wangyun
 * @date 2018-05-14 13:00:02
 */
@RestController
@RequestMapping("bond/bondproject")
public class BondProjectController extends AbstractController {

	@Autowired
	private BondProjectService bondProjectService;
	@Autowired
	private BondEnagencyService bondEnagencyService;

	/**
	 * 用户服务
	 */
	@Autowired
	private BondUserService bondUserService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = bondProjectService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{projectId}")
	public R info(@PathVariable("projectId") Integer projectId) {
		BondProjectEntity bondProject = bondProjectService.selectById(projectId);
		// 根据代理商id查出对应代理商
		BondEnagencyEntity bondEnagencyEntity = bondEnagencyService.selectById(bondProject.getAgencyId());
		String agencyName = bondEnagencyEntity.getAgencyName();
		if (agencyName != null) {
			bondProject.setAgencyName(agencyName);
		}

		if (bondProject.getProjectUserId() != null) {
			// 根据项目负责人id查出对应的项目负责人
			BondUserEntity bondUserEntity = bondUserService.selectById(bondProject.getProjectUserId());
			String userSurname = bondUserEntity.getUserSurname();
			if (userSurname != null) {
				bondProject.setProjectUserName(userSurname);
			}

			return R.ok().put("bondProject", bondProject);
		}

		return R.ok().put("bondProject", bondProject);
	}

	/**
	 * @Title: 添加项目
	 * @Description:
	 * @author: chengyun
	 * @date: 2018-05-17 13:39:39
	 */
	@RequestMapping("/save")
	// @RequiresPermissions("bond:bondproject:save")
	public R save(@RequestBody BondProjectEntity bondProject) {
		// 设置状态为未删除
		// bondProject.setProjectStatus(Constant.DeleteStatus.UNDELETED.getValue());
		if (bondProject != null) {
			bondProject.setProjectDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
			bondProject.setUpdateDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
			bondProject.setUpdateUesrName(getUser().getUserName());
			bondProjectService.insert(bondProject);
		}
		return R.ok();
	}

	/**
	 * 添加的时候获取其他信息(代理机构,项目负责人)
	 * 
	 * @author: chengyun
	 */
	@RequestMapping("/getOtherInfo")
	// @RequiresPermissions("bond:bondproject:update")
	public R getOtherInfo() {

		// 添加项目的时候查询所有的代理商
		List<BondEnagencyEntity> BondEnagencyEntityList = bondEnagencyService.selectAll();

		// 添加项目的时候查询项目负责人
		List<BondUserEntity> BondUserEntityList = bondUserService.selectAll();

		return R.ok().put("BondEnagencyEntityList", BondEnagencyEntityList).put("BondUserEntityList",
				BondUserEntityList);
	}

	/**
	 * 修改
	 * 
	 * @author: chengyun
	 */
	@RequestMapping("/update")
	// @RequiresPermissions("bond:bondproject:update")
	public R update(@RequestBody BondProjectEntity bondProject) {
		if (bondProject != null) {
			bondProject.setUpdateDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
			bondProject.setUpdateUesrName(getUser().getUserName());
			bondProjectService.updateById(bondProject);
		}
		return R.ok();
	}

	/**
	 * 逻辑删除
	 * 
	 * @author: chengyun
	 */
	@RequestMapping("/delete")
	// @RequiresPermissions("bond:bondproject:delete")
	public R delete(@RequestBody Long[] projectIds) {

		List<Long> longs = new ArrayList<Long>();
		for (Long projectId : projectIds) {
			longs.add(projectId);
		}
		List<BondProjectEntity> list = bondProjectService.selectBatchIds(longs);
		for (BondProjectEntity entity : list) {
			entity.setProjectStatus(Constant.DeleteStatus.DELETED.getValue());
			entity.setUpdateUesrName(getUser().getUserSurname());
			entity.setUpdateDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
		}
		bondProjectService.updateBatchById(list);
		return R.ok();
	}

	/**
	 * 导入
	 */
	@RequestMapping("/import")
	public R importFile(@RequestParam Map<String, Object> params) {

		return R.ok();
	}

	/**
	 * 导出
	 */
	@RequestMapping("/export")
	public R exportFile(@RequestParam Map<String, Object> params) {

		return R.ok();
	}

}
