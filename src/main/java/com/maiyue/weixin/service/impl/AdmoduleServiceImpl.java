package com.maiyue.app.service.impl;

import com.maiyue.app.bean.Admodule;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.mapper.AdmoduleMapper;
import com.maiyue.app.mapper.BaseMapper;
import com.maiyue.app.service.AdmoduleService;
import com.github.pagehelper.PageInfo;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AdmoduleService实现类
 * 2018/03/29
 */
@Service("admoduleService")
public class AdmoduleServiceImpl extends BaseServiceImpl<Admodule, String> implements AdmoduleService {
   
	/**
     * 注入Mapper
     */
    @Autowired
    private AdmoduleMapper admoduleMapper;

	@Override
	public BaseMapper<Admodule, String> getMapper() {
		return admoduleMapper;
	}

	@Override
	public PageInfo<Admodule> getPageData(Map<String, Object> params) {
		params = BusinessConstant.defaultState(Admodule.class, params, "state");
		return super.findByPage(params, (Integer)params.get("pageNum"), (Integer)params.get("pageSize"));
	}
	
	
	
}