package com.maiyue.weixin.base.mapper;

import com.maiyue.weixin.base.bean.User;
import com.maiyue.weixin.mapper.BaseMapper;

/**
 * UserMapper
 * 2018/04/09
 */
public interface UserMapper extends BaseMapper<User, String> {
	
	
	User getByUsername(String username);
	
	
}