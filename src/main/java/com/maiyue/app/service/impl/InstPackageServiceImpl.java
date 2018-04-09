package com.maiyue.app.service.impl;

import com.maiyue.app.bean.InstPackage;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.mapper.BaseMapper;
import com.maiyue.app.mapper.InstPackageMapper;
import com.maiyue.app.service.InstPackageService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * InstPackageService实现类
 * 2018/03/29
 */
@Service("instPackageService")
public class InstPackageServiceImpl extends BaseServiceImpl<InstPackage, String> implements InstPackageService {
   
	
    @Autowired
    private InstPackageMapper instPackageMapper;

	@Override
	public PageInfo<InstPackage> getPageData(Map<String, Object> params) {
		params = BusinessConstant.defaultState(InstPackage.class,params,"installState");
		return super.findByPage(params, (Integer)params.get("pageNum"), (Integer)params.get("pageSize"));
	}

	@Override
	public BaseMapper<InstPackage, String> getMapper() {
		return instPackageMapper;
	}

	@Override
	public List<InstPackage> findByAppId(String appInfoId) {
		if(StringUtils.isNotBlank(appInfoId)){
			return instPackageMapper.findByAppId(appInfoId);
		}
		return null;
	}

	@Override
	public List<InstPackage> findByUserId(String userId) {
		if(StringUtils.isNotBlank(userId)){
			return instPackageMapper.findByUserId(userId);
		}
		return null;
	}

   
    
    
    
}