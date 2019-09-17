package com.gusi.demo.jms.activemq.simple.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by gusi on 2017/8/27.
 */
public class AppProducer {
    public static final String url = "tcp://127.0.0.1:61616";
    public static final String queueName = "firstQueue";


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
        Destination destination = session.createQueue(queueName);
        //创建生产者
        MessageProducer producer = session.createProducer(destination);

        //发送消息到队列
        for (int i = 0; i < 10; i++) {
            TextMessage message = session.createTextMessage("msg" + i);
            producer.send(message);
            System.out.println("send message:" + message.getText());
        }

        //关闭连接
        connection.close();
    }
}
