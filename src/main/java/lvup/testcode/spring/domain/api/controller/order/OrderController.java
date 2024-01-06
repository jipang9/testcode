package lvup.testcode.spring.domain.api.controller.order;

import lombok.RequiredArgsConstructor;
import lvup.testcode.spring.domain.api.controller.order.request.OrderCreateRequest;
import lvup.testcode.spring.domain.api.service.order.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @PostMapping("/api/v1/orders/new")
  public void createOrder(@RequestBody OrderCreateRequest request){
    orderService.createOrder(request);
  }
}
