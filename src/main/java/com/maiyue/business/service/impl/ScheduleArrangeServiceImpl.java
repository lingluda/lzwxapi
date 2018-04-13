package com.maiyue.business.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.business.bean.ScheduleArrange;
import com.maiyue.business.mapper.ScheduleArrangeMapper;
import com.maiyue.business.service.ScheduleArrangeService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ScheduleArrangeService实现类
 * 2018/04/13
 */
@Service("scheduleArrangeService")
public class ScheduleArrangeServiceImpl extends BaseServiceImpl<ScheduleArrange, String> implements ScheduleArrangeService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private ScheduleArrangeMapper scheduleArrangeMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<ScheduleArrange, String> getMapper() {
        return scheduleArrangeMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<ScheduleArrange> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}