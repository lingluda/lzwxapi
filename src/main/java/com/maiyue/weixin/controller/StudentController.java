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
                "{'course':'电子技术','teacher':'丁恺乐','score':'56','point':'0'}," +
                "{'course':'离散数学','teacher':'赵修洁','score':'88','point':'4'}," +
                "{'course':'数据结构','teacher':'康成化','score':'34','point':'0'}]}";
        String json3 = "{'semester':'2017年第一学期课程'," +
                "'messages':[" +
                "{'course':'计算机组成原理','teacher':'丁恺乐','score':'91','point':'4'}," +
                "{'course':'编译原理','teacher':'赵修洁','score':'89','point':'3'}," +
                "{'course':'计算机网络','teacher':'康成化','score':'78','point':'3'}]}";
        String json4 = "{'semester':'2017年第二学期课程'," +
                "'messages':[" +
                "{'course':'应用密码学基础','teacher':'丁恺乐','score':'88','point':'3'}," +
                "{'course':'算法设计与分析','teacher':'赵修洁','score':'67','point':'4'}," +
                "{'course':'计算机图形学','teacher':'康成化','score':'58','point':'0'}]}";
        list.add(json1);
        list.add(json2);
        list.add(json3);
        list.add(json4);
        return list;
    }

    /**
     * 学生课表查询
     * @param model
     * @return
     */
    public String getCourseTable(Model model){
        String json = "{'semester':'2018年第一学期课程'," +
                "}";
        return null;
    }
}
