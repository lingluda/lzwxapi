package com.maiyue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/***
 * @author Admin
 */
@Configuration
@SpringBootApplication
@ComponentScan(basePackages={"com.maiyue.weixin"})
public class StartUp{

    public static void main(String[] args) {
        SpringApplication.run(StartUp.class, args);
    }
    

}
