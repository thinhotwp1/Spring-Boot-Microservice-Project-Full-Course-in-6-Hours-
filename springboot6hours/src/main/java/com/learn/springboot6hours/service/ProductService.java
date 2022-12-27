package com.learn.springboot6hours.service;

import com.learn.springboot6hours.dto.ProductRequest;
import com.learn.springboot6hours.dto.ProductResponse;
import com.learn.springboot6hours.model.Product;
import com.learn.springboot6hours.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository db;


    public void createProduct(ProductRequest request){
        Product product = Product.builder().
                name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
        db.save(product);
        log.info("Product is save: {}",product);
    }

    public List<ProductResponse> getAllProduct() {
        List<Product> list = db.findAll();
        List<ProductResponse> listRespone = list.stream().map(product -> mapToProductResponse(product)).toList();
        log.info("list product size: {}",listRespone.size());
        return listRespone;
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public ProductResponse updateProduct(ProductRequest request) {
        String id = request.getId();
        Optional<Product> Find = db.findById(id);
        db.delete(Find);
        Product product = Product.builder().
                name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
        db.save(product);
        log.info("Product is save: {}",product);
        ProductResponse response = ProductResponse.builder()
                .id(product.getId())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
        log.info("Product is update: {}",response);
        return response;
    }
}
