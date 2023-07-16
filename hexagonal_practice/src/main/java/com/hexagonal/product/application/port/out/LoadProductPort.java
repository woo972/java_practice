package com.hexagonal.product.application.port.out;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
/* 포트의 스콥을 최대한 좁게 만들어서 코딩을 플러그앤플레이 방식이 되도록 해야한다.
 * ex) load product port에서 register메서드를 가지고 있다면, 응집성이 떨어지는 사례라고 볼 수 있다.
 * 이상적인 것은 포트 당 하나의 메서드만 존재하는 것이다.
 */

public interface LoadProductPort {

}
