package com.maiyue.weixin.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Major;
import com.maiyue.weixin.base.mapper.MajorMapper;
import com.maiyue.weixin.base.service.MajorService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MajorService实现类
 * 2018/04/16
 */
@Service("majorService")
public class MajorServiceImpl extends BaseServiceImpl<Major, String> implements MajorService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private MajorMapper majorMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<Major, String> getMapper() {
        return majorMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<Major> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }

    @Override
    public Major selectByCode(String majorCode) {
        return majorMapper.selectByCode(majorCode);
    }
}