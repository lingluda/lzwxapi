package com.maiyue.app.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.app.bean.DownHist;
import java.util.Map;

/**
 * DownHistService业务层
 * 2018/04/01
 */
public interface DownHistService extends BaseService<DownHist, String> {
	
	/**
     * 分页查询
     * @param offset 偏移量
     * @param pageSize 一页显示多少记录
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<DownHist> getPageData(Map<String, Object> params);
}