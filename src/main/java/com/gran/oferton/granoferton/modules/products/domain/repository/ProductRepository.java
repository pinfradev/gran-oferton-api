package com.gran.oferton.granoferton.modules.products.domain.repository;


import com.gran.oferton.granoferton.modules.products.domain.dto.Product;
import com.gran.oferton.granoferton.modules.products.persistence.entity.ProductEntity;
import com.gran.oferton.granoferton.modules.products.persistence.mapper.ProductMapper;
import com.gran.oferton.granoferton.modules.products.persistence.repository.ProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    public Product saveProduct(Product product) {
        ProductEntity productEntity = productMapper.toProductEntity(product);
        productCrudRepository.save(productEntity);
        return product;
    }

    @Override
    public Product updateProduct(Product newProduct) {
        return null;
    }

    @Override
    public Product findProductById(String id) {
        ProductEntity searchedProduct = productCrudRepository.findById(id).get();
        return productMapper.toProduct(searchedProduct);
    }

    public boolean checkProductPresent(String id) {
        Optional<ProductEntity> product = productCrudRepository.findById(id);
        return product.isPresent();
    }

    public int updateProduct(boolean isActive, String id) {
        return productCrudRepository.updateProductStatus(isActive, id);
    }

    public void deleteProduct(String id) {
        productCrudRepository.deleteById(id);
    }
}
