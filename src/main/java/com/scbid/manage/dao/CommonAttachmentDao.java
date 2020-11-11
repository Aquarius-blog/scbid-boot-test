package com.scbid.manage.dao;

import java.util.List;
import java.util.Map;
import com.scbid.manage.entity.CommonAttachmentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * 用户角色
 * 
 * @author wangyun
 * @email 278812723
 * @date 2018-12-18 14:51:27
 */
@Mapper
public interface CommonAttachmentDao extends BaseMapper<CommonAttachmentEntity> {
	List<CommonAttachmentEntity> commonAttachmentPage(Map<String, Object> params);
}
