package com.maiyue.weixin.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.bean.SystemConfig;
import com.maiyue.weixin.constant.BusinessConstant;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.mapper.SystemConfigMapper;
import com.maiyue.weixin.service.SystemConfigService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SystemConfigService实现类
 * 2018/04/01
 */
@Service("systemConfigService")
public class SystemConfigServiceImpl extends BaseServiceImpl<SystemConfig, String> implements SystemConfigService {
    
	/**
     * 注入Mweixiner
     */
    @Autowired
    private SystemConfigMapper systemConfigMapper;

	@Override
	public PageInfo<SystemConfig> getPageData(Map<String, Object> params) {
		params = BusinessConstant.defaultState(SystemConfig.class,params,"configState");
		return super.findByPage(params, (Integer)params.get("pageNum"), (Integer)params.get("pageSize"));
	}

	@Override
	public BaseMapper<SystemConfig, String> getMapper() {
		return systemConfigMapper;
	}

	@Override
	public String findByconfigName(String configName) {
		return systemConfigMapper.findByConfigName(configName);
	}

	

   
}