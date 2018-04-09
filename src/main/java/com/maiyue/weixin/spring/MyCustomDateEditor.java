package com.maiyue.weixin.spring;

import com.maiyue.weixin.utils.ComUtil;

import java.beans.PropertyEditorSupport;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyCustomDateEditor extends PropertyEditorSupport {

	private static String timeReg = "^(([0-1][0-9])|2[0-3]):[0-5][0-9]$";
	private static String timeReg2 = "^(([0-1][0-9])|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
	private static String dateReg = "^\\d{4}-\\d{2}-\\d{2}$";
	private static String dateTimeReg = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}(\\.[0-9]){0,1}$";
	private static String dateTimeReg2 = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}$";
	private static String dateTimeReg3 = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
	
	@Override
	public void setAsText(String text){
		if(text != null){
			SimpleDateFormat sdf = null;
			if(ComUtil.isRex(text, dateTimeReg)){
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}else if(ComUtil.isRex(text, dateTimeReg2)){
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			}else if(ComUtil.isRex(text, dateReg)) {
				sdf = new SimpleDateFormat("yyyy-MM-dd");
			}else if(ComUtil.isRex(text, dateTimeReg3)){

			}
			if(sdf != null){
				try {
					Date date = sdf.parse(text);
					this.setValue(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else {
				if (ComUtil.isRex(text, timeReg)) {
					sdf = new SimpleDateFormat("HH:mm");
				}else if(ComUtil.isRex(text, timeReg2)){
					sdf = new SimpleDateFormat("HH:mm:ss");
				}

				if(sdf != null){
					try {
						Date date = sdf.parse(text);
						Time timer = new Time(date.getTime());
						this.setValue(timer);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
