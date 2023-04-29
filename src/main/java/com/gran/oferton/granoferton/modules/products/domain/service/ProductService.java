package com.gran.oferton.granoferton.modules.products.domain.service;

import com.gran.oferton.granoferton.modules.products.domain.dto.Product;
import com.gran.oferton.granoferton.modules.products.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public  ProductService(
            ProductRepository productRepository
    ) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product saveProduct(Product product) {
        productRepository.saveProduct(product);
        return product;
    }

    public Product getProductById(String id) {
        return productRepository.findProductById(id);
    }

    public boolean isProductPresent(String  id) {
        return productRepository.checkProductPresent(id);
    }

    public int updateProduct(boolean status, String id) {
        return productRepository.updateProduct(status, id);
    }

    public void deleteProduct(String id) {
        productRepository.deleteProduct(id);
    }
}
