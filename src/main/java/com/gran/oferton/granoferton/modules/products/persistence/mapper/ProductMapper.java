package com.gran.oferton.granoferton.modules.products.persistence.mapper;

import com.gran.oferton.granoferton.modules.products.domain.dto.Product;
import com.gran.oferton.granoferton.modules.products.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper{
    @Mappings({
            @Mapping(source = "name", target = "productName")
    })
    public Product toProduct(ProductEntity productEntity);

    public List<Product> toProducts(List<ProductEntity> entities);

    @InheritInverseConfiguration
    public ProductEntity toProductEntity(Product product);
}
