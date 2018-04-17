package com.maiyue.weixin.base.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Dept;
import com.maiyue.weixin.service.BaseService;
import java.util.List;
import java.util.Map;

/**
 * DeptService业务层
 * 2018/04/16
 */
public interface DeptService extends BaseService<Dept, String> {
     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<Dept> getPageData(Map<String, Object> params);

    Dept selectByCode(String deptCode);
}