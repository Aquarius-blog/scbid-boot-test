package com.scbid.bond.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.bond.dao.BondOrderDao;
import com.scbid.bond.entity.BondEnguaratorEntity;
import com.scbid.bond.entity.BondOrderEntity;
import com.scbid.bond.entity.BondOrderFileEntity;
import com.scbid.bond.service.BondOrderFileService;
import com.scbid.bond.service.BondOrderService;
import com.scbid.common.config.ScbidOssBean;
import com.scbid.common.utils.DateUtils;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;
import com.scbid.manage.entity.SaleOrderBondStatusEnum;
import com.scbid.manage.entity.TenderBidBookSaleRecordEntity;

@Service("bondOrderService")
public class BondOrderServiceImpl extends ServiceImpl<BondOrderDao, BondOrderEntity> implements BondOrderService {

	@Autowired
	private BondOrderDao bondOrderDao;

	@Autowired
	private BondOrderFileService bondOrderFileService;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<BondOrderEntity> page = this.selectPage(new Query<BondOrderEntity>(params).getPage(), new EntityWrapper<BondOrderEntity>());
		return new PageUtils(page);
	}

	@Override
	public PageUtils queryPageOrders(Map<String, Object> params) {
		Page<BondOrderEntity> page = new Query<BondOrderEntity>(params).getPage();
		page.setRecords(baseMapper.queryPageOrders(page, params));
		return new PageUtils(page);
	}

	@Override
	public PageUtils guaranteeOrderList(Map<String, Object> params) {
		Page<BondOrderEntity> page = new Query<BondOrderEntity>(params).getPage();
		page.setRecords(bondOrderDao.guaranteeOrderList(page, params));
		return new PageUtils(page);
	}

	@Override
	@Transactional
	public Boolean updateOrderEntityByUrl(List<ScbidOssBean> ossBeans, String orderId) throws Exception {
		try {
			// 删除原来的上传文件
			List<BondOrderFileEntity> fileEntities = bondOrderFileService.queryList(Long.parseLong(orderId));
			for (BondOrderFileEntity entity : fileEntities) {
				bondOrderFileService.deleteById(entity.getFileId());
			}
			for (ScbidOssBean ossBean : ossBeans) {
				BondOrderFileEntity entity = new BondOrderFileEntity();
				entity.setOrderId(Integer.parseInt(orderId));
				entity.setOrderVoucher(ossBean.getFileId());
				// 保存上传的文件
				bondOrderFileService.insert(entity);
			}
			// 修改状态
			bondOrderDao.updateOrderStatus(SaleOrderBondStatusEnum.COMPLETED.getValue(), orderId);// 已完成
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	@Override
	public PageUtils findSupplierOrderByUser(Map<String, Object> params) {
		Page<BondOrderEntity> page = new Query<BondOrderEntity>(params).getPage();
		page.setRecords(baseMapper.findSupplierOrderByUser(page, params));
		return new PageUtils(page);
	}

	@Override
	public BondOrderEntity selectByOrderNo(String orderNo) {

		return baseMapper.selectByOrderNo(orderNo);

	}

	@Override
	public boolean insertBondOrder(TenderBidBookSaleRecordEntity saleRecordEntity, BondOrderEntity bondOrderEntity) {
		bondOrderEntity.setOrderDate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));// 订单创建时间
		return insert(bondOrderEntity);
	}
	@Transactional
	@Override
	public boolean updateGuarator(List<BondOrderEntity> list, BondEnguaratorEntity guarator) throws Exception {
		for (BondOrderEntity orderEntity : list) {
			orderEntity.setGuaratorId(guarator.getGuaratorId());
			updateById(orderEntity);
		}
		return true;
	}

	@Override
	public BondOrderEntity selectOrderByParams(Map<String, Object> params) {
		return baseMapper.selectOrderByParams(params);
	}

}
