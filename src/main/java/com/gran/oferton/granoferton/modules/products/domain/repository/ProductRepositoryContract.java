package com.gran.oferton.granoferton.modules.products.domain.repository;

import com.gran.oferton.granoferton.modules.products.domain.dto.Product;

import java.util.List;

public interface ProductRepositoryContract {

    public Product findProductById(String id);
    public List<Product> getAllProducts();
    public Product saveProduct(Product product);
    public Product updateProduct(Product newProduct);
    public boolean checkProductPresent(String id);
    public int updateProduct(boolean isActive, String id);

    public void deleteProduct(String id);
}
