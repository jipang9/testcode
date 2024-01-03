package lvup.testcode.spring.domain.product.enums;


import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProductsellingStatus {

  SELLING("판매중"),
  HOLD("판매보류"),
  STOP_SELLING("판매중지");

  private final String text;

  public static List<ProductsellingStatus> forDisplay() {
  return List.of(SELLING,HOLD);
  }
}
