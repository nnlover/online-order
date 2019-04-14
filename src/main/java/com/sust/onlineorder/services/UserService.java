package com.sust.onlineorder.services;

import com.sust.onlineorder.entity.TUser;


public interface UserService {

	int insert(TUser user);

	TUser selectByName(String name);
}
