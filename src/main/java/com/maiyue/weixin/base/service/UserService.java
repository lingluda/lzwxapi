package com.maiyue.weixin.base.service;

import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.User;
import com.maiyue.weixin.service.BaseService;

/**
 * UserService业务层
 * 2018/04/09
 */
public interface UserService extends BaseService<User, String> {
    /***
     * 分页查询
     * @param params
     * @return
     */
    PageInfo<User> getPageData(Map<String, Object> params);
   
    /***
     * 按用户名查询
     * @param username
     * @return
     */
    User findByUsername(String username);
}