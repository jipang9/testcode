package lvup.testcode.spring.domain.api.service.order;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lvup.testcode.spring.domain.api.controller.order.request.OrderCreateRequest;
import lvup.testcode.spring.domain.api.service.order.response.OrderResponse;
import lvup.testcode.spring.domain.order.Order;
import lvup.testcode.spring.domain.order.OrderRepository;
import lvup.testcode.spring.domain.product.Product;
import lvup.testcode.spring.domain.product.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final ProductRepository productRepository;

  public OrderResponse createOrder(OrderCreateRequest request) {
    final List<String> productNumbers = request.getProductNumbers();

    final List<Product> products = productRepository.findByProductNumberIn(productNumbers);


    Order order = Order.create(products);
  }
}
