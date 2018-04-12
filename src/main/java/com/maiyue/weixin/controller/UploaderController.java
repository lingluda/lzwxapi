package com.maiyue.weixin.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.maiyue.weixin.base.bean.BaseFiles;
import com.maiyue.weixin.base.service.BaseFilesService;
import com.maiyue.weixin.constant.Business;
import com.maiyue.weixin.constant.Constant;
import com.maiyue.weixin.utils.FileUtils;
import com.maiyue.weixin.utils.MimeUtil;
import com.maiyue.weixin.utils.RedisUtil;
import com.maiyue.weixin.utils.ResponseUtil;
import com.maiyue.weixin.utils.jsonUtil.JSONUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/****
 * 上传工具类
 * @author Admin
 */
@Controller
@RequestMapping("/uploader/*")
@EnableAutoConfiguration
@Api(value = "UploaderController", description = "文件上传接口")
public class UploaderController extends BaseController{
	
	
	@Resource(name="redisUtil")
	private RedisUtil redisUtil;
	
	@Resource(name="baseFilesService")
	private BaseFilesService baseFilesService;
	
	/***
	 * 文件夹目录
	 */
	private static final String Catalog = "catalog.txt";
	
	
	private static Logger logger = LoggerFactory.getLogger(UploaderController.class);
	
	
	/****
	 * 系统内置上传界面
	 * @param type
	 * @param fileNumLimit
	 * @param fileSizeLimit
	 * @param fileSingleSizeLimit
	 * @return
	 */
	@ApiOperation(value="系统内置上传样例", notes="系统内置上传样例接口")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "fileNumLimit", value = "最大上传文件数（默认100）", required = false ,dataType = "int"),
        @ApiImplicitParam(name = "fileSizeLimit", value = "最大上传大小（默认209715200-200M）", required = false ,dataType = "long"),
        @ApiImplicitParam(name = "fileSingleSizeLimit", value = "最大单文件上传大小（默认3145728-3M）", required = false ,dataType = "long")
    })
	@RequestMapping(value="web/{type}",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView uploadPicture(@PathVariable("type") String type,
		   @RequestParam(value="fileNumLimit",required=false,defaultValue="100")String fileNumLimit,
		   @RequestParam(value="fileSizeLimit",required=false,defaultValue="209715200")String fileSizeLimit,
		   @RequestParam(value="fileSingleSizeLimit",required=false,defaultValue="3145728")String fileSingleSizeLimit){
		   ModelAndView mav = new ModelAndView();
		   mav.addObject("fileNumLimit", fileNumLimit);
		   mav.addObject("fileSizeLimit", fileSizeLimit);
		   mav.addObject("fileSingleSizeLimit", fileSingleSizeLimit);
		   if(type.indexOf("file") != -1){
			   mav.setViewName("file");
			   return mav;
		   }
		   mav.setViewName("picture");
		   return mav;
	}
	
	
	
	@ApiOperation(value="按ID查询文件", notes="按ID查询文件接口")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "文件ID", required = true ,dataType = "String")
    })
    @RequestMapping(value="file/find/{id}",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody synchronized ModelMap selectFileById(@PathVariable(value="id")String id){
		try {
			logger.info("调用 按ID查询文件 接口！");
			if(StringUtils.isBlank(id)){
				return ResponseUtil.RetErrorInfo("id is null");
			}
			BaseFiles baseFiles = baseFilesService.selectById(id);
			if(baseFiles == null){
				return ResponseUtil.RetErrorInfo("this object is null");
			}
			logger.info("调用 按ID查询文件 接口,执行查询成功！");
			return ResponseUtil.RetCorrectInfo(JSONUtils.toJSONObject(baseFiles));
		} catch (Exception e) {
			logger.error("调用 按ID查询文件 接口,异常:{}",e.getCause().getMessage(),e);
			return ResponseUtil.RetErrorInfo(e.getCause().getMessage());
		}
	}
	
	
    /****
     * 分片上传
     * @param request
     * @param file
     * @param md5Id
     * @param chunks
     * @param chunk
     * @return
     */
	@ApiOperation(value="分片上传文件", notes="分片上传文件接口")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "file", value = "文件域", required = true ,dataType = "File"),
        @ApiImplicitParam(name = "md5Id", value = "唯一ID主键", required = true ,dataType = "String"),
        @ApiImplicitParam(name = "chunks", value = "分片数量", required = false ,dataType = "int"),
        @ApiImplicitParam(name = "chunk", value = "当前分片", required = false ,dataType = "int")
    })
    @RequestMapping(value="file/slice",method={RequestMethod.POST})
    public @ResponseBody synchronized ModelMap chunkUpload(MultipartFile file,@RequestParam(value="md5Id",required=false)String md5Id, 
		   @RequestParam(value="chunks",required=false,defaultValue="0") int chunks, 
		   @RequestParam(value="chunk",required=false,defaultValue="0") int chunk){
		   if(file == null || StringUtils.isBlank(md5Id)){
			   return ResponseUtil.RetErrorInfo("file or md5Id object is null!");
		   }
		   //文件真实名称
	       String origin = file.getOriginalFilename();
		   //类型文件夹
		   String folder = MimeUtil.getMimeFolder(file.getContentType());
		   String id = md5Id.substring(0,18).toUpperCase();
		   //md5文件名称
	       String fileName =  id + origin.substring(origin.lastIndexOf("."),origin.length());
	       //地址
	       String address = this.FilePath(folder);
	       logger.debug("文件名:{},分片总数:{},当前分片:{},文件大小:{}KB",origin,chunks,chunk,file.getSize());
	       try {
	    	   File rf = new File(this.RealPath(folder),fileName);
		       if(!rf.exists()){
		    	   rf.createNewFile();
		       }
	           // 判断文件是否分块
	           if (chunks > 1) {
	        	       //分片
		        	   String chunkName = (md5Id + "_" + chunk + ".part");//分片名称
		        	   long fileSize = FileUtils.MergeFiles(file.getInputStream(), this.TmpPath(), chunkName, rf);//累加合并
		        	   if(fileSize != 0){
		        		   BaseFiles syFiles = baseFilesService.selectById(id);
		        		   if(syFiles == null){
		        			   syFiles = this.setBean(id, fileSize, file.getContentType(), origin, fileName, address);
		        			   baseFilesService.insert(syFiles);
		        			   FileUtils.Catalog(this.CatalogPath(folder), JSONUtils.toJSONObject(syFiles));//写入目录
		        		   }else{
		        			   syFiles.setFileSize(String.valueOf((fileSize/1024)));
		        			   syFiles.setCreateTime(new Date());
		        			   baseFilesService.update(syFiles);
		        			   FileUtils.Catalog(this.CatalogPath(folder), JSONUtils.toJSONObject(syFiles));//写入目录
		        		   }
		        		   String result = "{'id':'"+syFiles.getId()+"','src':'" + syFiles.getDownload() + "','fileType':'"+syFiles.getFileType()+"'}";
		        		   return ResponseUtil.RetCorrectInfo(result);
		        	   }else{
		        		   return ResponseUtil.RetErrorInfo("file is null,upload error!");
		        	   }
	           } else {
	        	    //保存文件
		            boolean flag = FileUtils.copyStreamToFile(file.getInputStream(),this.RealPath(folder),fileName,origin,this.DiskPath());
		            if(flag){
		            	BaseFiles syFiles = baseFilesService.selectById(id);
	        		    if(syFiles == null){
	        			   syFiles = this.setBean(id, file.getSize(), file.getContentType(), origin, fileName, address);
	        			   baseFilesService.insert(syFiles);
	        		    }
	        		    FileUtils.Catalog(this.CatalogPath(folder), JSONUtils.toJSONObject(syFiles));//写入目录
	        		    String result = "{'id':'"+syFiles.getId()+"','src':'" + syFiles.getDownload() + "','fileType':'"+syFiles.getFileType()+"'}";
			            return ResponseUtil.RetCorrectInfo(result);
		            }else{
		            	return ResponseUtil.RetErrorInfo(" upload error!");
		            }
	           }
	       } catch (Exception ex) {
	           return ResponseUtil.RetErrorInfo(ex.getCause().getMessage());
	    } 
    }
	   
	   
	   
	   /***
	    * 文件上传
	    * @param file
	    * @return
	    */
	   @ApiOperation(value="文件上传", notes="文件上传接口")
	   @RequestMapping(value="file/upload",method={RequestMethod.POST})
	   public @ResponseBody synchronized ModelMap uploadPicture(MultipartFile file){
		   if(file == null){
			   return ResponseUtil.RetErrorInfo("file object is null!");
		   }
		   //文件真实名称
	       String origin = file.getOriginalFilename();
		   //类型文件夹
		   String folder = MimeUtil.getMimeFolder(file.getContentType());
		   String id = FileUtils.UuidName();
		   //UUID文件名称
	       String fileName =  id + origin.substring(origin.lastIndexOf("."),origin.length());
	       //真实文件路径
	       String filePath = this.FilePath(folder);
	       try {
	    	    //保存文件
	            boolean flag = FileUtils.copyStreamToFile(file.getInputStream(),filePath,fileName,origin,this.DiskPath());
	            if(flag){
	            	BaseFiles syFiles = this.setBean(id, file.getSize(), file.getContentType(), origin, fileName, filePath);
		            baseFilesService.insert(syFiles);
	 			    FileUtils.Catalog(this.CatalogPath(folder), JSONUtils.toJSONObject(syFiles));//写入目录
	 			    String result = "{'id':'"+syFiles.getId()+"','src':'" + syFiles.getDownload() + "','fileType':'"+syFiles.getFileType()+"'}";
	 			    return ResponseUtil.RetCorrectInfo(result);
	            }else{
	            	return ResponseUtil.RetErrorInfo(" upload error!");
	            }
	       } catch (Exception ex) {
	           return ResponseUtil.RetErrorInfo(ex.getCause().getMessage());
	       }
	   }
	   
	   
	   
	   
	   /***
	    * 存入数据库
	    * @param id
	    * @param size
	    * @param type
	    * @param origin
	    * @param fileName
	    * @param address
	    * @return
	    */
	   private BaseFiles setBean(String id,long size,String type,String origin,String fileName,String address){
		   BaseFiles syFiles = new BaseFiles();
		   syFiles.setId(id);
		   syFiles.setDisk(this.DiskPath());
		   syFiles.setFileSize(String.valueOf((size/1024)));
		   syFiles.setCreateTime(new Date());
		   syFiles.setState(Business.COMMON_STATE_STAY);
		   syFiles.setFileType(type);
		   syFiles.setFileName(origin);
		   syFiles.setUuidName(fileName);
		   syFiles.setFileAddress(address);
		   syFiles.setDownload(this.DownPath(id));
		   return syFiles;
	   }
	   
	   /***
	     * 下载文件
	     * @param filepath
	     * @param request
	     * @param response
	     */
	    @ApiOperation(value="文件下载", notes="文件下载接口")
	    @RequestMapping(value = "file/download/{id}",method={RequestMethod.GET,RequestMethod.POST}) 
		public synchronized void download(HttpServletRequest request,@PathVariable(value="id",required=false)String id,HttpServletResponse response) {
	    	BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			OutputStream fos = null;
			InputStream fis = null;
	    	try {
		    	if(StringUtils.isBlank(id)){
		    		response.getWriter().write(JSONUtils.toJSONObject(ResponseUtil.RetErrorInfo("sign id is null!"),null));
		    	}
		    	BaseFiles sfFiles = baseFilesService.selectById(id);
		    	if(sfFiles == null){
		    		response.getWriter().write(JSONUtils.toJSONObject(ResponseUtil.RetErrorInfo("sign id is invalid!"),null)); 
		    	}
		    	File file = new File(sfFiles.getDisk() + sfFiles.getFileAddress(),sfFiles.getUuidName());
				response.setContentType("application/octet-stream; charset=utf-8"); 
				response.setHeader("Content-Disposition", "attachment; filename="+sfFiles.getFileName());
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
		   return (String) redisUtil.get(Constant.UP_DOWN_LOAD_PATH);
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
	   

	   /***
	    * 下载地址
	    * @param id
	    * @return
	    */
	   private String DownPath(String id){
		   return (String) redisUtil.get(Constant.DOMAIN_NAME) + "/uploader/file/download/" + id;
	   }
	   
	   
}



