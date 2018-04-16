package com.maiyue.weixin.base.mapper;

import com.maiyue.weixin.base.bean.Cities;
import com.maiyue.weixin.mapper.BaseMapper;
import java.util.List;

/**
 * CitiesMapper
 * 2018/04/13
 */
public interface CitiesMapper extends BaseMapper<Cities, String> {

    List<Cities> findByProId(String proId);
}