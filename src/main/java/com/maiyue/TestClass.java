package com.maiyue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.maiyue.weixin.utils.jsonUtil.JSONUtils;

import net.sf.json.JSONObject;

public class TestClass {

	
	
	
	
	public static void main(String[] args) throws ParseException {
		
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018,4,0);  //month 0 开始
       //调用Calendar类中的add()，增加时间量
        calendar.add(Calendar.DATE, 100);
        
        /*
        int num = 7*18;
        
        String toDay = "2018-03-16";
        
        String i = TestClass.getDaysToDate(2018,02,26, num);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int ds = ComUtil.getDaysBetween(sdf.parse("2018-02-26"), sdf.parse("2018-07-02"));
        
        
        */
        
        //TestClass.getWeeks("2018-02-26", "2018-11-30");
        
        
        
        List<CBean> data = new ArrayList<CBean>();
        
        CBean cb = new CBean();
        cb.setWid(2);//星期3
        cb.setCourse("大学英语");
        cb.setAddress("1号教学楼");
        cb.setEndTime("09:00");
        cb.setEndTime("12:00");
        cb.setTeacher("老李");
        cb.setSign("第2节");
        data.add(cb);
        
        cb = new CBean();
        cb.setWid(2);
        cb.setCourse("大学英语||");
        cb.setAddress("1号教学楼");
        cb.setEndTime("9:00");
        cb.setEndTime("12:00");
        cb.setTeacher("老李00");
        cb.setSign("第3节");
        data.add(cb);
        
        
        cb = new CBean();
        cb.setWid(3);
        cb.setCourse("java编程");
        cb.setAddress("2号教学楼");
        cb.setEndTime("09:00");
        cb.setEndTime("12:00");
        cb.setTeacher("老张");
        
        data.add(cb);
        
        
        int i = 19*7;
        
        TestClass.getDays("2018-02-26", "2018-07-02",data);
        
        
        //TestClass.getWeeks("2018-01-01","2018-12-31");
	}
	
	/**
	 * 某年某月多少天
	 * @param year
	 * @param month
	 * @return
	 */
	private static String getMonDays(Integer year,Integer month){
		Calendar calendar = Calendar.getInstance();
		calendar.set(year,month, 0); 
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + "年" + month + "月有" + dayOfMonth + "天");
		return year + "年" + month + "月有" + dayOfMonth + "天";
	}
	
	/***
	 * 当前时间 + 天数 推断下个日期
	 * @param year
	 * @param month
	 * @param day
	 * @param days
	 * @return
	 */
	private static String getDaysToDate(Integer year,Integer month,Integer day,Integer days){
		Calendar calendar = Calendar.getInstance();
		calendar.set(year,month-1,day==0?1:day);  //month 0 开始
		calendar.add(Calendar.DATE, days);
		return calendar.get(Calendar.YEAR) + " 年 " + (calendar.get(Calendar.MONTH) + 1)+" 月 "+calendar.get(Calendar.DATE) + " 日";
	}
	
	
	
	
	private static void getMonths(String start,String end) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1=Calendar.getInstance();
        c1.setTime(sdf.parse(start));
        //转为周一
        /*
        int year = c1.get(Calendar.YEAR);
        int month = c1.get(Calendar.MONTH);
        c1.set(year, month, 1, 0, 0, 0);
        */
        System.out.println("开始时间为周：" + c1.get(Calendar.DAY_OF_WEEK));
        
        Calendar c2 = Calendar.getInstance();
        c2.setTime(sdf.parse(end));
        
        System.out.println("结束时间为周：" + c1.get(Calendar.DAY_OF_WEEK));
        
        int weekYear2 = c2.get(Calendar.YEAR);
        int weekOfYear2 = c2.get(Calendar.WEEK_OF_YEAR);
        c2.setWeekDate(weekYear2, weekOfYear2, Calendar.SUNDAY);
        
        while (true) {
            System.out.println(sdf.format(c1.getTime())+" : " + c1.get(Calendar.DAY_OF_WEEK));
            //下一个月<结束日期
            c1.set(Calendar.MONTH, c1.get(Calendar.MONTH) + 1 );
            if(c1.getTimeInMillis() >= c2.getTimeInMillis()){
                break;
            }
        }
    }

	
	
	
    private static void getWeeks(String start,String end) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //开始时间
        Calendar c1 = Calendar.getInstance();
        c1.setTime(sdf.parse(start));
        c1.setWeekDate(c1.get(Calendar.YEAR), c1.get(Calendar.WEEK_OF_YEAR), Calendar.MONDAY);
        //结束时间
        Calendar c2 = Calendar.getInstance();
        c2.setTime(sdf.parse(end));
        c2.setWeekDate(c2.get(Calendar.YEAR), c2.get(Calendar.WEEK_OF_YEAR), Calendar.SUNDAY);
        while (true) {
            System.out.println(sdf.format(c1.getTime())+" : 第  " + (c1.get(Calendar.WEEK_OF_YEAR)-1) + " 周");
            if(c1.getTimeInMillis() >= c2.getTimeInMillis()){
                break;
            }
            //增加7天
            c1.setTimeInMillis(c1.getTimeInMillis()+1000*60*60*24*7);
        }
    }
    
    
    
    
    private static void getDays(String start,String end,List<CBean> data) throws ParseException{
    	String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Long startTIme = sdf.parse(start).getTime();  
        Long endTime = sdf.parse(end).getTime();  
        Long oneDay = 1000 * 60 * 60 * 24l; //一天 
        Long time = startTIme;  
        while (time <= endTime) {  
            Date d = new Date(time);  
            calendar.setTime(d);
            int w = calendar.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
            String date = sdf.format(d);
            if(data.size() > 0){
            	List<String> json = new ArrayList<String>();
            	for(int i = 0 ; i < data.size() ; i++){
            		if(data.get(i) != null && data.get(i).getWid() == w){
            			json.add(JSONObject.fromObject(data.get(i)).toString());
            		}
            	}
            	System.out.println("日期:" + date + " , " + weekDays[w] + " , 上课内容：" + JSONUtils.toJSONArray(json));
            }
            //System.out.println("日期:" + date + " , " + weekDays[w] );
            time += oneDay; 
        }
    }
	
	
   
    
    
    
    
    
    
    
}





