package com.wl.cotroller;

import com.wl.entity.Product;
import com.wl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@Validated @RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        return addedProduct;
    }


    @GetMapping("/fetchProducts")
    public List<Product> fetchProducts() {
        List<Product> products = productService.fetchProducts();
        return products;
    }


    @PutMapping("/updateProduct")
    public Product update(@RequestBody Product product, @RequestParam(value = "id") Long id) {
        return productService.update(product, id);
    }

    @DeleteMapping("/deleteProduct")
    public String delete(@RequestParam(value = "id") Long id) {
        Optional<Product> optionalProduct = productService.get(id);
        Product productToDelete = optionalProduct.get();
        productService.delete(productToDelete);
        return "Product with id [" + id + "] has been deleted";
    }
}
