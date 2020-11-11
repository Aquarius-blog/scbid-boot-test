package com.scbid.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.scbid.sys.entity.BondDictEntity;

/**
 * 数据字典表
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-14 13:00:03
 */
@Mapper
public interface BondDictDao extends BaseMapper<BondDictEntity> {
	
}
