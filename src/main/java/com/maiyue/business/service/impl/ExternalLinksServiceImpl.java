package com.maiyue.business.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.business.bean.ExternalLinks;
import com.maiyue.business.mapper.ExternalLinksMapper;
import com.maiyue.business.service.ExternalLinksService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ExternalLinksService实现类
 * 2018/04/13
 */
@Service("externalLinksService")
public class ExternalLinksServiceImpl extends BaseServiceImpl<ExternalLinks, String> implements ExternalLinksService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private ExternalLinksMapper externalLinksMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<ExternalLinks, String> getMapper() {
        return externalLinksMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<ExternalLinks> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}