market
==========

  - 사과 시장 프로그램
  - Trader
    - 항목: 잔액, 남은 사과의 수
  
  - Buyer
    - Trader를 상속
    - 기능
      - buy(Seller seller, int amount) -> seller에게 amount만큼의 사과를 구매
      - pay(Seller, int price) -> seller에게 price만큼 금액을 지불
  
  - Seller
    - Trader를 상속
    - 기능
      - sell(amount) -> amount만큼 사과를 판매
      - addMoney(int money) -> money만큼 잔액을 증가
  
  - Market
    - 항목: Buyer, Seller
    - 기능
      - proceed() -> Buyer가 Seller에게 사과를 구매
      - show() -> buyer와 seller의 잔액, 남은 사과의 수를 출력
   
  - Main
    - main 실행 -> Market 인스턴스를 생성한 후 proceed,show를 호출
 