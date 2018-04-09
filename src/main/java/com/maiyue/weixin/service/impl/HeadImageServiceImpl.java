package com.maiyue.app.service.impl;

import com.maiyue.app.bean.HeadImage;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.mapper.BaseMapper;
import com.maiyue.app.mapper.HeadImageMapper;
import com.maiyue.app.service.HeadImageService;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * HeadImageService实现类
 * 2018/03/29
 */
@Service("headImageService")
public class HeadImageServiceImpl extends BaseServiceImpl<HeadImage, String> implements HeadImageService {
    
	/**
     * 注入Mapper
     */
    @Autowired
    private HeadImageMapper headImageMapper;

    
	@Override
	public PageInfo<HeadImage> getPageData(Map<String, Object> params) {
		params = BusinessConstant.defaultState(HeadImage.class, params, "state");
		return super.findByPage(params, (Integer)params.get("pageNum"),  (Integer)params.get("pageSize"));
	}

	
	@Override
	public BaseMapper<HeadImage, String> getMapper() {
		return headImageMapper;
	}


	@Override
	public List<HeadImage> findByUserId(String uid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", uid);
		params = BusinessConstant.defaultState(HeadImage.class, params, "state");
		PageInfo<HeadImage> list = super.findByPage(params, (Integer)params.get("pageNum"),(Integer)params.get("pageSize"));
		return list.getList();
	}


	@Override
	public HeadImage currentHead(String userId) {
		return headImageMapper.getCurrentHead(userId);
	}

   
    
    
    
}