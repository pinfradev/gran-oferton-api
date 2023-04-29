package com.gran.oferton.granoferton.modules.products.domain.repository;

import com.gran.oferton.granoferton.modules.products.domain.dto.Product;

import java.util.List;

public interface ProductRepositoryContract {

    public Product findProductById(long id);
    public List<Product> getAllProducts();
    public Void saveProduct(Product product);
    public Product updateProduct(Product newProduct);
    public Product deleteProduct(long id);
}
