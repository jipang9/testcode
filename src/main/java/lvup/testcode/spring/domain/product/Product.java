package lvup.testcode.spring.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lvup.testcode.spring.domain.BaseEntity;
import lvup.testcode.spring.domain.product.enums.ProductsellingStatus;
import lvup.testcode.spring.domain.product.enums.ProductType;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String productNumber;

  @Enumerated(EnumType.STRING)
  private ProductType type;

  @Enumerated(EnumType.STRING)
  private ProductsellingStatus sellingStatus;

  private String name;

  private int price;

}
