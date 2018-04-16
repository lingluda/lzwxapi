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
 * 教师信息端
 * @date 2017/04/10
 *
 */
@RestController
@RequestMapping("/teacher/*")
@EnableAutoConfiguration
public class TeacherController1 extends BaseController {

	@GetMapping(value="teachers")
	public Object getTeacherInformation(ModelMap model,HttpSession session,HttpServletRequest request) {
		List<String> list = new ArrayList<>();
		String json = "{'staffID':'10001','name':'张树标','phone':'13877685978','department':'柳州职业学院技术学院','title':'教授'},"+
					  "{'staffID':'10002','name':'刘培培','phone':'13678556623','department':'国际贸易学院','title':'特级教师'},"+
					  "{'staffID':'10003','name':'李沁沁','phone':'18898765721','department':'商务贸易学院','title':'高级教师'},"+
					  "{'staffID':'10004','name':'刘响','phone':'13889767855','department':'国际贸易学院','title':'中级教师'},"+
					  "{'staffID':'10005','name':'农建广','phone':'13878285707','department':'柳州职业学院技术学院','title':'特级教师'},"+
					  "{'staffID':'10006','name':'甘露','phone':'13088603680','department':'柳州职业学院技术学院','title':'高级教师'},"+
					  "{'staffID':'10007','name':'谭子麦','phone':'18377689011','department':'柳州职业学院技术学院','title':'中级教师'}";
	
		list.add(json);
		return list;
	}
}


























