package com.maiyue.weixin.business.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.business.bean.Student;
import com.maiyue.weixin.service.BaseService;
import java.util.List;
import java.util.Map;

/**
 * StudentService业务层
 * 2018/04/16
 */
public interface StudentService extends BaseService<Student, String> {
     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<Student> getPageData(Map<String, Object> params);
}