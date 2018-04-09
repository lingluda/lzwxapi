package com.maiyue.weixin.mapper;

import com.maiyue.weixin.bean.SystemConfig;

/**
 * SystemConfigMweixiner
 * 2018/04/01
 */
public interface SystemConfigMapper extends BaseMapper<SystemConfig, String> {
	
	String findByConfigName(String configName);
}