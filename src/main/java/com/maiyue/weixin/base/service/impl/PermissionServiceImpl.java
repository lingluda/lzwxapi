package com.maiyue.weixin.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Permission;
import com.maiyue.weixin.base.mapper.PermissionMapper;
import com.maiyue.weixin.base.service.PermissionService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PermissionService实现类
 * 2018/04/09
 */
@Service("permissionService")
public class PermissionServiceImpl extends BaseServiceImpl<Permission, String> implements PermissionService {
    /**
     * 注入Mapper
     */
    @Autowired
    private PermissionMapper permissionMapper;

	@Override
	public PageInfo<Permission> getPageData(Map<String, Object> params) {
		return null;
	}

	@Override
	public BaseMapper<Permission, String> getMapper() {
		return permissionMapper;
	}


    
}