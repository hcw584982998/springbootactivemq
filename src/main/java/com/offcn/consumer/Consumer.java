package com.offcn.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Consumer {

    @JmsListener(destination = "queue_offcn")
    public void listen(String text){
        System.out.println("收到的信息为："+text);
    }

    @JmsListener(destination = "queue_map")
    public void listen(Map map){
        System.out.println("收到的信息为："+map);
    }
}
