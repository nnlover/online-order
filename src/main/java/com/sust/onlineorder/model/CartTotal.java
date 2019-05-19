package com.sust.onlineorder.model;

import lombok.Data;

@Data
public class CartTotal {
	double totalPrice;
	Integer itemCount;

	public CartTotal(double v, int i) {
		totalPrice = v;
		itemCount = i;
	}
}
