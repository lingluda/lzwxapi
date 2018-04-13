package com.maiyue.business.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.business.bean.WorkLog;
import com.maiyue.business.mapper.WorkLogMapper;
import com.maiyue.business.service.WorkLogService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * WorkLogService实现类
 * 2018/04/13
 */
@Service("workLogService")
public class WorkLogServiceImpl extends BaseServiceImpl<WorkLog, String> implements WorkLogService {
     
    /**
     * 注入Mapper
     */
    @Autowired
    private WorkLogMapper workLogMapper;

    /**
     * getMapper
     * @return 返回实体的DAO
     */ 
    @Override
    public BaseMapper<WorkLog, String> getMapper() {
        return workLogMapper;
    }

     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    @Override
    public PageInfo<WorkLog> getPageData(Map<String, Object> params) {
        return super.findByPage(params);
    }
}