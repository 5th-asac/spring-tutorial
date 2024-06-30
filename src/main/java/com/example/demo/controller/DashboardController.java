package com.example.demo.controller;

import com.example.demo.controller.dto.ProductDto;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
/**
 * - Only 'http://localhost:5173' origins are allowed.
 * - The HTTP methods allowed are all @RequestMapping annotation in this class.
 * - The time that the preflight response is cached (maxAge) is 60 minutes(1 hour).
 */
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

    @GetMapping("/product")
    @ResponseBody
    public ProductDto product() {
        return productService.retrieve(1);
    }
}
