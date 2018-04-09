package com.maiyue.app.service.impl;

import com.maiyue.app.bean.AppReview;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.mapper.AppReviewMapper;
import com.maiyue.app.mapper.BaseMapper;
import com.maiyue.app.service.AppReviewService;
import com.github.pagehelper.PageInfo;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AppReviewService实现类
 * 2018/03/29
 */
@Service("appReviewService")
public class AppReviewServiceImpl extends BaseServiceImpl<AppReview, String> implements AppReviewService {
    
	/**
     * 注入Mapper
     */
    @Autowired
    private AppReviewMapper appReviewMapper;

    
	@Override
	public PageInfo<AppReview> getPageData(Map<String, Object> params) {
		params = BusinessConstant.defaultState(AppReview.class, params, "state");
		return super.findByPage(params, (Integer)params.get("pageNum"), (Integer)params.get("pageSize"));
	}

	@Override
	public BaseMapper<AppReview, String> getMapper() {
		return appReviewMapper;
	}

	
	
    
}