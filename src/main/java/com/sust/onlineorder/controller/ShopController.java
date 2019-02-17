package com.sust.onlineorder.controller;

import com.sust.onlineorder.entity.TShop;
import com.sust.onlineorder.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ShopController {

	@Autowired
	private ShopService shopService;

	@RequestMapping("/shop_list")
	public List<TShop> shopList() {

		return shopService.getShopListByPage();
	}

}
