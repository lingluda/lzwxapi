package com.maiyue.weixin.shiro;

import java.io.Serializable;
import javax.annotation.Resource;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.maiyue.weixin.utils.RedisUtil;

public class RedisSessionDAO extends EnterpriseCacheSessionDAO {

    private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);

    // session 在redis过期时间是30分钟30*60
    private static final long expireTime = 1800;

    private static final String prefix = "session_id_";

    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;

    // 创建session，保存到数据库
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        logger.debug("创建session:{}", session.getId());
        redisUtil.set(prefix + sessionId.toString(), session);
        return sessionId;
    }

    // 获取session
    @Override
    protected Session doReadSession(Serializable sessionId) {
        return (Session) redisUtil.get(prefix + sessionId);
    }

    
    // 更新session的最后一次访问时间
    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
        logger.debug("更新session:{}", session.getId());
        //过期session
        if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()){
            this.deleteSession(this.getSessionId(session.getId()));
        }else{
            this.updateSession(this.getSessionId(session.getId()),session);
        }
    }

    
    
    
    
    // 删除session
    @Override
    protected void doDelete(Session session) {
        logger.debug("删除session:{}", session.getId());
        super.doDelete(session);
        redisUtil.remove(prefix + session.getId().toString());
    }

    /**
     * 更新session
     * @param session
     */
    public Session updateSession(String sessionId, Session session){
        if (!redisUtil.exists(sessionId)) {
       	     redisUtil.set(sessionId, session,expireTime);
        }
        return session;
    }
    
    /**
     * 删除session
     * @param sessionId
     */
    public void deleteSession(String sessionId){
        redisUtil.remove(sessionId);
    }
    
    private String getSessionId(Serializable serializable){
        return prefix + serializable.toString();
    }
    
    
}
