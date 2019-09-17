package com.gusi.demo.jms.activemq.spring.procucer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created by gusi on 2017/8/28.
 */
@Component
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier(value = "destinationTopic")
    Destination topicDestination;

    @Override
    public void sendMessageTopic(final String msg) {
        jmsTemplate.send(topicDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(msg);
                return textMessage;
            }
        });
    }

    @Override
    public void sendMessageQueue(final String msg) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(msg);
                return textMessage;
            }
        });
    }
}
