package com.maiyue.weixin.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private static Logger logger = LoggerFactory.getLogger(FileUtils.class);
	
	/***
	  * 合并文件
	  * @param inputStream
	  * @param tempPath
	  * @param chunkName
	  * @param resultFile
	  * @return
	  */
	public static long MergeFiles(InputStream inputStream, String tempPath,String chunkName,File resultFile) {
		long result = 0;
		if (inputStream == null || StringUtils.isBlank(tempPath) || StringUtils.isBlank(chunkName)) {
	        return 0;
	    }
	    long strat = System.currentTimeMillis();
	    FileInputStream fis = null;
	    FileOutputStream fos = null;
	    try {
	    	 File partFile = new File(tempPath, chunkName);
	    	 byte[] bys = new byte[1024];
	    	 if(!partFile.exists()){
	             FileUtils.getInputStreamToFile(inputStream,partFile); //保存分片文件
		    	 fis = new FileInputStream(partFile);
	             fos = new FileOutputStream(resultFile, true);
	             int len = 0;
	             while ((len = fis.read(bys)) != -1) {
	          	    fos.write(bys, 0, len);
	             }
	             fos.flush();
		    	 long end = System.currentTimeMillis();
		    	 logger.info("合并文件耗时：" + (end-strat) + " 毫秒");
	    	 }
	    	 result = resultFile.length();
	    }catch(Exception e) {
	    	logger.error(e.getCause().getMessage(),e);
	    }finally{
	    	try {
				if(fos != null){fos.close();}
				if(fis != null){fis.close();}
				if(inputStream != null){inputStream.close();}
			} catch (Exception e2) {
				logger.error(e2.getCause().getMessage(),e2);
			}
	    }
	    return result;
	}
    
	
	
	
	
	
	  /**
     * URL 解码
     * @return String
     * @date 2015-3-17 下午04:09:51
     */
	public static String getURLDecoderString(String str) {
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
	 * 保存文件流到文件
	 * @param inputStream
	 * @param filepath
	 * @param filename
	 * @param originName
	 * @param disk
	 * @return
	 */
    public static boolean copyStreamToFile(InputStream inputStream,String filepath,String filename,String originName,String disk){
    	 FileOutputStream fos = null;
    	 FileInputStream in = null;
    	 File file = null;
    	 try {
             if(inputStream == null || StringUtils.isBlank(filepath)) {
                 return false;
             }
             long strat = System.currentTimeMillis();
             String path = (disk + filepath);
             file = new File(path);
             if(!file.exists()){
            	 file.mkdirs();
             }
             file = new File(path,filename);
             byte[] b = new byte[102400];//set b 100Kb byte.
             int len = 0;
             long totalBytes = 0; //文件大小
             fos = new FileOutputStream(file);
             while ((len = inputStream.read(b)) != -1) {
                 fos.write(b, 0, len);
                 totalBytes += len;
             }
             fos.flush();
             inputStream.close();
             in = new FileInputStream(file); 
             //文件内存映射，提高读写超大文件可能和速度，但会造成文件锁定不可操作。
             MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());  
             FileUtils.clean(byteBuffer);
             long end = System.currentTimeMillis();
             logger.info("文件名:{},UUID文件名称:{},文件大小:{}KB,上传耗时:{}毫秒", originName,file.getName(),(totalBytes/1024),(end-strat));
             return true;
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
         	try {
 				if(fos != null){fos.close();}
 				if(in != null){in.close();}
 				if(inputStream != null){inputStream.close();}
 			} catch (Exception e2) {
 				logger.error(e2.getCause().getMessage(),e2);
 			}
         }
    	 return false;
    }
    
    
    
    
    
    
    
  
    
    /***
     * 文件目录
     * F:\\platfrom\\picture\\2018\\04\\02\\catalog.txt
     * @param filePath
     * @param content
     */
    public static boolean Catalog(String filePath,String content) {
    	if(StringUtils.isBlank(content)){
    		 return false;
    	}
        File file = new File(filePath);
    	BufferedWriter out = null;
	    try {
	    	 if(!file.exists()){
	    		 file.createNewFile();
	    	 }
			 out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			 out.write(content + "\r\n");
			 out.flush();
		} catch (Exception e) {
			 e.printStackTrace();
		} finally {
		  try {
			 out.close();
		  } catch (IOException e) {
			 e.printStackTrace();
		  }
	   }
		return false;
	}
    
    
    /***
     * 上传文件
     * @param inputStream
     * @param file
     */
    public static void getInputStreamToFile(InputStream inputStream,File file){
    	FileOutputStream fos = null;
    	FileInputStream in = null;
    	try {
            if(inputStream != null) {
	            byte[] bys = new byte[1024];
	            long strat = System.currentTimeMillis();
	            int len = 0;
	            long totalBytes = 0; //文件大小
	            fos = new FileOutputStream(file);
	            while ((len = inputStream.read(bys)) != -1) {
	                fos.write(bys, 0, len);
	                totalBytes += len;
	            }
	            fos.flush();
	            in = new FileInputStream(file); 
	            //文件内存映射，提高读写超大文件可能和速度，但会造成文件锁定不可操作。
	            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());  
	            FileUtils.clean(byteBuffer);
	            long end = System.currentTimeMillis();
	            logger.info("文件名称:{},文件大小:{}KB,上传耗时:{}毫秒",file.getName(),(totalBytes/1024),(end-strat));
            }
        } catch (Exception e) {
            logger.error(e.getCause().getMessage(),e);
        } finally {
        	try {
				if(fos != null){fos.close();}
				if(in != null){in.close();}
				if(inputStream != null){inputStream.close();}
			} catch (Exception e2) {
				logger.error(e2.getCause().getMessage(),e2);
			}
        }
    }
    
    
    
   
    
    
    /***
     * 清除缓存
     * @param buffer
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void clean(final Object buffer) throws Exception {
         AccessController.doPrivileged(new PrivilegedAction() {
             public Object run() {
	             try {
	                Method getCleanerMethod = buffer.getClass().getMethod("cleaner",new Class[0]);
	                getCleanerMethod.setAccessible(true);
	                sun.misc.Cleaner cleaner =(sun.misc.Cleaner)getCleanerMethod.invoke(buffer,new Object[0]);
	                cleaner.clean();
	             } catch(Exception e) {
	                e.printStackTrace();
	             }
                return null;
             }
          });
     }
    
    
    
    /**
	 * 在MappedByteBuffer释放后再对它进行读操作的话就会引发jvm crash，在并发情况下很容易发生
	 * 正在释放时另一个线程正开始读取，于是crash就发生了。所以为了系统稳定性释放前一般需要检
	 * 查是否还有线程在读或写
	 * @param mappedByteBuffer
	 */
	public static void unmap(final MappedByteBuffer mappedByteBuffer) {
		try {
			if (mappedByteBuffer == null) {
				return;
			}
			mappedByteBuffer.force();
			AccessController.doPrivileged(new PrivilegedAction<Object>() {
				@Override
				public Object run() {
					try {
						Method getCleanerMethod = mappedByteBuffer.getClass().getMethod("cleaner", new Class[0]);
						getCleanerMethod.setAccessible(true);
						sun.misc.Cleaner cleaner = (sun.misc.Cleaner) getCleanerMethod.invoke(mappedByteBuffer, new Object[0]);
						cleaner.clean();
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	 /***
	  * 年月日文件夹
	  * @return
	  */
	 public static String TimeFolder(){
		   String date = sdf.format(new Date());
		   String year = date.substring(0, 4);
		   String month = date.substring(5, 7);
		   String day = date.substring(8, date.length());
		   return (File.separator + year + File.separator + month + File.separator + day + File.separator);
	 }
    
	 /***
	  * 年月日文件夹
	  * @return
	  */
	 public static String UuidName(){
		  return ComUtil.randomChar(16);
	 }
	 
	 /*
	 public void downloadPost(String filepath,String filename,HttpServletRequest request, HttpServletResponse response) {
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
				response.setContentType("application/octet-stream; charset=utf-8"); 
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
	 */
}
