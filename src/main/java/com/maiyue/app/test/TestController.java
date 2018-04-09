package com.maiyue.app.test;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maiyue.app.bean.SocketMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huang on 2017/12/21.
 */
@RestController
@EnableAutoConfiguration
public class TestController {

    /*@Autowired
    private SimpMessagingTemplate messagingTemplate;*/

    @RequestMapping("/hello")
    @ApiOperation(value="Hello", notes="")
    String hello() {
        return "Hello World!";
    }

    @RequestMapping("/name/{myName}")
    String myName(@PathVariable String myName,@RequestParam(name = "id",required = false)String id) {
        String name = "";
        return "Hello "+myName+"!!!"+name;
    }


    @MessageMapping("/send")
    @SendTo("/topic/send")
    public SocketMessage send(SocketMessage message) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        message.setSendDate(sdf.format(new Date()));
        return message;
    }

    @MessageMapping("/message")
    @SendToUser("/message")
    public SocketMessage handleSubscribe(SocketMessage message) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        message.setMessage("test");
        message.setSendDate(sdf.format(new Date()));
        return message;
    }

}
