package com.maiyue.weixin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	/*
	 * @RequestMapping("/list2")
	    @ResponseBody
	    public Object list2(ModelMap map){
	    	List<User> userList=userService.findAll();
	    	map.addAttribute("userList", userList);
	    	//return userList;
	    	
	    	return userList;
	    }
	 * */
	 
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
    	
    	return messagesList;
    }
    
    
}



