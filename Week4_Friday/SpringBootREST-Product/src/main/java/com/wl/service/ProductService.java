package com.wl.service;

import com.wl.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product addProduct(Product product);

    List<Product> fetchProducts();

    Product update(Product product, Long productId);

    void delete(Product product);

    Optional<Product> get(Long productId);
}
