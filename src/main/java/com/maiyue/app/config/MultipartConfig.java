package com.maiyue.app.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipartConfig {
		
	@Value("${spring.multipart.maxFileSize}")
	private String maxFileSize;
	
	@Value("${spring.multipart.maxRequestSize}")
	private String maxRequestSize;
	
	
	/**  
     * 文件上传配置  
     * @return  
     */  
    @Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        //文件最大  
        factory.setMaxFileSize(maxFileSize); //KB,MB  
        //设置总上传数据总大小  
        factory.setMaxRequestSize(maxRequestSize);  
        return factory.createMultipartConfig();  
    }  
    
    
    
    
}
