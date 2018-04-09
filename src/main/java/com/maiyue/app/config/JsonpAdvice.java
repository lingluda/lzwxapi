package com.maiyue.app.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@ControllerAdvice(basePackages = "com.maiyue.app.controller")  
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice{

	  public JsonpAdvice(){
		  super("callback","jsonp");  
	  }
	  
}
