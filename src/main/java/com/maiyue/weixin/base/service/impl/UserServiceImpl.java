package com.maiyue.weixin.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.User;
import com.maiyue.weixin.base.mapper.UserMapper;
import com.maiyue.weixin.base.service.UserService;
import com.maiyue.weixin.mapper.BaseMapper;
import com.maiyue.weixin.service.impl.BaseServiceImpl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService实现类
 * 2018/04/09
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {
    /**
     * 注入Mapper
     */
    @Autowired
    private UserMapper userMapper;

	@Override
	public PageInfo<User> getPageData(Map<String, Object> params) {
		return null;
	}

	@Override
	public BaseMapper<User, String> getMapper() {
		// TODO Auto-generated method stub
		return userMapper;
	}

	@Override
	public User findByUsername(String username) {
		return userMapper.getByUsername(username);
	}

    
}