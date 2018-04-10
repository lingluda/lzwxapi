package com.maiyue.weixin.controller;

import java.util.Date;

import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maiyue.weixin.base.bean.Role;
import com.maiyue.weixin.base.service.PermissionService;
import com.maiyue.weixin.base.service.RoleService;
import com.maiyue.weixin.base.service.UserService;
import com.maiyue.weixin.constant.Business;
import com.maiyue.weixin.utils.ComUtil;
import com.maiyue.weixin.utils.RedisUtil;
import com.maiyue.weixin.utils.ResponseUtil;
import com.maiyue.weixin.utils.jsonUtil.JSONUtils;

/***
 * 基本信息接口
 * @author Admin
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/basic/")
public class BasicController extends BaseController{

	
	    @Resource(name = "userService")
	    private UserService userService;
	    
	    @Resource(name = "roleService")
	    private RoleService roleService;
	    
	    @Resource(name = "permissionService")
	    private PermissionService permissionService;
	   
	    @Resource(name = "redisUtil")
	    private RedisUtil redisUtil;
	    
	    private static Logger logger = LoggerFactory.getLogger(BasicController.class);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    /***
	     * 新增角色
	     * @param roleName
	     * @return
	     */
	    @PostMapping(value="role/new")
	    public ModelMap newRole(@RequestParam(value="roleName",required=false)String roleName) {
	    	try {
	    		if(StringUtils.isBlank(roleName)){
	    			return ResponseUtil.RetErrorInfo("roleName is null!");
	    		}
	    		Role role = new Role();
	    		role.setId(ComUtil.BusinessID());
	    		role.setCreatetime(new Date());
	    		role.setStatus(Business.COMMON_STATE_STAY);
	    		roleService.insert(role);
	    		logger.debug("新增角色成功,ID={}", role.getId());
	    		return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(role));
			} catch (Exception e) {
				logger.error("新增角色,异常：" + e.getCause().getMessage(), e);
				return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
			}
		}
	    
	    
	    /***
	     * 新增角色
	     * @param roleName
	     * @return
	     */
	    @RequestMapping(value="role/edit/{id}")
	    public ModelMap editRole(@PathVariable("id")String id) {
	    	try {
	    		Role role = roleService.selectById(id);
	    		if(role == null){
	    			
	    		}
	    		logger.debug("新增角色成功,ID={}", role.getId());
	    		return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(role));
			} catch (Exception e) {
				logger.error("新增角色,异常：" + e.getCause().getMessage(), e);
				return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
			}
		}
	
	
}
