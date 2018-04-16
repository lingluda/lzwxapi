package com.maiyue.weixin.business.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.business.bean.Teacher;
import com.maiyue.weixin.service.BaseService;
import java.util.List;
import java.util.Map;

/**
 * TeacherService业务层
 * 2018/04/16
 */
public interface TeacherService extends BaseService<Teacher, String> {
     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<Teacher> getPageData(Map<String, Object> params);
}