package com.maiyue.app.mapper;

import org.springframework.stereotype.Repository;

import com.maiyue.app.bean.UserInfo;

/**
 * UserInfoMapper
 * 2018/03/29
 */
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo, String> {
	
	 /**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	UserInfo getByUserName(String username);
    
}