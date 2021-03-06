package com.maiyue.weixin.shiro;

import java.io.Serializable;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

/**
 * 实现DefaultWebSessionManager的序列化
 * 自定义session调度器后,quartz 2.x版本以上放入JobDataMap需要序列化SessionManager
 * Created by huang on 2018/01/16.
 */
public class MySessionManager extends DefaultWebSessionManager implements Serializable{

	private static final long serialVersionUID = 1306070058364744798L;
	
}
