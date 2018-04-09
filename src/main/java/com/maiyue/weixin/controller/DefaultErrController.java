package com.maiyue.weixin.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maiyue.weixin.utils.ResponseUtil;

/***
 * 请求异常统一处理
 * @author Admin
 */
@ControllerAdvice
public class DefaultErrController {
	
	 /**
     * 系统异常处理，比如：404,500
     * @param req
     * @param resp
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public @ResponseBody Map<String,Object> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
             return ResponseUtil.ReqError("No interface can be found!(404)");
        } else {
        	return ResponseUtil.ReqError("System error! (500),exception:'"+e.getCause().getMessage());
        }
    }
    
    
}