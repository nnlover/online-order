package com.sust.onlineorder.model;

import com.sust.onlineorder.entity.TFood;
import lombok.Data;

import java.util.List;

/**
 * @Author: wangzongyu
 * @Date: 2019/5/18 15:12
 */
@Data
public class FoodGroup {
	String category;
	List<TFood> foodList;

	public FoodGroup(String category, List<TFood> foodList) {
		this.category = category;
		this.foodList = foodList;
	}
}
