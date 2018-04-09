package com.maiyue.app.constant;

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

    //
    public final static int MANAGER_PERMISSIONS_TYPE_LIST = 1; //列表显示
    public final static int MANAGER_PERMISSIONS_TYPE_BUTTON = 2; //按钮显示
    public final static int MANAGER_PERMISSIONS_TYPE_BUTTON_COMFIRM = 3; //按钮显示,需要确认
    public final static int MANAGER_PERMISSIONS_TYPE_BUTTON_AJAX = 4;//按钮显示,ajax执行,需要确认,显示返回信息
    public final static int MANAGER_PERMISSIONS_TYPE_ACTION = 5;
    public final static int MANAGER_PERMISSIONS_TYPE_ACTION_AJAX = 6;//按钮显示,ajax执行,显示返回信息

    //权限的根节点Pid
    public final static String MANAGER_PERMISSION_ROOT_PID = "0";
    //权限状态
    public final static Integer MANAGER_PERMISSION_STATUS_DISABLE = 0;
    public final static Integer MANAGER_PERMISSION_STATUS_ENABLE = 1;

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
     * APP信息ID
     */
    public final static String APP_INFO_ID = "APP_INFO_ID";
    /***
     * APP评分信息ID
     */
    public final static String APP_SCORE_ID = "APP_SCORE_ID";
    /***
     * APP分类ID
     */
    public final static String APP_CATEGORY_ID = "APP_CATEGORY_ID";
    
    /***
     * APP评论ID
     */
    public final static String APP_REWIEW_ID = "APP_REWIEW_ID";
    
    /***
     * APP浏览历史
     */
    public final static String APP_BROW_HIST = "APP_BROW_HIST";
    
    /***
     * APP浏览历史
     */
    public final static String APP_INSTALL_PACK = "APP_INSTALL_PACK";
    
    /***
     * APP用户信息
     */
    public final static String APP_USER_INFO = "APP_USER_INFO";
    
    /***
     * APP图片信息
     */
    public final static String APP_PICTURE = "APP_PICTURE";
    
    /***
     * AD信息
     */
    public final static String AD_INFO = "AD_INFO";
    
    /***
     * AD模块信息
     */
    public final static String AD_MODULE = "AD_MODULE";
    
    /***
     * AD资源
     */
    public final static String AD_MEDIA = "AD_MEDIA";
    
    
    
    /***
     * 秒 30 - 80之间
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
