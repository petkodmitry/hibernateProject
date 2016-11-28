package com.petko;

import com.petko.entities.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLoader1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        SenderService senderService = (SenderService) context.getBean("senderService");
        Message message = new Message();
        message.setTitle("Theme of the message");
        message.setBody("Text of the message");
        senderService.setMessage(message);
        senderService.sendMessage();
    }
}
