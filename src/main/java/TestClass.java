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
			calendar.set(2018,4,0);  //month 0 寮�濮�
	       //璋冪敤Calendar绫讳腑鐨刟dd()锛屽鍔犳椂闂撮噺
	        calendar.add(Calendar.DATE, 100);
	        
	        /*
	        int num = 7*18;
	        
	        String toDay = "2018-03-16";
	        
	        String i = TestClass.getDaysToDate(2018,02,26, num);
	        
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        int ds = ComUtil.getDaysBetween(sdf.parse("2018-02-26"), sdf.parse("2018-07-02"));
	        
	        
	        */
	        
	        TestClass.getWeeks("2018-02-26", "2018-11-30");
	        
	        
	        
	        List<CBean> data = new ArrayList<CBean>();
	        
	        CBean cb = new CBean();
	        cb.setWid(2);
	        cb.setCourse("澶у鑻辫");
	        cb.setAddress("1鍙锋暀瀛︽ゼ");
	        cb.setEndTime("09:00");
	        cb.setEndTime("12:00");
	        cb.setTeacher("鑰佹潕");
	        data.add(cb);
	        
	        
	        cb = new CBean();
	        cb.setWid(3);
	        cb.setCourse("澶у鑻辫||");
	        cb.setAddress("1鍙锋暀瀛︽ゼ");
	        cb.setEndTime("9:00");
	        cb.setEndTime("12:00");
	        cb.setTeacher("鑰佹潕00");
	        data.add(cb);
	        
	        
	        cb = new CBean();
	        cb.setWid(3);
	        cb.setCourse("java缂栫▼");
	        cb.setAddress("2鍙锋暀瀛︽ゼ");
	        cb.setEndTime("09:00");
	        cb.setEndTime("12:00");
	        cb.setTeacher("鑰佸紶");
	        
	        data.add(cb);
	        
	        //TestClass.getDays("2018-02-26", "2018-07-02",data);
	        
	        
	        //TestClass.getWeeks("2018-01-01","2018-12-31");
		}
		
		/**
		 * 鏌愬勾鏌愭湀澶氬皯澶�
		 * @param year
		 * @param month
		 * @return
		 */
		private static String getMonDays(Integer year,Integer month){
			Calendar calendar = Calendar.getInstance();
			calendar.set(year,month, 0); 
			int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
			System.out.println(year + "骞�" + month + "鏈堟湁" + dayOfMonth + "澶�");
			return year + "骞�" + month + "鏈堟湁" + dayOfMonth + "澶�";
		}
		
		/***
		 * 褰撳墠鏃堕棿 + 澶╂暟 鎺ㄦ柇涓嬩釜鏃ユ湡
		 * @param year
		 * @param month
		 * @param day
		 * @param days
		 * @return
		 */
		private static String getDaysToDate(Integer year,Integer month,Integer day,Integer days){
			Calendar calendar = Calendar.getInstance();
			calendar.set(year,month-1,day==0?1:day);  //month 0 寮�濮�
			calendar.add(Calendar.DATE, days);
			return calendar.get(Calendar.YEAR) + " 骞� " + (calendar.get(Calendar.MONTH) + 1)+" 鏈� "+calendar.get(Calendar.DATE) + " 鏃�";
		}
		
		
		
		
		private static void getMonths(String start,String end) throws ParseException{
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Calendar c1=Calendar.getInstance();
	        c1.setTime(sdf.parse(start));
	        //杞负鍛ㄤ竴
	        /*
	        int year = c1.get(Calendar.YEAR);
	        int month = c1.get(Calendar.MONTH);
	        c1.set(year, month, 1, 0, 0, 0);
	        */
	        System.out.println("寮�濮嬫椂闂翠负鍛細" + c1.get(Calendar.DAY_OF_WEEK));
	        
	        Calendar c2 = Calendar.getInstance();
	        c2.setTime(sdf.parse(end));
	        
	        System.out.println("缁撴潫鏃堕棿涓哄懆锛�" + c1.get(Calendar.DAY_OF_WEEK));
	        
	        int weekYear2 = c2.get(Calendar.YEAR);
	        int weekOfYear2 = c2.get(Calendar.WEEK_OF_YEAR);
	        c2.setWeekDate(weekYear2, weekOfYear2, Calendar.SUNDAY);
	        
	        while (true) {
	            System.out.println(sdf.format(c1.getTime())+" : " + c1.get(Calendar.DAY_OF_WEEK));
	            //涓嬩竴涓湀<缁撴潫鏃ユ湡
	            c1.set(Calendar.MONTH, c1.get(Calendar.MONTH) + 1 );
	            if(c1.getTimeInMillis() >= c2.getTimeInMillis()){
	                break;
	            }
	        }
	    }

		
		
		
	    private static void getWeeks(String start,String end) throws ParseException{
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        //寮�濮嬫椂闂�
	        Calendar c1 = Calendar.getInstance();
	        c1.setTime(sdf.parse(start));
	        c1.setWeekDate(c1.get(Calendar.YEAR), c1.get(Calendar.WEEK_OF_YEAR), Calendar.MONDAY);
	        //缁撴潫鏃堕棿
	        Calendar c2 = Calendar.getInstance();
	        c2.setTime(sdf.parse(end));
	        c2.setWeekDate(c2.get(Calendar.YEAR), c2.get(Calendar.WEEK_OF_YEAR), Calendar.SUNDAY);
	        while (true) {
	            System.out.println(sdf.format(c1.getTime())+" : 绗�  " + (c1.get(Calendar.WEEK_OF_YEAR)-1) + " 鍛�");
	            if(c1.getTimeInMillis() >= c2.getTimeInMillis()){
	                break;
	            }
	            //澧炲姞7澶�
	            c1.setTimeInMillis(c1.getTimeInMillis()+1000*60*60*24*7);
	        }
	    }
	    
	    
	    
	    
	    private static void getDays(String start,String end,List<CBean> data) throws ParseException{
	    	String[] weekDays = { "鏄熸湡鏃�", "鏄熸湡涓�", "鏄熸湡浜�", "鏄熸湡涓�", "鏄熸湡鍥�", "鏄熸湡浜�", "鏄熸湡鍏�" };
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        Calendar calendar = Calendar.getInstance();
	        Long startTIme = sdf.parse(start).getTime();  
	        Long endTime = sdf.parse(end).getTime();  
	        Long oneDay = 1000 * 60 * 60 * 24l; //涓�澶� 
	        Long time = startTIme;  
	        while (time <= endTime) {  
	            Date d = new Date(time);  
	            calendar.setTime(d);
	            int w = calendar.get(Calendar.DAY_OF_WEEK) - 1; // 鎸囩ず涓�涓槦鏈熶腑鐨勬煇澶┿��
	            String date = sdf.format(d);
	            if(data.size() > 0){
	            	List<String> json = new ArrayList<String>();
	            	for(int i = 0 ; i < data.size() ; i++){
	            		if(data.get(i) != null && data.get(i).getWid() == w){
	            			json.add(JSONObject.fromObject(data.get(i)).toString());
	            		}
	            	}
	            	System.out.println("鏃ユ湡:" + date + " , " + weekDays[w] + " , 涓婅鍐呭锛�" + JSONUtils.toJSONArray(json));
	            }
	            //System.out.println("鏃ユ湡:" + date + " , " + weekDays[w] );
	            time += oneDay; 
	        }
	    }
		
		
	   
	    
	    
	    
	    
	    
	    
	    
	}





