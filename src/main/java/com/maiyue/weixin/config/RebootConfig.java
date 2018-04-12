package com.maiyue.weixin.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * 关闭程序
 * @author Admin
 */
public class RebootConfig extends Thread{
    
	private static String domain;
	
	private static Logger Logger = LoggerFactory.getLogger(RebootConfig.class);
	
	@SuppressWarnings("static-access")
	public RebootConfig(Object domain){
		if(domain == null)
			this.domain = "http://localhost:8100";
		else
			this.domain = (String) domain;
	}
	
	@Override
    public void run() {
        try {
            URL url = new URL(domain + "/basic/system/shutdown");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("encoding", "UTF-8");//添加请求属性
            connection.setDoInput(true);//允许输入
            connection.setDoOutput(true);//允许输出
            connection.setRequestMethod("POST");//POST请求 要在获取输入输出流之前设置  否则报错
            //输入
            InputStream in = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(in,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            StringBuilder sb = new StringBuilder();
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            br.close();
            isr.close();
            in.close();
            Logger.info("系统已关闭:{}", sb.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
}
