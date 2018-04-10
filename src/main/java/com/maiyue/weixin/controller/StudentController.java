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
@RequestMapping("/student/*")
@EnableAutoConfiguration
public class StudentController extends BaseController {

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
     * @param model
     */
    @RequestMapping(value="notice")
    public Object getNotice(Model model){
        List<String> list = new ArrayList<>();
        String json1 = "{'type':'通知','title':'中央国家机关工委关于认真学习宣传贯彻党的十九大精神的通知','createTime':'2018-04-15 09:02','content':'党的十九大是在我国全面建成小康社会决胜阶段、中国特色社会主义进入新时代的关键时期召开的一次十分重要的大会。学习宣传贯彻党的十九大精神是全党全国当前和今后一个时期的首要政治任务，《中共中央关于认真学习宣传贯彻党的十九大精神的决定》（以下简称《决定》）专门对此作出了系统部署，提出了明确要求。中央国家机关是党代表人民执掌政权的重要阵地，担负着从宏观上管理国家政治、经济、文化、生态和社会事务的职能，在决胜全面建成小康社会、全面建设中国特色社会主义现代化国家的伟大征程中发挥着全局性的重要作用，能否学习宣传贯彻好党的十九大精神事关党和国家工作全局，事关中国特色社会主义事业发展，事关最广大人民根本利益，事关党的十九大确定的各项重大决策部署的落实。'}";
        String json2 = "{'type':'通知','title':'关于十九大报告，你必须知道的“关键词”','createTime':'2018-03-14 07:02','content':'“中国特色社会主义进入了新时代”，“新时代中国共产党的历史使命”，“新时代中国特色社会主义思想”，“我国社会主要矛盾已经转化”，“伟大斗争，伟大工程，伟大事业，伟大梦想，紧密联系、相互贯通、相互作用”……十九大报告中出现的不少“关键词”，展示了新理念、新观点，给予了重大时代课题明确的回答，在理论上拓展了新境界、在实践上作出了新部署。'}";
        String json3 = "{'type':'公告','title':'百位名家将为首都高校百万师生宣讲十九大精神','createTime':'2017-10-17 09:02','content':'北京市委教育工作委员会今天透露，100位理论名家将走进学校、走近师生，结合党的十九大精神和习近平新时代中国特色社会主义思想，为师生提供全方位、系统化、多角度的理论阐释和思想指导，帮助师生解疑释惑。'}";
        String json4 = "{'type':'公告','title':'习近平谈新时代选人用人的“标尺”','createTime':'2018-04-15 09:02','content':'好干部要做到信念坚定、为民服务、勤政务实、敢于担当、清正廉洁。焦裕禄同志以自己的实际行动塑造了一个优秀共产党员和优秀县委书记的光辉形象。做县委书记就要做焦裕禄式的县委书记，始终做到心中有党、心中有民、心中有责、心中有戒。一是要做政治的明白人，二是要做发展的开路人，三是要做群众的贴心人，四是要做班子的带头人。实现第一个百年奋斗目标、全面建成小康社会，进而实现第二个百年奋斗目标、实现中华民族伟大复兴的中国梦，关键在于培养造就一支具有铁一般信仰、铁一般信念、铁一般纪律、铁一般担当的干部队伍。'}";
        list.add(json1);
        list.add(json2);
        list.add(json3);
        list.add(json4);
        return list;
    }
}
