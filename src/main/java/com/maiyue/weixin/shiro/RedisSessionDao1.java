package com.maiyue.weixin.shiro;

import com.maiyue.weixin.utils.RedisUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by huang on 2017/1/9.
 */

public class RedisSessionDao implements SessionDAO {

    private SessionIdGenerator sessionIdGenerator = new JavaUuidSessionIdGenerator();

    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;

    @Override
    public Serializable create(Session session) {
        Serializable sessionId = generateSessionId(session);//创建session
        this.verifySessionId(sessionId);//验证sessionid
        this.assignSessionId(session,sessionId);//设置sessionId
        this.saveSession(this.getSessionId(session.getId()),session);
        return session.getId();
    }

    @Override
    public Session readSession(Serializable sessionId) throws UnknownSessionException {
        return this.getSession(this.getSessionId(sessionId));
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        //过期session
        if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()){
            this.deleteSession(this.getSessionId(session.getId()));
        }else{
            this.updateSession(this.getSessionId(session.getId()),session);
        }
    }

    @Override
    public void delete(Session session) {
        this.deleteSession(this.getSessionId(session.getId()));
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Collection<Session> sessionList = new ArrayList<Session>();
        return sessionList;
    }

    /**
     * 删除session
     * @param sessionId
     */
    public void deleteSession(String sessionId){
        redisUtil.remove(sessionId);
    }

    /**
     * 保存session
     * @param sessionId
     * @param session
     */
    public Session saveSession(String sessionId, Session session){
        redisUtil.set(sessionId,session);
        return session;
    }

    /**
     * 更新session
     * @param session
     */
    public Session updateSession(String sessionId, Session session){
        redisUtil.set(sessionId,session);
        return session;
    }

    public Session getSession(String sessionId){
        Object obj = redisUtil.get(sessionId);
        return (Session) obj;
    }

    @SuppressWarnings("unused")
	private SessionIdGenerator getSessionIdGenerator() {
        return this.sessionIdGenerator;
    }

    public void setSessionIdGenerator(SessionIdGenerator sessionIdGenerator) {
        this.sessionIdGenerator = sessionIdGenerator;
    }


    private Serializable generateSessionId(Session session) {
        if(this.sessionIdGenerator == null) {
            String msg = "sessionIdGenerator attribute has not been configured.";
            throw new IllegalStateException(msg);
        } else {
            return this.sessionIdGenerator.generateId(session);
        }
    }

    private void assignSessionId(Session session, Serializable sessionId) {
        ((SimpleSession)session).setId(sessionId);
    }

    private void verifySessionId(Serializable sessionId) {
        if(sessionId == null) {
            String msg = "sessionId returned from doCreate implementation is null.  Please verify the implementation.";
            throw new IllegalStateException(msg);
        }
    }

    private String getSessionId(Serializable serializable){
        return "session_id_"+serializable.toString();
    }
}
