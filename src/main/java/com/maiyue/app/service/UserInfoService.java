package com.maiyue.app.service;

import com.maiyue.app.bean.UserInfo;
import com.github.pagehelper.PageInfo;
import java.util.Map;

/**
 * UserInfoService业务层
 * 2018/03/29
 */
public interface UserInfoService extends BaseService<UserInfo, String> {
    /**
     * 分页查询
     * @param offset 偏移量
     * @param pageSize 一页显示多少记录
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<UserInfo> getPageData(Map<String, Object> params);


    /***
     * 根据用户名查询
     * @param username
     * @return
     */
    UserInfo getByUserName(String username);
    
    
}