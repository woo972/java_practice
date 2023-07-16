package com.hexagonal.product.adapter.out.persistence;

import com.hexagonal.product.adapter.out.ProductEntity;
import com.hexagonal.product.adapter.out.ProductMapper;
import com.hexagonal.product.application.port.out.RegisterProductPort;
import com.hexagonal.product.domain.Product;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/* JPA 엔티티(영속성 엔티티)를 ProductEntity 대신 Product를 활용할 경우,
* 몇 가지 제약(JPA 엔티티는 항상 기본생성자가 필요)이 생기기 때문에 이를 분리하여 서로 매핑하는 전략을 사용하는 것이 나을 때도 있다.
*
* spring 클래스패스 스캐닝을 이용할 경우,
* persistence package에 위치하는 클래스는 외부에서 접근할 필요가 없기 때문에 default 접근 제한자로 생성해도 된다.
* 리플렉션을 통해 인스턴스 생성이 가능하기 때문이다.
* 그러나 클래스 개수가 많아지고, 하위 패키지를 분리하다보면 하위패키지 default 접근제한자 member에 접근할 수 없기 때문에,
* public으로 놓을수 밖에 없게 된다.
*/
@RequiredArgsConstructor
@Component
class ProductPersistenceAdapter implements RegisterProductPort {

    private final ProductRepository productRepository;
//    private final SellerRepository sellerRepository;
    private final ProductMapper productMapper;


    public Product loadProduct(long productId) {
        ProductEntity productEntity = productRepository.findById(productId)
                .orElseThrow(EntityNotFoundException::new);

        // add seller info to Product

        return productMapper.mapToDomainEntity(productEntity);
    }

    @Override
    public void registerProduct(Product product) {

    }
}
