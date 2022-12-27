package com.learn.springboot6hours.repository;

import com.learn.springboot6hours.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product,String> {

    void delete(Optional<Product> find);
}
