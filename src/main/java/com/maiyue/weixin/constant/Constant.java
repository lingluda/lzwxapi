package com.maiyue.weixin.constant;

import org.apache.commons.lang3.RandomUtils;

/**
 * Created by huang on 2016/3/8.
 */
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

    
    
    
    
    
    
    
    
    /***
     * 上传下载路径键
     */
    public final static String UP_DOWN_LOAD_PATH = "up_down_load_path";
    
    /***
     * 缓存路径
     */
    public final static String UP_DOWN_TEMP_PATH = "up_down_temp_path";
    
    /***
     * 所在盘符
     */
    public final static String WHERE_DISK_PATH = "where_disk_path";
    
    
    
    
    
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
