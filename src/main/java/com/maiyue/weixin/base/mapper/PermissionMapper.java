package com.maiyue.weixin.base.mapper;

import com.maiyue.weixin.base.bean.Permission;
import com.maiyue.weixin.mapper.BaseMapper;

/**
 * PermissionMapper
 * 2018/04/09
 */
public interface PermissionMapper extends BaseMapper<Permission, String> {
	
	Permission findByPid(String pid);
}