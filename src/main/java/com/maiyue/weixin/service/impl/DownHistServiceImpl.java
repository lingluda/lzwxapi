package com.maiyue.app.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.app.bean.DownHist;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.mapper.BaseMapper;
import com.maiyue.app.mapper.DownHistMapper;
import com.maiyue.app.service.DownHistService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DownHistService实现类
 * 2018/04/01
 */
@Service("downHistService")
public class DownHistServiceImpl extends BaseServiceImpl<DownHist, String> implements DownHistService {
    
    @Autowired
    private DownHistMapper downHistMapper;

	@Override
	public PageInfo<DownHist> getPageData(Map<String, Object> params) {
		params = BusinessConstant.defaultState(DownHist.class,params,"state");
		return super.findByPage(params,(Integer)params.get("pageNum"), (Integer)params.get("pageSize"));
	}

	@Override
	public BaseMapper<DownHist, String> getMapper() {
		return downHistMapper;
	}

   
}