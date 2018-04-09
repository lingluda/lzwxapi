package com.maiyue.app.service.impl;

import com.maiyue.app.bean.AppPicture;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.mapper.AppPictureMapper;
import com.maiyue.app.mapper.BaseMapper;
import com.maiyue.app.service.AppPictureService;
import com.github.pagehelper.PageInfo;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AppPictureService实现类
 * 2018/03/29
 */
@Service("appPictureService")
public class AppPictureServiceImpl extends BaseServiceImpl<AppPicture, String> implements AppPictureService {
    /**
     * 注入Mapper
     */
    @Autowired
    private AppPictureMapper appPictureMapper;

	@Override
	public BaseMapper<AppPicture, String> getMapper() {
		return appPictureMapper;
	}

	@Override
	public PageInfo<AppPicture> getPageData(Map<String, Object> params) {
		params = BusinessConstant.defaultState(AppPicture.class, params, "pictureState");
		return super.findByPage(params, (Integer)params.get("pageNum"), (Integer)params.get("pageSize"));
	}

    
    
}