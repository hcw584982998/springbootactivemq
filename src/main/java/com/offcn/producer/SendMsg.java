package com.offcn.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SendMsg {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/send")
    @ResponseBody
    public String send(){
        jmsMessagingTemplate.convertAndSend("queue_offcn","Hello World");
        return "hello";
    }
    //注释
    public void test(){
        System.out.println("test");
    }
    @RequestMapping("/send2")
    @ResponseBody
    public String send2(){
        Map map=new HashMap<>();
        map.put("mobile", "13900001111");
        map.put("content", "恭喜获得 10 元代金券");
        jmsMessagingTemplate.convertAndSend("queue_map",map);
        return "hello";
    }

}
