package lvup.testcode.spring;

import lvup.testcode.spring.domain.product.Product;
import lvup.testcode.spring.domain.product.enums.ProductSellingStatus;
import lvup.testcode.spring.domain.product.enums.ProductType;

public class ItemFactory {

  public Product createProduct(String number, ProductType type, ProductSellingStatus sellingStatus, String name, Integer price){

    return Product.builder()
        .productNumber(number)
        .type(type)
        .sellingStatus(sellingStatus)
        .name(name)
        .price(price)
        .build();

  }
}
