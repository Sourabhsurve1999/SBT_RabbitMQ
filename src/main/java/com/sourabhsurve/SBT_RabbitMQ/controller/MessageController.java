package com.sourabhsurve.SBT_RabbitMQ.controller;

import com.sourabhsurve.SBT_RabbitMQ.publishers.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rabbitmq")
public class MessageController {

    private RabbitMQProducer rabbitMQProducer;

    public MessageController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    //http://localhost:8080/api/rabbitmq/publish?message=hello rabbitmq
    @GetMapping("/publish")
    public ResponseEntity<String>sendMessage(@RequestParam ("message") String message){
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message Sent to RabbitMQ....");

    }
}
