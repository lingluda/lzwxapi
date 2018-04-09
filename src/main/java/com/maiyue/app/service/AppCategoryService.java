package com.maiyue.app.service;

import com.maiyue.app.bean.AppCategory;
import com.github.pagehelper.PageInfo;
import java.util.Map;

/**
 * AppCategoryService业务层
 * 2018/03/29
 */
public interface AppCategoryService extends BaseService<AppCategory, String> {
    
	
	/**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<AppCategory> getPageData(Map<String, Object> params);
    
}