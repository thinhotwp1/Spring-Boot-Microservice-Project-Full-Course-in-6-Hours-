package com.learn.springboot6hours.controller;

import com.learn.springboot6hours.dto.ProductRequest;
import com.learn.springboot6hours.dto.ProductResponse;
import com.learn.springboot6hours.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest request){
        service.createProduct(request);
    }

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct(){
        return service.getAllProduct();
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse updateProduct(@RequestBody ProductRequest request){
        return service.updateProduct(request);
    }
}
