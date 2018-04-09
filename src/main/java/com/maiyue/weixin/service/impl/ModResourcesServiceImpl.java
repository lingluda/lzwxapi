package com.maiyue.app.service.impl;

import com.maiyue.app.bean.ModResources;
import com.maiyue.app.mapper.BaseMapper;
import com.maiyue.app.mapper.ModResourcesMapper;
import com.maiyue.app.service.ModResourcesService;
import com.github.pagehelper.PageInfo;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ModResourcesService实现类
 * 2018/03/29
 */
@Service("modResourcesService")
public class ModResourcesServiceImpl extends BaseServiceImpl<ModResources, String> implements ModResourcesService {
    /**
     * 注入Mapper
     */
    @Autowired
    private ModResourcesMapper modResourcesMapper;

	@Override
	public PageInfo<ModResources> getPageData(Map<String, Object> params) {
		return super.findByPage(params,(Integer)params.get("pageNum"),(Integer)params.get("pageSize"));
	}

	@Override
	public BaseMapper<ModResources, String> getMapper() {
		return modResourcesMapper;
	}

    
}