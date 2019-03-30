package com.sust.onlineorder.controller;

import com.sust.onlineorder.entity.TFood;
import com.sust.onlineorder.model.CartModel;
import com.sust.onlineorder.model.OutputCartItem;
import com.sust.onlineorder.services.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: wangzongyu
 * @Date: 2019/3/24 21:52
 */
@Slf4j
@Controller
public class CartController {

	private static final String CART = "cart";

	@Autowired
	private FoodService foodService;

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
		return cartItem;
	}

	@RequestMapping("/add/to_cart")
	@ResponseBody
	public String toCart(String price, String id, HttpServletRequest request) {
		log.info("price:{}, id:{}", price, id);
		HttpSession session = request.getSession();
		CartModel cart = (CartModel) session.getAttribute(CART);
		if (cart == null) {
			cart = CartModel.createCart();
			cart.putItem(id, price);
		} else {
			cart.putItem(id, price);
		}
		session.setAttribute(CART, cart);
		return "ok";
	}

	@RequestMapping("/remove/clean_cart")
	@ResponseBody
	public String revomeFromCart(HttpServletRequest request) {

		HttpSession session = request.getSession();
		//CartModel cart = (CartModel) session.getAttribute(CART);
		session.setAttribute(CART, CartModel.createCart());
		return "ok";
	}

	@RequestMapping("/cart/cart-list.json")
	@ResponseBody
	public List<OutputCartItem> cartList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		CartModel cart = (CartModel) session.getAttribute(CART);
		List<OutputCartItem> res = new ArrayList<>();
		if (cart != null) {
			Map<String, CartModel.SimpleItem> cartMap = cart.getCartMap();
			List<Integer> ids = cartMap.keySet().stream().map(Integer::valueOf).collect(Collectors.toList());
			List<TFood> foods = foodService.getFoodsWithIds(ids);
			res = TransToCartItem(foods, cart);
		}
		return res;
	}

}
