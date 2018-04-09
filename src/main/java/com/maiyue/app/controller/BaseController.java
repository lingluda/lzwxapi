package com.maiyue.app.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import com.maiyue.app.bean.UserInfo;
import com.maiyue.app.constant.Constant;

/**
 * Created by huang on 2017/1/6.
 */
public class BaseController{
	 
	 public UserInfo getCurrUser(){
	 	Object object = this.getSession().getAttribute(Constant.SESSION_MANAGER_USER_KEY);
	 	UserInfo muser = null;
        if(object != null){
        	muser = com.alibaba.fastjson.JSONObject.parseObject(object.toString(),UserInfo.class);
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
