package com.maiyue.app.config;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.maiyue.app.constant.Constant;
import com.maiyue.app.service.SystemConfigService;
import com.maiyue.app.utils.RedisUtil;

/**
 * Created by huang on 2018/01/10.
 */
@Scope("singleton")
@Component("appConfig")
public class AppConfig{

	@Resource(name = "systemConfigService")
    private SystemConfigService systemConfigService;
   
    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;
    
    //@Resource(name = "quartzService")
    //private QuartzService quartzService;
	
    
    @PostConstruct
    private void init(){
    	//this.loadUpAndDownPath();
    	//this.loadTempPath();
    }
    
    
    /***
     * 加载文件上传下载路径
     */
    private void loadUpAndDownPath(){
    	if(redisUtil.get(Constant.UP_DOWN_LOAD_PATH) == null){
    		String path = systemConfigService.findByconfigName(Constant.UP_DOWN_LOAD_PATH);
        	if(StringUtils.isNotBlank(path)){
        	   redisUtil.set(Constant.UP_DOWN_LOAD_PATH, path);
        	   //redisUtil.set(Constant.WHERE_DISK_PATH, path);
        	}
    	}
    }
    
    /***
     * 加载缓存路径
     */
    private void loadTempPath(){
    	if(redisUtil.get(Constant.UP_DOWN_TEMP_PATH) == null){
    		String path = systemConfigService.findByconfigName(Constant.UP_DOWN_TEMP_PATH);
        	if(StringUtils.isNotBlank(path)){
        	   redisUtil.set(Constant.UP_DOWN_TEMP_PATH, path);
        	}
    	}
    }
    
    
    
    
}
