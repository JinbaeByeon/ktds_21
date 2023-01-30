package store;

import java.util.List;

public class ProductCounter {
	
	public void checkQuantity(List<Product> products) {
		for (Product product : products) {
			String name = product.getName();
			int quantity = product.getQuantity();
			
			if(quantity>=2) {
				System.out.println(name + "제품은 재고가 " + quantity +"개 있습니다.");
			}
			else if(quantity == 1) {
				System.out.println(name +"제품은 재고가 " + quantity + "개 있습니다. 재주문이 필요합니다.");			}
			else {
				System.out.println(name + "제품은 품절 되었습니다.");

			}
		}
	}

}
