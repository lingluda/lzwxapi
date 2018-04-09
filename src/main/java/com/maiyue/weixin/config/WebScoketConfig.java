package com.maiyue.weixin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by huang on 2017/12/28.
 */

@Component
@Configuration
@EnableWebSocketMessageBroker
public class WebScoketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    //配置了以“/weixin”开头的websocket请求url
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/weixin");
        registry.setUserDestinationPrefix("/user");
    }


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/webSocket").withSockJS();

    }
}
