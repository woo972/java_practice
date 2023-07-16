package com.hexagonal.product.adapter.in.web.register;

import com.hexagonal.product.application.port.in.RegisterProductCommand;
import com.hexagonal.product.application.port.in.RegisterProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/* 웹 어댑터는 입력모델을 유즈케이스의 입력모델로 변환할 수 있다는 것을 검증해야한다.
* 이 과정에서 문제가 발생하면 에러를 발생시키고 호출자에게 보여줄 메시지로 변환해야한다.
* 각 컨트롤러는 최소한의 기능을 담도록 노력해야 한다.
* - 테스트 스콥을 줄이고
* - 공유되어 사용하는 객체의 중복사용을 지양하기 위해서
* => 별도 패키지 안에 별도의 컨트롤러와 전용 모델 클래스를 두는 방식
*/
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final RegisterProductUseCase registerProductUseCase;

    @PostMapping("/products")
    public RegisterProductResponse registerProduct(RegisterProductRequest registerProductRequest){
        RegisterProductCommand registerProductCommand = new RegisterProductCommand(
                registerProductRequest.getName(),
                registerProductRequest.getStock(),
                registerProductRequest.getPrice()
        );
        RegisterProductResponse registerProductResponse = registerProductUseCase.registerProduct(registerProductCommand);
        return registerProductResponse;
    }
}
