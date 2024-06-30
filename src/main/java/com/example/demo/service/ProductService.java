package com.example.demo.service;

import com.example.demo.controller.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public ProductDto retrieve(int id) {
        return new ProductDto("Keychron K3", "Keyboard", 120000, "/public/k3.jpg");
    }
}
