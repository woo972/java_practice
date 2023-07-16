package com.hexagonal.product.adapter.out.persistence;

import com.hexagonal.product.adapter.out.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/* 영속성 어댑터는 포트 인터페이스를 통해 입력을 받는다.
* 입력모델은 도메인 엔티티 혹은 데이터베이스 연산전용 객체다.
* 영속성 어댑터는 입력모델을 받아 데이터베이스에 쿼리할 수 있는 포맷(jpa 엔티티)으로 매핑한다.
* 데이터베이스에서 응답을 받으면 포트에 정의된 출력 모델로 매핑하여 반환한다(출력모델은 어플리케이션 코어에 위치한다)
*
* 영속성 어댑터는 통상 bounted context당 하나이다.
* 즉, 다른 맥락의 영속성 어댑터에 접근하는 방법은 전용 인커밍 포트를 통해서만 가능한다.
* ex) product 도메인에서 user 도메닝 영속성 어댑터에 바로 접근할 수 없다
*
* 통상 OR 매퍼로 JPA가 사용되나, 즉시로딩/지연로딩, 캐싱 등 복잡한 기술로 인한 부수효과가 있을 수 있기 때문에
* 경우에 따라서는 다른 툴을 사용하는 것이 더 좋을 수도 있다
*/
interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
