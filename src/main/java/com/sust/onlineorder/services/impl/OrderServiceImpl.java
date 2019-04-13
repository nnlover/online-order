package com.sust.onlineorder.services.impl;

import com.sust.onlineorder.dao.TOrderMapper;
import com.sust.onlineorder.dao.TShopMapper;
import com.sust.onlineorder.entity.TOrder;
import com.sust.onlineorder.entity.TShop;
import com.sust.onlineorder.model.CartModel;
import com.sust.onlineorder.model.UserModel;
import com.sust.onlineorder.services.AddressService;
import com.sust.onlineorder.services.OrderService;
import com.sust.onlineorder.services.ShopService;
import com.sust.onlineorder.utils.IdUtils;
import com.sust.onlineorder.utils.JsonUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Time;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: wangzongyu
 * @Date: 2019/3/30 16:36
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

	@Resource
	private TOrderMapper orderMapper;
	@Resource
	private ShopService shopService;
	@Resource
	private AddressService addressService;

	@Override
	public int create(CartModel cartModel, UserModel userModel) {
		Map<String, CartModel.SimpleItem> cartMap = cartModel.getCartMap();
		addressService.getByUserId(userModel.getId());
		TOrder order = new TOrder();
		order.setOrderNo(IdUtils.getNextId());
		order.setUserId(userModel.getId());
		order.setItemIds(buildItemsString(cartMap));
		order.setAddrId(userModel.getSelectAddrId());

		//设置店铺信息
		TShop shop = shopService.getShopById(cartModel.getShopId());
		Date date = new Date();
		order.setDeliveryTime(new Date(date.toInstant().plusSeconds(shop.getDispatchTime() * 60).toEpochMilli()));
		//order.setComments();
		order.setShopName(shop.getShopName());

		int insert = orderMapper.insert(order);
		return insert;
	}


	private String buildItemsString(Map<String, CartModel.SimpleItem> cartMap) {
		List<OrderItem> itemsString = new ArrayList<>();

		cartMap.forEach((id, val) -> itemsString.add(new OrderItem(id, val.getCnt())));
		return JsonUtils.objectToJson(itemsString);
	}

	public static class OrderItem implements Serializable {
		String itemId;
		Integer cnt;

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
}
