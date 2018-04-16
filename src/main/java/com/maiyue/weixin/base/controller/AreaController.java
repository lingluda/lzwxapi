package com.maiyue.weixin.base.controller;

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
import com.maiyue.weixin.base.bean.Area;
import com.maiyue.weixin.base.service.AreaService;
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
 * AreaController
 * 2018/04/13
 */
@RestController
@RequestMapping("/area/*")
@Api(value = "AreaController", description = "")
public class AreaController extends BaseController {
    
    
    private static Logger logger = LoggerFactory.getLogger(AreaController.class);
    
    @Resource(name = "areaService")
    private AreaService areaService;

    /**
     * 分页查询方法,POST方法
     * @param area 实体
     */
    @ApiOperation(value="area分页查询接口", notes="分页查询数据接口")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "ids", value = "ID-IN查询", dataType = "List")
    })
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(@RequestParam(value ="ids[]",required=false) String[] ids, Area area) {
        try {
            logger.info("调用area分页查询接口！");
            Map<String,Object> params = ReflectUtil.beanToMap(area, true);
            params.put(Constant.IN_SELECT_IDS,ids);//in查询
            PageInfo<Area> data = areaService.getPageData(params);
            return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
        } catch (Exception e) {
            logger.error("调用area分页查询接口,异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 新增数据,POST方法
     * @param area 实体
     */
    @ApiOperation(value="新增area数据接口", notes="新增数据接口")
    @RequestMapping(value="newly",method= RequestMethod.POST)
    public ModelMap newly(Area area) {
         try {
             logger.info("调用area数据新增接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(area != null){
                area.setId(ComUtil.randomUUID());
                areaService.insert(area);
                 logger.info("调用area数据新增接口,执行保存数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(area));
            }
            return ResponseUtil.RetErrorInfo("area is null!");
        } catch (Exception e) {
            logger.error("调用area数据新增接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 编辑数据,POST方法
     * @param area 实体
     */
    @ApiOperation(value="编辑area数据接口", notes="编辑数据接口")
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(Area area) {
         try {
             logger.info("调用area数据编辑接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(area != null){
                areaService.update(area);
                 logger.info("调用area数据编辑接口,执行编辑数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(area));
            }
            return ResponseUtil.RetErrorInfo("area is null!");
        } catch (Exception e) {
            logger.error("调用area数据编辑接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
         
    }

    /**
     * 按ID查询数据,POST,get 方法
     * @param area 实体
     */
    @ApiOperation(value="按ID查询area数据接口", notes="按ID查询数据接口")
    @ApiParam(name = "id", value = "ID查询",required=true)
    @RequestMapping(value="findById",method= {RequestMethod.POST,RequestMethod.GET})
    public ModelMap findById(@RequestParam(value ="id",required=false) String id) {
         try {
              logger.info("调用area按ID查询数据接口！");
             if(StringUtils.isBlank(id)){
                  return ResponseUtil.RetErrorInfo(" The id is null!");
                 }
                Area  area = areaService.selectById(id);
                if(area == null){
                     return ResponseUtil.RetErrorInfo(" The object is null!");
                }
                 logger.info("调用area按ID查询数据接口,执行成功！");
                 return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(area));
            } catch (Exception e) {
                logger.error("调用area按ID查询数据接口异常:" + e.getCause().getMessage(),e);
                return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
            }
        }
}