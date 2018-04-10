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
    @RequestMapping("/business/index")
    public String index(ModelMap model,HttpSession session,HttpServletRequest request) {
    	String uid = getCurrUser().getId();
    	System.out.println("uid:" + uid);
        return "index";
    }
    
  
    
    
    
    
}
