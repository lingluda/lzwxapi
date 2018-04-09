package com.maiyue.app.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.app.bean.Admedia;
import java.util.Map;

/**
 * AdmediaService业务层
 * 2018/03/29
 */
public interface AdmediaService extends BaseService<Admedia, String> {
    
	/***
     * 分页查询
     * @param params
     * @return
     */
    PageInfo<Admedia> getPageData(Map<String, Object> params);
}