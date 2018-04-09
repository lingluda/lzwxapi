package com.maiyue.weixin.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.bean.SystemConfig;
import java.util.Map;

/**
 * SystemConfigService业务层
 * 2018/04/01
 */
public interface SystemConfigService extends BaseService<SystemConfig, String> {
    /**
     * 分页查询
     * @param offset 偏移量
     * @param pageSize 一页显示多少记录
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<SystemConfig> getPageData(Map<String, Object> params);
    
    /***
     * 按配置名称查询
     * @param configName
     * @return
     */
    String findByconfigName(String configName);
    
}