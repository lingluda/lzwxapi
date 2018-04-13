package com.maiyue.business.controller;

import com.github.pagehelper.PageInfo;
import com.maiyue.business.bean.Payment;
import com.maiyue.business.service.PaymentService;
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
 * PaymentController
 * 2018/04/13
 */
@RestController
@RequestMapping("/payment/*")
@Api(value = "PaymentController", description = "")
public class PaymentController extends BaseController {
    
    
    private static Logger logger = LoggerFactory.getLogger(PaymentController.class);
    
    @Resource(name = "paymentService")
    private PaymentService paymentService;

    /**
     * 分页查询方法,POST方法
     * @param payment 实体
     */
    @ApiOperation(value="payment分页查询接口", notes="分页查询数据接口")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "ids", value = "ID-IN查询", dataType = "List")
    })
    @RequestMapping(value="getPage",method= RequestMethod.POST)
    public ModelMap getPage(@RequestParam(value ="ids[]",required=false) ArrayList ids[], Payment payment) {
        
        try {
            logger.info("调用payment分页查询接口！");
            Map<String,Object> params = ReflectUtil.beanToMap(payment, true);
            params.put(Constant.IN_SELECT_IDS,ids);//in查询
            PageInfo<Payment> data = paymentService.getPageData(params);
            return ResponseUtil.RetCorrectInfo(JSONUtils.toMapJSONObject(data));
        } catch (Exception e) {
            logger.error("调用payment分页查询接口,异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 新增数据,POST方法
     * @param payment 实体
     */
    @ApiOperation(value="新增payment数据接口", notes="新增数据接口")
    @RequestMapping(value="newly",method= RequestMethod.POST)
    public ModelMap newly(Payment payment) {
        
         try {
             logger.info("调用payment数据新增接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(payment != null){
                payment.setId(ComUtil.randomUUID());
                paymentService.insert(payment);
                 logger.info("调用payment数据新增接口,执行保存数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(payment));
            }
            return ResponseUtil.RetErrorInfo("payment is null!");
        } catch (Exception e) {
            logger.error("调用payment数据新增接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 编辑数据,POST方法
     * @param payment 实体
     */
    @ApiOperation(value="编辑payment数据接口", notes="编辑数据接口")
    @RequestMapping(value="editor",method= RequestMethod.POST)
    public ModelMap editor(Payment payment) {
        
         try {
             logger.info("调用payment数据编辑接口！");
            if(getCurrUser() == null){
                 return ResponseUtil.RetErrorInfo(" The user object is null,please login first!");
            }
            if(payment != null){
                paymentService.update(payment);
                 logger.info("调用payment数据编辑接口,执行编辑数据成功！");
                return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(payment));
            }
            return ResponseUtil.RetErrorInfo("payment is null!");
        } catch (Exception e) {
            logger.error("调用payment数据编辑接口异常:" + e.getCause().getMessage(),e);
            return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
        }
    }

    /**
     * 按ID查询数据,POST,get 方法
     * @param Payment 实体
     */
    @ApiOperation(value="按ID查询payment数据接口", notes="按ID查询数据接口")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "id", value = "ID查询", dataType = "String")
    })
    @RequestMapping(value="findById",method= RequestMethod.POST)
    public ModelMap findById(@RequestParam(value ="id",required=false) String id) {
        
         try {
              logger.info("调用payment按ID查询数据接口！");
             if(StringUtils.isBlank(id)){
                  return ResponseUtil.RetErrorInfo(" The id is null!");
                 }
                Payment payment = paymentService.selectById(id);
                if(payment == null){
                     return ResponseUtil.RetErrorInfo(" The object is null!");
                }
                 logger.info("调用payment按ID查询数据接口,执行成功！");
                 return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(payment));
            } catch (Exception e) {
                logger.error("调用payment按ID查询数据接口异常:" + e.getCause().getMessage(),e);
                return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
            }
        }
}