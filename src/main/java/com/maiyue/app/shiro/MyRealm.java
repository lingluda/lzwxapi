package com.maiyue.app.shiro;


import com.maiyue.app.bean.UserInfo;
import com.maiyue.app.constant.Constant;
import com.maiyue.app.service.UserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;
    /**
     * 为当前登录的Subject授予角色和权限
     *   经测试:本例中该方法的调用时机为需授权资源被访问时
     *   经测试:并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
     *   个人感觉若使用了Spring3.1开始提供的ConcurrentMapCache支持,则可灵活决定是否启用AuthorizationCache
     *   比如说这里从数据库获取权限信息时,先去访问Spring3.1提供的缓存,而不使用Shior提供的AuthorizationCache
     */


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //返回权限
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        UserInfo userInfo = userInfoService.getByUserName(username);
        if(userInfo != null){
            if (Constant.USER_STATUS_NORMAL.equals(userInfo.getState())){
                SimpleAuthenticationInfo ai = new SimpleAuthenticationInfo(userInfo.getUserName(),"123456", this.getName());
                return ai;
            }else if(!Constant.USER_STATUS_NORMAL.equals(userInfo.getState())){
                throw new LockedAccountException("账户已停用/锁定");
            }
        }else{
            throw new UnknownAccountException("账户不存在");
        }

        return null;
    }
    
    
    
}