package com.maiyue.weixin.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Classes;
import com.maiyue.weixin.base.mapper.ClassesMapper;
import com.maiyue.weixin.base.service.ClassesService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassesService实现类
 * 2018/04/16
 */
@Service("classesService")
public class ClassesServiceImpl extends BaseServiceImpl<Classes, String> implements ClassesService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private ClassesMapper classesMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<Classes, String> getMapper() {
        return classesMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<Classes> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}