package lvup.testcode.spring.domain.product;

import static lvup.testcode.spring.domain.product.enums.ProductSellingStatus.HOLD;
import static lvup.testcode.spring.domain.product.enums.ProductSellingStatus.SELLING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.List;
import lvup.testcode.spring.domain.product.enums.ProductSellingStatus;
import lvup.testcode.spring.domain.product.enums.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

// 단위 테스트에 가깝다는 점

@ActiveProfiles("test")
@SpringBootTest
//@DataJpaTest // spring boot test에 비해 조금 더 빠름 -> jpa와 관련된 bean 부분만 사용
class ProductRepositoryTest {

  @Autowired
  ProductRepository productRepository;

  @Test
  @DisplayName("원하는 판매상태를 가진 상품 조회")
  public void ProductRepositoryTest() {
    //given
    final Product product1 = Product.builder()
        .productNumber("001")
        .type(ProductType.HANDMADE)
        .sellingStatus(SELLING)
        .name("아메리카노")
        .price(4000)
        .build();

    final Product product2 = Product.builder()
        .productNumber("002")
        .type(ProductType.HANDMADE)
        .sellingStatus(HOLD)
        .name("카페라떼")
        .price(4500)
        .build();

    final Product product3 = Product.builder()
        .productNumber("003")
        .type(ProductType.HANDMADE)
        .sellingStatus(ProductSellingStatus.STOP_SELLING)
        .name("팥빙수")
        .price(7000)
        .build();

    productRepository.saveAll(List.of(product1, product2, product3));
    //when

    final List<Product> products = productRepository.findAllBySellingStatusIn(
        List.of(SELLING, HOLD));
    //then

    assertThat(products).hasSize(2)
        .extracting("productNumber", "name", "sellingStatus")
        .containsExactlyInAnyOrder(
            tuple("001", "아메리카노", SELLING),
            tuple("002", "카페라떼", HOLD)
        );
  }

  @Test
  @DisplayName("상품 번호(리스트)로 상품 조회 테스트 ")
  void findAllByProductNumberIn(){
    //given
    final Product product1 = Product.builder()
        .productNumber("001")
        .type(ProductType.HANDMADE)
        .sellingStatus(SELLING)
        .name("아메리카노")
        .price(4000)
        .build();

    final Product product2 = Product.builder()
        .productNumber("002")
        .type(ProductType.HANDMADE)
        .sellingStatus(HOLD)
        .name("카페라떼")
        .price(4500)
        .build();

    final Product product3 = Product.builder()
        .productNumber("003")
        .type(ProductType.HANDMADE)
        .sellingStatus(ProductSellingStatus.STOP_SELLING)
        .name("팥빙수")
        .price(7000)
        .build();

    productRepository.saveAll(List.of(product1, product2, product3));
    //when

    final List<Product> byProductNumberIn = productRepository.findByProductNumberIn(
        List.of("001", "002"));
    //then

    assertThat(byProductNumberIn).hasSize(2)
        .extracting("productNumber", "name", "sellingStatus")
        .containsExactlyInAnyOrder(
            tuple("001", "아메리카노", SELLING),
            tuple("002", "카페라떼", HOLD)
        );
  }
}