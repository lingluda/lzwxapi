package com.maiyue.weixin.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Provinces;
import com.maiyue.weixin.base.mapper.ProvincesMapper;
import com.maiyue.weixin.base.service.ProvincesService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProvincesService实现类
 * 2018/04/13
 */
@Service("provincesService")
public class ProvincesServiceImpl extends BaseServiceImpl<Provinces, String> implements ProvincesService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private ProvincesMapper provincesMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<Provinces, String> getMapper() {
        return provincesMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<Provinces> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}