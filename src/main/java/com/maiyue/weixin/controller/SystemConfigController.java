package com.maiyue.weixin.controller;

import com.maiyue.weixin.service.BaseConfigService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SystemConfigController
 * 2018/04/01
 */
@Controller
@RequestMapping("/config/*")
public class SystemConfigController extends BaseController {
    
	
	@Resource(name = "systemConfigService")
    private BaseConfigService systemConfigService;

    
}