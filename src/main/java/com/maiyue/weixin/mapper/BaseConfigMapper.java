package com.maiyue.weixin.mapper;

import com.maiyue.weixin.bean.BaseConfig;

/**
 * SystemConfigMweixiner
 * 2018/04/01
 */
public interface BaseConfigMapper extends BaseMapper<BaseConfig, String> {
	
	String findByConfigName(String configName);
}