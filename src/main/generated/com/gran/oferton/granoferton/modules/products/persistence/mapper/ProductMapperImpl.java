package com.gran.oferton.granoferton.modules.products.persistence.mapper;

import com.gran.oferton.granoferton.modules.products.domain.dto.Product;
import com.gran.oferton.granoferton.modules.products.persistence.entity.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-28T23:09:38-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductName( productEntity.getName() );
        product.setId( productEntity.getId() );
        product.setImageUrl( productEntity.getImageUrl() );
        if ( productEntity.getPrice() != null ) {
            product.setPrice( productEntity.getPrice() );
        }
        if ( productEntity.getStock() != null ) {
            product.setStock( productEntity.getStock().intValue() );
        }
        product.setDescription( productEntity.getDescription() );

        return product;
    }

    @Override
    public List<Product> toProducts(List<ProductEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( entities.size() );
        for ( ProductEntity productEntity : entities ) {
            list.add( toProduct( productEntity ) );
        }

        return list;
    }
}
