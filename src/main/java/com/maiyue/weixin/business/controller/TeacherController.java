package com.maiyue.weixin.business.controller;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Dept;
import com.maiyue.weixin.base.bean.Major;
import com.maiyue.weixin.base.service.DeptService;
import com.maiyue.weixin.base.service.MajorService;
import com.maiyue.weixin.business.bean.Teacher;
import com.maiyue.weixin.business.bean.Teacher;
import com.maiyue.weixin.business.service.TeacherService;
import com.maiyue.weixin.constant.Constant;
import com.maiyue.weixin.controller.BaseController;
import com.maiyue.weixin.utils.ComUtil;
import com.maiyue.weixin.utils.ReflectUtil;
import com.maiyue.weixin.utils.ResponseUtil;
import com.maiyue.weixin.utils.jsonUtil.JSONUtils;
import io.swagger.annotations.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

/**
 * TeacherController
 * 2018/04/16
 */
@RestController
@RequestMapping("/teacher/*")
@Api(value = "TeacherController", description = "教师个人信息接口")
public class TeacherController extends BaseController {
    
    
    private static Logger logger = LoggerFactory.getLogger(TeacherController.class);
    
    @Resource(name = "teacherService")
    private TeacherService teacherService;

    @Resource(name = "majorService")
    private MajorService majorService;

    @Resource(name = "deptService")
    private DeptService deptService;

    /**
     * 分页查询方法,POST方法
     * @param teacher 实体
     */
    @ApiOperation(value="teacher分页查询接口", notes="分页查询数据接口")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "ids", value = "ID-IN查询", dataType = "List")
    })
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(@RequestParam(value ="ids",required=false) ArrayList ids, Teacher teacher) {
        
        try {
            logger.info("调用teacher分页查询接口！");
            Map<String,Object> params = ReflectUtil.beanToMap(teacher, true);
            params.put(Constant.IN_SELECT_IDS,ids);//in查询
            PageInfo<Teacher> data = teacherService.getPageData(params);
            return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
        } catch (Exception e) {
            logger.error("调用teacher分页查询接口,异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 新增数据,POST方法
     * @param teacher 实体
     */
    @ApiOperation(value="新增teacher数据接口", notes="新增数据接口")
    @RequestMapping(value="newly",method= RequestMethod.POST)
    public ModelMap newly(Teacher teacher) {
        
         try {
             logger.info("调用teacher数据新增接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(teacher != null){
                teacher.setId(ComUtil.randomUUID());
                teacherService.insert(teacher);
                 logger.info("调用teacher数据新增接口,执行保存数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(teacher));
            }
            return ResponseUtil.RetErrorInfo("teacher is null!");
        } catch (Exception e) {
            logger.error("调用teacher数据新增接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 编辑数据,POST方法
     * @param teacher 实体
     */
    @ApiOperation(value="编辑teacher数据接口", notes="编辑数据接口")
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(Teacher teacher) {
        
         try {
             logger.info("调用teacher数据编辑接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(teacher != null){
                teacherService.update(teacher);
                 logger.info("调用teacher数据编辑接口,执行编辑数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(teacher));
            }
            return ResponseUtil.RetErrorInfo("teacher is null!");
        } catch (Exception e) {
            logger.error("调用teacher数据编辑接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 按ID查询数据,POST,get 方法
     * @param teacher 实体
     */
    @ApiOperation(value="按ID查询teacher数据接口", notes="按ID查询数据接口")
    @ApiParam(name = "id", value = "ID查询",required=true)
    @RequestMapping(value="findById",method= RequestMethod.POST)
    public ModelMap findById(@RequestParam(value ="id",required=false) String id) {
        
         try {
              logger.info("调用teacher按ID查询数据接口！");
             if(StringUtils.isBlank(id)){
                  return ResponseUtil.RetErrorInfo(" The id is null!");
                 }
                Teacher  teacher = teacherService.selectById(id);
                if(teacher == null){
                     return ResponseUtil.RetErrorInfo(" The object is null!");
                }
                 logger.info("调用teacher按ID查询数据接口,执行成功！");
                 return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(teacher));
            } catch (Exception e) {
                logger.error("调用teacher按ID查询数据接口异常:" + e.getCause().getMessage(),e);
                return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
            }
        }

    /*
     * 显示教师个人信息：头像图片、姓名、学院、专业、班级、学号、辅导员
     * */
    @ApiOperation(value = "显示教师个人信息数据接口", notes = "按ID(UUID)查询个人信息")
    @ApiParam(name = "id", value = "ID查询")
    @RequestMapping(value = "showTeacherInfo", method = RequestMethod.POST)
    public ModelMap showTeacherInfo(@RequestParam(value = "id", required = false) String id) {

        logger.info("调用teacher按ID查询数据接口！返回学生个人信息");
        if (StringUtils.isBlank(id)) {
            return ResponseUtil.RetErrorInfo(" The id is null!");
        }

        Teacher teacher = teacherService.selectById(id);
        if (teacher == null) {
            return ResponseUtil.RetErrorInfo(" The object is null!");
        }
        Map<String, Object> result = ReflectUtil.beanToMap(teacher, false);
        //隔离的字段
//        String ex[] = {"id","sex","birthday","nationCode","idenId","nativePlaceId","areaId","politicalId","entranceGrade","adress","email"
//                ,"oneCard","bankAccount"};
        //Major major = majorService.selectByCode(teacher.getMajorCode());
        Dept dept = deptService.selectByCode(teacher.getDeptCode());
        //result.put("majorName",major.getName());
        result.put("deptName",dept.getName());


        logger.info("调用teacher按ID查询数据接口,执行成功！......");
        //返回result就会过滤null的字段，返回 teacher 实体，就会返回所有字段
        return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(result));


    }
}