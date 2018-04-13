package com.maiyue.weixin.base.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Provinces;
import com.maiyue.weixin.service.BaseService;
import java.util.List;
import java.util.Map;

/**
 * ProvincesService业务层
 * 2018/04/13
 */
public interface ProvincesService extends BaseService<Provinces, String> {
     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<Provinces> getPageData(Map<String, Object> params);
}