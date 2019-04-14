package com.sust.onlineorder.services;

import com.sust.onlineorder.model.CartModel;
import com.sust.onlineorder.model.UserModel;


public interface OrderService {

	public int create(CartModel cartModel, UserModel userModel, String orderNo);
}
