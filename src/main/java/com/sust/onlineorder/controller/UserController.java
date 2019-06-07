package com.sust.onlineorder.controller;

import com.sust.onlineorder.entity.TAddress;
import com.sust.onlineorder.entity.TComment;
import com.sust.onlineorder.entity.TUser;
import com.sust.onlineorder.model.OutputOrder;
import com.sust.onlineorder.model.UserModel;
import com.sust.onlineorder.services.AddressService;
import com.sust.onlineorder.services.CommentService;
import com.sust.onlineorder.services.OrderService;
import com.sust.onlineorder.services.UserService;
import com.sust.onlineorder.utils.Result;
import com.sust.onlineorder.utils.SessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.sust.onlineorder.constants.UserConts.USER;
import static com.sust.onlineorder.model.UserModel.convertFrom;
import static com.sust.onlineorder.model.UserModel.setUserSession;
import static com.sust.onlineorder.utils.SessionUtils.getAttr;


@Slf4j
@Controller
public class UserController {
	private static final String DEFAULT_ICON = "/image/maomi.jpg";
	@Resource
	private UserService userService;
	@Resource
	private AddressService addressService;
	@Resource
	private OrderService orderService;

	@Resource
	private CommentService commentService;

	@RequestMapping("/register/user")
	@ResponseBody
	public Result register(@RequestParam("name") String name,
	                       @RequestParam("phone") String phone,
	                       @RequestParam("address") String address,
	                       @RequestParam("pwd") String pwd) {
		if (checkParam(name, phone, address, pwd)) {
			return Result.failed("参数错误");
		}
		TUser user = new TUser();
		user.setUserName(name);
		user.setPassword(pwd);
		user.setPhone(phone);
		user.setRank(1);
		user.setUserIcon(DEFAULT_ICON);

		int id = userService.insert(user);
		/*TUser tUser = userService.selectByName(name);*/
		TAddress tAddress = new TAddress();
		tAddress.setAddress(address);
		tAddress.setUserId(id);
		addressService.insert(tAddress);
		return Result.ok();
	}

	@RequestMapping("/login/user")
	@ResponseBody
	public Result login(@RequestParam("phone") String phone,
	                    @RequestParam("pwd") String pwd,
	                    HttpServletRequest request
	) {
		if (phone == null || "".equals(phone)) {
			return Result.failed("电话号码为空");
		}
		if (pwd == null || "".equals(pwd)) {
			return Result.failed("密码为空");
		}

		TUser user = userService.selectByPhone(phone, pwd);
		if (phone.equals(user.getPhone()) && pwd.equals(user.getPassword())) {
			List<TAddress> addrList = addressService.getByUserId(user.getId());
			//TODO::只能在登录的地方设置 userSession
			setUserSession(request, convertFrom(user, addrList.get(0)));
			return Result.ok();
		}
		return Result.failed("电话或者密码错误");
	}

	@RequestMapping("/order/user-order-list.json")
	@ResponseBody
	public Result userOrderList(
			HttpServletRequest request
	) {

		UserModel user = getAttr(request, USER);
		if (user == null || user.getId() == null || user.getId() == 0) {
			Result.failed("未登录");
		}
		List<OutputOrder> orderList = orderService.selectByUser(user.getId());

		return Result.ok(orderList);
	}

	@RequestMapping("/user/query-user.json")
	@ResponseBody
	public Result queryUser(HttpServletRequest request) {

		UserModel user = getAttr(request, USER);
		if (user == null || user.getId() == null || user.getId() == 0) {
			Result.failed("未登录");
		}

		return Result.ok(user);
	}


	@RequestMapping("/user/login-out")
	@ResponseBody
	public Result loginOut(HttpServletRequest request) {
		//将session 去掉就算是登出了
		SessionUtils.removeAttr(request, USER);
		return Result.ok();
	}

	@RequestMapping("/comments/add")
	@ResponseBody
	public Result comentAdd(@RequestParam("shopId")String shopId,
	                        @RequestParam("userId")String userId,
	                        @RequestParam("orderId")String orderId,
	                        @RequestParam("msg")String msg,
	                        HttpServletRequest request) {
		if("".equals(shopId) || "".equals(userId) || "".equals(orderId) || "".equals(msg)){
			return Result.failed("提交内容不正确");
		}
		TComment comment = new TComment();
		comment.setCommentMsg(msg);
		comment.setOrderId(Integer.valueOf(orderId));
		comment.setShopId(Integer.valueOf(shopId));
		comment.setUserId(Integer.valueOf(userId));
		Integer integer = commentService.insertComment(comment);
		return Result.ok(comment.getId());
	}





	private boolean checkParam(String name, String phone, String address, String pwd) {
		if (name == null || "".equals(name)) {
			return true;
		}
		if (phone == null || "".equals(phone)) {
			return true;
		}
		if (address == null || "".equals(address)) {
			return true;
		}
		if (pwd == null || "".equals(pwd)) {
			return true;
		}
		return false;
	}

}
