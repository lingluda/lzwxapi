package com.maiyue.weixin.config;

import com.google.common.base.Predicate;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author huang
 * @date 2017/12/28
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @SuppressWarnings("unused")
	@Bean
    public Docket createBaseApi() {
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            
        	@SuppressWarnings("deprecation")
			@Override
            public boolean apply(RequestHandler input) {
                Class<?> declaringClass = input.declaringClass();
                if (declaringClass == BasicErrorController.class){
                    // 排除
                    return false;
                }
                if(declaringClass.isAnnotationPresent(RestController.class)){
                    // 被注解的类
                    return true;
                }
                if(input.isAnnotatedWith(ResponseBody.class)){
                    // 被注解的方法
                    return true;
                }
                return false;
            }
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //根据匿名注入的类型扫描API
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    //大标题  详细描述 版本 作者
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("微信API接口文档")
                .description("微信API接口文档,所有开放接口皆在此展示！").version("1.0")
                .contact(new Contact("迈越软件", "http://www.maiyuesoft.com/", "info@MaiyueSoft.com"))
                .license("南宁市迈越软件有限责任公司").licenseUrl("http://www.maiyuesoft.com/").build();
    }

    
    
    
}
