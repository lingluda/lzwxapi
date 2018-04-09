package com.maiyue.app.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.app.bean.Adinfo;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.mapper.AdinfoMapper;
import com.maiyue.app.mapper.BaseMapper;
import com.maiyue.app.service.AdinfoService;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * AdinfoService实现类
 * 2018/03/29
 */
@Service(value = "adinfoService")
public class AdinfoServiceImpl extends BaseServiceImpl<Adinfo, String> implements AdinfoService {
    
	/**
     * 注入Mapper
     */
    @Resource(name="adinfoMapper")
    private AdinfoMapper adinfoMapper;

	@Override
	public BaseMapper<Adinfo, String> getMapper() {
		return adinfoMapper;
	}
	
	@Override
	public PageInfo<Adinfo> getPageData(Map<String, Object> params) {
		params = BusinessConstant.defaultState(Adinfo.class, params, "state");
		return super.findByPage(params, (Integer)params.get("pageNum"), (Integer)params.get("pageSize"));
	}
	
	
	
	
	
	
}