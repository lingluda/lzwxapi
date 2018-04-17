package com.maiyue.weixin.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Dept;
import com.maiyue.weixin.base.mapper.DeptMapper;
import com.maiyue.weixin.base.service.DeptService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DeptService实现类
 * 2018/04/16
 */
@Service("deptService")
public class DeptServiceImpl extends BaseServiceImpl<Dept, String> implements DeptService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private DeptMapper deptMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<Dept, String> getMapper() {
        return deptMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<Dept> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }

    @Override
    public Dept selectByCode(String deptCode) {
        return deptMapper.selectByCode(deptCode);
    }
}