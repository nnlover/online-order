package com.sust.onlineorder.utils;

import com.sust.onlineorder.model.OrderItem;
import org.junit.Test;

import java.util.List;

/**
 * @Author: wangzongyu
 * @Date: 2019/4/21 16:48
 */
public class JsonUtilsTest {

	@Test
	public void jsonToList() {

		String items = "[{\"itemId\":\"12\",\"cnt\":4}]";
		List<OrderItem> orderItems = JsonUtils.jsonToList(items, OrderItem.class);
		System.out.println(orderItems.toString());
	}
}