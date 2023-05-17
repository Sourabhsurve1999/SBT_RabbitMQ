package com.sourabhsurve.SBT_RabbitMQ.controller;

import com.sourabhsurve.SBT_RabbitMQ.dto.User;
import com.sourabhsurve.SBT_RabbitMQ.publishers.JsonRabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rabbitmqjson")
public class MessageJsonController {

    private JsonRabbitMQProducer jsonRabbitMQProducer;

    public MessageJsonController(JsonRabbitMQProducer jsonRabbitMQProducer) {
        this.jsonRabbitMQProducer = jsonRabbitMQProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonRabbitMQProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Message send to RabbitMQ....");

    }
}
