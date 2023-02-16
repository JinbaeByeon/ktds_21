Java
==========
 
## [address](https://github.com/JinbaeByeon/ktds_21/tree/master/Java/eclipse-workspace/address/src/address_book)
  - 주소록 실습
  - 배열, List를 활용한 CRUD 구현

## [board](https://github.com/JinbaeByeon/ktds_21/tree/master/Java/eclipse-workspace/board/src/board)/[bulletin_board](https://github.com/JinbaeByeon/ktds_21/tree/master/Java/eclipse-workspace/bulletin_board/src/bulletin_board)
  - 게시판 프로그램
  - BoardVO
    * 항목: 이름, 제목, 작성자, 조회수

 - BoardService
   * 항목: BoardVO의 리스트
   * 기능
     + create(String subject, String writer) -> subject과 writer에 해당하는 글을 생성
     + update(int idx, String subject) -> 리스트에서 idx에 해당하는 객체의 제목을 subject로 변경
     + delete(int idx) -> 리스트에서 idx에 해당하는 객체를 삭제
     + read(int idx) -> 유효한 idx인 경우 리스트에서 해당하는 객체의 조회수를 1 증가시키고 출력
     + readAll() -> 리스트의 모든 객체를 출력
   
  ##### *bulletin_board는 과제로 먼저 만든 프로젝트

## [calculator](https://github.com/JinbaeByeon/ktds_21/tree/master/Java/eclipse-workspace/bulletin_board/src/calculator)
  - 계산기 프로그램
  - 정수 계산 실습 (더하기, 빼기, 곱하기, 나누기, 나머지)
 
## [class_test](https://github.com/JinbaeByeon/ktds_21/tree/master/Java/eclipse-workspace/bulletin_board/src/class_test)
  - 클래스 및 메소드 실습
  - 평균구하기, 계산기, 온도변화기 등 기능에 따라 클래스와 메소드로 나눔

## [example](https://github.com/JinbaeByeon/ktds_21/tree/master/Java/eclipse-workspace/bulletin_board/src/example)
  - Java를 활용한 디자인패턴 예제

## [gas_station](https://github.com/JinbaeByeon/ktds_21/tree/master/Java/eclipse-workspace/bulletin_board/src/gas_station)
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

## [hospital](https://github.com/JinbaeByeon/ktds_21/tree/master/Java/eclipse-workspace/bulletin_board/src/hospital)
  - Comvertor
    - 기능: 한글의 종성에 따라 뒤에 붙는 글자를 반환해주는 기능

  - Patient
    - 항목: 이름, 증상, 처방받은 약
  
 - Pharmacy
   - 항목: 환자리스트
   - 기능
     - addPatient(String name,String symptom) -> 해당하는 이름과 증상의 환자를 리스트에 추가
     - prescribe() -> 리스트의 모든 환자들의 증상별로 약을 처방 

 - Program
   - main 실행 -> 약국에 환자를 추가하고 약국에서 환자에게 처방을 해줌

## [lotto](https://github.com/JinbaeByeon/ktds_21/tree/master/Java/eclipse-workspace/bulletin_board/src/lotto)
  - 반복문 실습
  - Lotto
    - for, for-each, List for-each / String.split(" ")으로 띄어쓰기로 나눈 문자들을 String[]에 넣어 for문으로 출력
  
  - CSV
    - csv파일을 Files.readAllLines("Path") 메소드로 List<String>에 넣어 반복문으로 출력
  
## [market](https://github.com/JinbaeByeon/ktds_21/tree/master/Java/eclipse-workspace/bulletin_board/src/market)
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
 
## [store](https://github.com/JinbaeByeon/ktds_21/tree/master/Java/eclipse-workspace/bulletin_board/src/store)
 - 재고 확인 프로그램
 - Product
   - 항목: 이름, 재고
  
 - ProductCounter
   - 기능: 상품 리스트를 받아와 모든 상품에 대하여 재고를 확인하고 재고 별로 다른 안내문을 출력
  
 - Store
   - 항목: Product 리스트, ProductCounter
   - 기능
     - addProducts() -> 상품 입고
     - checkProducts() -> ProductCounter를 통해 상품 리스트의 재고 확인
     - addProduct(String name, int quantity) -> 상품 리스트에 이름이 name인 상품이 있을 경우 quantity를 증가시키고 아니라면 새 상품을 추가
   
 - Main : main 실행

## [stream](https://github.com/JinbaeByeon/ktds_21/tree/master/Java/eclipse-workspace/bulletin_board/src/stream)
 - stream 예제 코드
 - Dish
   - 항목: 칼로리, 이름
   - Dish() -> 랜덤한 이름과 랜덤한 칼로리의 음식 생성
   - Dish(string name,int calories) -> 이름이 name이고 칼로리가 calories인 음식 생성
  
 - ExampleCode
   - 항목: Dish의 리스트
   - 기능
     - showMenu() -> Dish 리스트에 존재하는 음식들의 이름과 칼로리를 출력
     - example(int i) -> i에 따라 다른 예제 코드들을 실행
 
 - Main : ExampleCode 실행
## [todo_list](https://github.com/JinbaeByeon/ktds_21/tree/master/Java/eclipse-workspace/bulletin_board/src/todo_list)
 - TODO LIST 프로그램
 - TodoItemService
   - 항목: Todo 아이템 리스트
   - 기능
     - add(String name) -> 리스트에 이름이 name인 아이템을 추가
     - update(int idx, boolean isComplete) -> 리스트의 idx에 해당하는 인덱스의 완료여부를 isComplete으로 설정
     - delete(int idx) -> 리스트의 idx에 해당하는 인덱스의 객체를 삭제
     - read() -> 리스트의 모든 아이템을 조회
     - main() -> 무한반복문을 호출해 입력받는 정수값에 따라 해당하는 메뉴를 호출 및 출력, 종료코드를 호출 시 반복문 종료
   
 - TodoItemVO
   - 항목: 아이템 명, 완료 여부
