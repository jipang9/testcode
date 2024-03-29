package lvup.testcode.spring.domain.api.service.product.response;

import lombok.Builder;
import lombok.Getter;
import lvup.testcode.spring.domain.product.Product;
import lvup.testcode.spring.domain.product.enums.ProductSellingStatus;
import lvup.testcode.spring.domain.product.enums.ProductType;

@Getter
public class ProductResponse {

  private Long id;

  private String productNumber;

  private ProductType type;

  private ProductSellingStatus sellingType;

  private String name;

  private int price;

  @Builder
  public ProductResponse(Long id, String productNumber, ProductType type,
      ProductSellingStatus sellingType, String name, int price) {
    this.id = id;
    this.productNumber = productNumber;
    this.type = type;
    this.sellingType = sellingType;
    this.name = name;
    this.price = price;
  }

  public static ProductResponse of(Product product) {
    return ProductResponse.builder()
        .id(product.getId())
        .productNumber(product.getProductNumber())
        .type(product.getType())
        .sellingType(product.getSellingStatus())
        .name(product.getName())
        .price(product.getPrice()).build();
  }
}
