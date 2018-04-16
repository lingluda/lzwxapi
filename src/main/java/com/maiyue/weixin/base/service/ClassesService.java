package com.maiyue.weixin.base.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Classes;
import com.maiyue.weixin.service.BaseService;
import java.util.List;
import java.util.Map;

/**
 * ClassesService业务层
 * 2018/04/16
 */
public interface ClassesService extends BaseService<Classes, String> {
     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<Classes> getPageData(Map<String, Object> params);
}