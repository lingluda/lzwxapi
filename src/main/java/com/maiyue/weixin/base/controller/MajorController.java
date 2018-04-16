package com.maiyue.weixin.base.controller;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Major;
import com.maiyue.weixin.base.service.MajorService;
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
import java.util.List;
import java.util.Map;

/**
 * MajorController
 * 2018/04/16
 */
@RestController
@RequestMapping("/major/*")
@Api(value = "MajorController", description = "专业信息接口")
public class MajorController extends BaseController {
    
    
    private static Logger logger = LoggerFactory.getLogger(MajorController.class);
    
    @Resource(name = "majorService")
    private MajorService majorService;

    /**
     * 分页查询方法,POST方法
     * @param major 实体
     */
    @ApiOperation(value="major分页查询接口", notes="分页查询数据接口")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "ids", value = "ID-IN查询", dataType = "List")
    })
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(@RequestParam(value ="ids",required=false) ArrayList ids, Major major) {
        
        try {
            logger.info("调用major分页查询接口！");
            Map<String,Object> params = ReflectUtil.beanToMap(major, true);
            params.put(Constant.IN_SELECT_IDS,ids);//in查询
            PageInfo<Major> data = majorService.getPageData(params);
            return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
        } catch (Exception e) {
            logger.error("调用major分页查询接口,异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 新增数据,POST方法
     * @param major 实体
     */
    @ApiOperation(value="新增major数据接口", notes="新增数据接口")
    @RequestMapping(value="newly",method= RequestMethod.POST)
    public ModelMap newly(Major major) {
        
         try {
             logger.info("调用major数据新增接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(major != null){
                major.setId(ComUtil.randomUUID());
                majorService.insert(major);
                 logger.info("调用major数据新增接口,执行保存数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(major));
            }
            return ResponseUtil.RetErrorInfo("major is null!");
        } catch (Exception e) {
            logger.error("调用major数据新增接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 编辑数据,POST方法
     * @param major 实体
     */
    @ApiOperation(value="编辑major数据接口", notes="编辑数据接口")
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(Major major) {
        
         try {
             logger.info("调用major数据编辑接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(major != null){
                majorService.update(major);
                 logger.info("调用major数据编辑接口,执行编辑数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(major));
            }
            return ResponseUtil.RetErrorInfo("major is null!");
        } catch (Exception e) {
            logger.error("调用major数据编辑接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 按ID查询数据,POST,get 方法
     * @param major 实体
     */
    @ApiOperation(value="按ID查询major数据接口", notes="按ID查询数据接口")
    @ApiParam(name = "id", value = "ID查询",required=true)
    @RequestMapping(value="findById",method= RequestMethod.POST)
    public ModelMap findById(@RequestParam(value ="id",required=false) String id) {
        
         try {
              logger.info("调用major按ID查询数据接口！");
             if(StringUtils.isBlank(id)){
                  return ResponseUtil.RetErrorInfo(" The id is null!");
                 }
                Major  major = majorService.selectById(id);
                if(major == null){
                     return ResponseUtil.RetErrorInfo(" The object is null!");
                }
                 logger.info("调用major按ID查询数据接口,执行成功！");
                 return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(major));
            } catch (Exception e) {
                logger.error("调用major按ID查询数据接口异常:" + e.getCause().getMessage(),e);
                return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
            }
        }

    /**
     * 按code查询数据,POST,get 方法
     * @param major 实体
     */
    @ApiOperation(value="按code查询major数据接口", notes="按专业代码查询数据接口")
    @ApiParam(name = "majorCode", value = "CODE查询",required=true)
    @RequestMapping(value="findByCode",method= RequestMethod.POST)
    public ModelMap findByCode(@RequestParam(value ="majorCode",required=false) String majorCode) {

         try {
              logger.info("调用major按code查询数据接口！");
             if(StringUtils.isBlank(majorCode)){
                  return ResponseUtil.RetErrorInfo(" The majorCode is null!");
                 }
                Major major = majorService.selectByCode(majorCode);
                if(major == null){
                     return ResponseUtil.RetErrorInfo(" The object is null!");
                }
                 logger.info("调用major按majorCode查询数据接口,执行成功！");
                 return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(major));
            } catch (Exception e) {
                logger.error("调用major按majorCode查询数据接口异常:" + e.getCause().getMessage(),e);
                return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
            }
        }
}