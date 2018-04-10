package com.maiyue.weixin.config;

import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.SessionValidationScheduler;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.mgt.SecurityManager; 
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import com.maiyue.weixin.redis.RedisCacheManager;
import com.maiyue.weixin.shiro.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ConfigurationProperties 注入配置时,需要配合@Value使用
 * 如果不使用,需要配置prefix,并且有get/set方法
 * yml只能配置在 application.yml中
 * properties 可以使用@PropertySource读取
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

    @SuppressWarnings("rawtypes")
	private Map filterChainDefinitionMap = new LinkedHashMap();

    /**
     * shiro过滤器
     * @param securityManager
     * @return
     */
    @SuppressWarnings("unchecked")
	@Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
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
    public RedisSessionDAO redisSessionDAO(){
        return new RedisSessionDAO();
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
    public RedisCacheManager redisCacheManager() {
        return new RedisCacheManager();
    }
    
    @Bean
    public SecurityManager securityManager(){
    	 DefaultWebSecurityManager manager = new DefaultWebSecurityManager();  
    	 manager.setRealm(myRealm());
    	 manager.setSessionManager(sessionManager());
    	 manager.setCacheManager(redisCacheManager());
        return manager;
    }
    
    /** 
     * 开启shiro aop注解支持. 
     * 使用代理方式;所以需要开启代码支持; 
     * @param securityManager 
     * @return 
     */  
    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(securityManager());
        return aasa;
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
    public SessionManager sessionManager(){
        MySessionManager sessionManager = new MySessionManager();
        //sessionManager.setSessionIdCookie(sessionIdCookie());//
        //sessionManager.setSessionIdCookieEnabled(true);
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

    
	@SuppressWarnings("rawtypes")
	public Map getFilterChainDefinitionMap() {
        return filterChainDefinitionMap;
    }

    @SuppressWarnings("rawtypes")
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
