package com.scbid.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.scbid.sys.entity.BondLogEntity;

/**
 * 系统日志
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-12 08:25:10
 */
@Mapper
public interface BondLogDao extends BaseMapper<BondLogEntity> {
	
}
