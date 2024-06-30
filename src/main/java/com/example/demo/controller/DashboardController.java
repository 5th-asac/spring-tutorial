package com.example.demo.controller;

import com.example.demo.controller.dto.ProductDto;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class DashboardController {
    private final ProductService productService;

    @GetMapping("")
    public String main(Model model) {
        ProductDto product = productService.retrieve(1);
        model.addAttribute("list", List.of(product));
        return "/index";
    }

    @PostMapping("/product")
    @ResponseBody
    public ProductDto product() {
        return productService.retrieve(1);
    }
}
