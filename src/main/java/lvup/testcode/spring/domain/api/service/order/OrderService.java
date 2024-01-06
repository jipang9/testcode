package lvup.testcode.spring.domain.api.service.order;

import lombok.RequiredArgsConstructor;
import lvup.testcode.spring.domain.api.controller.order.request.OrderCreateRequest;
import lvup.testcode.spring.domain.api.service.order.response.OrderResponse;
import lvup.testcode.spring.domain.order.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;

  public OrderResponse createOrder(OrderCreateRequest request) {

  }
}
