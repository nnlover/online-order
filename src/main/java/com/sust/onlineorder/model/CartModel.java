package com.sust.onlineorder.model;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wangzongyu
 * @Date: 2019/3/24 22:19
 */
@Slf4j
public class CartModel implements Serializable {
	Integer shopId;
	Map<String, SimpleItem> cartMap;

	private CartModel() {
		cartMap = new HashMap<>(5);
	}

	public static CartModel createCart() {
		return new CartModel();
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Map<String, SimpleItem> getCartMap() {
		return cartMap;
	}

	public void setCartMap(Map<String, SimpleItem> cartMap) {
		this.cartMap = cartMap;
	}

	public void putItem(String id, String price) {
		if (cartMap.containsKey(id)) {
			SimpleItem item = cartMap.get(id);
			log.info("SimpleItem:{}", item.toString());
			cartMap.put(id, new SimpleItem(price, item.cnt + 1));
		} else {
			cartMap.put(id, new SimpleItem(price, 1));
		}
	}

	public void removeItem(String id) {
		if (cartMap.containsKey(id)) {
			cartMap.remove(id);
		}
	}

	public Integer getPayCount(String id) {
		Integer res = 0;
		if (cartMap.containsKey(id)) {
			res = cartMap.get(id).cnt;
		}
		return res;
	}

	public static class SimpleItem implements Serializable {
		/**
		 * 价格
		 */
		Float price;
		/**
		 * 数量
		 */
		Integer cnt;
		public SimpleItem(Float price, Integer cnt) {
			this.price = price;
			this.cnt = cnt;
		}

		SimpleItem(String price, int cnt) {
			this.price = Float.valueOf(price);
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "SimpleItem{" +
					"price=" + price +
					", cnt=" + cnt +
					'}';
		}

		public Float getPrice() {
			return price;
		}

		public void setPrice(Float price) {
			this.price = price;
		}

		public Integer getCnt() {
			return cnt;
		}

		public void setCnt(Integer cnt) {
			this.cnt = cnt;
		}
	}
}

