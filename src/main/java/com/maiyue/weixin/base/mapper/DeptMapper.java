package com.maiyue.weixin.base.mapper;

import com.maiyue.weixin.base.bean.Dept;
import com.maiyue.weixin.mapper.BaseMapper;

/**
 * DeptMapper
 * 2018/04/16
 */
public interface DeptMapper extends BaseMapper<Dept, String> {

    Dept selectByCode(String deptCode);
}