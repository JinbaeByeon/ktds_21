gas_station
==========

 - 주유소 프로그램
 - GasStation
   - 항목: 기름 별 가격, Fuel 리스트, 보유금
   - 기능
     - sell(int type,int amount) -> type의 Fuel을 amount만큼 판매
     - checkRemain(int type,int amount) -> type의 Fuel이 amount이상 있는지 확인
     - 출력을 위해 toString() 오버라이딩   
 
 - Customer
   - 항목: Fuel, money(보유금)
   - 기능
     - pay(GasStation gasStation, double) -> gasStation에 price만큼 비용을 지불 
     - buy(GasStation gaStation, int type, int amount) -> gaStation에 type의 Fuel을 amount만큼 구매
     - checkMoney(double price) -> 보유금이 price이상인지 확인
     - 출력을 위해 toString() 오버라이딩   
  
 - Fuel
   - GASOLINE, DIESEL, LPG 3가지 종류를 상수 0,1,2로 지정(index를 통한 접근을 위해)
   - 항목: type(기름의 종류), remain(잔량)

     - 출력을 위해 toString() 오버라이딩
 
 - Street
   - main 실행 
     - gasStation과 customer를 생성해 customer가 gasStation에서 필요한 타입의 기름을 필요량만큼 구매함
