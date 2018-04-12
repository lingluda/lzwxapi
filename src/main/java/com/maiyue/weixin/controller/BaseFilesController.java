package com.maiyue.weixin.controller;

import com.github.pagehelper.PageInfo;
import com.maiyue.weixin.base.bean.BaseFiles;
import com.maiyue.weixin.base.service.BaseFilesService;
import com.maiyue.weixin.constant.Constant;
import com.maiyue.weixin.utils.ComUtil;
import com.maiyue.weixin.utils.ReflectUtil;
import com.maiyue.weixin.utils.ResponseUtil;
import com.maiyue.weixin.utils.jsonUtil.JSONUtils;
import io.swagger.annotations.*;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * BaseFilesController
 * 2018/04/12
 */
@RestController
@RequestMapping("/files/*")
@Api(value = "BaseFilesController系统文件信息")
public class BaseFilesController extends BaseController {
    
    
    private static Logger logger = LoggerFactory.getLogger(BaseFilesController.class);
    
    @Resource(name = "baseFilesService")
    private BaseFilesService baseFilesService;

    /**
     * 分页查询方法,POST方法
     * @param baseFiles 实体
     */
    @ApiOperation(value="baseFiles分页查询接口", notes="分页查询数据接口")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "ids", value = "ID-IN查询", dataType = "List")
    })
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(@RequestParam(value ="ids[]",required=false) String[] ids[], BaseFiles baseFiles) {
        try {
            logger.info("调用baseFiles分页查询接口！");
            Map<String,Object> params = ReflectUtil.beanToMap(baseFiles, true);
            params.put(Constant.IN_SELECT_IDS,ids);//in查询
            PageInfo<BaseFiles> data = baseFilesService.getPageData(params);
            return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
        } catch (Exception e) {
            logger.error("调用baseFiles分页查询接口,异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 新增数据,POST方法
     * @param baseFiles 实体
     */
    @ApiOperation(value="新增baseFiles数据接口", notes="新增数据接口")
    @RequestMapping(value="newly",method= RequestMethod.POST)
    public ModelMap newly(BaseFiles baseFiles) {
        
         try {
             logger.info("调用baseFiles数据新增接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(baseFiles != null){
                baseFiles.setId(ComUtil.BusinessID());
                baseFilesService.insert(baseFiles);
                logger.info("调用baseFiles数据新增接口,执行保存数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(baseFiles));
            }
            return ResponseUtil.RetErrorInfo("baseFiles is null!");
        } catch (Exception e) {
            logger.error("调用baseFiles数据新增接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 编辑数据,POST方法
     * @param baseFiles 实体
     */
    @ApiOperation(value="编辑baseFiles数据接口", notes="编辑数据接口")
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(BaseFiles baseFiles) {
         try {
             logger.info("调用baseFiles数据编辑接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(baseFiles != null){
                baseFilesService.update(baseFiles);
                 logger.info("调用baseFiles数据编辑接口,执行编辑数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(baseFiles));
            }
            return ResponseUtil.RetErrorInfo("baseFiles is null!");
        } catch (Exception e) {
            logger.error("调用baseFiles数据编辑接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }
    
}