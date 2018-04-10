package com.maiyue.weixin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 查询学生信息
 * @date 2017/04/10
 *
 */
@RestController
@RequestMapping("/querystuinfor/*")
@EnableAutoConfiguration
public class QueryStuInforController extends BaseController {

	/**
	 * 学生ID查询信息
	 * @param model
	 * @return list
	 */
	  @RequestMapping(value="querystuid")
	    public Object getQueryStuId(Model model) {
	        List<String> list = new ArrayList<>();
	        String json = "{'name':'甘雅'},{'sex':'0'},{'clas':'1801班'},{'teacher':'杜雨芯'},{'grade':'经济管理系'},{'phone':'18677986606'},{'address':'北京市朝阳区西山一号院'}}";	       
	        list.add(json);	        
	        return list;
	    }
	
	/**
	 * 院系查询信息
	 * @param model
	 * @return list
	 */
	  @RequestMapping(value="querybygrade")
	    public Object getQueryByGrade(Model model) {
	        List<String> list = new ArrayList<>();
	        String json1 = "{'grade':'18级',"+"{'grade':'土木工程系'},{'grade':'信息工程系'},{'grade':'经济管理系'},{'grade':'机电系'},{'grade':'师范教育系'},{'grade':'艺术传媒系'},{'grade':'服装设计系'},{'grade':'新闻系'}}";
	        String json2 = "{'grade':'17级',"+"{'grade':'土木工程系'},{'grade':'信息工程系'},{'grade':'经济管理系'},{'grade':'机电系'},{'grade':'师范教育系'},{'grade':'艺术传媒系'},{'grade':'服装设计系'},{'grade':'新闻系'}}";
	        String json3 = "{'grade':'16级',"+"{'grade':'土木工程系'},{'grade':'信息工程系'},{'grade':'经济管理系'},{'grade':'机电系'},{'grade':'师范教育系'},{'grade':'艺术传媒系'},{'grade':'服装设计系'},{'grade':'新闻系'}}";
	        String json4 = "{'grade':'15级',"+"{'grade':'土木工程系'},{'grade':'信息工程系'},{'grade':'经济管理系'},{'grade':'机电系'},{'grade':'师范教育系'},{'grade':'艺术传媒系'},{'grade':'服装设计系'},{'grade':'新闻系'}}";
	        list.add(json1);
	        list.add(json2);
	        list.add(json3);
	        list.add(json4);
	        return list;
	    }
	  
	  /**
		 * 年级查询信息
		 * @param model
		 * @return list
		 */
		  @RequestMapping(value="querybyclas")
		    public Object getQueryByClas(Model model) {
		        List<String> list = new ArrayList<>();
		        String json1 = "{'grade':'18级',"+"{'clas':'1801班','num':'48人'},{'clas':'1802班','num':'45人'},{'clas':'1803班','num':'35人'},{'clas':'1804班','num':'50人'},{'clas':'1805班','num':'42人'}}";
		        String json2 = "{'grade':'17级',"+"{'clas':'1701班','num':'48人'},{'clas':'1702班','num':'45人'},{'clas':'1703班','num':'35人'},{'clas':'1704班','num':'50人'},{'clas':'1705班','num':'42人'}}";
		        String json3 = "{'grade':'16级',"+"{'clas':'1601班','num':'48人'},{'clas':'1602班','num':'45人'},{'clas':'1603班','num':'35人'},{'clas':'1604班','num':'50人'},{'clas':'1605班','num':'42人'}}";
		        String json4 = "{'grade':'15级',"+"{'clas':'1501班','num':'48人'},{'clas':'1502班','num':'45人'},{'clas':'1503班','num':'35人'},{'clas':'1504班','num':'50人'},{'clas':'1505班','num':'42人'}}";
		        list.add(json1);
		        list.add(json2);
		        list.add(json3);
		        list.add(json4);
		        return list;
		    }
		  
		  /**
			 * 名字/学号查询信息
			 * @param model
			 * @return list
			 */
			  @RequestMapping(value="querybyname")
			    public Object getQueryByName(Model model) {
			        List<String> list = new ArrayList<>();
			        String json1 = "{'semester':'18年上学期课程'," +
			                "'messages':[" +
			                "{'course':'计算机应用','teacher':'丁恺乐','score':'80','point':'4'}," +
			                "{'course':'算数与计算','teacher':'赵修洁','score':'60','point':'4'}," +
			                "{'course':'素描','teacher':'康成化','score':'50','point':'0'}]}";
			        String json2 = "{'semester':'18年下学期课程'," +
			                "'messages':[" +
			                "{'course':'电子技术','teacher':'郭永思','score':'56','point':'0'}," +
			                "{'course':'离散数学','teacher':'董嘉荣','score':'88','point':'4'}," +
			                "{'course':'数据结构','teacher':'于新立','score':'34','point':'0'}]}";			        
			        list.add(json1);
			        list.add(json2);			        
			        return list;
			    }
			  
			  /**
				 * 课程选修查询信息
				 * @param model
				 * @return list
				 */
				  @RequestMapping(value="querybysubject")
				    public Object getqueryBySubject(Model model) {
				        List<String> list = new ArrayList<>();
				        String json1 = "{'semester':'18年上学期课程'," +"{'subjectname':'计算机应(选修)'},"+
				                "'messages':[" +
				                "{'stuname':'白雪','id':'0000000001','teacher':'李磊','score':'80','point':'4'}," +
				                "{'stuname':'黄雪','id':'0000000002','teacher':'未选修','score':' ','point':' '}," +
				                "{'stuname':'红雪','id':'0000000003','teacher':'李磊','score':'50','point':'0'}]}";
				        String json2 = "{'semester':'18年下学期课程'," +
				                "'messages':[" +
				                "{'stuname':'白雪','id':'0000000001','teacher':'李磊','score':'56','point':'4'}," +
				                "{'stuname':'黄雪','id':'0000000002','teacher':'未选修','score':' ','point':' '}," +
				                "{'stuname':'红雪','id':'0000000003','teacher':'未选修','score':' ','point':' '}]}";			        
				        list.add(json1);
				        list.add(json2);			        
				        return list;
				    }
			  
}
