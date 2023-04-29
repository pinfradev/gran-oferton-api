package com.gran.oferton.granoferton.modules.products.domain.repository;


import com.gran.oferton.granoferton.modules.products.domain.dto.Product;
import com.gran.oferton.granoferton.modules.products.persistence.entity.ProductEntity;
import com.gran.oferton.granoferton.modules.products.persistence.mapper.ProductMapper;
import com.gran.oferton.granoferton.modules.products.persistence.repository.ProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements ProductRepositoryContract{

    private ProductCrudRepository productCrudRepository;
    private ProductMapper productMapper;
    @Autowired
    public ProductRepository(
        ProductCrudRepository productCrudRepository,
        ProductMapper productMapper
    ) {
        this.productCrudRepository = productCrudRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> getAllProducts() {
        List<ProductEntity> products = (List<ProductEntity>) productCrudRepository.findAll();
        return productMapper.toProducts(products);
    }

    @Override
    public Void saveProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product newProduct) {
        return null;
    }

    @Override
    public Product deleteProduct(long id) {
        return null;
    }

    @Override
    public Product findProductById(long id) {
        return null;
    }
}
