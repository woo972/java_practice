package com.hexagonal.product.adapter.in.web.register;

import com.hexagonal.product.domain.Money;
import lombok.Getter;

/* 각 유즈케이스마다 출력모델을 다르게 해야 강결합을 막을 수 있다
* 도메인 엔티티를 출력모델로 사용할 경우, 불필요한 필드를 도메인 엔티티에 추가하는 등 SRP를 위반하게될 가능서이 높다
*/
@Getter
public
class RegisterProductResponse {
    private long id;
    private String name;
    private long stock;
    private Money price;

}
