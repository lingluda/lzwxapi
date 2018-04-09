package com.maiyue.app.service;

import com.maiyue.app.bean.ModResources;
import com.github.pagehelper.PageInfo;
import java.util.Map;

/**
 * ModResourcesService业务层
 * 2018/03/29
 */
public interface ModResourcesService extends BaseService<ModResources, String> {
    
	/***
     * 分页查询
     * @param params
     * @return
     */
    PageInfo<ModResources> getPageData(Map<String, Object> params);
}