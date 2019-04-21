package com.sust.onlineorder.services;

import com.sust.onlineorder.entity.TShop;

import java.util.List;

public interface ShopService {
	/**
	 * 分页查询商家列表页面
	 *
	 * @return
	 */
	List<TShop> getShopListByPage();

	TShop getShopById(Integer shopId);

	List<TShop> getShopByIds(List<Integer> shopIds);
}
