package com.shop;

import com.shop.service.ProductService;
import com.shop.service.ProductServiceWs;

import java.net.MalformedURLException;
import java.net.URL;

public class WsClient {

    public static void main(String[] args) throws MalformedURLException {
        URL wsUrl = new URL("http://localhost:8080/JavaEEWebApp/ProductService/ProductServiceImpl?WSDL");
        ProductService productService = new ProductService(wsUrl);
        ProductServiceWs servicePort = productService.getProductServiceImplPort();

        servicePort.findAll()
                .forEach(p -> System.out.println(p.getName()));
    }
}
