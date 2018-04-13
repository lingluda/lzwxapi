package com.maiyue.weixin.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.maiyue.weixin.base.service.UserService;
import com.maiyue.weixin.utils.RedisUtil;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by huang on 2017/12/26.
 */
@Controller
@EnableAutoConfiguration
public class IndexController extends BaseController{

    @Resource(name = "userService")
    private UserService userService;
   
    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;

    
    
    /***
     * 首页
     * @param model
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value="/business/index")
    public String index(ModelMap model,HttpSession session,HttpServletRequest request) {
    	String uid = getCurrUser().getId();
    	System.out.println("uid:" + uid);
        return "index";
    }
    
    @RequestMapping(value="/business/schedule")
    public String schedule(ModelMap model,HttpSession session,HttpServletRequest request) {
        return "schedule";
    }
    
    
//    public synchronized ModelMap rebootSystem(){
//    	try {
//    		String os = System.getProperty("os.name").toLowerCase();
//        	Object domain = redisUtil.get(Constant.DOMAIN_NAME);
//        	redisUtil.remove(Constant.DOMAIN_NAME,Constant.UP_DOWN_LOAD_PATH,Constant.UP_DOWN_TEMP_PATH,Constant.WHERE_DISK_PATH);
//        	new RebootConfig(domain).run();
//        	if(os.indexOf("windows") != -1){
//        		String bat = systemConfigService.findByconfigName("WINDOWS_BAT");
//        		if(StringUtils.isNotBlank(bat)){
//        			String ex = "cmd /c start /b " + bat; ///b
//        			new Restart(ex).run();
//        		}
//        	}else{
//        		String sh = systemConfigService.findByconfigName("SHELL_SH");
//        		if(StringUtils.isNotBlank(sh)){
//        			new Restart(sh).run();
//        		}
//        	}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
//		}
//		return ResponseUtil.RetCorrectInfo("系统重启成功！");
//    }
    
    
    
}


/***
 * 执行命令
 * @author Admin
 */
class Restart extends Thread{
	private String ex;
	public Restart(String ex){
		this.ex = ex;
	}
	@Override
    public void run(){
        try {  
        	Process ps = Runtime.getRuntime().exec(ex); 
            int i = ps.waitFor();  
            if (i == 0) {   
                 System.out.println("重启执行完成...请稍等") ;   
            } else {   
                 System.out.println("重启执行失败.") ;  
            }  
        } catch (Exception e1) {  
           e1.printStackTrace();  
        }     
    }  
}
