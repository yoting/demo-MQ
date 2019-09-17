package com.gusi.demo.jms.activemq.spring;

import com.gusi.demo.jms.activemq.spring.procucer.ProducerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * Created by gusi on 2017/8/28.
 */
public class AppProducer {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("activemq/producer.xml");
        ProducerService producerService = (ProducerService) ac.getBean("producerServiceImpl");

        TimeUnit.SECONDS.sleep(10);

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                producerService.sendMessageTopic("msg" + i);
            } else {
                producerService.sendMessageQueue("msg" + i);
            }
        }
    }
}
