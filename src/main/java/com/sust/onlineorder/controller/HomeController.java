package com.sust.onlineorder.controller;

import com.sust.onlineorder.entity.TFood;
import com.sust.onlineorder.entity.TShop;
import com.sust.onlineorder.model.CartModel;
import com.sust.onlineorder.model.FoodGroup;
import com.sust.onlineorder.services.FoodService;
import com.sust.onlineorder.services.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.sust.onlineorder.constants.CartConts.CART;
import static com.sust.onlineorder.utils.SessionUtils.getAttr;
import static com.sust.onlineorder.utils.SessionUtils.setAttr;

@Controller
@Slf4j
public class HomeController {

	@Autowired
	private ShopService shopService;
	@Autowired
	private FoodService foodService;

	@RequestMapping(value = "/index")
	public String home(HttpServletRequest request) {
		//setUserSession(request);
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
	public List<FoodGroup> inShop(@RequestParam(value = "id") Integer id, HttpServletRequest request) {
		CartModel cart;
		if ((cart = getAttr(request, CART)) == null) {
			cart = CartModel.createCart();
			cart.setShopId(id);
			setAttr(request, CART, cart);
		} else {
			if (!id.equals(cart.getShopId())) {
				cart.setShopId(id);
				setAttr(request, CART, cart);
			}
		}
		log.info("shopId:{}", id);
		List<TFood> foodList = foodService.getFoodsWithShopId(id);
		List<FoodGroup> foodGroups = new ArrayList<>();
		foodList.stream().collect(Collectors.groupingBy(TFood::getCategory)).forEach((catagory, foods)->{
			foodGroups.add(new FoodGroup(catagory,foods));
		});
		return foodGroups;
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
