package com.scbid.manage.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.scbid.common.datasources.DataSourceNames;
import com.scbid.common.datasources.TargetDataSource;
import com.scbid.common.utils.PageUtils;
import com.scbid.common.utils.Query;
import com.scbid.manage.dao.AccountDao;
import com.scbid.manage.entity.AccountEntity;
import com.scbid.manage.service.AccountService;


@Service("accountService")
public class AccountServiceImpl extends ServiceImpl<AccountDao, AccountEntity> implements AccountService {

    @Override
    @TargetDataSource(name=DataSourceNames.SECOND)
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AccountEntity> page = this.selectPage(
                new Query<AccountEntity>(params).getPage(),
                new EntityWrapper<AccountEntity>()
        );

        return new PageUtils(page);
    }
	
	@Override
	@TargetDataSource(name=DataSourceNames.SECOND)
	public List<AccountEntity> selectList() {
		return baseMapper.selectList(null);
	}

	@Override
	@TargetDataSource(name=DataSourceNames.SECOND)
	public AccountEntity selectById(String listId) {
		return baseMapper.selectById(listId);
	}

}
