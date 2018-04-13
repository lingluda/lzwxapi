package com.maiyue.weixin.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Area;
import com.maiyue.weixin.base.mapper.AreaMapper;
import com.maiyue.weixin.base.service.AreaService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AreaService实现类
 * 2018/04/13
 */
@Service("areaService")
public class AreaServiceImpl extends BaseServiceImpl<Area, String> implements AreaService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private AreaMapper areaMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<Area, String> getMapper() {
        return areaMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<Area> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}