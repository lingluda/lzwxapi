package com.maiyue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huang on 2017/12/21.
 *
 */
@Configuration
@SpringBootApplication
@ComponentScan(basePackages={"com.maiyue.app"})
@MapperScan({"com.maiyue.app.mapper"})  
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
