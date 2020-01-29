package com.rabbitmqsample.springbootrabbitmq.listener;

import com.rabbitmqsample.springbootrabbitmq.entity.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "stutuncu-queue")
    public void handleMessage(Notification notification){
        System.out.println("Mesaj okundu...");
        System.out.println(notification.toString());
    }
}
