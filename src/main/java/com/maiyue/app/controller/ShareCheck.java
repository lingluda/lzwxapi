package com.maiyue.app.controller;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import com.maiyue.app.bean.Adinfo;
import com.maiyue.app.bean.Admedia;
import com.maiyue.app.bean.Admodule;
import com.maiyue.app.bean.AppCategory;
import com.maiyue.app.bean.AppInfo;
import com.maiyue.app.bean.AppPicture;
import com.maiyue.app.bean.AppReview;
import com.maiyue.app.bean.AppScore;
import com.maiyue.app.bean.BrowHist;
import com.maiyue.app.bean.InstPackage;
import com.maiyue.app.bean.UserInfo;
import com.maiyue.app.constant.BusinessConstant;
import com.maiyue.app.constant.Constant;
import com.maiyue.app.service.AdinfoService;
import com.maiyue.app.service.AdmediaService;
import com.maiyue.app.service.AdmoduleService;
import com.maiyue.app.service.AppCategoryService;
import com.maiyue.app.service.AppInfoService;
import com.maiyue.app.service.AppPictureService;
import com.maiyue.app.service.AppReviewService;
import com.maiyue.app.service.AppScoreService;
import com.maiyue.app.service.BrowHistService;
import com.maiyue.app.service.InstPackageService;
import com.maiyue.app.service.UserInfoService;
import com.maiyue.app.utils.RedisUtil;

@Component
@EnableAutoConfiguration
public class ShareCheck extends BaseController{

	
	@Resource(name = "appReviewService")
    private AppReviewService appReviewService;
	
	@Resource(name = "appInfoService")
	private AppInfoService appInfoService;
	
	@Resource(name = "appCategoryService")
	private AppCategoryService appCategoryService;
	
	@Resource(name = "appScoreService")
	private AppScoreService appScoreService;
	
	@Resource(name = "browHistService")
	private BrowHistService browHistService;
	
	@Resource(name = "instPackageService")
	private InstPackageService instPackageService;
	
	@Resource(name = "userInfoService")
	private UserInfoService userInfoService;
	
	@Resource(name = "appPictureService")
	private AppPictureService appPictureService;
	
	@Resource(name = "adinfoService")
	private AdinfoService adinfoService;
	
	@Resource(name = "admoduleService")
	private AdmoduleService admoduleService;
	
	@Resource(name = "admediaService")
	private AdmediaService admediaService;
	
	@Resource(name = "redisUtil")
	private RedisUtil redisUtil;
	
	
	/***
     * 校验是否是有效ID
     * @param value
     * @param type
     * @return
     */
    public synchronized boolean isEffective(String value,String type){
    	boolean resut = false;
    	if(redisUtil.get(value) == null){
    		if(Constant.APP_INFO_ID.equals(type)){//-----------------------------------------App信息
    			AppInfo appInfo = appInfoService.selectById(value);
    			resut = this.CommonCheck(appInfo,appInfo.getAppState(),value);
    		}else if(Constant.APP_SCORE_ID.equals(type)){ //---------------------------------APP得分
    			AppScore appScore = appScoreService.selectById(value);
    			resut = this.CommonCheck(appScore,appScore.getState(),value);
    		}else if(Constant.APP_REWIEW_ID.equals(type)){ //---------------------------------APP评论
    			AppReview appReview = appReviewService.selectById(value);
    			resut = this.CommonCheck(appReview,appReview.getState(),value);
    		}else if(Constant.APP_CATEGORY_ID.equals(type)){ //------------------------------APP类别
    			AppCategory category = appCategoryService.selectById(value);
    			resut = this.CommonCheck(category,category.getState(),value);
    		}else if(Constant.APP_BROW_HIST.equals(type)){ //--------------------------------浏览历史
    			BrowHist browHist = browHistService.selectById(value);
    			resut = this.CommonCheck(browHist,browHist.getState(),value);
    		}else if(Constant.APP_INSTALL_PACK.equals(type)){ //----------------------------APP安装包
    			InstPackage instPackage = instPackageService.selectById(value);
    			resut = this.CommonCheck(instPackage,instPackage.getInstallState(),value);
    		}else if(Constant.APP_INSTALL_PACK.equals(type)){ //-----------------------------应用平台用户
    			UserInfo userInfo = userInfoService.getByUserName(value);
    			resut = this.CommonCheck(userInfo,userInfo.getState(),value);
    		}else if(Constant.APP_PICTURE.equals(type)){ //---------------------------------APP图片
    			AppPicture appPicture = appPictureService.selectById(value);
    			resut = this.CommonCheck(appPicture,appPicture.getPictureState(),value);
    		}else if(Constant.AD_INFO.equals(type)){ //--------------------------------------广告信息
    			Adinfo adinfo = adinfoService.selectById(value);
    			resut = this.CommonCheck(adinfo,adinfo.getState(),value);
    		}else if(Constant.AD_MODULE.equals(type)){ //--------------------------------------广告模块
    			Admodule admodule = admoduleService.selectById(value);
    			resut = this.CommonCheck(admodule,admodule.getState(),value);
    		}else if(Constant.AD_MEDIA.equals(type)){ //--------------------------------------广告资源
    			Admedia media = admediaService.selectById(value);
    			resut = this.CommonCheck(media,media.getState(),value);
    		}
    	}else{
    		resut = (boolean) redisUtil.get(value);
    	}
		return resut;
    }
    
    
    
    
    
    
    /***
     * 校验
     * @param object
     * @param state
     * @param value
     * @return
     */
    private synchronized boolean CommonCheck(Object object,String state,String value){
    	boolean resut = false;
    	if(object != null){
			if(StringUtils.isNotBlank(state)){
				if(BusinessConstant.COMMON_STATE_STAY.equals(state)){
        			resut = true;
        			redisUtil.set(value, true,Constant.exTime());
				}else{
					redisUtil.set(value, false,Constant.exTime());
				}
			}else{
				redisUtil.set(value, false,Constant.exTime());
			}
		}
		else
		redisUtil.set(value, false,Constant.exTime());
    	return resut;
    }
    
    
    
    
    
    
    
}
