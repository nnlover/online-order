package com.sust.onlineorder.services;

import com.sust.onlineorder.entity.TFood;

import java.util.Collection;
import java.util.List;
import java.util.Set;


public interface FoodService {

	List<TFood> getFoodsWithShopId(Integer id);

	List<TFood> getFoodsWithIds(List<Integer> ids);
}
