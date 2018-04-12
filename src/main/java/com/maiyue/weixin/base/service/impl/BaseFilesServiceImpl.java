package com.maiyue.weixin.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.BaseFiles;
import com.maiyue.weixin.base.mapper.BaseFilesMapper;
import com.maiyue.weixin.base.service.BaseFilesService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BaseFilesService实现类
 * 2018/04/12
 */
@Service("baseFilesService")
public class BaseFilesServiceImpl extends BaseServiceImpl<BaseFiles, String> implements BaseFilesService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private BaseFilesMapper baseFilesMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<BaseFiles, String> getMapper() {
        return baseFilesMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<BaseFiles> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}