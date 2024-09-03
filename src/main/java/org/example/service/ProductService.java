package org.example.service;

import org.example.annotation.Metric;

public class ProductService {
    @Metric(name = "test")
    public void findProduct(String id) {
        System.out.println("Product found with ID: " + id);
    }
}
