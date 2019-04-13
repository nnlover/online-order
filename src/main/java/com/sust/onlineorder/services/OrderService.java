package com.sust.onlineorder.services;

import com.sust.onlineorder.model.CartModel;
import com.sust.onlineorder.model.UserModel;

/**
 * @Author: wangzongyu
 * @Date: 2019/3/30 16:35
 */
public interface OrderService {

	public int create(CartModel cartModel, UserModel userModel, String orderNo);
}
