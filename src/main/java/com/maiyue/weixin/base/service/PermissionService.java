package com.maiyue.weixin.base.service;

import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Permission;
import com.maiyue.weixin.service.BaseService;

/**
 * PermissionService业务层
 * 2018/04/09
 */
public interface PermissionService extends BaseService<Permission, String> {
    
	/***
     * 分页查询
     * @param params
     * @return
     */
    PageInfo<Permission> getPageData(Map<String, Object> params);
    
    
    /***
     * 按标识查询
     * @param pid
     * @return
     */
    Permission findByPid(String pid);
    
    
}