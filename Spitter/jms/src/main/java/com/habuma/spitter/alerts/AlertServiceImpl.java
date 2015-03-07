package com.habuma.spitter.alerts;

import com.habuma.spitter.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class AlertServiceImpl implements AlertService {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendSpittleAlert(final Spittle spittle) {
        jmsTemplate.send(
                "spittle.alert.queue",
                new MessageCreator() {
                    public Message createMessage(Session session)
                            throws JMSException {
                        return session.createObjectMessage(spittle);
                    }
                }
        );
    }
}
