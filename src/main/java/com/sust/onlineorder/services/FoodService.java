package com.sust.onlineorder.services;

import com.sust.onlineorder.entity.TFood;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @Author: wangzongyu
 * @Date: 2019/2/24 18:27
 */
public interface FoodService {

	List<TFood> getFoodsWithShopId(Integer id);

	List<TFood> getFoodsWithIds(List<Integer> ids);
}
