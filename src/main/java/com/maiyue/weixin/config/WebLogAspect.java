package com.maiyue.weixin.config;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/***
 * AOP 统一 日志收集
 * @author Admin
 */
@Aspect
@Component
public class WebLogAspect {
	
		
	protected static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

	/***
	 * 切入点 1
	 */
	//@Order(1) //优先级 越小 越高
    @Pointcut("execution(public * com.maiyue.weixin.base.controller.*.*(..))")
    public void CollectBase() {  }

    /***
     *切入点 2
     */
    @Pointcut("execution(public * com.maiyue.weixin.business.controller.*.*(..))")
    public void CollectBis() {  }
    
    /***
     * 进入切点
     * @param joinPoint
     * @throws Throwable
     */
    @Before(value = "CollectBase() || CollectBis()")  //|| CollectBis()
    public void before(JoinPoint joinPoint) throws Throwable {
        System.out.println( "进入Before切面");
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("请求URL: " + request.getRequestURL().toString());
        logger.info("请求方法 : " + request.getMethod());
        logger.info("客户端IP: " + request.getRemoteAddr());
        logger.info("类 方 法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("请求参数 : " + Arrays.toString(joinPoint.getArgs()));

    }

    /**
     * 处理完成之后返回的内容
     * @param reult  
     * @throws Throwable
     */
    @AfterReturning(pointcut="CollectBase() || CollectBis()",returning = "reult")
    public void afterReturning(Object reult){
        logger.info("reult : {}",reult);
    }
    
 
    
    
}
