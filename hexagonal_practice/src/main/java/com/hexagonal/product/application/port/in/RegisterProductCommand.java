package com.hexagonal.product.application.port.in;

import com.hexagonal.product.domain.Money;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import com.hexagonal.shared.SelfValidating;

/* 어플리케이션 코어 외부에서 들어온 유효하지 않은 입력값으로 인해 모델 상태가 오염되는 것을 방지하기 위해
* 어플리케이션 계층(유즈케이스 구현체 진입 전)에서 입력 유효성 검증을 한다.
* 입려모델 객체의 생성자에서 이 문제를 다룬다.
* Bean Validation API를 이용해 생성자에 넣을 코드를 줄인다.
*
* builder 대신 생성자를 이용하여 필드 추가 시 반드시 해당 필드에 대해 조치하도록 컴파일타임에 알린다.

* 유즈케이스 전용 모델을 통해 유즈케이스를 명확하게 한다.
*/

@Getter
public class RegisterProductCommand extends SelfValidating<RegisterProductCommand> {
    @NotNull(message = "product name is mandatory")
    private final ProductName productName;

    @NotNull(message = "product stock is mandatory")
    private final Stock productStock;
    @NotNull(message = "product price is mandatory")
    private final Money productPrice;

    public RegisterProductCommand(
            String productName,
            int productStock,
            int productPrice
    ) {
        this.productName = new ProductName(productName);
        this.productStock = new Stock(productStock);
        this.productPrice = new Money(productPrice);
        this.validateSelf();
    }
}
