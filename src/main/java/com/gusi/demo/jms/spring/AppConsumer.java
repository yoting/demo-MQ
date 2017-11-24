package com.gusi.demo.jms.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gusi on 2017/8/28.
 */
public class AppConsumer {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("consumer.xml");
    }
}
