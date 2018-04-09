package com.maiyue.app.service.impl;

import com.maiyue.app.bean.AppCategory;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.mapper.AppCategoryMapper;
import com.maiyue.app.mapper.BaseMapper;
import com.maiyue.app.service.AppCategoryService;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AppCategoryService实现类
 * 2018/03/29
 */
@Service("appCategoryService")
public class AppCategoryServiceImpl extends BaseServiceImpl<AppCategory, String> implements AppCategoryService {
    /**
     * 注入Mapper
     */
    @Autowired
    private AppCategoryMapper appCategoryMapper;

    

	@Override
	public BaseMapper<AppCategory, String> getMapper() {
		return appCategoryMapper;
	}



	@Override
	public PageInfo<AppCategory> getPageData(Map<String, Object> params) {
		params = BusinessConstant.defaultState(AppCategory.class,params,"state");
		return super.findByPage(params,(Integer)params.get("pageNum"), (Integer)params.get("pageSize"));
	}


	@Override
	public List<AppCategory> findAll(Map<String, Object> params) {
		return super.findAll(params);
	}
	
	
}