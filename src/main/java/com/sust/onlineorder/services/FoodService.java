package com.sust.onlineorder.services;

import com.sust.onlineorder.entity.TFood;

import java.util.List;

/**
 * @Author: wangzongyu
 * @Date: 2019/2/24 18:27
 */
public interface FoodService {

	List<TFood> getFoodsWithShopId(Integer id);
}
