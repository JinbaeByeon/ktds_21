store
==========

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
