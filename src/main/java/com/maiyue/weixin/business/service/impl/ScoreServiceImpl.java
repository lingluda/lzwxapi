package com.maiyue.weixin.business.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.business.bean.Score;
import com.maiyue.weixin.business.mapper.ScoreMapper;
import com.maiyue.weixin.business.service.ScoreService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ScoreService实现类
 * 2018/04/13
 */
@Service("scoreService")
public class ScoreServiceImpl extends BaseServiceImpl<Score, String> implements ScoreService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private ScoreMapper scoreMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<Score, String> getMapper() {
        return scoreMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<Score> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}