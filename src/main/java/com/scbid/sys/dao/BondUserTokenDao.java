package com.scbid.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.scbid.sys.entity.BondUserTokenEntity;

/**
 * 系统用户Token
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-05-12 08:25:09
 */
@Mapper
public interface BondUserTokenDao extends BaseMapper<BondUserTokenEntity> {

	BondUserTokenEntity queryByToken(String token);
	
}
