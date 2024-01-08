package lvup.testcode.spring.domain.api.service.order.response;


import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lvup.testcode.spring.domain.api.service.product.response.ProductResponse;
import lvup.testcode.spring.domain.order.OrderStatus;

@Getter
public class OrderResponse {

  private Long id;
  private OrderStatus orderStatus;
  private int totalPrice;
  private LocalDateTime registerDateTime;
  private List<ProductResponse> products;

}
