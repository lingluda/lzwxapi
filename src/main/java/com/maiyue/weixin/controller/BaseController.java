package com.maiyue.weixin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.maiyue.weixin.base.bean.User;
import com.maiyue.weixin.constant.Constant;
import com.maiyue.weixin.redis.KryoUtil;


@RestController
public class BaseController{
	
	private static Logger logger = LoggerFactory.getLogger(BaseController.class);
	 
	 /***
	  * 当前登陆用户
	  * @return
	  */
	 public User getCurrUser(){
         return this.getSessionAttribute(Constant.SESSION_MANAGER_USER_KEY, User.class);
	}

    /***
	* 获得session
	* @return
	*/
    public Object getSessionAttribute(String key){
    	Session session = this.getSession();
        if(session != null){
        	if(session.getAttribute(key) != null){
            	return session.getAttribute(key);
            }
        }else{
        	logger.debug("<当前session为空>");
        }
        return null;
    }
    
    
    
    /***
	* 获得session
	* @return
	*/
	public <T> T getSessionAttribute(String key,Class<T> clazz){
		Session session = this.getSession();
        if(session != null){
        	 Object object = session.getAttribute(key);
             if(object != null){
             	return (T) KryoUtil.readObjectFromByteArray(KryoUtil.writeObjectToByteArray(object), clazz);
             }
        }else{
        	logger.debug("<当前session为空>");
        }
        return null;
    }
    

    /***
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * @param key
     * @param value
     */
    public void setSession(Object key, Object value){
    	Session session = this.getSession();
        if(session != null){
           session.setAttribute(key, value);
        }else{
        	logger.debug("<当前session为空>");
        }
    }

    
    /***
     * 获取Session
     * @return
     */
    private Session getSession(){
    	Subject subject = SecurityUtils.getSubject();
    	if(subject != null){
    		return subject.getSession();
    	}
		return null;
    }
    
    
}
