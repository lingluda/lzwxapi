package com.maiyue.weixin.base.service.impl;
import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.RolePermission;
import com.maiyue.weixin.base.mapper.RolePermissionMapper;
import com.maiyue.weixin.base.service.RolePermissionService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RolePermissionService实现类
 * 2018/04/09
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermission, String> implements RolePermissionService {
    /**
     * 注入Mapper
     */
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

	@Override
	public PageInfo<RolePermission> getPageData(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseMapper<RolePermission, String> getMapper() {
		return rolePermissionMapper;
	}

   
}