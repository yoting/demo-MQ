package com.gusi.demo.jms.activemq.spring.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by gusi on 2017/8/28.
 */
public class ConsumerMessageListenerTopic implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println("接收消息(topic)：" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
