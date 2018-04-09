package com.maiyue.app.service;

import com.maiyue.app.bean.AppPicture;
import com.github.pagehelper.PageInfo;
import java.util.Map;

/**
 * AppPictureService业务层
 * 2018/03/29
 */
public interface AppPictureService extends BaseService<AppPicture, String> {
    /**
     * 分页查询
     * @param offset 偏移量
     * @param pageSize 一页显示多少记录
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<AppPicture> getPageData(Map<String, Object> params);
}