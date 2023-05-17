package com.sourabhsurve.SBT_RabbitMQ.publishers;

import com.sourabhsurve.SBT_RabbitMQ.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JsonRabbitMQProducer {

    private static final Logger LOGGER= LoggerFactory.getLogger(JsonRabbitMQProducer.class);
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.json.routing.key}")
    private String routingjsonkey;

    private RabbitTemplate rabbitTemplate;

    public JsonRabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user){
        LOGGER.info(String.format("Json Message sent -. %s " ,user.toString()));
        rabbitTemplate.convertAndSend(exchange,routingjsonkey,user);

    }
}
