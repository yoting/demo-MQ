package com.gusi.demo.jms.activemq.spring.procucer;

/**
 * Created by gusi on 2017/8/28.
 */
public interface ProducerService {
    void sendMessageTopic(String msg);
    void sendMessageQueue(String msg);
}
