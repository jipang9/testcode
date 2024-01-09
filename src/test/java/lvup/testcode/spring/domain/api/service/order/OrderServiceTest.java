package lvup.testcode.spring.domain.api.service.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.time.LocalDateTime;
import java.util.List;
import lvup.testcode.spring.ItemFactory;
import lvup.testcode.spring.domain.api.controller.order.request.OrderCreateRequest;
import lvup.testcode.spring.domain.api.service.order.response.OrderResponse;
import lvup.testcode.spring.domain.product.Product;
import lvup.testcode.spring.domain.product.ProductRepository;
import lvup.testcode.spring.domain.product.enums.ProductSellingStatus;
import lvup.testcode.spring.domain.product.enums.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceTest {

  @Autowired
  private OrderService orderService;

  @Autowired
  ProductRepository productRepository;

  ItemFactory itemFactory;

  @Test
  @DisplayName("주문번호 리스트를 받아 주문을 생성")
  public void OrderServiceTest(){
      //given

    LocalDateTime registeredDateTime = LocalDateTime.now();

    final Product product1 = itemFactory.createProduct("001", ProductType.HANDMADE,
        ProductSellingStatus.SELLING, "아메리카노", 1000);
    final Product product2 = itemFactory.createProduct("002", ProductType.HANDMADE,
        ProductSellingStatus.HOLD, "카페라떼", 3000);
    final Product product3 = itemFactory.createProduct("003", ProductType.HANDMADE,
        ProductSellingStatus.STOP_SELLING, "팥빙수", 5000);

    productRepository.saveAll(List.of(product1, product2, product3));

    final OrderCreateRequest request = OrderCreateRequest.builder()
        .productNumbers(List.of("001", "002")).build();

    //when
    OrderResponse orderResponse = orderService.createOrder(request);

    //then
    assertThat(orderResponse.getId()).isNotNull();
    assertThat(orderResponse)
        .extracting("registeredDateTime", "totalPrice")
        .contains(registeredDateTime, 4000);
    assertThat(orderResponse.getProducts()).hasSize(2)
        .extracting("productNumber", "price")
        .containsExactlyInAnyOrder(
            tuple("001", 1000),
            tuple("002", 3000)
        );
  }
}