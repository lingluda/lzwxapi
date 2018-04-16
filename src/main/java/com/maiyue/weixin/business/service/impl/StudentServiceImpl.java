package com.maiyue.weixin.business.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.business.bean.Student;
import com.maiyue.weixin.business.mapper.StudentMapper;
import com.maiyue.weixin.business.service.StudentService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * StudentService实现类
 * 2018/04/16
 */
@Service("studentService")
public class StudentServiceImpl extends BaseServiceImpl<Student, String> implements StudentService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private StudentMapper studentMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<Student, String> getMapper() {
        return studentMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<Student> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}