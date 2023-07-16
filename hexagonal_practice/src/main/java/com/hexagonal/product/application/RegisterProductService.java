package com.hexagonal.product.application;

import com.hexagonal.product.adapter.in.web.register.RegisterProductResponse;
import com.hexagonal.product.application.port.in.RegisterProductCommand;
import com.hexagonal.product.application.port.in.RegisterProductUseCase;
import com.hexagonal.product.application.port.out.LoadProductPort;
import com.hexagonal.product.application.port.out.RegisterProductPort;
import com.hexagonal.product.domain.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.hexagonal.shared.exception.InvalidRequestException;

/* 도메인 엔티티 내에서 비즈니스 규칙 검증이 어려운 경우에는 유즈케이스 레벨에서 한다.
* 영속성 어댑터 호출을 관장하는 서비스 레벨에서 @Transactional을 사용하여 트랜잭션을 관리한다.
* (클래스에 사용하는 경우, 모든 public 메서드에 적용된다)
*/
@Transactional
@RequiredArgsConstructor
@Service
class RegisterProductService implements RegisterProductUseCase {

    private final LoadProductPort loadProductPort;
    private final RegisterProductPort registerProductPort;

    @Override
    public RegisterProductResponse registerProduct(RegisterProductCommand registerProductCommand) {
        Product product = loadProductPort.getProductByProductNameAndSellerName(registerProductCommand.getProductName(), registerProductCommand.getSellerName());
        if (product != null) {
            throw new InvalidRequestException("duplicated product with product name & seller name is exist arleady");
        }
        registerProductPort.save(registerProductCommand);
        return null;
    }
}
