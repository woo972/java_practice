package com.hexagonal.product.adapter.out;

import com.hexagonal.product.domain.Money;
import com.hexagonal.product.domain.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class ProductMapper {

    public Product mapToDomainEntity(ProductEntity productEntity){
        long id = productEntity.getId();
        String name = productEntity.getName();
        long stock = Optional.ofNullable(productEntity.getStock()).orElse(0L);
        Money price = new Money(new BigDecimal(Optional.of(productEntity.getPrice()).orElse("0")));
        return new Product(id, name, stock, price);
    }

    public ProductEntity mapToPersistenceEntity(Product product){
        return new ProductEntity(
                product.getId(),
                product.getName(),
                product.getStock(),
                product.getPrice().getValue().toString()
        );
    }
}
