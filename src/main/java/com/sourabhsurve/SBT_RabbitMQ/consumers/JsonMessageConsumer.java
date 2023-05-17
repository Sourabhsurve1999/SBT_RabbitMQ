package com.sourabhsurve.SBT_RabbitMQ.consumers;

import com.sourabhsurve.SBT_RabbitMQ.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class JsonMessageConsumer {

    private static final Logger LOGGER= LoggerFactory.getLogger(JsonMessageConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void consume(User user){
      LOGGER.info(String.format("Json Message Received -> %s ",user.toString()));
      
    }
}
