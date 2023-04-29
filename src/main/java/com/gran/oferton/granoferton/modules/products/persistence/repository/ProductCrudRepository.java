package com.gran.oferton.granoferton.modules.products.persistence.repository;

import com.gran.oferton.granoferton.modules.products.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Long> {
}
