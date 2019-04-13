package com.sust.onlineorder.services.impl;

import com.sust.onlineorder.dao.TOrderMapper;
import com.sust.onlineorder.entity.TOrder;
import com.sust.onlineorder.entity.TShop;
import com.sust.onlineorder.model.CartModel;
import com.sust.onlineorder.model.UserModel;
import com.sust.onlineorder.services.AddressService;
import com.sust.onlineorder.services.OrderService;
import com.sust.onlineorder.services.ShopService;
import com.sust.onlineorder.utils.IdUtils;
import com.sust.onlineorder.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigDecimal;
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
	public int create(CartModel cartModel, UserModel userModel, String orderNo) {

		Map<String, CartModel.SimpleItem> cartMap = cartModel.getCartMap();
		TShop shop = shopService.getShopById(cartModel.getShopId());

		return orderMapper.insert(buildOrder(userModel, cartMap, shop, orderNo));
	}

	private TOrder buildOrder(UserModel userModel, Map<String, CartModel.SimpleItem> cartMap, TShop shop, String orderNo) {
		TOrder order = new TOrder();
		order.setOrderNo(orderNo);
		order.setUserId(userModel.getId());
		order.setItemIds(buildItemsString(cartMap));
		order.setAddrId(userModel.getSelectAddrId());
		order.setPayTime(new Date());
		order.setCreateTime(new Date());
		order.setPayType("支付宝");
		//设置店铺信息
		order.setTotalPrice(calTotalPrice(cartMap, shop.getDispatchPrice()));
		Date date = new Date();
		order.setDeliveryTime(new Date(date.toInstant().plusSeconds(shop.getDispatchTime() * 60).toEpochMilli()));
		order.setComments("");
		order.setShopName(shop.getShopName());
		log.info("[order]-->{}", order.toString());
		log.info("[user]-->{}", userModel.toString());
		return order;
	}

	//计算总价  订单价格+ 快递费
	private BigDecimal calTotalPrice(Map<String, CartModel.SimpleItem> cartMap, BigDecimal dispatchPrice) {
		return BigDecimal.valueOf(cartMap.values().stream().mapToDouble(item -> item.getPrice() * item.getCnt()).sum() + dispatchPrice.doubleValue());
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
