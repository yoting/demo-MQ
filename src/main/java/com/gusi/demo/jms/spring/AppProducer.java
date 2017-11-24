package com.gusi.demo.jms.spring;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gusi on 2017/8/28.
 */
public class AppProducer {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService producerService = (ProducerService) ac.getBean("producerServiceImpl");

        for (int i = 0; i < 100; i++) {
            producerService.sendMessage("msg" + i);
        }
    }
}
