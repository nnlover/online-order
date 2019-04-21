package com.sust.onlineorder.model;

import lombok.Data;

/**
 * @Author: wangzongyu
 * @Date: 2019/4/21 16:50
 */
@Data
public class OrderItem {
	String itemId;
	Integer cnt;

	public OrderItem() { }


	public OrderItem(String itemId, Integer cnt) {
		this.itemId = itemId;
		this.cnt = cnt;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
}
