package com.maiyue.weixin.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.bean.BaseConfig;
import com.maiyue.weixin.constant.BusinessConstant;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.mapper.BaseConfigMapper;
import com.maiyue.weixin.service.BaseConfigService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SystemConfigService实现类
 * 2018/04/01
 */
@Service("baseConfigService")
public class BaseConfigServiceImpl extends BaseServiceImpl<BaseConfig, String> implements BaseConfigService {
    
	/**
     * 注入Mweixiner
     */
    @Autowired
    private BaseConfigMapper baseConfigMapper;

	@Override
	public PageInfo<BaseConfig> getPageData(Map<String, Object> params) {
		params = BusinessConstant.defaultState(BaseConfig.class,params,"configState");
		return super.findByPage(params, (Integer)params.get("pageNum"), (Integer)params.get("pageSize"));
	}

	@Override
	public BaseMapper<BaseConfig, String> getMapper() {
		return baseConfigMapper;
	}

	@Override
	public String findByconfigName(String configName) {
		return baseConfigMapper.findByConfigName(configName);
	}

	

   
}