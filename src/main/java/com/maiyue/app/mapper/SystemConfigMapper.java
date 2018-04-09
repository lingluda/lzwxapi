package com.maiyue.app.mapper;

import com.maiyue.app.bean.SystemConfig;

/**
 * SystemConfigMapper
 * 2018/04/01
 */
public interface SystemConfigMapper extends BaseMapper<SystemConfig, String> {
	
	String findByConfigName(String configName);
}