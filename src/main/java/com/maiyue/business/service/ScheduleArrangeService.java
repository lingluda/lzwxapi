package com.maiyue.business.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.business.bean.ScheduleArrange;
import com.maiyue.weixin.service.BaseService;
import java.util.List;
import java.util.Map;

/**
 * ScheduleArrangeService业务层
 * 2018/04/13
 */
public interface ScheduleArrangeService extends BaseService<ScheduleArrange, String> {
     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<ScheduleArrange> getPageData(Map<String, Object> params);
}