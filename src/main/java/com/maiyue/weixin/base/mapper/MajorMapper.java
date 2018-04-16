package com.maiyue.weixin.base.mapper;

import com.maiyue.weixin.base.bean.Major;
import com.maiyue.weixin.mapper.BaseMapper;

import java.util.List;

/**
 * MajorMapper
 * 2018/04/16
 */
public interface MajorMapper extends BaseMapper<Major, String> {

    Major selectByCode(String majorCode);
}