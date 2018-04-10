package com.maiyue.weixin.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.UserRole;
import com.maiyue.weixin.base.mapper.UserRoleMapper;
import com.maiyue.weixin.base.service.UserRoleService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserRoleService实现类
 * 2018/04/09
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, String> implements UserRoleService {
    /**
     * 注入Mapper
     */
    @Autowired
    private UserRoleMapper userRoleMapper;

	@Override
	public PageInfo<UserRole> getPageData(Map<String, Object> params) {
		return super.findByPage(params);
	}

	@Override
	public BaseMapper<UserRole, String> getMapper() {
		return userRoleMapper;
	}

   
}