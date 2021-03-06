package com.maiyue.weixin.business.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.business.bean.Teacher;
import com.maiyue.weixin.business.mapper.TeacherMapper;
import com.maiyue.weixin.business.service.TeacherService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TeacherService实现类
 * 2018/04/16
 */
@Service("teacherService")
public class TeacherServiceImpl extends BaseServiceImpl<Teacher, String> implements TeacherService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<Teacher, String> getMapper() {
        return teacherMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<Teacher> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}