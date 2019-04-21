package com.sust.onlineorder.model;

import com.sust.onlineorder.entity.TFood;
import com.sust.onlineorder.entity.TOrder;
import com.sust.onlineorder.entity.TShop;
import com.sust.onlineorder.utils.JsonUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Slf4j
public class OutputOrder {
	String orderNo;
	String createTime;


	BigDecimal orderPrcie;

	List<Item> items;

	String payType;

	String shopName;
	String shopPhone;

	String totalPrice;


	public static OutputOrder convertFrom(TOrder order, TShop shop, List<TFood> foodList) {
		OutputOrder outputOrder = new OutputOrder();
		outputOrder.setOrderNo(order.getOrderNo());
		outputOrder.setPayType(order.getPayType());
		outputOrder.setCreateTime(order.getCreateTime().toString());

		outputOrder.setShopName(shop.getShopName());
		outputOrder.setShopPhone(shop.getPhone());

		outputOrder.setItems(convertItemFrom(order, foodList));
		outputOrder.setTotalPrice(order.getTotalPrice().toString());
		return outputOrder;
	}

	public static List<Item> convertItemFrom(TOrder order, List<TFood> foodList) {
		Map<Integer, TFood> foodMap = foodList.stream().collect(Collectors.toMap(TFood::getId,
				e -> e,
				(v1, v2) -> v1));
		List<OrderItem> orderItems = JsonUtils.jsonToList(order.getItemIds(), OrderItem.class);
		List<Item> resList = new ArrayList<>();
		orderItems.forEach(orderItem -> {
			TFood food = foodMap.get(Integer.valueOf(orderItem.getItemId()));
			log.info("food:{}", food);
			Item item = new Item();
			item.setItemName(food.getItemName());
			item.setPrice(food.getPrice());
			item.setCnt(orderItem.getCnt());
			resList.add(item);
		});
		return resList;
	}

	@Data
	public static class Item {
		String itemName;
		BigDecimal price;
		Integer cnt;
	}
}
