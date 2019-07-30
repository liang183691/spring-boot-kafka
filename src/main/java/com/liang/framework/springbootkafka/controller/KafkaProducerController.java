package com.liang.framework.springbootkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("send")
    public String send(String msg){
        for(int i = 0;i<10000;i++) {
            kafkaTemplate.send("test_topic1", msg + i);
            /*kafkaTemplate.send("test_topic2", msg + i);
            kafkaTemplate.send("test_topic3", msg + i);
            kafkaTemplate.send("test_topic4", msg + i);
            kafkaTemplate.send("test_topic5", msg + i);*/
        }
        return "success";
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
