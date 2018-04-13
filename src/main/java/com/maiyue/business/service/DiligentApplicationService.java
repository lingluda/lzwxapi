package com.maiyue.business.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.business.bean.DiligentApplication;
import com.maiyue.weixin.service.BaseService;
import java.util.List;
import java.util.Map;

/**
 * DiligentApplicationService业务层
 * 2018/04/13
 */
public interface DiligentApplicationService extends BaseService<DiligentApplication, String> {
     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<DiligentApplication> getPageData(Map<String, Object> params);
}