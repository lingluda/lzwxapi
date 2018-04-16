package com.maiyue.weixin.base.service;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Major;
import com.maiyue.weixin.service.BaseService;
import java.util.List;
import java.util.Map;

/**
 * MajorService业务层
 * 2018/04/16
 */
public interface MajorService extends BaseService<Major, String> {
     
    /**
     * 分页查询
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<Major> getPageData(Map<String, Object> params);

    Major selectByCode(String majorCode);
}