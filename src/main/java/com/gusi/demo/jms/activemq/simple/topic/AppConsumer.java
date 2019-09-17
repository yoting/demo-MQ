package com.gusi.demo.jms.activemq.simple.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by gusi on 2017/8/27.
 */
public class AppConsumer {
    public static final String url = "tcp://127.0.0.1:61616";
    public static final String topicName = "firstTopic";

    public static void main(String[] args) throws JMSException {
        //创建连接工厂
        // ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", url);
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        //通过工厂获得连接并且启动连接
        Connection connection = factory.createConnection();
        connection.start();

        //创建会话session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建一个地址
        Destination destination = session.createTopic(topicName);
        //创建消费者
        MessageConsumer consumer = session.createConsumer(destination);

        //接收消息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;

                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        //关闭连接
        //connection.close();
    }
}