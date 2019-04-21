package com.sust.onlineorder.controller;

import com.sust.onlineorder.entity.TFood;
import com.sust.onlineorder.entity.TShop;
import com.sust.onlineorder.model.CartModel;
import com.sust.onlineorder.model.CheckoutDetailDTO;
import com.sust.onlineorder.model.OutputCartItem;
import com.sust.onlineorder.model.UserModel;
import com.sust.onlineorder.services.FoodService;
import com.sust.onlineorder.services.OrderService;
import com.sust.onlineorder.services.ShopService;
import com.sust.onlineorder.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.sust.onlineorder.constants.CartConts.CART;
import static com.sust.onlineorder.constants.UserConts.USER;
import static com.sust.onlineorder.utils.IdUtils.buildAOrderNo;
import static com.sust.onlineorder.utils.SessionUtils.*;


@Slf4j
@Controller
public class CartController {

	@Resource
	private FoodService foodService;
	@Resource
	private ShopService shopService;
	@Resource
	private OrderService orderService;

	public static List<OutputCartItem> TransToCartItem(List<TFood> foods, CartModel cart) {
		return foods.stream().map(food -> convert(food, cart)).collect(Collectors.toList());
	}

	private static OutputCartItem convert(TFood food, CartModel cart) {
		OutputCartItem cartItem = new OutputCartItem();
		cartItem.setId(food.getId());
		cartItem.setCategory(food.getCategory());
		cartItem.setItemName(food.getItemName());
		cartItem.setItemTitle(food.getItemTitle());
		cartItem.setPrice(food.getPrice());
		cartItem.setShopId(food.getShopId());
		cartItem.setPicture(food.getPicture());
		cartItem.setPayCount(cart.getPayCount(String.valueOf(food.getId())));
		cartItem.setOrginPrice(food.getOrginPrice());
		cartItem.setMonthSale(food.getMonthSale());
		return cartItem;
	}

	@RequestMapping("/add/to_cart")
	@ResponseBody
	public String toCart(String price, String id, HttpServletRequest request) {
		log.info("price:{}, id:{}", price, id);
		CartModel cart = getAttr(request, CART);
		if (cart == null) {
			cart = CartModel.createCart();
			cart.putItem(id, price);
		} else {
			cart.putItem(id, price);
		}
		setAttr(request, CART, cart);
		return "ok";
	}

	@RequestMapping("/remove/clean_cart")
	@ResponseBody
	public String revomeFromCart(HttpServletRequest request) {
		setAttr(request, CART, CartModel.createCart());
		return "ok";
	}

	@RequestMapping("/cart/cart-list.json")
	@ResponseBody
	public CheckoutDetailDTO cartList(String shopId, HttpServletRequest request) {
		CartModel cart = getAttr(request, CART);
		List<OutputCartItem> items = new ArrayList<>();
		if (cart != null) {
			Map<String, CartModel.SimpleItem> cartMap = cart.getCartMap();
			List<Integer> ids = cartMap.keySet().stream().map(Integer::valueOf).collect(Collectors.toList());
			List<TFood> foods = foodService.getFoodsWithIds(ids);
			items = TransToCartItem(foods, cart);
		}

		TShop shop = shopService.getShopById(items.get(0).getShopId());

		return CheckoutDetailDTO.builder().items(items).shop(shop).build();
	}


	@RequestMapping("/submit/cart")
	@ResponseBody
	public Result submitCart(HttpServletRequest request) {
		CartModel cart = getAttr(request, CART);
		if (cart == null || CollectionUtils.isEmpty(cart.getCartMap())) {
			return Result.build(400, "订单出现异常");
		}
		UserModel user = getAttr(request, USER);
		if (user == null || user.getId() == null || user.getId() == 0) {
			return Result.build(400, "请先登录");
		}
		String orderNo = "D-" + buildAOrderNo().substring(0, 8);
		int i = orderService.create(cart, user, orderNo);
		if (i > 0) {
			removeAttr(request, CART);
			return Result.ok(orderNo);
		}
		return Result.build(400, "订单出现异常");
	}

	@RequestMapping("/select/addr")
	@ResponseBody
	public String selectAddr(Integer addrId, HttpServletRequest request) {
		UserModel user = getAttr(request, USER);
		user.setSelectAddrId(addrId);
		setAttr(request, USER, user);
		return "ok";
	}
}
