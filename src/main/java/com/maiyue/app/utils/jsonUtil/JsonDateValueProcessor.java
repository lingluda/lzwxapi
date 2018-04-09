package com.maiyue.app.utils.jsonUtil;

import java.text.SimpleDateFormat;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonDateValueProcessor implements JsonValueProcessor {   
    
	  protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	  protected SimpleDateFormat sdfT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	  public Object processArrayValue(Object value, JsonConfig config) {   
	    return process(value);   
	  }   
	  
	  public Object processObjectValue(String key, Object value, JsonConfig config) {   
	    return process(value);   
	  }   
	     
	  private Object process(Object value){   
	    if(value instanceof java.sql.Date){   
	        return sdf.format(value);   
	    }else if(value instanceof java.util.Date){
	    	return sdfT.format(value);
	    }
	    return value == null ? "" : value.toString();   
	  }   
}
