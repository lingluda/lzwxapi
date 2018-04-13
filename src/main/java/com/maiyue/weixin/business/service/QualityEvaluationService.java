package com.maiyue.weixin.business.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.business.bean.QualityEvaluation;
import com.maiyue.weixin.service.BaseService;
import java.util.List;
import java.util.Map;

/**
 * QualityEvaluationService业务层
 * 2018/04/13
 */
public interface QualityEvaluationService extends BaseService<QualityEvaluation, String> {
     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<QualityEvaluation> getPageData(Map<String, Object> params);
}