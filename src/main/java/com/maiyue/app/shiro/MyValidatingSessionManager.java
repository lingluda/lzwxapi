package com.maiyue.app.shiro;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.AbstractValidatingSessionManager;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by huang on 2018/01/16.
 */
public class MyValidatingSessionManager extends AbstractValidatingSessionManager implements Serializable{

    private static final Logger log = LoggerFactory.getLogger(MyValidatingSessionManager.class);


    private static final long serialVersionUID = 8978566625374235381L;

    private MySessionManager sessionManager;

    public MySessionManager getSessionManager() {
        return sessionManager;
    }

    public void setSessionManager(MySessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
        Serializable sessionId = sessionKey.getSessionId();
        if(sessionId == null) {
            if(log.isDebugEnabled()) {
                log.debug("Unable to resolve session ID from SessionKey [{}].  Returning null to indicate a session could not be found.", sessionKey);
            }
            return null;
        } else {
            Session s = sessionManager.getSessionDAO().readSession(sessionId);
            if(s == null) {
                String msg = "Could not find session with ID [" + sessionId + "]";
                throw new UnknownSessionException(msg);
            } else {
                return s;
            }
        }
    }

    @Override
    protected Session doCreateSession(SessionContext sessionContext) throws AuthorizationException {

        Session session = sessionManager.getSessionFactory().createSession(sessionContext);
        if(log.isTraceEnabled()) {
            log.trace("Creating session for host {}", session.getHost());
        }
        this.create(session);
        return session;
    }

    protected void create(Session session) {
        if(log.isDebugEnabled()) {
            log.debug("Creating new EIS record for new session instance [" + session + "]");
        }

        sessionManager.getSessionDAO().create(session);
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Collection<Session> getActiveSessions() {
		Collection active = sessionManager.getSessionDAO().getActiveSessions();
        return (Collection)(active != null?active: Collections.emptySet());
    }
    
}
