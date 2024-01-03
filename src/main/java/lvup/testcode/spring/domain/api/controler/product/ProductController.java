package lvup.testcode.spring.domain.api.controler.product;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lvup.testcode.spring.domain.api.service.product.ProductService;
import lvup.testcode.spring.domain.api.service.product.response.ProductResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductController {

  private final ProductService productService;

  @GetMapping("/api/v1/products/selling")
  public List<ProductResponse> get(){
    return productService.getSellingProducts();
  }

}
