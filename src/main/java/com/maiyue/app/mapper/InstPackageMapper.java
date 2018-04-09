package com.maiyue.app.mapper;

import java.util.List;

import com.maiyue.app.bean.InstPackage;

/**
 * InstPackageMapper
 * 2018/03/29
 */
public interface InstPackageMapper extends BaseMapper<InstPackage, String> {
	
	 List<InstPackage> findByAppId(String appInfoId);
	 
	 List<InstPackage> findByUserId(String userId);
	 
}