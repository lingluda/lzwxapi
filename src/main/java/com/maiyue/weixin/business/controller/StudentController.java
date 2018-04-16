package com.maiyue.weixin.business.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.business.bean.Student;
import com.maiyue.weixin.business.service.StudentService;
import com.maiyue.weixin.constant.Constant;
import com.maiyue.weixin.controller.BaseController;
import com.maiyue.weixin.utils.ComUtil;
import com.maiyue.weixin.utils.ReflectUtil;
import com.maiyue.weixin.utils.ResponseUtil;
import com.maiyue.weixin.utils.jsonUtil.JSONUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * StudentController
 * 2018/04/15
 */
@RestController
@RequestMapping("/student/*")
@Api(value = "StudentController", description = "学生信息接口")
public class StudentController extends BaseController {
    
    
    private static Logger logger = LoggerFactory.getLogger(StudentController.class);
    
    @Resource(name = "studentService")
    private StudentService studentService;

    /**
     * 分页查询方法,POST方法
     * @param student 实体
     */
    @ApiOperation(value="student分页查询接口", notes="分页查询数据接口")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "ids", value = "ID-IN查询", dataType = "List")
    })
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(@RequestParam(value ="ids",required=false) ArrayList ids[], Student student) {
        
        try {
            logger.info("调用student分页查询接口！");
            Map<String,Object> params = ReflectUtil.beanToMap(student, true);
            params.put(Constant.IN_SELECT_IDS,ids);//in查询
            PageInfo<Student> data = studentService.getPageData(params);
            return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
        } catch (Exception e) {
            logger.error("调用student分页查询接口,异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 新增数据,POST方法
     * @param student 实体
     */
    @ApiOperation(value="新增student数据接口", notes="新增数据接口")
    @RequestMapping(value="newly",method= RequestMethod.POST)
    public ModelMap newly(Student student) {
        
         try {
             logger.info("调用student数据新增接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(student != null){
                student.setId(ComUtil.randomUUID());
                studentService.insert(student);
                 logger.info("调用student数据新增接口,执行保存数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(student));
            }
            return ResponseUtil.RetErrorInfo("student is null!");
        } catch (Exception e) {
            logger.error("调用student数据新增接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 编辑数据,POST方法
     * @param student 实体
     */
    @ApiOperation(value="编辑student数据接口", notes="编辑数据接口")
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(Student student) {
        
         try {
             logger.info("调用student数据编辑接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(student != null){
                studentService.update(student);
                 logger.info("调用student数据编辑接口,执行编辑数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(student));
            }
            return ResponseUtil.RetErrorInfo("student is null!");
        } catch (Exception e) {
            logger.error("调用student数据编辑接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 按ID查询数据,POST,get 方法
     * @param student 实体
     */
    @ApiOperation(value="按ID查询student数据接口", notes="按ID查询数据接口")
    @ApiParam(name = "id", value = "ID查询")
    @RequestMapping(value="findById",method= RequestMethod.POST)
    public ModelMap findById(@RequestParam(value ="id",required=false) String id) {
        
         try {
              logger.info("调用student按ID查询数据接口！");
             if(StringUtils.isBlank(id)){
                  return ResponseUtil.RetErrorInfo(" The id is null!");
                 }
                Student  student = studentService.selectById(id);
                if(student == null){
                     return ResponseUtil.RetErrorInfo(" The object is null!");
                }
                 logger.info("调用student按ID查询数据接口,执行成功！");
                 return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(student));
            } catch (Exception e) {
                logger.error("调用student按ID查询数据接口异常:" + e.getCause().getMessage(),e);
                return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
            }
        }
    
    /*
     * 显示学生个人信息：头像图片、姓名、学院、专业、班级、学号、辅导员
     * */
    @ApiOperation(value = "显示学生个人信息数据接口",notes="按ID(UUID)查询个人信息")
    @ApiParam(name = "id",value="ID查询")
    @RequestMapping(value="showStudentInfo",method= RequestMethod.POST)
    public ModelMap showStudentInfo(@RequestParam(value="id",required=false) String id){
            
    	logger.info("调用student按ID查询数据接口！返回学生个人信息");
            if(StringUtils.isBlank(id)){
                 return ResponseUtil.RetErrorInfo(" The id is null!");
            }
            
               Student  student = studentService.selectById(id);
               if(student == null){
                    return ResponseUtil.RetErrorInfo(" The object is null!");
               }
               Map<String, Object> result =  ReflectUtil.beanToMap(student, true);
               System.out.println("test");
               System.out.println("-------->"+result);
               System.out.println(result.toString());
               //学院Service。根据学生的学院ID查出 学院名称。
               //专业Service。  根据专业id查出专业名称
               
                logger.info("调用student按ID查询数据接口,执行成功！......");
               return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(student));
               // return  null;
                
    }
    
}