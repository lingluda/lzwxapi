package com.maiyue.weixin.business.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.business.bean.Schedule;
import com.maiyue.weixin.service.BaseService;
import java.util.List;
import java.util.Map;

/**
 * ScheduleService业务层
 * 2018/04/13
 */
public interface ScheduleService extends BaseService<Schedule, String> {
     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<Schedule> getPageData(Map<String, Object> params);
}