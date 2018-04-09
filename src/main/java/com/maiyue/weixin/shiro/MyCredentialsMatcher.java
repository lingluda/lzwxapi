package com.maiyue.weixin.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 *
 * @author hym
 * @date 2015/11/20
 */
public class MyCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        boolean success = false;

        //密码匹配
        //String encrypt = ComUtil.getMD5(token.getUsername() + "_" + String.valueOf(token.getPassword()));
        //String encrypt = ComUtil.getMD5(String.valueOf(token.getPassword()));
        String encrypt = String.valueOf(token.getPassword());
        Object accountCredentials = getCredentials(info);
        success = equals(encrypt, accountCredentials);
//        if(!success){
//            EhCacheUtil ehCacheUtil = new EhCacheUtil(ehCacheCacheManager,"passwordRetryCache");
//            Integer count = (Integer) ehCacheUtil.get(token.getUsername());
//            if(count != null){
//                if(count<5){
//                    ehCacheUtil.put(token.getUsername(),count+1);
//                }else{
//                    throw new ExcessiveAttemptsException("错误次数超过5次");
//                }
//            }else{
//                ehCacheUtil.put(token.getUsername(),1);
//            }
//        }
        return success;
    }

    
    
}
