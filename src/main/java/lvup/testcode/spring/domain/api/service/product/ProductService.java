package lvup.testcode.spring.domain.api.service.product;


import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lvup.testcode.spring.domain.api.service.product.response.ProductResponse;
import lvup.testcode.spring.domain.product.Product;
import lvup.testcode.spring.domain.product.ProductRepository;
import lvup.testcode.spring.domain.product.enums.ProductsellingStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<ProductResponse> getSellingProducts(){

    final List<Product> products = productRepository.findAllBySellingStatusIn(
        ProductsellingStatus.forDisplay());
    return products.stream().map(ProductResponse::of).collect(Collectors.toList());

  }
}
