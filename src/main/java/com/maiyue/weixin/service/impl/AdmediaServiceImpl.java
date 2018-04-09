package com.maiyue.app.service.impl;

import com.maiyue.app.bean.Admedia;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.mapper.AdmediaMapper;
import com.maiyue.app.mapper.BaseMapper;
import com.maiyue.app.service.AdmediaService;
import com.github.pagehelper.PageInfo;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AdmediaService实现类
 * 2018/03/29
 */
@Service("admediaService")
public class AdmediaServiceImpl extends BaseServiceImpl<Admedia, String> implements AdmediaService {
    
	/**
     * 注入Mapper
     */
    @Autowired
    private AdmediaMapper admediaMapper;

	@Override
	public PageInfo<Admedia> getPageData(Map<String, Object> params) {
		params = BusinessConstant.defaultState(Admedia.class, params, "state");
		return super.findByPage(params, (Integer)params.get("pageNum"), (Integer)params.get("pageSize"));
	}

	@Override
	public BaseMapper<Admedia, String> getMapper() {
		return admediaMapper;
	}

   
}