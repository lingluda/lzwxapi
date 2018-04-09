package com.maiyue.weixin.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.maiyue.weixin.constant.BusinessConstant;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComUtil {
	
	private static final int KB = 1024;
	private static final int MB = 1024*1024;

	private static final String[] chars = { "0", "1", "2", "3", "4", "5", "6","7",
			"8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K", "L","M", "N","O",
			"P", "Q", "R", "S", "T", "U","V", "W", "X", "Y", "Z", "a", "b", "c", "d",
			"e", "f", "g", "h", "i", "j", "k", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z" };
	
    /**
     * 格式化字节单位
     * @param bytes
     * @return
     */
    public static String formatByte(long bytes){
    	DecimalFormat df = new DecimalFormat("0.0");
    	StringBuffer sbuf = new StringBuffer();
    	if(bytes>=100*KB){
    		sbuf.append(df.format(bytes*1.0f/MB)).append("M");
    	}else{
    		sbuf.append(df.format(bytes*1.0f/KB)).append("K");
    	}
    	return sbuf.toString();
    }
    
    
    
	public static Date addDay(Date date, int day){
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.DAY_OF_YEAR, day);
		return cl.getTime();
	}
	
	/**
	 * 日期是否大于今天(含今天)
	 * @param date
	 * @return
	 */
	public static boolean afterToday(Date date){
		boolean after = false;
		Calendar curDate = Calendar.getInstance();
		curDate.add(Calendar.DAY_OF_YEAR, -1);
		if(curDate.getTime().before(date)){
			after = true;
		}
		return after;
	}
	
	/**
	 * 返回制定格式日期
	 * @param format
	 * @return
	 */
	public static String getDate(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
	
	/**
	 * 返回指定格式日期
	 * @param format
	 * @param date
	 * @return
	 */
	public static String getDate(String format, Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}	
	
	
	
	public static String getCheckColumn(@SuppressWarnings("rawtypes") Class obj,String field){
		if(StringUtils.isBlank(field)){
			return null;
		}
		if( obj == null){
			return null;
		}
		String column = ""; 
		List<String> fields = getFields(obj);
		if(fields.contains(field.trim())){
			column = getColumn(field);
		}
		return column;
	}
	
	
	/***
     * 根据实体字段名生成对应的 数据库字段（大写）
     * @param field
     * @return newCol
     */
    public static String getColumn(String field){
        for(int i = 0; i < field.length(); i++){
           char cos = field.charAt(i);
           if(Character.isUpperCase(cos)){ //存在大写
              int len = field.indexOf(cos);
              field = (field.substring(0, len) + "_" + cos).toLowerCase() + field.substring(len + 1, field.length());
              String newCol1 = getColumn(field);
              if(newCol1 != null){
                  return newCol1.toUpperCase(); 
              }
              break;
            }
        }
        return field.toUpperCase();
    }
	
	private static final String iclass = "class";
    
	
	
	/***
	 * 获得类字段
	 * @param obj
	 * @param field
	 * @return
	 */
    private static List<String> getFields(@SuppressWarnings("rawtypes") Class obj){
		List<String> fields = new ArrayList<String>();
    	try {
			 BeanInfo beanInfo = Introspector.getBeanInfo(obj);
			 PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
	         for (PropertyDescriptor property : propertyDescriptors) {
	             String key = property.getName();
	             // 过滤class属性
	             if (!key.equals(iclass) && !key.equals(BusinessConstant.ORDER) && !key.equals(BusinessConstant.SORT)
	                 && !key.equals(BusinessConstant.PAGENUM) && !key.equals(BusinessConstant.PAGESIZE)) { 
	            	 fields.add(key);
	             }
	         }
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return fields;
    }
    
    
	
	/**
	 * 对比两个long时间值的差距
	 * @param start
	 * @param end
	 * @return 返回x天x时x分x秒的格式
	 */
    public static String diffTime(long start, long end){
        
        String str = null;
        long diff = end - start;
        if(diff<=0){
            return "0天0时0分";
        }else{
            long day = 0;
            long hou = 0;
            long min = 0;
            //long ses = 0;
            day = diff/(1000*60*60*24);
            diff = diff - day*1000*60*60*24;
            hou = (diff/(1000*60*60));
            diff = diff - hou*1000*60*60;
            min = (diff/(1000*60));
            diff = diff - min*1000*60;
            //ses = (diff/1000);
            //str = String.format("%d天%d时%d分%d秒",day,hou,min,ses);
            str = String.format("%d天%d时%d分",day,hou,min);
        }
        
        return str;
    }	
    
    /**
     * 返回两个日期相差的天数
     * @param date1
     * @param date2
     * @return
     */
	public static int getDaysBetween(Date date1, Date date2) {
		Calendar cl1 = Calendar.getInstance();
		Calendar cl2 = Calendar.getInstance();
		cl1.setTime(date1);
		cl2.setTime(date2);
		if (cl1.after(cl2)) {
			Calendar swap = cl1;
			cl1 = cl2;
			cl2 = swap;
		}
		int days = cl2.get(Calendar.DAY_OF_YEAR) - cl1.get(Calendar.DAY_OF_YEAR);
		int y2 = cl2.get(Calendar.YEAR);
		if (cl1.get(Calendar.YEAR) != y2) {
			cl1 = (Calendar) cl1.clone();
			do {
				days += cl1.getActualMaximum(Calendar.DAY_OF_YEAR);
				cl1.add(Calendar.YEAR, 1);
			} while (cl1.get(Calendar.YEAR) != y2);
		}
		return days;
	}   
    
    public static int getInt(String str){
    	int i = 0;
    	try{
    		i = Integer.parseInt(str);
    	}catch(NumberFormatException ex){}
    	return i;
    }
    
	public static double getDouble(String str){
		
		double d = 0;
		if(str!=null){
			try{
				d = Double.parseDouble(str);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return d;
	}
    
    public static String getRex(String str, String regEx) {
        String tmp = null;
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find()) {
            tmp = m.group();
        }
        return tmp;
    }

    public static List<String> getRexs(String str, String regEx) {

        List<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        while (m.find()) {
            list.add(m.group());
        }
        return list;
    }

    public static boolean isRex(String str, String regEx) {
        boolean b = false;
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find()) {
            b = true;
        }
        return b;
    }    
    
    /**
     * 字符是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
    	if(str==null || str.length()==0){
    		return true;
    	}else{
    		return false;
    	}
    }


	/**
	 * MD5值
	 * @param s
	 * @return
	 */
	public static String getMD5(String s) {
		StringBuffer sbuf = new StringBuffer();
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(s.getBytes());
			byte[] buf = mdTemp.digest();
			for (byte b : buf) {
				sbuf.append(Integer.toHexString(b >> 4 & 0xF).toUpperCase());
				sbuf.append(Integer.toHexString(b & 0xF).toUpperCase());
			}
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return sbuf.toString();
	}

	/**
	 * 获取IP地址
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forwarded-for");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static String randomChar(int size){
		StringBuffer sb = null;
		if(size>0){
			sb = new StringBuffer();
			Random ran = new Random();
			for(int i = 1; i <= size; i++ ){
				int r = ran.nextInt(chars.length);
				sb.append(chars[r]);
			}
		}
		return sb.toString();
	}

	/**
	 * 产生一个36个字符的UUID
	 *
	 * @return UUID
	 */
	public static synchronized String randomUUID() {
		String s =  UUID.randomUUID().toString();
		return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
	}

	public static String getPercentage(Double number1, Double number2, int maximumFractionDigits){
		if(number1 != null && number2 != null && !number1.equals(0) && !number2.equals(0)){
			NumberFormat numberFormat = NumberFormat.getInstance();

			numberFormat.setMaximumFractionDigits(maximumFractionDigits);

			String result = numberFormat.format(number1 * 100/ number2);

			return result;
		}else{
			return "0";
		}
	}

	public static String getPercentage(Integer number1, Integer number2, int maximumFractionDigits){
		if(number1 != null && number2 != null && !number1.equals(0) && !number2.equals(0)){
			NumberFormat numberFormat = NumberFormat.getInstance();

			numberFormat.setMaximumFractionDigits(maximumFractionDigits);

			Double result = Double.valueOf(number1) / Double.valueOf(number2) * 100;

			return numberFormat.format( result);
		}else{
			return "0";
		}
	}
}
