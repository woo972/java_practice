package com.hexagonal.product.application.port.in;

import com.hexagonal.product.adapter.in.web.register.RegisterProductResponse;

/* 유즈케이스의 역할
*  - 입력을 받는다 (유즈케이스는 도메인 로직에만 신경써야 하므로, 입력 유효성 검증은 리퀘스트 객체에서 한다)
*  - 비즈니스 규칙을 검증한다 (도메인 엔티티와 규칙 검증 책임을 공유한다)
*  - 모델 상태를 조작한다
*  - 출력을 반환한다 (아웃고잉 어댑터에서 온 출력값을 유즈케이스를 출력 객체로 전환하여 반환한다)
*/
public interface RegisterProductUseCase {

    RegisterProductResponse registerProduct(RegisterProductCommand registerProductCommand);
}
