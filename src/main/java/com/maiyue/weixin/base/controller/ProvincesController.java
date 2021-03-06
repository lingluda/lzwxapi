package com.maiyue.weixin.base.controller;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.utils.ReflectUtil;
import com.maiyue.weixin.base.bean.Provinces;
import com.maiyue.weixin.base.service.ProvincesService;
import com.maiyue.weixin.constant.Constant;
import com.maiyue.weixin.controller.BaseController;
import com.maiyue.weixin.utils.ComUtil;
import com.maiyue.weixin.utils.ResponseUtil;
import com.maiyue.weixin.utils.jsonUtil.JSONUtils;
import io.swagger.annotations.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProvincesController
 * 2018/04/13
 */
@RestController
@RequestMapping("/provinces/*")
@Api(value = "ProvincesController", description = "中国省份接口（直辖市、省、自治区）")
public class ProvincesController extends BaseController {
    
    
    private static Logger logger = LoggerFactory.getLogger(ProvincesController.class);
    
    @Resource(name = "provincesService")
    private ProvincesService provincesService;

    /**
     * 分页查询方法,POST方法
     * @param provinces 实体
     */
    @ApiOperation(value="provinces分页查询接口", notes="分页查询数据接口")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "ids", value = "ID-IN查询", dataType = "List")
    })
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(@RequestParam(value ="ids[]",required=false) ArrayList ids[], Provinces provinces) {
        
        try {
            logger.info("调用provinces分页查询接口！");
            Map<String,Object> params = ReflectUtil.beanToMap(provinces, true);
            params.put(Constant.IN_SELECT_IDS,ids);//in查询
            PageInfo<Provinces> data = provincesService.getPageData(params);
            return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
        } catch (Exception e) {
            logger.error("调用provinces分页查询接口,异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 新增数据,POST方法
     * @param provinces 实体
     */
    /*@ApiOperation(value="新增provinces数据接口", notes="新增数据接口")
=======
    @ApiOperation(value="新增provinces数据接口", notes="新增数据接口")
>>>>>>> remotes/origin/Develop
=======
    @ApiOperation(value="新增provinces数据接口", notes="新增数据接口")
>>>>>>> remotes/origin/Develop
    @RequestMapping(value="newly",method= RequestMethod.POST)
    public ModelMap newly(Provinces provinces) {
        
         try {
             logger.info("调用provinces数据新增接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(provinces != null){
                provinces.setId(ComUtil.randomUUID());
                provincesService.insert(provinces);
                 logger.info("调用provinces数据新增接口,执行保存数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(provinces));
            }
            return ResponseUtil.RetErrorInfo("provinces is null!");
        } catch (Exception e) {
            logger.error("调用provinces数据新增接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }*/

    /**
     * 编辑数据,POST方法
     * @param provinces 实体
     */
    /*@ApiOperation(value="编辑provinces数据接口", notes="编辑数据接口")
    @ApiOperation(value="编辑provinces数据接口", notes="编辑数据接口")
    @ApiOperation(value="编辑provinces数据接口", notes="编辑数据接口")
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(Provinces provinces) {
        
         try {
             logger.info("调用provinces数据编辑接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(provinces != null){
                provincesService.update(provinces);
                 logger.info("调用provinces数据编辑接口,执行编辑数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(provinces));
            }
            return ResponseUtil.RetErrorInfo("provinces is null!");
        } catch (Exception e) {
            logger.error("调用provinces数据编辑接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }

    /**
     * 按ID查询数据,POST,get 方法
     * @param provinces 实体
     */
    @ApiOperation(value="按ID查询provinces数据接口", notes="按ID查询数据接口")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "id", value = "ID查询", dataType = "String")
    })
    @RequestMapping(value="findById",method= RequestMethod.POST)
    public ModelMap findById(@RequestParam(value ="id",required=false) String id) {
        
         try {
              logger.info("调用provinces按ID查询数据接口！");
             if(StringUtils.isBlank(id)){
                  return ResponseUtil.RetErrorInfo(" The id is null!");
                 }
                Provinces  provinces = provincesService.selectById(id);
                if(provinces == null){
                     return ResponseUtil.RetErrorInfo(" The object is null!");
                }
                 logger.info("调用provinces按ID查询数据接口,执行成功！");
                 return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(provinces));
            } catch (Exception e) {
                logger.error("调用provinces按ID查询数据接口异常:" + e.getCause().getMessage(),e);
                return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
            }
        }
}