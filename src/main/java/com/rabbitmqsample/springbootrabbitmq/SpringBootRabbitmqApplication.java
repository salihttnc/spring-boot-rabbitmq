package com.rabbitmqsample.springbootrabbitmq;

import com.rabbitmqsample.springbootrabbitmq.entity.Notification;
import com.rabbitmqsample.springbootrabbitmq.producer.NotificationProducer;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableRabbit
public class SpringBootRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitmqApplication.class, args);
    }

}
