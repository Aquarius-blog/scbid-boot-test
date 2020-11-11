package com.scbid.bond.dao;

import java.util.List;
import java.util.Map;
import com.scbid.bond.entity.BondOrderFileEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * 
 * 
 * @author wangyun
 * @email 278812723
 * @date 2019-06-25 09:33:49
 */
@Mapper
public interface BondOrderFileDao extends BaseMapper<BondOrderFileEntity> {
	List<BondOrderFileEntity> bondOrderFilePage(Pagination page, Map<String, Object> params);
}
