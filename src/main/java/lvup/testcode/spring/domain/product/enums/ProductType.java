package lvup.testcode.spring.domain.product.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProductType {
  HANDMADE("제조 음료"),
  BOTTLE("병음료"),
  BAKERY("베이커리");
  private final String text;
}
