package com.maiyue.app.service;

import com.maiyue.app.bean.HeadImage;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * HeadImageService业务层
 * 2018/03/29
 */
public interface HeadImageService extends BaseService<HeadImage, String> {
    
	/**
     * 分页查询
     * @param offset 偏移量
     * @param pageSize 一页显示多少记录
     * @param params 条件参数
     * @return 分页结果实体
     */ 
    PageInfo<HeadImage> getPageData(Map<String, Object> params);
    
    
    /***
     * 按用户ID查询用户头像
     * @param uid
     * @return
     */
    List<HeadImage> findByUserId(String uid);
    
    /***
     * 用户当前头像
     * @param uid
     * @return
     */
    HeadImage currentHead(String uid);
    
}