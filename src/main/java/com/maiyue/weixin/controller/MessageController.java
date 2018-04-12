package com.maiyue.weixin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maiyue.weixin.base.bean.Course;
import com.maiyue.weixin.base.bean.Schedules;
import com.maiyue.weixin.base.bean.StudentInfo;
import com.maiyue.weixin.base.bean.TermName;
import com.maiyue.weixin.bean.Messages;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	//例子
	@GetMapping("/getPage")
	@ResponseBody
	public String getPage(ModelMap modelMap,HttpSession session,HttpServletResponse response,
			HttpServletRequest request){
		String json = "{'username':'Li','sex':'0'}";
		return json;
	}
	 
	//消息通知接口    消息通知列表
    @RequestMapping("/messageInfo")
    public Object messageInfo(ModelMap modelMap,HttpSession session,HttpServletResponse response,
			HttpServletRequest request){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
    	
    	List<Messages> messagesList = new ArrayList<Messages>();
    	Messages messages1 = new Messages("通知", sdf.format(new Date()) , "　原定今日上午进行的草坪杯足球对抗赛因雨改期，具体比赛日期经两公司协商后，另行通知。 另，午后的体育活动改为文艺活动，由各部按预案组织实施。");
    	Messages messages2 = new Messages("通知", sdf.format(new Date()), "时至年底，全县各种不稳定因素增加，治安形势比较严峻。加强值班工作，加强安全保卫工作显得尤为重要。然而，近一段时间以来，我县一些单位和乡镇在机关值班和安全保卫方面存在一些问题。有的单位平时不安排值班，公休日、节假日期间更是无人在岗，值班制度形同虚设;有的单位领导不带班，只有一般工作人员守摊子;还有的单位连值班室、值班电话都没有设立，有些单位和乡镇安全保卫工作制度不落实，管理松懈，导致发生入室盗窃等问题。");
    	Messages messages3 = new Messages("公告", sdf.format(new Date()), "坚持以热爱祖国为荣、以危害祖国为耻，以服务人民为荣、以背离人民为耻，以崇尚科学为荣、以愚昧无知为耻，以辛勤劳动为荣、以好逸恶劳为耻，以团结互助为荣");
    	Messages messages4 = new Messages("通知", sdf.format(new Date()), "一、五一劳动节放假时间定为5月1日，与周末连休。 　　二、各部门接通知后，妥善安排好值班工作，并将各部门值班表于20xx年x月xx日下午xxx以前报公司办公室。 　　三、各部门要加强对值班人员的管理，认真落实公司突发事件预案制度，切实做好公司防火、安全、保卫等工作，发现苗头要及时向公司办公室值班人员报告。 　　公司办公室值班电话：xxxxx");
    	messagesList.add(messages1);messagesList.add(messages2);
    	messagesList.add(messages3);messagesList.add(messages4);
    	
    	modelMap.addAttribute("messagesList", messagesList);
    	
    	ModelMap modelMap1 = new ModelMap();
    	
    	modelMap1.addAttribute("status", "1");
    	modelMap1.addAttribute("messagesList", messagesList);
    	
    	return modelMap1;
    }
    
    //消息通知-详情页面
    @RequestMapping("/messageDetail")
    public Object messageDetail(ModelMap modelMap,HttpSession session,HttpServletResponse response,
			HttpServletRequest request){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
    	Messages messages1 = new Messages("通知", sdf.format(new Date()) , "　原定今日上午进行的草坪杯足球对抗赛因雨改期，具体比赛日期经两公司协商后，另行通知。 另，午后的体育活动改为文艺活动，由各部按预案组织实施。");
    	
    	modelMap.addAttribute("messagesList", messages1);
    	//
    	ModelMap modelMap1 = new ModelMap();
    	
    	modelMap1.addAttribute("status", "1");
    	modelMap1.addAttribute("messages", messages1);
    	return modelMap1;
    }
    
    
    
    //教师-我的课程
    @RequestMapping("/teacherCourse")
    public Object teacherCourse(ModelMap modelMap,HttpSession session,HttpServletResponse response,
			HttpServletRequest request){
    	
    	Map<String, List<Course>> map = new HashMap<String, List<Course>>();
    	List<Course> coursesList1 = new ArrayList<Course>();
    	List<Course> coursesList2 = new ArrayList<Course>();
    	String term1 = "18年上学期课程";
    	String term2 = "18年下学期课程";
    	Course course1 = new Course("计算机技术与应用", "80节", "4个班", "200人");
    	Course course2 = new Course("环境艺术", "60节", "2个班", "100人");
    	coursesList1.add(course1);coursesList1.add(course2);
    	
    	Course course3 = new Course("素描", "70节", "3个班", "150人");
    	Course course4 = new Course("Java", "50节", "2个班", "95人");
    	coursesList2.add(course3);coursesList2.add(course4);

    	map.put(term1, coursesList1);
    	map.put(term2, coursesList2);
    	
    	ModelMap modelMap1 = new ModelMap();
    	
    	modelMap1.addAttribute("status", "1");
    	modelMap1.addAttribute("teacherCourses", map);
    	return modelMap1;
    	//return map;
    }
    
    //教师-查看"某专业"的 班级-学生-成绩  信息   sketch1.html
    @RequestMapping("/sketch")
    @ResponseBody
    public Object sketch(ModelMap map){
    	ModelMap map1 = new ModelMap();
    	map1.addAttribute("status", "1");
    	map1.addAttribute("title", "素描（选修）");
    	map1.addAttribute("msg", "2018年第一学期的素描课教学 班级有3个课时共80节学生121人");
       	map1.addAttribute("studentNum", "40");
    	
    	List<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();
    	StudentInfo studentInfo1 = new StudentInfo("素描1班", "徐冬萱  14050201 机械180031班", "80");
    	StudentInfo studentInfo2 = new StudentInfo("素描2班", "韦听芹  14050202 机械180032班", "75");
    	StudentInfo studentInfo3 = new StudentInfo("素描3班", "朱腾海  14050203 机械180033班", "81");
    	
    	studentInfoList.add(studentInfo1);
    	studentInfoList.add(studentInfo2);
    	studentInfoList.add(studentInfo3);
    	map1.addAttribute("studentInfoList", studentInfoList);

    	
    	return map1;
    }
    
    //教师-日程提醒
    @RequestMapping("/teacherSchedule")
    public Object teacherSchedule(ModelMap modelMap,HttpSession session,HttpServletResponse response,
			HttpServletRequest request){
    	
    	Map<String, List<Schedules>> map = new HashMap<String, List<Schedules>>();
    	List<Schedules> schedulesList = new ArrayList<Schedules>();
    	Schedules schedules1 = new Schedules("08:00 - 09:50", "计科系数学课", "思源楼102室");
    	Schedules schedules2 = new Schedules("10:10 - 12:00", "通控系数学课", "思源楼309室");
    	Schedules schedules3 = new Schedules("13:00 - 15:00", "自动化数学课", "思源楼102室");
    	schedulesList.add(schedules1);schedulesList.add(schedules2);schedulesList.add(schedules3);
    	
    	map.put("2018年4月1日", schedulesList);
    	map.put("2018年4月3日", schedulesList);
    	
    	
    	ModelMap modelMap1 = new ModelMap();
    	modelMap1.addAttribute("status", "1");
    	modelMap1.addAttribute("schedulesList", map);
    	return modelMap1;
    	
    }
    
    
    
}



