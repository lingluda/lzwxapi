package com.maiyue.app.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.app.bean.Adinfo;
import java.util.Map;

/**
 * AdinfoService业务层
 * 2018/03/29
 */
public interface AdinfoService extends BaseService<Adinfo, String> {
    
	/***
     * 分页查询
     * @param params
     * @return
     */
    PageInfo<Adinfo> getPageData(Map<String, Object> params);

}