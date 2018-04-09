package com.maiyue.app.service;

import com.maiyue.app.bean.BrowHist;
import com.github.pagehelper.PageInfo;
import java.util.Map;

/**
 * BrowHistService业务层
 * 2018/03/29
 */
public interface BrowHistService extends BaseService<BrowHist, String> {
    /**
     * 分页查询
     * @param offset 偏移量
     * @param pageSize 一页显示多少记录
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<BrowHist> getPageData(Map<String, Object> params);
}