package com.maiyue.app.service.impl;

import com.maiyue.app.bean.AppInfo;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.mapper.AppInfoMapper;
import com.maiyue.app.mapper.BaseMapper;
import com.maiyue.app.service.AppInfoService;
import com.github.pagehelper.PageInfo;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AppInfoService实现类
 * 2018/03/29
 */
@Service("appInfoService")
public class AppInfoServiceImpl extends BaseServiceImpl<AppInfo, String> implements AppInfoService {
    
	/**
     * 注入Mapper
     */
    @Autowired
    private AppInfoMapper appInfoMapper;

	@Override
	public PageInfo<AppInfo> getPageData(Map<String, Object> params) {
		params = BusinessConstant.defaultState(AppInfo.class,params,"appState");
		return super.findByPage(params, (Integer)params.get("pageNum"), (Integer)params.get("pageSize"));
	}

	
	
	
	@Override
	public BaseMapper<AppInfo, String> getMapper() {
		return appInfoMapper;
	}

    
}