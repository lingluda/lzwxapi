package com.maiyue.weixin.base.service;

import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Role;
import com.maiyue.weixin.service.BaseService;

/**
 * RoleService业务层
 * 2018/04/09
 */
public interface RoleService extends BaseService<Role, String> {
   
	/***
     * 分页查询
     * @param params
     * @return
     */
    PageInfo<Role> getPageData(Map<String, Object> params);
}