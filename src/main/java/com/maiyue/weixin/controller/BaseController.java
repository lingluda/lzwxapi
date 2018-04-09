package com.maiyue.weixin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.maiyue.weixin.base.bean.User;
import com.maiyue.weixin.constant.Constant;

/**
 * Created by huang on 2017/1/6.
 */
public class BaseController{
	 
	 public User getCurrUser(){
	 	Object object = this.getSession().getAttribute(Constant.SESSION_MANAGER_USER_KEY);
	 	User muser = null;
        if(object != null){
        	muser = com.alibaba.fastjson.JSONObject.parseObject(object.toString(),User.class);
        }
        return muser;
	  }

	
	
   /***
	* 获得session
	* @return
	*/
    public Session getSession(){
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser.getSession();
    }

   

    /***
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * @param key
     * @param value
     */
    public void setSession(Object key, Object value){
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser){
            Session session = currentUser.getSession();
            if(null != session){
                session.setAttribute(key, value);
            }
        }
    }

}
