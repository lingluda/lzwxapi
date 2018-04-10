package com.maiyue.weixin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 待办事项
 * @date 2017/04/10
 *
 */
@RestController
@RequestMapping("/schedule/*")
@EnableAutoConfiguration
public class ScheduleController extends BaseController {

	@GetMapping(value="schedules")
	public Object getScheduleInformation(ModelMap model,HttpSession session,HttpServletRequest request) {
		List<String> list = new ArrayList<>();		
		String json1 = "{'time':'2017-04-15 12:53','applicationtitle':'李雷发来国际贸易学院经费申请，等待审批...'}"+
					   "{'time':'2017-04-15 12:53','applicationtitle':'韩梅发来请假申请，等待审批...'}";
        String json2 = "{'excesstime':'剩余时间20分钟','memorandumTitle':'您12:30有个重要客户要联系'}"+
        			   "{'excesstime':'剩余时间2小时20分','memorandumTitle':'您14:30有个会议需要召开'}";      
        list.add(json1);
        list.add(json2);        
		return list;
	}
}


























