package com.sust.onlineorder.controller;

import com.sust.onlineorder.constants.CartConts;
import com.sust.onlineorder.constants.UserConts;
import com.sust.onlineorder.entity.TFood;
import com.sust.onlineorder.entity.TShop;
import com.sust.onlineorder.model.CartModel;
import com.sust.onlineorder.model.UserModel;
import com.sust.onlineorder.services.FoodService;
import com.sust.onlineorder.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.sust.onlineorder.constants.CartConts.CART;
import static com.sust.onlineorder.constants.UserConts.USER;
import static com.sust.onlineorder.model.UserModel.setUserSession;
import static com.sust.onlineorder.utils.SessionUtils.getAttr;
import static com.sust.onlineorder.utils.SessionUtils.setAttr;

/**
 * @Author: wangzongyu
 * @Date: 2019/2/13 21:32
 */
@Controller
public class HomeController {

	@Autowired
	private ShopService shopService;
	@Autowired
	private FoodService foodService;

	@RequestMapping(value = "/index")
	public String home(HttpServletRequest request) {
		setUserSession(request);
		return "index";
	}


	@RequestMapping(value = "/test")
	public String test() {
		return "test";
	}

	/**
	 * 商家列表页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/shop/shop-list.json")
	@ResponseBody
	public List<TShop> shopList() {
		List<TShop> shopListByPage = shopService.getShopListByPage();
		//model.addAttribute("shopList", shopListByPage);
		return shopListByPage;
	}

	/**
	 * 进店 商品页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/shop/food-list.json")
	@ResponseBody
	public List<TFood> inShop(@RequestParam(value = "id") Integer id, HttpServletRequest request) {
		CartModel cart;
		if((cart = getAttr(request,CART)) == null) {
			cart = CartModel.createCart();
			cart.setShopId(id);
			setAttr(request, CART, cart);
		}else {
			if(!id.equals(cart.getShopId())){
				cart.setShopId(id);
				setAttr(request, CART, cart);
			}
		}
		setUserSession(request);
		List<TFood> foodList = foodService.getFoodsWithShopId(id);

		return foodList;
	}

	@RequestMapping(value = "/shop_detail")
	public String shopDetail(@RequestParam(value = "id") Integer id, Model model) {
		List<TFood> foodList = foodService.getFoodsWithShopId(id);
		Map<String, List<TFood>> foodsGroup = foodList.stream().collect(Collectors.groupingBy(TFood::getCategory));

		model.addAttribute("foodsGroup", foodsGroup);
		return "shop_detail";
	}


	@RequestMapping(value = "/home/page")
	@ResponseBody
	public ModelAndView goHome() {
		System.out.println("go to the home page!");
		ModelAndView mode = new ModelAndView();
		mode.addObject("name", "zhangsan");
		mode.setViewName("index");
		return mode;
	}

}
