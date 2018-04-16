package com.maiyue.weixin.base.mapper;

import com.maiyue.weixin.base.bean.Area;
import com.maiyue.weixin.mapper.BaseMapper;
import java.util.List;
/**
 * AreaMapper
 * 2018/04/13
 */
public interface AreaMapper extends BaseMapper<Area, String> {

    List<Area> selectByCityId(String cityId);
}