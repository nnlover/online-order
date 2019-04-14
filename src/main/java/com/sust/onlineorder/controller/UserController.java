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


@Slf4j
@Controller
public class UserController {

	@Resource
	private UserService userService;
	@Resource
	private AddressService addressService;

	@RequestMapping("/register/user")
	@ResponseBody
	public Result register(@RequestParam("name")String name,
	                       @RequestParam("phone")String phone,
	                       @RequestParam("address")String address,
	                       @RequestParam("pwd")String pwd){
		TUser user = TUser.builder().
				userName(name).
				phone(phone).
				password(pwd).
				build();
		userService.insert(user);
		TUser tUser = userService.selectByName(name);
		TAddress tAddress = new TAddress();
		tAddress.setAddress(address);
		tAddress.setUserId(tUser.getId());
		addressService.insert(tAddress);
		return Result.ok();
	}
}
