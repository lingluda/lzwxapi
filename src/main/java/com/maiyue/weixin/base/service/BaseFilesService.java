package com.maiyue.weixin.base.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.BaseFiles;
import com.maiyue.weixin.service.BaseService;
import java.util.Map;

/**
 * BaseFilesService业务层
 * 2018/04/12
 */
public interface BaseFilesService extends BaseService<BaseFiles, String> {
     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<BaseFiles> getPageData(Map<String, Object> params);
}