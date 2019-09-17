package com.gusi.demo.jms.activemq.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gusi on 2017/8/28.
 */
public class AppConsumer {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("activemq/consumer.xml");
        //加载消息接收容器后，监听器收到消息会自动触发onMessage方法
    }
}
