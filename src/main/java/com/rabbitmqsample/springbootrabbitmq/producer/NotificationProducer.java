package com.rabbitmqsample.springbootrabbitmq.producer;


import java.util.Date;
import java.util.UUID;
import javax.annotation.PostConstruct;

import com.rabbitmqsample.springbootrabbitmq.entity.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    @Value("${sr.rabbitmq.routing.name}")
    private String routingName;

    @Value("${sr.rabbitmq.exchange.name}")
    private String exchangeName;


    @PostConstruct
    public void init() {
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("RabbitMQ deneme uygulaması");
        notification.setSeen(Boolean.FALSE);

        sendToQueue(notification);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToQueue(Notification notification) {
        System.out.println("Notification Sent ID : " + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName, routingName, notification);
    }
}