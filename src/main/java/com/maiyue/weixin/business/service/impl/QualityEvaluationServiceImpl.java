package com.maiyue.weixin.business.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.business.bean.QualityEvaluation;
import com.maiyue.weixin.business.mapper.QualityEvaluationMapper;
import com.maiyue.weixin.business.service.QualityEvaluationService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * QualityEvaluationService实现类
 * 2018/04/13
 */
@Service("qualityEvaluationService")
public class QualityEvaluationServiceImpl extends BaseServiceImpl<QualityEvaluation, String> implements QualityEvaluationService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private QualityEvaluationMapper qualityEvaluationMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<QualityEvaluation, String> getMapper() {
        return qualityEvaluationMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<QualityEvaluation> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}