package com.sust.onlineorder.model;

import com.sust.onlineorder.entity.TShop;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: wangzongyu
 * @Date: 2019/3/30 14:30
 */
@Data
@Builder
public class CheckoutDetailDTO implements Serializable {

	List<OutputCartItem> items;
	TShop shop;
	UserAndAddrModel user;
}
