package com.maiyue.app.service;

import com.maiyue.app.bean.Admodule;
import com.github.pagehelper.PageInfo;
import java.util.Map;

/**
 * AdmoduleService业务层
 * 2018/03/29
 */
public interface AdmoduleService extends BaseService<Admodule, String> {
    
	/***
     * 分页查询
     * @param params
     * @return
     */
    PageInfo<Admodule> getPageData(Map<String, Object> params);
}