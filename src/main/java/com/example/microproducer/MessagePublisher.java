package com.example.microproducer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("publish")
public class MessagePublisher {

    private final RabbitTemplate template;

    @PostMapping
    public String publishMessage(@RequestBody CustomMessage message){

        message.setMessageId(UUID.randomUUID());
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
        System.out.println("id: "+ message.getMessageId());
        System.out.println("message: "+message.getMessage());
        return "publish message success";
    }
}
