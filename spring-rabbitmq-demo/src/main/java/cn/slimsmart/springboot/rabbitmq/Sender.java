package cn.slimsmart.springboot.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String message) {
        System.out.println("send message = [" + message + "]");
        amqpTemplate.convertAndSend("hello", message);
    }
}
