package com.sust.onlineorder.services;

import com.sust.onlineorder.model.CartModel;
import com.sust.onlineorder.model.OutputOrder;
import com.sust.onlineorder.model.UserModel;

import java.util.List;


public interface OrderService {

	public int create(CartModel cartModel, UserModel userModel, String orderNo);

	List<OutputOrder> selectByUser(Integer userId);
}
