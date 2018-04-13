package com.maiyue.weixin.business.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.business.bean.DiligentApplication;
import com.maiyue.weixin.business.mapper.DiligentApplicationMapper;
import com.maiyue.weixin.business.service.DiligentApplicationService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DiligentApplicationService实现类
 * 2018/04/13
 */
@Service("diligentApplicationService")
public class DiligentApplicationServiceImpl extends BaseServiceImpl<DiligentApplication, String> implements DiligentApplicationService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private DiligentApplicationMapper diligentApplicationMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<DiligentApplication, String> getMapper() {
        return diligentApplicationMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<DiligentApplication> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}