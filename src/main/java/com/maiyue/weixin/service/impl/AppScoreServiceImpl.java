package com.maiyue.app.service.impl;

import com.maiyue.app.bean.AppScore;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.mapper.AppScoreMapper;
import com.maiyue.app.mapper.BaseMapper;
import com.maiyue.app.service.AppScoreService;
import com.github.pagehelper.PageInfo;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AppScoreService实现类
 * 2018/03/29
 */
@Service("appScoreService")
public class AppScoreServiceImpl extends BaseServiceImpl<AppScore, String> implements AppScoreService {
   
	
	/**
     * 注入Mapper
     */
    @Autowired
    private AppScoreMapper appScoreMapper;

    

	@Override
	public BaseMapper<AppScore, String> getMapper() {
		return appScoreMapper;
	}



	@Override
	public PageInfo<AppScore> getPageData(Map<String, Object> params) {
		params = BusinessConstant.defaultState(AppScore.class, params, "state");
		return super.findByPage(params, (Integer)params.get("pageNum"), (Integer)params.get("pageSize"));
	}
	
	
	
}