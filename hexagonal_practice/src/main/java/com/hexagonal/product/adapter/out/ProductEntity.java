package com.hexagonal.product.adapter.out;


import com.hexagonal.product.domain.Money;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/* @OneToMany, @ManyToOne 등을 이용해 다른 엔티티와 관계를 표현할 수도 있고,
* 사용에 따른 부수효과를 주기위해서 의도적으로 사용하지 않을 수도 있다
*/
@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column private String name;
    @Column private Long stock;
    @Column private String price;
}
