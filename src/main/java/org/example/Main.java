package org.example;

import org.example.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService = context.getBean(ProductService.class);
        productService.findProduct("test");
    }
}
