package com.wl.dao;

import com.wl.entity.Product;

public interface Dao {
    public void addProduct(Product product);

    public void searchProduct(Long productId);

    public void browseAllProducts();

    public void updateProduct(Long productId);

    public void deleteProduct(Long productId);


}
