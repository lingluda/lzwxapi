package com.maiyue.weixin.constant;

import org.apache.commons.lang3.RandomUtils;


public class Constant {


    //manager登录用户session key
    public final static String SESSION_MANAGER_USER_KEY = "currManagerUser";

    public final static String SESSION_VERIFY_CODE = "verifyCode";

    //用户状态
    public final static String USER_STATUS_NORMAL = "0";
    public final static String USER_STATUS_DISABLE = "-1";
    public final static String USER_STATUS_LOCK = "1";


    //权限常量
    //全部权限的redis缓存key
    public final static String CACHAE_MANAGER_PERMISSION_ALL = "cacheManagerPermissionAll";
    //全部权限的redis缓存key
    public final static String CACHAE_MANAGER_PERMISSION_TREE = "cacheManagerPermissionTree";
    //全部权限的redis缓存key
    public final static String CACHAE_MANAGER_PERMISSION_INDEX_TREE = "cacheManagerPermissionIndexTree";

    public final static Integer QUARTZ_TASK_INFO_ENABLE = 1;
    public final static Integer QUARTZ_TASK_INFO_DISABLE = 0;
    
    /**
     * ID-in查询
     */
    public final static String IN_SELECT_IDS = "ids";

    
    /*************************************************** 系统 配置 存入Redis的键***************************************************/
    /***
     * 程序域名
     */
    public final static String DOMAIN_NAME = "SdTC01ZRIT7fUEic6nbM";
    /***
     * 上传下载路径键
     */
    public final static String UP_DOWN_LOAD_PATH = "d0fRGLd747Nc0cytLdKB";
    /***
     * 缓存路径
     */
    public final static String UP_DOWN_TEMP_PATH = "HIOiKggAh1mLurL4zzU9";
    /***
     * 所在盘符
     */
    public final static String WHERE_DISK_PATH = "a45KIdPRG8sBLnjv4WFg";
    /***
     * 程序端口
     */
    public final static String SERVER_PORT = "JPRDYHoPNu2Sk5ZcTRZ6";
    /***
     * 程序默认端口
     */
    public final static Integer DEFAULT_SERVER_PORT = 8100;
    
    /*************************************************** 系统 配置 存入Redis的键 end ***************************************************/
    
    
    
    
    
    
    /***
     * 秒 5 - 30之间
     * @return
     */
    public static long exTime() {
		return RandomUtils.nextLong(5,30);
	}
    
    /***
     * 秒 1800 - 1900之间
     * @return
     */
    public static long SessionTime() {
		return RandomUtils.nextLong(1800,2000);
	}

}
