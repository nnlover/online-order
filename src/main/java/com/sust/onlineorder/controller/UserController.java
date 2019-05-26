package com.sust.onlineorder.controller;

import com.sust.onlineorder.entity.TAddress;
import com.sust.onlineorder.entity.TUser;
import com.sust.onlineorder.model.OutputOrder;
import com.sust.onlineorder.model.UserModel;
import com.sust.onlineorder.services.AddressService;
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

	/**
	 * 和 $.post("/login/user"） 是一一对应的
	 *
	 * @param phone
	 * @param pwd
	 * @param request
	 * @return
	 */
	@RequestMapping("/login/user")
	@ResponseBody /*返回一个字符串*/
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
		/*查询数据库*/
		TUser user = userService.selectByPhone(phone, pwd);
		/*做返回值的校验*/
		if (phone.equals(user.getPhone()) && pwd.equals(user.getPassword())) {
			List<TAddress> addrList = addressService.getByUserId(user.getId());
			//TODO::只能在登录的地方设置 userSession
			setUserSession(request, convertFrom(user, addrList.get(0)));
			return Result.ok();
		}
		/*如果异常了就返回异常信息*/
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
