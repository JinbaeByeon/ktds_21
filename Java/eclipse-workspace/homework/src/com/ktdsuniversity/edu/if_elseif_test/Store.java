package com.ktdsuniversity.edu.if_elseif_test;

import java.util.List;

import com.ktdsuniversity.edu.class_test.ProductVO;

public class Store {
	List<ProductVO> list;
	int money;
	
	public Store() {
		list = List.of(new ProductVO[10]);
		for(int i=0;i<10;++i) {
			list.get(i).setName("a" +i);
			list.get(i).setPrice(i*1000);
			list.get(i).setRemain(100);
		}
	}

	public int sell(int idx, int amount) {
		for(int i=0;i<amount;++i) {
			if(!sell(i)) {
				return i;
			}
		}
		return amount;
	}
	public boolean sell(int idx) {
		ProductVO product = list.get(idx);
		if(product.getRemain()>0) {
			product.addRemain(-1);
			money += product.getPrice();
			return true;
		}
		else {
			System.out.println("상품의 재고가 부족합니다.");
			return false;
		}
	}

	public void refund(int idx) {
		ProductVO product = list.get(idx);
		product.addRemain();
		money -= product.getPrice();
	}


	@Override
	public String toString() {
		String res = "편의점\n";
		for(ProductVO vo : list) {
			res +="물품명: " +vo.getName() + "\n가격: " + vo.getPrice() + "\n재고: " + vo.getRemain();
		}
		
		return res;
	}

}
