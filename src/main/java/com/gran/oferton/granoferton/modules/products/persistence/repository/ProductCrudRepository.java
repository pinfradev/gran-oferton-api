package com.gran.oferton.granoferton.modules.products.persistence.repository;

import com.gran.oferton.granoferton.modules.products.persistence.entity.ProductEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, String> {
    @Transactional
    @Modifying
    @Query(value="update ProductEntity p set p.isActive = :isActive where p.id= :id")
    int updateProductStatus(@Param("isActive") boolean isActive, @Param("id")String id);
}
