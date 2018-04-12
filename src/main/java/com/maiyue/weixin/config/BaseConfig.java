package com.maiyue.weixin.config;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.maiyue.weixin.constant.Constant;
import com.maiyue.weixin.service.BaseConfigService;
import com.maiyue.weixin.utils.RedisUtil;

/***
 * 系统配置
 * @author Admin
 */
@Scope("singleton")
@Component("baseConfig")
public class BaseConfig implements EmbeddedServletContainerCustomizer{

	@Resource(name = "baseConfigService")
    private BaseConfigService baseConfigService;
   
    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;
    
    @PostConstruct
    private void init(){
    	this.loadBasicConfig();
    }
    
    
    /***
     * 加载系统配置
     */
    private void loadBasicConfig(){
    	//上传下载文件配置
    	if(redisUtil.get(Constant.UP_DOWN_LOAD_PATH) == null){
    		String path = baseConfigService.findByconfigName("LOAD_PATH");
        	if(StringUtils.isNotBlank(path)){
        	   redisUtil.set(Constant.UP_DOWN_LOAD_PATH, path);
        	   redisUtil.set(Constant.WHERE_DISK_PATH, path);
        	}
    	}
    	//域名配置
    	if(redisUtil.get(Constant.DOMAIN_NAME) == null){
    		String domain = baseConfigService.findByconfigName("DOMAIN_NAME");
        	if(StringUtils.isNotBlank(domain)){
        	   redisUtil.set(Constant.DOMAIN_NAME, domain);
        	}
    	}
    	//缓存路径
    	if(redisUtil.get(Constant.UP_DOWN_TEMP_PATH) == null){
    		String temp = baseConfigService.findByconfigName("TEMP_PATH");
        	if(StringUtils.isNotBlank(temp)){
        	   redisUtil.set(Constant.UP_DOWN_TEMP_PATH, temp);
        	}
    	}
    }


	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		if(redisUtil.get(Constant.SERVER_PORT)==null){
			String port = baseConfigService.findByconfigName("SERVER_PORT");
        	if(StringUtils.isNotBlank(port)){
        	   redisUtil.set(Constant.SERVER_PORT, port);
        	   container.setPort(Integer.valueOf(port));
        	}else{
        	   redisUtil.set(Constant.SERVER_PORT, Constant.DEFAULT_SERVER_PORT);
        	   container.setPort(Constant.DEFAULT_SERVER_PORT);
        	}
		}else{
			container.setPort(Integer.valueOf(redisUtil.get(Constant.SERVER_PORT).toString()));
		}
	}
    
    
    
    
    
    
}
