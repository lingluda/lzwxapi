package com.maiyue.weixin.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.maiyue.weixin.bean.FileBean;
import com.maiyue.weixin.constant.Constant;
import com.maiyue.weixin.utils.FileUtils;
import com.maiyue.weixin.utils.MimeUtil;
import com.maiyue.weixin.utils.RedisUtil;
import com.maiyue.weixin.utils.ResponseUtil;
import com.maiyue.weixin.utils.jsonUtil.JSONUtils;


@Controller
@RequestMapping("/uploader/*")
@EnableAutoConfiguration
public class UploaderController extends BaseController{
	
	
	@Resource(name="redisUtil")
	private RedisUtil redisUtil;
	
	/***
	 * 文件夹目录
	 */
	private static final String Catalog = "catalog.txt";
	
	private static Logger logger = LoggerFactory.getLogger(UploaderController.class);
	
	
	/****
	 * 
	 * 系统内置上传图片界面
	 * @param fileNumLimit
	 * @param fileSizeLimit
	 * @param fileSingleSizeLimit
	 * @return
	 */
	@RequestMapping(value="upload-Picture")
	public ModelAndView uploadPicture(
		   @RequestParam(value="fileNumLimit",required=false,defaultValue="100")String fileNumLimit,
		   @RequestParam(value="fileSizeLimit",required=false,defaultValue="209715200")String fileSizeLimit,
		   @RequestParam(value="fileSingleSizeLimit",required=false,defaultValue="3145728")String fileSingleSizeLimit){
		   ModelAndView mav = new ModelAndView();
		   mav.addObject("fileNumLimit", fileNumLimit);
		   mav.addObject("fileSizeLimit", fileSizeLimit);
		   mav.addObject("fileSingleSizeLimit", fileSingleSizeLimit);
		   mav.setViewName("upload");
		   return mav;
	}
	
	
	
	
	
	
	@RequestMapping(value="index2")
	public String index2() {
		return "upload1";
	}
	
	
	
	
	
	
	
	
	

	   
	   
	   
	   /****
	    * 分片上传
	    * @param request
	    * @param file
	    * @param md5value
	    * @param chunks
	    * @param chunk
	    * @param name
	    * @param type mime类型
	    * @return
	    */
	   @RequestMapping(value="chunkUpload")
	   public @ResponseBody synchronized ModelMap chunkUpload(HttpServletRequest request,MultipartFile file,
			  @RequestParam(value="md5value",required=false)String md5value, 
			  @RequestParam(value="chunks",required=false,defaultValue="0") int chunks, 
			  @RequestParam(value="chunk",required=false,defaultValue="0") int chunk,
			  @RequestParam(value="name",required=false) String name,
			  @RequestParam(value="type",required=false) String type){
		   
		   if(file == null || StringUtils.isBlank(md5value)){
			   return ResponseUtil.RetErrorInfo("file or md5value object is null!");
		   }
		   if(StringUtils.isBlank(name)){
			   return ResponseUtil.RetErrorInfo("name is null!");
		   }
		   //类型文件夹
		   String folder = MimeUtil.getMimeFolder(type);
		   //md5文件名称
	       String fileName = md5value.substring(0, 16).toUpperCase() + name.substring(name.lastIndexOf("."),name.length());
	       String address = this.FilePath(folder) + fileName;//地址
	       logger.debug("fileName:{},chunks(分片总数):{},chunk(当前分片):{},size:{}", name,chunks,chunk,file.getSize());
	       //文件真实名称
	       String OriginFilename = file.getOriginalFilename();
	       try {
	    	   File rf = new File(this.RealPath(folder),fileName);
		       if(!rf.exists()){
		    	   rf.createNewFile();
		       }
	           // 判断文件是否分块
	           if (chunks > 1) {
	        	       //分片
		        	   String chunkName = (md5value + "_" + chunk + ".part"); //+ "_";// + suffix;//分片名称
		        	   long fileSize = FileUtils.MergeFiles(file.getInputStream(), this.TmpPath(), chunkName, rf);//累加合并
		        	   if(fileSize != 0){
		        		   FileBean fileBean = new FileBean(fileName, OriginFilename, address, this.DiskPath(),(fileSize/1024)+"KB");
		        		   String json = JSONUtils.toJSONObject(fileBean, null);
		        		   FileUtils.Catalog(this.CatalogPath(folder), json);//写入目录
		        		   return ResponseUtil.RetCorrectInfo(json);
		        	   }else{
		        		   return ResponseUtil.RetErrorInfo("file is null");
		        	   }
	           } else {
	        	    //保存文件
		            String json = FileUtils.copyInputStreamToFile(file.getInputStream(),this.RealPath(folder),
		            	   fileName,OriginFilename,this.DiskPath());
		            FileUtils.Catalog(this.CatalogPath(folder), json);//写入目录
		            return ResponseUtil.RetCorrectInfo(json);
	           }
	       } catch (Exception ex) {
	           return ResponseUtil.RetErrorInfo(ex.getCause().getMessage());
	       } 
	   }
	   
	   
	   
	   
	   
	   
	   /***
	    * 上传图片
	    * @param request
	    * @param file
	    * @param md5value
	    * @param chunks
	    * @param chunk
	    * @param id
	    * @param type mime类型
	    * @return
	    */
	   @RequestMapping(value="upPicture")
	   public @ResponseBody synchronized ModelMap uploadPicture(MultipartFile file,@RequestParam(value="name",required=false) String name,
			   @RequestParam(value="type",required=false) String type){
		   if(file == null){
			   return ResponseUtil.RetErrorInfo("file object is null!");
		   }
		   if(StringUtils.isBlank(name)){
			   return ResponseUtil.RetErrorInfo("name is null!");
		   }
		   //类型文件夹
		   String folder = MimeUtil.getMimeFolder(type);
		   //UUID文件名称
	       String fileName = FileUtils.UuidName() + name.substring(name.lastIndexOf("."),name.length());
	       //真实文件路径
	       String filePath = this.FilePath(folder);
	       //文件真实名称
	       String OriginFilename = file.getOriginalFilename();
	       try {
        	    //保存文件
	            String json = FileUtils.copyInputStreamToFile(file.getInputStream(),filePath,fileName,OriginFilename,this.DiskPath());
	            FileUtils.Catalog(this.CatalogPath(folder), json);//写入目录
	            return ResponseUtil.RetCorrectInfo(json);
	       } catch (Exception ex) {
	           return ResponseUtil.RetErrorInfo(ex.getCause().getMessage());
	       }
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   /***
	     * 下载文件
	     * @param path
	     * @param request
	     * @param response
	     */
	    @RequestMapping(value = "download",method=RequestMethod.GET) 
		public void download(HttpServletRequest request,HttpServletResponse response,
			   @RequestParam(value="path",required=false)String path,@RequestParam(value="filename",required=false)String filename){
	    	
	    	String downPath = (this.DiskPath() + path);
	    	if(StringUtils.isEmpty(filename) && StringUtils.isBlank(filename)){
	    		filename = path.substring(path.lastIndexOf("/")+1);
	    	}
			File file = new File(downPath);
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			OutputStream fos = null;
			InputStream fis = null;
			try {
		    	String userAgent = request.getHeader("User-Agent");
				String downloadFielName = setBrowserEncoding(userAgent,filename);
				response.setContentType("weixinlication/octet-stream; charset=utf-8"); 
				response.setHeader("Content-Disposition", "attachment; filename="+downloadFielName);
				response.setContentLength(org.apache.commons.io.FileUtils.readFileToByteArray(file).length);//文件大小   k 
				fis = new FileInputStream(file.getAbsolutePath());
				fos = response.getOutputStream();
				bis = new BufferedInputStream(fis);
				bos = new BufferedOutputStream(fos);
				int bytesRead = 0;
				byte[] buffer = new byte[5 * 1024];
				while ((bytesRead = bis.read(buffer)) != -1) {
					bos.write(buffer, 0, bytesRead);
				}
				bos.flush();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
			}finally {
				try {
					bis.close();
					bos.close();
					fos.close();
					fis.close();
				}catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}

	    
	    /***
	     * 下载文件
	     * @param filepath
	     * @param request
	     * @param response
	     */
	    @RequestMapping(value = "download",method=RequestMethod.POST) 
		public void downloadPost(@RequestParam(value="filepath",required=false)String filepath,@RequestParam(value="filename",required=false)String filename,
				HttpServletRequest request, HttpServletResponse response) {
	    	
	    	String ctxPath = this.DiskPath() + filepath;
	    	if(StringUtils.isEmpty(filename) && StringUtils.isBlank(filename)){
	    		filename = filepath.substring(filepath.lastIndexOf("/")+1);
	    	}
			File file = new File(ctxPath);
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			OutputStream fos = null;
			InputStream fis = null;
			try {
		    	String userAgent = request.getHeader("User-Agent");
				String downloadFielName = setBrowserEncoding(userAgent,filename);
				response.setContentType("weixinlication/octet-stream; charset=utf-8"); 
				response.setHeader("Content-Disposition", "attachment; filename="+downloadFielName);
				response.setContentLength(org.apache.commons.io.FileUtils.readFileToByteArray(file).length);//文件大小   k 
				fis = new FileInputStream(file.getAbsolutePath());
				bis = new BufferedInputStream(fis);
				fos = response.getOutputStream();
				bos = new BufferedOutputStream(fos);
				int bytesRead = 0;
				byte[] buffer = new byte[5 * 1024];
				while ((bytesRead = bis.read(buffer)) != -1) {
					bos.write(buffer, 0, bytesRead);
				}
				bos.flush();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
			}finally {
				try {
					bis.close();
					bos.close();
					fos.close();
					fis.close();
				}catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}

	    
	    
	    
	    /**
	     * URL 解码
	     * @return String
	     * @date 2015-3-17 下午04:09:51
	     */
	    @SuppressWarnings("unused")
		private static String getURLDecoderString(String str) {
	        String result = "";
	        if (StringUtils.isBlank(str)) {
	            return "";
	        }
	        try {
	            result = java.net.URLDecoder.decode(str,"UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	    
	    
	    
	    /***
		 * 设置相对应的 浏览器文件名编码
		 * @param userAgent
		 * @param filename
		 * @return
		 */
		public static String setBrowserEncoding(String userAgent,String filename){
			 if(StringUtils.isBlank(userAgent) && StringUtils.isBlank(filename)){
				 return null;
			 }
			 if (userAgent.contains("MSIE")||userAgent.contains("Trident")) {
		            try {
		            	filename = URLEncoder.encode(filename,"UTF-8");
		            } catch (UnsupportedEncodingException e) {
		                e.printStackTrace();
		            }
		      } else { //非IE浏览器的处理：
		            try {
		            	filename = new String(filename.getBytes("UTF-8"),"ISO-8859-1");
		            } catch (UnsupportedEncodingException e) {
		                e.printStackTrace();
		            }
		     }
			return filename;
		}
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   /***
	    * 文件目录
	    * @return
	    */
	   private String CatalogPath(String folder){
		   return this.DiskPath() + this.FilePath(folder) + Catalog;
	   }
	   
		
	   /***
	    * 缓存路径
	    * @return
	    */
	   private String TmpPath(){
		   File file = new File((String) redisUtil.get(Constant.UP_DOWN_TEMP_PATH) + File.separator);
		   if(!file.exists()){
			   file.mkdirs();
		   }
		   return (String) redisUtil.get(Constant.UP_DOWN_TEMP_PATH) + File.separator;
	   }
	   
	   /***
	    * 返回文件路径
	    * @return
	    */
	   private String FilePath(String level){
		   return File.separator + level + FileUtils.TimeFolder();
	   }
	
	   /***
	    * 盘
	    * @return
	    */
	   private String DiskPath(){
		   return (String) redisUtil.get(Constant.WHERE_DISK_PATH);
	   }
	   
	   /***
	    * 文件真实路径 
	    * @return
	    */
	   private String RealPath(String level){
		   String path = this.DiskPath() + this.FilePath(level);
		   File fileFolder = new File(path);
           if (!fileFolder.exists()) {
        	    fileFolder.mkdirs();
           }
		   return path;
	   }
	   

}
