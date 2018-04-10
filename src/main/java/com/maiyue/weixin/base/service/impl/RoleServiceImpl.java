package com.maiyue.weixin.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Role;
import com.maiyue.weixin.base.mapper.RoleMapper;
import com.maiyue.weixin.base.service.RoleService;
import com.maiyue.weixin.constant.Business;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RoleService实现类
 * 2018/04/09
 */
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role, String> implements RoleService {
    /**
     * 注入Mapper
     */
    @Autowired
    private RoleMapper roleMapper;

	@Override
	public PageInfo<Role> getPageData(Map<String, Object> params) {
		params = Business.defaultState(Role.class, params, "status");
		return super.findByPage(params);
	}

	@Override
	public BaseMapper<Role, String> getMapper() {
		return roleMapper;
	}

   
}