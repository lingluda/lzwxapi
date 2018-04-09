package com.maiyue.weixin.base.service;

import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.RolePermission;
import com.maiyue.weixin.service.BaseService;

/**
 * RolePermissionService业务层
 * 2018/04/09
 */
public interface RolePermissionService extends BaseService<RolePermission, String> {
    
	/***
     * 分页查询
     * @param params
     * @return
     */
    PageInfo<RolePermission> getPageData(Map<String, Object> params);
}