package com.maiyue.weixin.business.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.maiyue.weixin.business.bean.ScheduleArrange;
import com.maiyue.weixin.business.service.ScheduleArrangeService;
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
 * ScheduleArrangeController
 * 2018/04/13
 */
@RestController
@RequestMapping("/scheduleArrange/*")
@Api(value = "ScheduleArrangeController", description = "课表安排(包含班级、个人)接口")
public class ScheduleArrangeController extends BaseController {
    
    
    private static Logger logger = LoggerFactory.getLogger(ScheduleArrangeController.class);
    
    @Resource(name = "scheduleArrangeService")
    private ScheduleArrangeService scheduleArrangeService;

    /**
     * 分页查询方法,POST方法
     * @param scheduleArrange 实体
     */
    @ApiOperation(value="scheduleArrange分页查询接口", notes="分页查询数据接口")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "ids", value = "ID-IN查询", dataType = "List")
    })
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(@RequestParam(value ="ids",required=false) ArrayList ids[], ScheduleArrange scheduleArrange) {
        
        try {
            logger.info("调用scheduleArrange分页查询接口！");
            Map<String,Object> params = ReflectUtil.beanToMap(scheduleArrange, true);
            params.put(Constant.IN_SELECT_IDS,ids);//in查询
            PageInfo<ScheduleArrange> data = scheduleArrangeService.getPageData(params);
            return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
        } catch (Exception e) {
            logger.error("调用scheduleArrange分页查询接口,异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 新增数据,POST方法
     * @param scheduleArrange 实体
     */
    @ApiOperation(value="新增scheduleArrange数据接口", notes="新增数据接口")
    @RequestMapping(value="newly",method= RequestMethod.POST)
    public ModelMap newly(ScheduleArrange scheduleArrange) {
        
         try {
             logger.info("调用scheduleArrange数据新增接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(scheduleArrange != null){
                scheduleArrange.setId(ComUtil.randomUUID());
                scheduleArrange.setCreateTime(new Date());
                scheduleArrangeService.insert(scheduleArrange);
                 logger.info("调用scheduleArrange数据新增接口,执行保存数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(scheduleArrange));
            }
            return ResponseUtil.RetErrorInfo("scheduleArrange is null!");
        } catch (Exception e) {
            logger.error("调用scheduleArrange数据新增接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 编辑数据,POST方法
     * @param scheduleArrange 实体
     */
    @ApiOperation(value="编辑scheduleArrange数据接口", notes="编辑数据接口")
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(ScheduleArrange scheduleArrange) {
        
         try {
             logger.info("调用scheduleArrange数据编辑接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(scheduleArrange != null){
                scheduleArrangeService.update(scheduleArrange);
                 logger.info("调用scheduleArrange数据编辑接口,执行编辑数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(scheduleArrange));
            }
            return ResponseUtil.RetErrorInfo("scheduleArrange is null!");
        } catch (Exception e) {
            logger.error("调用scheduleArrange数据编辑接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 按ID查询数据,POST,get 方法
     * @param scheduleArrange 实体
     */
    @ApiOperation(value="按ID查询scheduleArrange数据接口", notes="按ID查询数据接口")
    @ApiParam(name = "id", value = "ID查询")
    @RequestMapping(value="findById",method= RequestMethod.POST)
    public ModelMap findById(@RequestParam(value ="id",required=false) String id) {
        
         try {
              logger.info("调用scheduleArrange按ID查询数据接口！");
             if(StringUtils.isBlank(id)){
                  return ResponseUtil.RetErrorInfo(" The id is null!");
                 }
                ScheduleArrange  scheduleArrange = scheduleArrangeService.selectById(id);
                if(scheduleArrange == null){
                     return ResponseUtil.RetErrorInfo(" The object is null!");
                }
                 logger.info("调用scheduleArrange按ID查询数据接口,执行成功！");
                 return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(scheduleArrange));
            } catch (Exception e) {
                logger.error("调用scheduleArrange按ID查询数据接口异常:" + e.getCause().getMessage(),e);
                return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
            }
        }
}