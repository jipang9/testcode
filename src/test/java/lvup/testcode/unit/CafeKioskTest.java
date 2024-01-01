package lvup.testcode.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import lvup.testcode.unit.beverage.Americano;
import lvup.testcode.unit.order.Order;
import org.junit.jupiter.api.Test;

class CafeKioskTest {

 @Test
  void add() {
     //given

    CafeKiosk cafeKiosk =  new CafeKiosk();
    Americano americano = new Americano();
    cafeKiosk.add(americano);
     //when

     //then

 }

 @Test
  void addZeroBeverages(){
   CafeKiosk cafeKiosk = new CafeKiosk();
   Americano americano = new Americano();

   // 예외 테스트
   assertThatThrownBy(()->cafeKiosk.add(americano, 0)).isInstanceOf(IllegalArgumentException.class)
       .hasMessage("음료는 1잔 이상 주문해야함");
 }

 @Test
 void createOrder(){


  CafeKiosk cafeKiosk =  new CafeKiosk();
  Americano americano = new Americano();
  cafeKiosk.add(americano);

  Order order = cafeKiosk.createOrder();

  assertThat(order.getBeverages()).hasSize(1);


 }

 @Test
 void createOrderV2(){

  CafeKiosk cafeKiosk =  new CafeKiosk();
  Americano americano = new Americano();
  cafeKiosk.add(americano);
//경계값 테스트
  Order order = cafeKiosk.createOrderV2(LocalDateTime.of(2023,1,17,10,0));

  assertThat(order.getBeverages()).hasSize(1);
  assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");

 }

 // 테스트하기 어려운 영역을 구분하고 분리하기
 // 테스트하기 어려운 영역의 예시

 /**
  * 관측할 떄마다 다른 값에 의존하는 코드
  * ex 현재 날짜/시간/랜덤 값/전역 변수/함수, 사용자 입력 등
  *
  * 외부 세계에 영향을 주는 코드
  * ex 표준 출력, 메시지 발솔, 데이터베이스에 기록하기 등
  */

}