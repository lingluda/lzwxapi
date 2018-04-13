package com.maiyue.weixin.business.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.business.bean.DiligentStudy;
import com.maiyue.weixin.business.mapper.DiligentStudyMapper;
import com.maiyue.weixin.business.service.DiligentStudyService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DiligentStudyService实现类
 * 2018/04/13
 */
@Service("diligentStudyService")
public class DiligentStudyServiceImpl extends BaseServiceImpl<DiligentStudy, String> implements DiligentStudyService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private DiligentStudyMapper diligentStudyMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<DiligentStudy, String> getMapper() {
        return diligentStudyMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<DiligentStudy> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}