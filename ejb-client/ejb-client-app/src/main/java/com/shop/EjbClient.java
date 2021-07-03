package com.shop;

import com.shop.persist.ProductRepr;
import com.shop.persist.ProductServiceRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class EjbClient {

    public static void main(String[] args) throws IOException, NamingException, ExecutionException, InterruptedException {
        Context context = createInitialContext();

        ProductServiceRemote repository = (ProductServiceRemote) context.lookup("ejb:/JavaEEWebApp/ProductServiceImpl!com.shop.persist.ProductServiceRemote");
        repository.findAll().forEach(prod -> System.out.println(prod.getName()));

        Future<List<ProductRepr>> future = repository.findAllAsync();
        List<ProductRepr> productReprs = future.get();
    }

    public static Context createInitialContext() throws IOException, NamingException {
        final Properties env = new Properties();
        env.load(EjbClient.class.getClassLoader().getResourceAsStream("wildfly-jndi.properties"));
        return new InitialContext(env);
    }
}

