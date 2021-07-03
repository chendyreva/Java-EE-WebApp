package com.shop;

import com.shop.persist.ProductRepr;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.resource.cci.ConnectionFactory;

import java.io.IOException;
import java.math.BigDecimal;

import static com.shop.EjbClient.createInitialContext;

public class JmsClient {

    public static void main(String[] args) throws IOException, NamingException {
        Context context = createInitialContext();

        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
        JMSContext jmsContext = connectionFactory.createContext("jmsuser", "123");

        Destination dest = (Destination) context.lookup("jms/queue/productQueue");

        JMSProducer producer = jmsContext.createProducer();

        ObjectMessage objectMessage = jmsContext.createObjectMessage(new ProductRepr(null, "JmsProduct",
                "JmsProduct", new BigDecimal(111)));
        producer.setProperty("action", "create").send(dest, objectMessage);
    }
}
