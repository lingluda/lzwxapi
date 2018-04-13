package com.maiyue.business.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.business.bean.Schedule;
import com.maiyue.business.mapper.ScheduleMapper;
import com.maiyue.business.service.ScheduleService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ScheduleService实现类
 * 2018/04/13
 */
@Service("scheduleService")
public class ScheduleServiceImpl extends BaseServiceImpl<Schedule, String> implements ScheduleService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private ScheduleMapper scheduleMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<Schedule, String> getMapper() {
        return scheduleMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<Schedule> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}