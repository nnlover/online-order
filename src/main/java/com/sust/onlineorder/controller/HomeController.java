package com.sust.onlineorder.controller;

import com.sust.onlineorder.entity.TComment;
import com.sust.onlineorder.entity.TFood;
import com.sust.onlineorder.entity.TShop;
import com.sust.onlineorder.model.CartModel;
import com.sust.onlineorder.model.FoodGroup;
import com.sust.onlineorder.model.ShopModel;
import com.sust.onlineorder.services.CommentService;
import com.sust.onlineorder.services.FoodService;
import com.sust.onlineorder.services.ShopService;
import com.sust.onlineorder.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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
	@Resource
	private CommentService commentService;

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
	public Result shopList(@RequestParam(value = "keyword", required = false) String keyword) {
		log.info("keyword", keyword);
		List<TShop> shopListByPage;
		if (keyword != null && !"".equals(keyword)) {
			shopListByPage = shopService.getShopListBykeyword(keyword);
		} else {
			shopListByPage = shopService.getShopListByPage();
		}
		List<Integer> shopIds = shopListByPage.stream().map(shop -> shop.getId()).collect(Collectors.toList());
		List<TComment> comments = commentService.queryByShopIds(shopIds);
		List<ShopModel> shopModels = convert2ShopModelList(shopListByPage, comments);

		return Result.ok(shopModels);
	}

	private List<ShopModel> convert2ShopModelList(List<TShop> shopListByPage, List<TComment> comments) {
		ArrayList<ShopModel> shopModels = new ArrayList<>(shopListByPage.size());
		Map<Integer, TComment> commentMap = comments.stream().
				collect(Collectors.toMap(
						TComment::getShopId,
						e -> e,
						(v1, v2) -> {
							if (v1.getId() > v2.getId()) {
								return v1;
							}
							return v2;
						}));
		for (TShop shop : shopListByPage) {
			shopModels.add(convert2ShopModel(shop, commentMap.getOrDefault(shop.getId(), new TComment())));
		}
		return shopModels;
	}

	private ShopModel convert2ShopModel(TShop shop, TComment comment) {
		ShopModel shopModel = new ShopModel();
		BeanUtils.copyProperties(shop, shopModel);
		if (comment.getCommentMsg() == null || "".equals(comment.getCommentMsg())) {
			comment.setCommentMsg("暂时还没有评论，快去添加一个吧！");
		}
		shopModel.setLastComment(comment.getCommentMsg());
		return shopModel;
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
		foodList.stream().collect(Collectors.groupingBy(TFood::getCategory)).forEach((catagory, foods) -> {
			foodGroups.add(new FoodGroup(catagory, foods));
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
