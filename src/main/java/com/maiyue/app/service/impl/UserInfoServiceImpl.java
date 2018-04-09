package com.maiyue.app.service.impl;

import com.maiyue.app.bean.UserInfo;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.mapper.BaseMapper;
import com.maiyue.app.mapper.UserInfoMapper;
import com.maiyue.app.service.UserInfoService;
import com.github.pagehelper.PageInfo;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserInfoService实现类
 * 2018/03/29
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo, String> implements UserInfoService {
    /**
     * 注入Mapper
     */
    @Autowired
    private UserInfoMapper userInfoMapper;

    
	@Override
	public PageInfo<UserInfo> getPageData(Map<String, Object> params) {
		params = BusinessConstant.defaultState(UserInfo.class, params,"state");
		return super.findByPage(params, (Integer)params.get("pageNum"),(Integer)params.get("pageSize"));
	}

	@Override
	public BaseMapper<UserInfo, String> getMapper() {
		return userInfoMapper;
	}

	@Override
	public UserInfo getByUserName(String username) {
		return userInfoMapper.getByUserName(username);
	}

   
}