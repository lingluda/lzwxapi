package com.maiyue.weixin.base.controller;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.Dept;
import com.maiyue.weixin.base.service.DeptService;
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
 * DeptController
 * 2018/04/16
 */
@RestController
@RequestMapping("/dept/*")
@Api(value = "DeptController", description = "院系信息接口")
public class DeptController extends BaseController {
    
    
    private static Logger logger = LoggerFactory.getLogger(DeptController.class);
    
    @Resource(name = "deptService")
    private DeptService deptService;

    /**
     * 分页查询方法,POST方法
     * @param dept 实体
     */
    @ApiOperation(value="dept分页查询接口", notes="分页查询数据接口")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "ids", value = "ID-IN查询", dataType = "List")
    })
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(@RequestParam(value ="ids",required=false) ArrayList ids, Dept dept) {
        
        try {
            logger.info("调用dept分页查询接口！");
            Map<String,Object> params = ReflectUtil.beanToMap(dept, true);
            params.put(Constant.IN_SELECT_IDS,ids);//in查询
            PageInfo<Dept> data = deptService.getPageData(params);
            return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
        } catch (Exception e) {
            logger.error("调用dept分页查询接口,异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 新增数据,POST方法
     * @param dept 实体
     */
    @ApiOperation(value="新增dept数据接口", notes="新增数据接口")
    @RequestMapping(value="newly",method= RequestMethod.POST)
    public ModelMap newly(Dept dept) {
        
         try {
             logger.info("调用dept数据新增接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(dept != null){
                dept.setId(ComUtil.randomUUID());
                deptService.insert(dept);
                 logger.info("调用dept数据新增接口,执行保存数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(dept));
            }
            return ResponseUtil.RetErrorInfo("dept is null!");
        } catch (Exception e) {
            logger.error("调用dept数据新增接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 编辑数据,POST方法
     * @param dept 实体
     */
    @ApiOperation(value="编辑dept数据接口", notes="编辑数据接口")
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(Dept dept) {
        
         try {
             logger.info("调用dept数据编辑接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(dept != null){
                deptService.update(dept);
                 logger.info("调用dept数据编辑接口,执行编辑数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(dept));
            }
            return ResponseUtil.RetErrorInfo("dept is null!");
        } catch (Exception e) {
            logger.error("调用dept数据编辑接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 按ID查询数据,POST,get 方法
     * @param dept 实体
     */
    @ApiOperation(value="按ID查询dept数据接口", notes="按ID查询数据接口")
    @ApiParam(name = "id", value = "ID查询",required=true)
    @RequestMapping(value="findById",method= RequestMethod.POST)
    public ModelMap findById(@RequestParam(value ="id",required=false) String id) {
        
         try {
              logger.info("调用dept按ID查询数据接口！");
             if(StringUtils.isBlank(id)){
                  return ResponseUtil.RetErrorInfo(" The id is null!");
                 }
                Dept  dept = deptService.selectById(id);
                if(dept == null){
                     return ResponseUtil.RetErrorInfo(" The object is null!");
                }
                 logger.info("调用dept按ID查询数据接口,执行成功！");
                 return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(dept));
            } catch (Exception e) {
                logger.error("调用dept按ID查询数据接口异常:" + e.getCause().getMessage(),e);
                return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
            }
        }
}