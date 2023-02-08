package com.ktdsuniversity.edu.class_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
	private Map<ProductType, List<ProductVO>> dataSources;

	public VendingMachine() {
		dataSources = new HashMap<>();
		dataSources.put(ProductType.coffee, new ArrayList<>());
		dataSources.put(ProductType.drink, new ArrayList<>());
		dataSources.put(ProductType.etc, new ArrayList<>());
	}

	public int add(ProductType type, ProductVO vo) {
		List<ProductVO> list = dataSources.get(type);
		if(list!= null) {
			list.add(vo);
			return 1;
		}
		return 0;
	}

	public ProductVO pull(ProductType type, int idx) {
		ProductVO vo = dataSources.get(type).get(idx);
		if (vo != null) {
			dataSources.get(type).remove(idx);
		}
		return vo;
	}

}
