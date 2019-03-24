package com.sust.onlineorder.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wangzongyu
 * @Date: 2019/3/24 22:19
 */
public class CartModel implements Serializable {
	Map<String, SimpleItem> cartMap = new HashMap<>(5);

	public CartModel() {
	}

	public Map<String, SimpleItem> getCartMap() {
		return cartMap;
	}

	public void setCartMap(Map<String, SimpleItem> cartMap) {
		this.cartMap = cartMap;
	}

	public void putItem(String id, String price) {
		if (cartMap.containsKey(id)) {
			cartMap.put(id, new SimpleItem(price, cartMap.get(id).cnt + 1));
		} else {
			cartMap.put(id, new SimpleItem(price, 1));
		}
	}

	public void removeItem(String id) {
		if (cartMap.containsKey(id)) {
			cartMap.remove(id);
		}
	}

	public Integer getPayCount(String id){
		Integer res = 0;
		if (cartMap.containsKey(id)) {
			res = cartMap.get(id).cnt;
		}
		return res;
	}

	 public  static  class SimpleItem implements Serializable {
		//价格
		Float price;
		//数量
		Integer cnt;
		public SimpleItem(Float price, Integer cnt) {
			this.price = price;
			this.cnt = cnt;
		}

		public SimpleItem(String price, int cnt) {
			new SimpleItem(Float.valueOf(price), cnt);
		}
	}
}

