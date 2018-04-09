package com.maiyue.weixin.config;

import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.session.mgt.SessionValidationScheduler;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import com.maiyue.weixin.shiro.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ConfigurationProperties 注入配置时,需要配合@Value使用
 * 如果不使用,需要配置prefix,并且有get/set方法
 * yml只能配置在 weixinlication.yml中
 * properties 可以使用@PropertySource读取
 * Created by huang on 2017/12/25.
 */

@Configuration
@Component
@AutoConfigureAfter({MybatisConfig.class })
@ConfigurationProperties(prefix = "shiro")
public class ShiroConfig {

    private String loginUrl;
    private String successUrl;
    private String unauthorizedUrl;
    private Boolean deleteInvalidSessions;
    private Boolean sessionValidationSchedulerEnabled;
    private Long globalSessionTimeout;
    private Long sessionValidationInterval;

    private Map filterChainDefinitionMap = new LinkedHashMap();

    /**
     * shiro过滤器
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl(loginUrl);
        shiroFilterFactoryBean.setSuccessUrl(successUrl);
        shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(myCredentialsMatcher());
        return  myRealm;
    }

    /**
     * redis管理session
     * @return
     */
    @Bean
    public SessionDAO redisSessionDAO(){
        return new RedisSessionDao();
    }

    /**
     * 自定义的密码匹配器
     * @return
     */
    @Bean
    public SimpleCredentialsMatcher myCredentialsMatcher(){
        return new MyCredentialsMatcher();
    }

    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public SimpleCookie sessionIdCookie(){
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(-1);
        return simpleCookie;
    }


    /**
     * 使用序列化后的SessionManager
     * @return
     */
    @Bean
    public MySessionManager sessionManager(){
        MySessionManager sessionManager = new MySessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        sessionManager.setSessionFactory(sessionFactory());
        sessionManager.setGlobalSessionTimeout(globalSessionTimeout);
        sessionManager.setDeleteInvalidSessions(deleteInvalidSessions);
        sessionManager.setSessionValidationSchedulerEnabled(sessionValidationSchedulerEnabled);
        sessionManager.setSessionValidationScheduler(sessionValidationScheduler(sessionManager));
        return sessionManager;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean(name = "sessionFactory")
    public static ShiroSessionFactory sessionFactory() {
        return new ShiroSessionFactory();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    /**
     * 注入自定义的session调度器
     * @param sessionManager
     * @return
     */
    @Bean
    public SessionValidationScheduler sessionValidationScheduler(MySessionManager sessionManager){
        QuartzSessionValidationScheduler sessionValidationScheduler = new QuartzSessionValidationScheduler();
        sessionValidationScheduler.setSessionValidationInterval(sessionValidationInterval);
        sessionValidationScheduler.setSessionManager(validatingSessionManager(sessionManager));
        return sessionValidationScheduler;
    }

    /**
     * 注入自定义的ValidatingSessionManager
     * @param sessionManager
     * @return
     */
    @Bean
    public MyValidatingSessionManager validatingSessionManager(MySessionManager sessionManager){
        MyValidatingSessionManager validatingSessionManager = new MyValidatingSessionManager();
        validatingSessionManager.setSessionManager(sessionManager);
        return validatingSessionManager;
    }


    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    
	public Map getFilterChainDefinitionMap() {
        return filterChainDefinitionMap;
    }

    public void setFilterChainDefinitionMap(Map filterChainDefinitionMap) {
        this.filterChainDefinitionMap = filterChainDefinitionMap;
    }

    public String getUnauthorizedUrl() {
        return unauthorizedUrl;
    }

    public void setUnauthorizedUrl(String unauthorizedUrl) {
        this.unauthorizedUrl = unauthorizedUrl;
    }

    public Boolean getDeleteInvalidSessions() {
        return deleteInvalidSessions;
    }

    public void setDeleteInvalidSessions(Boolean deleteInvalidSessions) {
        this.deleteInvalidSessions = deleteInvalidSessions;
    }

    public Boolean getSessionValidationSchedulerEnabled() {
        return sessionValidationSchedulerEnabled;
    }

    public void setSessionValidationSchedulerEnabled(Boolean sessionValidationSchedulerEnabled) {
        this.sessionValidationSchedulerEnabled = sessionValidationSchedulerEnabled;
    }

    public Long getGlobalSessionTimeout() {
        return globalSessionTimeout;
    }

    public void setGlobalSessionTimeout(Long globalSessionTimeout) {
        this.globalSessionTimeout = globalSessionTimeout;
    }

    public Long getSessionValidationInterval() {
        return sessionValidationInterval;
    }

    public void setSessionValidationInterval(Long sessionValidationInterval) {
        this.sessionValidationInterval = sessionValidationInterval;
    }
}
