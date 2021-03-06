package com.scbid.bond.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.bond.dao.BondProjectDao;
import com.scbid.bond.entity.BondEnagencyEntity;
import com.scbid.bond.entity.BondProjectEntity;
import com.scbid.bond.service.BondProjectService;
import com.scbid.common.utils.Constant;
import com.scbid.common.utils.DateUtils;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;
import com.scbid.manage.entity.SaleProjectEntity;
import com.scbid.manage.entity.TenderBidBookSaleRecordEntity;


@Service("bondProjectService")
public class BondProjectServiceImpl extends ServiceImpl<BondProjectDao, BondProjectEntity> implements BondProjectService {

	@Autowired
	private BondProjectDao bondProjectDao;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<BondProjectEntity> page = this.selectPage(new Query<BondProjectEntity>(params).getPage(), new EntityWrapper<BondProjectEntity>());

		return new PageUtils(page);
	}

	@Override
	public PageUtils findSupplierProjectByUser(Map<String, Object> params) {
		Page<BondProjectEntity> page = new Query<BondProjectEntity>(params).getPage();
		page.setRecords(baseMapper.findSupplierProjectByUser(page,params));
		return new PageUtils(page);
	}
	
	

	@Override
	public PageUtils queryGuaranteeProjectList(Map<String, Object> params) {
		Page<BondProjectEntity> page = new Query<BondProjectEntity>(params).getPage();
		page.setRecords(bondProjectDao.queryGuaranteeProjectList(page,params));
		return new PageUtils(page);
	}

	@Override
	public PageUtils queryPageProjects(Map<String, Object> params) {
		Page<BondProjectEntity> page = new Query<BondProjectEntity>(params).getPage();
		page.setRecords(baseMapper.queryPageProjects(page, params));
		return new PageUtils(page);
	}

	@Override
	@Transactional(rollbackFor = Exception.class) // 事务控制
	public boolean guarantee(List<BondEnagencyEntity> agencys, Map<String, SaleProjectEntity> projectMap, List<TenderBidBookSaleRecordEntity> saleRecords) {

		List<BondProjectEntity> projectEntities = baseMapper.selectList(null);
		List<String> projectUuids = new ArrayList<String>();
		for (BondProjectEntity bondProjectEntity : projectEntities) {
			projectUuids.add(bondProjectEntity.getProjectUuid());
		}
		for (TenderBidBookSaleRecordEntity saleRecord : saleRecords) {
			SaleProjectEntity project = projectMap.get(saleRecord.getProjectId());
			if (!projectUuids.contains(project.getListId())) {
				BondProjectEntity bondProject = new BondProjectEntity();
				for (BondEnagencyEntity agency : agencys) {
					bondProject.setAgencyId(agency.getAgencyId());// 代理机构主键
					bondProject.setAgencyName(agency.getAgencyName());// 代理机构名称
				}
				bondProject.setProjectUuid(project.getListId());// 项目UUID
				bondProject.setPackageId(saleRecord.getPackageId());// 项目包UUID
				bondProject.setSupplierUuid(saleRecord.getSupplierId());// 供应商主键
				bondProject.setProjectCode(project.getCode());// 项目编码
				bondProject.setProjectName(project.getProjectName());// 项目名称
				bondProject.setProjectType(project.getProjectNature());// 项目类型
				bondProject.setProjectMoney(new BigDecimal(project.getBidBookPrice()));// 项目金额
				bondProject.setProjectStatus(Constant.ProjectStatus.STATUS_1.getValue());// 项目状态
				bondProject.setProjectDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));// 创建时间
				baseMapper.insert(bondProject);
			}

		}
		return true;
	}

	@Override
	public BondProjectEntity queryGuaranteeProjecttByorderId(String orderId) {
		BondProjectEntity projecttByorderId = bondProjectDao.queryGuaranteeProjecttByorderId(orderId);	
		if (projecttByorderId==null) {
			return null;
		} 
		
		return projecttByorderId;
	}

	@Override
	public PageUtils selectBatchProjectIds(Map<String, Object> params) {
		Page<BondProjectEntity> page = new Query<BondProjectEntity>(params).getPage();
		page.setRecords(baseMapper.selectBatchProjectIds(page,params));
		return new PageUtils(page);
	}


	@Override
	public List<BondProjectEntity> findProjectByOrder(Map<String, Object> params) {
		List<BondProjectEntity> projectList = baseMapper.findProjectByOrder(params);
		return projectList;
	}

}
