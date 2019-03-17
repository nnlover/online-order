package com.sust.onlineorder.services.impl;

import com.sust.onlineorder.dao.TFoodMapper;
import com.sust.onlineorder.entity.TFood;
import com.sust.onlineorder.entity.TFoodExample;
import com.sust.onlineorder.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangzongyu
 * @Date: 2019/2/24 18:28
 */
@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private TFoodMapper foodMapper;

	/**
	 * 根据店铺Id 查询商品
	 * @param id
	 * @return
	 */
	@Override
	public List<TFood> getFoodsWithShopId(Integer id) {
		TFoodExample example = new TFoodExample();
		example.createCriteria().andShopIdEqualTo(id);
		List<TFood> foodList = foodMapper.selectByExample(example);
		return foodList;
	}
}
