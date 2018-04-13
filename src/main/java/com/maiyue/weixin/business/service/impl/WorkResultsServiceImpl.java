package com.maiyue.weixin.business.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.business.bean.WorkResults;
import com.maiyue.weixin.business.mapper.WorkResultsMapper;
import com.maiyue.weixin.business.service.WorkResultsService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * WorkResultsService实现类
 * 2018/04/13
 */
@Service("workResultsService")
public class WorkResultsServiceImpl extends BaseServiceImpl<WorkResults, String> implements WorkResultsService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private WorkResultsMapper workResultsMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<WorkResults, String> getMapper() {
        return workResultsMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<WorkResults> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}