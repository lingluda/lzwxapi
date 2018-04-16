package com.maiyue.weixin.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Cities;
import com.maiyue.weixin.base.mapper.CitiesMapper;
import com.maiyue.weixin.base.service.CitiesService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * CitiesService实现类
 * 2018/04/13
 */
@Service("citiesService")
public class CitiesServiceImpl extends BaseServiceImpl<Cities, String> implements CitiesService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private CitiesMapper citiesMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<Cities, String> getMapper() {
        return citiesMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<Cities> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }

    @Override
    public List<Cities> findByProId(String proId){
        return citiesMapper.findByProId(proId);
    }
}