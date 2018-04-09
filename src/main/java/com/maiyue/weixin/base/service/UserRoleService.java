package com.maiyue.weixin.base.service;

import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.UserRole;
import com.maiyue.weixin.service.BaseService;

/**
 * UserRoleService业务层
 * 2018/04/09
 */
public interface UserRoleService extends BaseService<UserRole, String> {
    
	/***
     * 分页查询
     * @param params
     * @return
     */
    PageInfo<UserRole> getPageData(Map<String, Object> params);
}