package com.sust.onlineorder.services;

import com.sust.onlineorder.model.CartModel;
import com.sust.onlineorder.model.CartTotal;
import com.sust.onlineorder.model.OutputOrder;
import com.sust.onlineorder.model.UserModel;

import java.util.List;
import java.util.Map;


public interface OrderService {

	int create(CartModel cartModel, UserModel userModel, String orderNo);

	List<OutputOrder> selectByUser(Integer userId);

	CartTotal calCartTotal(Map<String, CartModel.SimpleItem> cartMap);
}
