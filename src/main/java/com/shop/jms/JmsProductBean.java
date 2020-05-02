package com.shop.jms;

import com.shop.service.ProductServiceLocal;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/productQueue"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "action = 'create'")
})
public class JmsProductBean implements MessageListener {

    @EJB
    private ProductServiceLocal productRepository;

    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            try {
                ProductRepr product = (ProductRepr) ((ObjectMessage) message).getObject();
                productRepository.insert(product);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
