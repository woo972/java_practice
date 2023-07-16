package com.hexagonal.product.application.port.out;

import com.hexagonal.product.domain.Product;
import org.springframework.stereotype.Component;

public interface RegisterProductPort {

    public void registerProduct(Product product);
}
