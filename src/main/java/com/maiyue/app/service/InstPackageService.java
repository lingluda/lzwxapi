package com.maiyue.app.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.app.bean.InstPackage;

import java.util.List;
import java.util.Map;

/**
 * InstPackageService业务层
 * 2018/03/29
 */
public interface InstPackageService extends BaseService<InstPackage, String> {
    /**
     * 分页查询
     * @param offset 偏移量
     * @param pageSize 一页显示多少记录
     * @param params 条件参数
     * @return 分页结果实体 PageInfo
     */ 
    PageInfo<InstPackage> getPageData(Map<String, Object> params);
    
    /***
     * 按 App信息Id查询
     * @param appInfoId
     * @return
     */
    List<InstPackage> findByAppId(String appInfoId);
    
    
    /***
     * 按 UserId查询
     * @param appInfoId
     * @return
     */
    List<InstPackage> findByUserId(String userId);

}