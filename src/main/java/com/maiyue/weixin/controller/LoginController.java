package com.maiyue.weixin.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.maiyue.weixin.base.bean.User;
import com.maiyue.weixin.base.service.UserService;
import com.maiyue.weixin.constant.Constant;
import com.maiyue.weixin.utils.RedisUtil;
import com.maiyue.weixin.utils.ResponseUtil;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


@RestController
@EnableAutoConfiguration
public class LoginController extends BaseController{

	@Autowired
    private UserService userService;
	
    @Autowired
    private DefaultKaptcha defaultKaptcha;
    
    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;

    
    
    
    
    /***
     * 登录界面
     * @param username
     * @param password
     * @param verifyCode
     * @return
     */
    @PostMapping("/sign/login")
    public ModelMap login(@RequestParam(name = "username",required = false) String username
                        //@RequestParam(name = "password",required = false)String password,
                        //@RequestParam(name="verifyCode",required = false)String verifyCode
                        ){
        String password = "123456";
        String msg = "";
        if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
           UsernamePasswordToken token = new UsernamePasswordToken(username, password);
           Subject currentUser = SecurityUtils.getSubject();
           try {
                	//在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
                    //每个Realm都能在必要时对提交的AuthenticationTokens作出反应Constant
                    //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中
                   currentUser.login(token);
                   User userInfo = userService.findByUsername(username);
                   super.setSession(Constant.SESSION_MANAGER_USER_KEY,userInfo);
                   return ResponseUtil.RetCorrectInfo("登陆成功！");
                }catch(UnknownAccountException uae){
                    msg = "用户名不存在";
                }catch(IncorrectCredentialsException ice){
                    msg = "密码不正确";
                }catch(LockedAccountException lae){
                    msg = "账户已锁定";
                }catch(ExcessiveAttemptsException eae){
                    msg = "用户名或密码错误次数超过5次";
                }
        }else{
            msg = "用户名或密码不能为空";
        }
        return ResponseUtil.RetErrorInfo(msg);
    }

    
    
    
    
    
    /***
     * 验证码
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping("/verify/code")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            super.setSession(Constant.SESSION_VERIFY_CODE, createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    
    
    /***
     * 退出
     * @param response
     * @throws IOException
     */
    @GetMapping("/sign/logout")
    public void logout(HttpServletResponse response) throws IOException {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        response.sendRedirect("/login.html");
    }

    
    
    
}
