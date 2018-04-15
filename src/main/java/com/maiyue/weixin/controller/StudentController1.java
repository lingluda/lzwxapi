package com.maiyue.weixin.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author We1less
 * Create On 2018/4/10 9:53
 */

@RestController
@RequestMapping("/student1/*")
@EnableAutoConfiguration
public class StudentController1 extends BaseController {

    /**
     * 勤工俭学 职位申请
     * 需要用到的字段有：
     * 1.summary,岗位简介
     * 2.time,面试时间
     * 3.address,面试地点
     * 4.entered,已报名人数
     * 5.worked,已招聘人数
     * 6.status,我的状态
     * 7.endTime,结束时间
     * @param model
     * @return
     */
    @RequestMapping(value="/workStudy/add")
    public Object add(Model model){
    	List<String> list = new ArrayList<>();
    	String state = "0";
        String json = "{'summary':'负责日常图书管理与图书馆开馆闭馆工作','time':'2018年4月11日','address':'3栋教学楼402','entered':'5人','worked':'6人','status':'','endTime':'4月20日'}";
        state = "1";
        list.add(state);
        list.add(json);
        return list;
    }

    /**
     * 勤工俭学 我的职位
     * 需要用到的字段有：
     * 1.name,岗位名称
     * 2.time,起止时间
     * 3.status,我的状态
     * @return
     */
    @RequestMapping(value="/workStudy/myJob")
    public Object myJob(){
        List<String> list = new ArrayList<>();
        String state = "0";
        String json1 = "{'name':'图书管理员','time':'2018-04-11 2018-12-11','status':'进行中'}";
        String json2 = "{'name':'食堂工作人员','time':'2018-06-01 2018-08-01','status':'暂停'}";
        state = "1";
        list.add(state);
        list.add(json1);
        list.add(json2);
        return list;
    }

    /**
     * 勤工俭学 历史日志
     * 需要用到的字段有：
     * 1.title,标题
     * 2.status,审核状态
     * 3.content,日志内容
     * 4.createTime,创建时间
     * @param model
     * @return
     */
    @RequestMapping(value="/workStudy/notes")
    public Object notes(Model model){
        List<String> list = new ArrayList<>();
        String state = "0";
        String json1 = "{'title':'图书管理员日志','status':'未审核','content':'“刷刷”，一个中等身材的女孩不停地在图书架之间来回穿梭，专注地整理者着每一本图书。走近了才发现：她是一个五年级的学生，有着红扑扑的鹅蛋脸，梳着一条麻花辫，一对浓黑的眉毛下面嵌着一双水灵灵的大眼睛，再加上小鼻子和小嘴巴，凑成了认真执着的她。\n" +
                "      女孩刚刚来时，还是一脸的茫然。管理员阿姨让她先坐下，待会儿填写信息表。女孩坐下了，看了一下时间，才1：10呢。她笑了笑，问阿姨：“我可以先填了吗？”阿姨有些不解：“为什么呢？还有20分钟。”女孩脸红了，不语。阿姨似乎明白了女孩的心思，便让女孩先填了。\n" +
                "     大约1：35，小小管理员们来齐了。阿姨耐心地向我们布置了任务。阿姨让两位男孩去楼下运书，我们三位女孩被分到了右边的①—⑨号书架，整理图书，还要把男孩运回的图书分类准确无误地插进图书架上。','createTime':'2018年03月04日 12:13'}";
        String json2 = "{'title':'食堂工作人员日志','status':'审核通过','content':'她们看过最早出的太阳，了解学生的口味，收拾过布满残羹的桌子，关过饭堂的最后一盏灯，她们把大部分时间都花在食物方面，却并没有为此感到枯燥；她们没有许多朋友，却有着两三个可以聊得很开心的同伙们，面对油烟她们顾不上把自己打扮得漂漂亮亮；但她们是最可爱的人——饭堂阿姨。\n" +
                "与她们有相似经历的组员们，在为期一周的三下乡支教活动中与该校的饭堂阿姨合作为学生提供日常饮食服务。活动开展了三天，组员们体验了饭堂相关工作，比别人起得早是他们每天要做的事，做好饭堂保洁工作也是必须的，照顾每个人的胃口也是很大的难题，但是与饭堂阿姨相比，他们还是小巫见大巫。在组员的采访中，得知该校的饭堂阿姨的儿女也在该校读书，在照顾他人孩子的同时也照顾着自己的孩子，没有偏心之意。','createTime':'2018年04月11日 16:26'}";
        state = "1";
        list.add(state);
        list.add(json1);
        list.add(json2);
        return list;
    }

    /**
     * 勤工俭学 我的薪酬
     * 需要用到的字段有：
     * 1.time,时间
     * 2.hours,时长
     * 3.job,岗位
     * 4.salary,工资
     * @param model
     * @return
     */
    @RequestMapping(value="/workStudy/mySalary")
    public Object getSalary(Model model){
        List<String> list = new ArrayList<>();
        String json1 = "{'time':'2018年3月','hours':'32小时','job':'食堂工作人员','salary':'280元'}";
        String json2 = "{'time':'2018年2月','hours':'40小时','job':'图书管理员','salary':'320元'}";
        String json3 = "{'time':'2018年2月','hours':'10小时','job':'教室清洁工','salary':'80元'}";
        list.add(json1);
        list.add(json2);
        list.add(json3);
        return list;
    }

    /**
     * 勤工俭学 个人信息
     * 需要用到的字段有：
     * 1.image,头像
     * 2.college,学院
     * 3.major,专业
     * 4.className,班级名称
     * 5.stuNum,学号
     * 6.assistant,辅导员
     * 7.tel,联系电话
     * @param model
     * @return
     */
    @RequestMapping(value="/workStudy/myInfo")
    public String view(Model model){
        String json = "{'image':'image1.jpg','college':'信息工程学院','major':'计算机科学与技术','className':'计算机14-2班','stuNum':'14060222','assistant':'韦鳗珍(18777131742)','tel':'18578563324'}";
        return json;
    }

    /**
     * 学生成绩查询
     * 需要用到的字段有：
     * 1.semester,学期
     * 2.course,课程名称
     * 3.teacher,教师名称
     * 4.score,成绩
     * 5.point,学分
     *
     * @param model
     * @return
     */
    @RequestMapping(value="score")
    public Object getScore(Model model) {
        List<String> list = new ArrayList<>();
        String json1 = "{'semester':'2018年第一学期课程'," +
                "'messages':[" +
                "{'course':'计算机应用','teacher':'丁恺乐','score':'80','point':'4'}," +
                "{'course':'算数与计算','teacher':'赵修洁','score':'60','point':'4'}," +
                "{'course':'素描','teacher':'康成化','score':'50','point':'0'}]}";
        String json2 = "{'semester':'2018年第二学期课程'," +
                "'messages':[" +
                "{'course':'电子技术','teacher':'郭永思','score':'56','point':'0'}," +
                "{'course':'离散数学','teacher':'董嘉荣','score':'88','point':'4'}," +
                "{'course':'数据结构','teacher':'于新立','score':'34','point':'0'}]}";
        String json3 = "{'semester':'2017年第一学期课程'," +
                "'messages':[" +
                "{'course':'计算机组成原理','teacher':'董宏壮','score':'91','point':'4'}," +
                "{'course':'编译原理','teacher':'邹修齐','score':'89','point':'3'}," +
                "{'course':'计算机网络','teacher':'李子民','score':'78','point':'3'}]}";
        String json4 = "{'semester':'2017年第二学期课程'," +
                "'messages':[" +
                "{'course':'应用密码学基础','teacher':'袁飞鹏','score':'88','point':'3'}," +
                "{'course':'算法设计与分析','teacher':'汪志尚','score':'67','point':'4'}," +
                "{'course':'计算机图形学','teacher':'毛新立','score':'58','point':'0'}]}";
        list.add(json1);
        list.add(json2);
        list.add(json3);
        list.add(json4);
        return list;
    }

    /**
     * 学生课表查询
     * 需要用到的字段有：
     * 1.semester,学期
     * 2.startTime,课程开始时间
     * 3.endTime,课程结束时间
     * 4.day,周几
     * 5.week,第几周
     * 6.order,第几节课
     * 7.course,课程名称
     * 8.address,教室地址
     * @param model
     * @return
     */
    @RequestMapping(value="courseTable")
    public Object getCourseTable(Model model){
        List<String> list = new ArrayList<>();
        String json1 = "{'semester':'2018年第一学期'," +
                "'messages':[" +
                "{'startTime':'08:00','endTime':'09:50','day':'周四（今天）','week':'第八周','order':'第一二节','course':'算法设计与分析','address':'3栋教学楼502'}," +
                "{'startTime':'10:10','endTime':'12:00','day':'周四（今天）','week':'第八周','order':'第三四节','course':'面向对象程序设计','address':'1栋教学楼206'}," +
                "{'startTime':'14:30','endTime':'15:20','day':'周四（今天）','week':'第八周','order':'第五六节','course':'计算机网络','address':'1栋教学楼304'},";
        String json2 = "{'semester':'2018年第一学期'," +
                "'messages':[" +
                "{'startTime':'08:00','endTime':'09:50','day':'周五（明天）','week':'第八周','order':'第一二节','course':'计算机系统结构','address':'2栋教学楼202'}," +
                "{'startTime':'10:10','endTime':'12:00','day':'周五（明天）','week':'第八周','order':'第三四节','course':'面向对象程序设计','address':'2栋教学楼506'}," +
                "{'startTime':'15:40','endTime':'16:50','day':'周五（明天）','week':'第八周','order':'第七八节','course':'计算机网络','address':'1栋教学楼104'},";
        list.add(json1);
        list.add(json2);
        return list;
    }

    /**
     * 获取公告、通知
     * 需要用到的字段有：
     * 1.type,类型(通知/公告)
     * 2.status,是否已读
     * 3.title,标题
     * 4.createTime,发表时间
     * 5.content,内容
     * @param model
     */
    @RequestMapping(value="notice")
    public Object getNotice(Model model){
        List<String> list = new ArrayList<>();
        String json1 = "{'type':'通知','status':'已读','title':'中央国家机关工委关于认真学习宣传贯彻党的十九大精神的通知','createTime':'2018-04-15 09:02','content':'党的十九大是在我国全面建成小康社会决胜阶段、中国特色社会主义进入新时代的关键时期召开的一次十分重要的大会。学习宣传贯彻党的十九大精神是全党全国当前和今后一个时期的首要政治任务，《中共中央关于认真学习宣传贯彻党的十九大精神的决定》（以下简称《决定》）专门对此作出了系统部署，提出了明确要求。中央国家机关是党代表人民执掌政权的重要阵地，担负着从宏观上管理国家政治、经济、文化、生态和社会事务的职能，在决胜全面建成小康社会、全面建设中国特色社会主义现代化国家的伟大征程中发挥着全局性的重要作用，能否学习宣传贯彻好党的十九大精神事关党和国家工作全局，事关中国特色社会主义事业发展，事关最广大人民根本利益，事关党的十九大确定的各项重大决策部署的落实。'}";
        String json2 = "{'type':'通知','status':'已读','title':'关于十九大报告，你必须知道的“关键词”','createTime':'2018-03-14 07:02','content':'“中国特色社会主义进入了新时代”，“新时代中国共产党的历史使命”，“新时代中国特色社会主义思想”，“我国社会主要矛盾已经转化”，“伟大斗争，伟大工程，伟大事业，伟大梦想，紧密联系、相互贯通、相互作用”……十九大报告中出现的不少“关键词”，展示了新理念、新观点，给予了重大时代课题明确的回答，在理论上拓展了新境界、在实践上作出了新部署。'}";
        String json3 = "{'type':'公告','status':'未读','title':'百位名家将为首都高校百万师生宣讲十九大精神','createTime':'2017-10-17 09:02','content':'北京市委教育工作委员会今天透露，100位理论名家将走进学校、走近师生，结合党的十九大精神和习近平新时代中国特色社会主义思想，为师生提供全方位、系统化、多角度的理论阐释和思想指导，帮助师生解疑释惑。'}";
        String json4 = "{'type':'公告','status':'未读','title':'习近平谈新时代选人用人的“标尺”','createTime':'2018-02-03 11:02','content':'好干部要做到信念坚定、为民服务、勤政务实、敢于担当、清正廉洁。焦裕禄同志以自己的实际行动塑造了一个优秀共产党员和优秀县委书记的光辉形象。做县委书记就要做焦裕禄式的县委书记，始终做到心中有党、心中有民、心中有责、心中有戒。一是要做政治的明白人，二是要做发展的开路人，三是要做群众的贴心人，四是要做班子的带头人。实现第一个百年奋斗目标、全面建成小康社会，进而实现第二个百年奋斗目标、实现中华民族伟大复兴的中国梦，关键在于培养造就一支具有铁一般信仰、铁一般信念、铁一般纪律、铁一般担当的干部队伍。'}";
        list.add(json1);
        list.add(json2);
        list.add(json3);
        list.add(json4);
        return list;
    }

  
    /**
     * zf
	 * 获取外部链接
	 * @param model
	 * @return
	 */
    @RequestMapping(value="link")
	public Object getLink(Model model) {
    	List<String> list = new ArrayList<>();
		String json1="{'icon':'就业网'}";
		String json2="{'icon':'面试技巧'}";
		String json3="{'icon':'大学生创业园'}";
		list.add(json1);
		list.add(json2);
		list.add(json3);
		return list;
	}
	
	/**
	 * 获取教师通讯录
	 * 1.type,种类
	 * 2.teacher,老师
	 * 3.contacts,通讯录
	 * @param model
	 * @return
	 */
    @RequestMapping(value="contacts")
	public Object getContacts(Model model) {
    	List<String> list = new ArrayList<>();
		String json1="{'type':'辅导员','teacher':'张华','contacts':'18577964239'}";
		String json2="{'type':'语文课','teacher':'李强','contacts':'19768673212'}";
		String json3="{'type':'数学课','teacher':'王文','contacts':'15536354567'}";
		String json4="{'type':'体育课','teacher':'刘健','contacts':'15646377767'}";
		list.add(json1);
		list.add(json2);
		list.add(json3);
		list.add(json4);
		return list;
	}
	
	/**
	 * 获取综合素质考评
	 * 1.time,时间
	 * 2.avg,学年各科成绩平均分
	 * 3.faith,诚信分
	 * 4.activity,活动分
	 * 5.grade,综合素质考评成绩
	 * 6.describle,简介
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/quality/mixed")
	public Object getQuality(Model model) {
		List<String> list = new ArrayList<>();
		String json1="{'time':'2018','avg':'80.07','faith':'800','activity':'0','grade':'89'}";
		String json2="{'time':'2017','avg':'91.32','faith':'800','activity':'10','grade':'90'}";
		String json3="{'time':'2016','avg':'87.65','faith':'800','activity':'0','grade':'87'}";
		String json4="{'describle':'综合素质测评一般是对大学生的一种评价指标，综合素质测评的内容包括德育测评、智育测评、体育测评和能力测评四个方面。'}";
		list.add(json1);
		list.add(json2);
		list.add(json3);
		list.add(json4);
		return list;
	}
	
	/**
	 * 获取诚信分
	 * 1.time,时间
	 * 2.reason,扣存原因
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/quality/faithPoint")
	public Object getFaithPoint(Model model) {
		List<String> list = new ArrayList<>();
		String json1="{'time':'2018/03/12','reason':'显示10个字符，剩余...','score':'-30'}";
		String json2="{'time':'2018/02/12','reason':'显示10个字符，剩余...','score':'+30'}";
		list.add(json1);
		list.add(json2);
		return list;
	}
	
	/**
	 * 获取活动分
	 * 1.time,时间
	 * 2.reason,扣存原因
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/quality/activityPoint")
	public Object getActivityPoint(Model model) {
    	List<String> list = new ArrayList<>();
		String json1="{'time':'2018/03/12','reason':'显示10个字符，剩余...','score':'-30'}";
		String json2="{'time':'2018/02/12','reason':'显示10个字符，剩余...','score':'+30'}";
		list.add(json1);
		list.add(json2);
		return list;
	}
	/**
	 * 获取缴费信息
	 * 1.semester,学期
	 * 2.tuition,学费
	 * 3.account,缴入账号
	 * 4.state,状态
	 * 5.time.时间
	 * @param model
	 * @return
	 */
    @RequestMapping(value="payment")
	public Object getPayment(Model model) {
    	List<String> list = new ArrayList<>();
		String json1="{'semester':'2018年第一学期','tuition':'4000','account':'354564562866666128','state':'已缴清','time':'2018/01/23'}";
		String json2="{'semester':'2018年第二学期','tuition':'4000','account':'354564562866666128','state':'已缴清','time':'2017/11/23'}";
		String json3="{'semester':'2017年第一学期','tuition':'4000','account':'354564562866666128','state':'已缴清','time':'2017/01/23'}";
		list.add(json1);
		list.add(json2);
		list.add(json3);
		return list;
	}
}
