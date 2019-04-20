package com.sust.onlineorder.controller;

import com.sust.onlineorder.entity.TAddress;
import com.sust.onlineorder.entity.TUser;
import com.sust.onlineorder.services.AddressService;
import com.sust.onlineorder.services.UserService;
import com.sust.onlineorder.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.sust.onlineorder.model.UserModel.convertFrom;
import static com.sust.onlineorder.model.UserModel.setUserSession;


@Slf4j
@Controller
public class UserController {
	private static final String DEFAULT_ICON = "/image/maomi.jpg";
	@Resource
	private UserService userService;
	@Resource
	private AddressService addressService;

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

		TUser user = userService.selectByPhone(phone,pwd);
		if (phone.equals(user.getPhone()) && pwd.equals(user.getPassword())) {
			setUserSession(request,convertFrom(user));
			return Result.ok();
		}
		return Result.failed("电话或者密码错误");
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
