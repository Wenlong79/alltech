package com.wl.service;

import com.wl.entity.Product;
import com.wl.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product update(Product product, Long productId) {
        Product productFromDb = get(productId).get();
        productFromDb.setProductName(product.getProductName());
        productFromDb.setProductPrice(product.getProductPrice());
        return productRepository.save(productFromDb);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Optional<Product> get(Long productId) {
        return productRepository.findById(productId);
    }
}
