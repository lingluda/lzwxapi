package com.maiyue.app.service.impl;

import com.maiyue.app.bean.BrowHist;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.mapper.BaseMapper;
import com.maiyue.app.mapper.BrowHistMapper;
import com.maiyue.app.service.BrowHistService;
import com.github.pagehelper.PageInfo;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BrowHistService实现类
 * 2018/03/29
 */
@Service("browHistService")
public class BrowHistServiceImpl extends BaseServiceImpl<BrowHist, String> implements BrowHistService {
    
	/**
     * 注入Mapper
     */
    @Autowired
    private BrowHistMapper browHistMapper;

    
	@Override
	public PageInfo<BrowHist> getPageData(Map<String, Object> params) {
		params = BusinessConstant.defaultState(BrowHist.class, params, "state");
		return super.findByPage(params,(Integer)params.get("pageNum"),(Integer)params.get("pageSize"));
	}

	@Override
	public BaseMapper<BrowHist, String> getMapper() {
		return browHistMapper;
	}

	
	
    
}