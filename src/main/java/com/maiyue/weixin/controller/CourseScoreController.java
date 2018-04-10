package com.maiyue.weixin.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class CourseScoreController extends BaseController {
	
	/**
	 * 教师通讯录
	 * 需要用到的字段有
	 * semester 学院
	 * department 部门
	 * teacher   老师
	 * phone	电话
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@GetMapping("/contacts")
	public String getContacts(ModelMap model,HttpSession session,HttpServletRequest request) {
		String json = "{\"contacts\":[{\"semester\":\"土木工程学院\",\"departmentAll\":[{\"department\":\"部门1\",\"messages\":[{\"teacher\":\"张燕\",\"phone\":\"16899846687\"},{\"teacher\":\"林燕明\",\"phone\":\"15777482114\"},{\"teacher\":\"李伟先\",\"phone\":\"13844658897\"}]},{\"department\":\"部门2\",\"messages\":[{\"teacher\":\"王大海\",\"phone\":\"17044752239\"},{\"teacher\":\"李容霞\",\"phone\":\"15777406328\"},{\"teacher\":\"张小天\",\"phone\":\"13877482134\"}]},{\"department\":\"部门3\",\"messages\":[{\"teacher\":\"李庆庆\",\"phone\":\"18977416897\"},{\"teacher\":\"罗敏\",\"phone\":\"13266352486\"},{\"teacher\":\"吴优\",\"phone\":\"13697787456\"}]}]},{\"semester\":\"信息工程学院\",\"departmentAll\":[{\"department\":\"部门1\",\"messages\":[{\"teacher\":\"马宏\",\"phone\":\"15766648952\"},{\"teacher\":\"蒙金强\",\"phone\":\"16921445547\"},{\"teacher\":\"陈俊昌\",\"phone\":\"13846512368\"}]},{\"department\":\"部门2\",\"messages\":[{\"teacher\":\"莫燕梅\",\"phone\":\"16778888454\"},{\"teacher\":\"黎欣\",\"phone\":\"17799944487\"},{\"teacher\":\"林火兴\",\"phone\":\"16555448778\"}]},{\"department\":\"部门3\",\"messages\":[{\"teacher\":\"方洋\",\"phone\":\"13669874451\"},{\"teacher\":\"黄宝湖\",\"phone\":\"18900570106\"},{\"teacher\":\"胡斌\",\"phone\":\"13476933067\"}]}]}]}";
		return json;
	}
	
	/**
	 * 学生查询-班级课程所有人成绩
	 * 需要用到的字段有
	 * semester 学期
	 * course	课程
	 * username	学生名字
	 * numbers	学号
	 * teacher	任课老师
	 * score	成绩
	 * credit	学分
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@GetMapping("/coursescore")
	public String getCourseScore(ModelMap model,HttpSession session,HttpServletRequest request) {
		String json = "{\"classname\":[{\"semester\":\"18年上学期\",\"courseAll\":[{\"course\":\"计算机应用\",\"messages\":[{\"username\":\"倪永东\",\"numbers\":\"1512310101\",\"teacher\":\"吴海强\",\"score\":\"80\",\"credit\":\"2\"},{\"username\":\"李云飞\",\"numbers\":\"1512310102\",\"teacher\":\"吴海强\",\"score\":\"90\",\"credit\":\"2\"},{\"username\":\"张大福\",\"numbers\":\"1512310103\",\"teacher\":\"吴海强\",\"score\":\"30\",\"credit\":\"2\"}]},{\"course\":\"现代科技\",\"messages\":[{\"username\":\"倪永东\",\"numbers\":\"1512310101\",\"teacher\":\"冯莫莫\",\"score\":\"90\",\"credit\":\"2\"},{\"username\":\"李云飞\",\"numbers\":\"1512310102\",\"teacher\":\"冯莫莫\",\"score\":\"80\",\"credit\":\"2\"},{\"username\":\"张大福\",\"numbers\":\"1512310103\",\"teacher\":\"冯莫莫\",\"score\":\"80\",\"credit\":\"2\"}]},{\"course\":\"软件测试\",\"messages\":[{\"username\":\"倪永东\",\"numbers\":\"1512310101\",\"teacher\":\"李少华\",\"score\":\"60\",\"credit\":\"2\"},{\"username\":\"李云飞\",\"numbers\":\"1512310102\",\"teacher\":\"李少华\",\"score\":\"50\",\"credit\":\"2\"},{\"username\":\"张大福\",\"numbers\":\"1512310103\",\"teacher\":\"冯莫莫\",\"score\":\"70\",\"credit\":\"2\"}]}]},{\"semester\":\"18年下学期\",\"courseAll\":[{\"course\":\"语文\",\"messages\":[{\"username\":\"倪永东\",\"numbers\":\"1512310101\",\"teacher\":\"张哲天\",\"score\":\"90\",\"credit\":\"2\"},{\"username\":\"李云飞\",\"numbers\":\"1512310102\",\"teacher\":\"张哲天\",\"score\":\"80\",\"credit\":\"2\"},{\"username\":\"张大福\",\"numbers\":\"1512310103\",\"teacher\":\"张哲天\",\"score\":\"60\",\"credit\":\"2\"}]},{\"course\":\"数学\",\"messages\":[{\"username\":\"倪永东\",\"numbers\":\"1512310101\",\"teacher\":\"周颖\",\"score\":\"40\",\"credit\":\"2\"},{\"username\":\"李云飞\",\"numbers\":\"1512310102\",\"teacher\":\"周颖\",\"score\":\"100\",\"credit\":\"2\"},{\"username\":\"张大福\",\"numbers\":\"1512310103\",\"teacher\":\"周颖\",\"score\":\"50\",\"credit\":\"2\"}]},{\"course\":\"英语\",\"messages\":[{\"username\":\"倪永东\",\"numbers\":\"1512310101\",\"teacher\":\"李莹\",\"score\":\"70\",\"credit\":\"2\"},{\"username\":\"李云飞\",\"numbers\":\"1512310102\",\"teacher\":\"李莹\",\"score\":\"80\",\"credit\":\"2\"},{\"username\":\"张大福\",\"numbers\":\"1512310103\",\"teacher\":\"李莹\",\"score\":\"70\",\"credit\":\"2\"}]}]}]}";
		return json;
	}
	
	/**
	 * 学生查询-系
	 * 需要用到的字段有
	 * semester 年级
	 * department 系
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@GetMapping("/department")
	public String getDepartment(ModelMap model,HttpSession session,HttpServletRequest request) {
		String json = "{\"studentDepartment\":[{\"semester\":\"17级\",\"departmentAll\":[{\"department\":\"土木工程系\"},{\"department\":\"信息工程系\"},{\"department\":\"经济管理系\"},{\"department\":\"机电系\"},{\"department\":\"师范教育系\"},{\"department\":\"艺术传媒系\"},{\"department\":\"服装设计系\"},{\"department\":\"新闻系\"}]},{\"semester\":\"18级\",\"departmentAll\":[{\"department\":\"土木工程系\"},{\"department\":\"信息工程系\"},{\"department\":\"经济管理系\"},{\"department\":\"机电系\"},{\"department\":\"师范教育系\"},{\"department\":\"艺术传媒系\"},{\"department\":\"服装设计系\"},{\"department\":\"新闻系\"}]}]}";
		return json;
	}
	
	/**
	 * 学生查询-班级
	 * 需要用到的字段有
	 * department 系
	 * semester	年级
	 * grade	班级
	 * numbers	人数
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@GetMapping("/grade")	
	public String getGrade(ModelMap model,HttpSession session,HttpServletRequest request) {
		String json = "{\"department\":[{\"semester\":\"17级\",\"gradeAll\":[{\"grade\":\"1701班\",\"numbers\":\"43人\"},{\"grade\":\"1702班\",\"numbers\":\"49人\"},{\"grade\":\"1703班\",\"numbers\":\"45人\"},{\"grade\":\"1704班\",\"numbers\":\"44人\"},{\"grade\":\"1705班\",\"numbers\":\"47人\"}]},{\"semester\":\"18级\",\"gradeAll\":[{\"grade\":\"1801班\",\"numbers\":\"47人\"},{\"grade\":\"1802班\",\"numbers\":\"48人\"},{\"grade\":\"1803班\",\"numbers\":\"47人\"},{\"grade\":\"1804班\",\"numbers\":\"44人\"},{\"grade\":\"1805班\",\"numbers\":\"48人\"}]}]}";		
		return json;
	}
	
	/**
	 * 学生查询-个人课程成绩
	 * 需要用到的字段有
	 * semester	学期
	 * course	课程
	 * teacher	任课老师
	 * score	成绩
	 * credit	学分
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@GetMapping("/score")
	public String getScore(ModelMap model,HttpSession session,HttpServletRequest request) {
		String json = "{\"personage\":[{\"semester\":\"18年上学期\",\"message\":[{\"course\":\"语文\",\"teacher\":\"张强\",\"score\":\"60\",\"credit\":\"2\"},{\"course\":\"数学\",\"teacher\":\"刘伊妮\",\"score\":\"90\",\"credit\":\"2\"}]},{\"semester\":\"18年下学期\",\"message\":[{\"course\":\"计算机应用\",\"teacher\":\"张强\",\"score\":\"90\",\"credit\":\"2\"},{\"course\":\"现代科技\",\"teacher\":\"刘伊妮\",\"score\":\"80\",\"credit\":\"2\"}]}]}";	
		return json;
	}
	
	/**
	 * 流程 申请
	 * 需要用到的字段有
	 * proposer 申请人
	 * time  申请时间
	 * type  申请类型
	 * reasons 申请事由
	 * commitTo 提交到
	 * department 部门
	 * teacher	老师
	 * copyTo	抄送到
	 * accessory  申请附件
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@GetMapping("/putin")
	public String getPutIn(ModelMap model,HttpSession session,HttpServletRequest request) {
		String json = "{\"proposer\":\"李军\",\"time\":\"2018-04-10 12:30\",\"type\":\"经费申请\",\"reasons\":\"买器材\",\"commitTo\":{\"department\":\"财务部\",\"teacher\":\"李老师\"},\"copyTo\":[{\"department\":\"教师部\",\"teacher\":\"白老师\"},{\"department\":\"事务部\",\"teacher\":\"张老师\"}],\"accessory\":\"申请附件\"}";
		return json;
	}
	
	/**
	 * 流程 审核
	 * 需要用到的字段有
	 * proposer 申请人
	 * time		申请时间
	 * type		申请类型
	 * reasons	申请事由
	 * accessory 申请附件
	 * audit	审批
	 * instruct	批示
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@GetMapping("/audit")
	public String getAudit(ModelMap model,HttpSession session,HttpServletRequest request) {
		String json = "{\"proposer\":\"李军\",\"time\":\"2018-04-1012: 30\",\"type\":\"经费申请\",\"reasons\":\"买器材\",\"accessory\":\"申请附件\",\"audit\":\"同意\",\"instruct\":\"同意了\"}";
		return json;
	}
}
