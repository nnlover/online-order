package com.sust.onlineorder.services.impl;

import com.sust.onlineorder.dao.TFoodMapper;
import com.sust.onlineorder.entity.TFood;
import com.sust.onlineorder.entity.TFoodExample;
import com.sust.onlineorder.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @Author: wangzongyu
 * @Date: 2019/2/24 18:28
 */
@Service
public class FoodServiceImpl implements FoodService {

	@Resource
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
		return foodMapper.selectByExample(example);
	}

	/**
	 * 根据idList 查询商品
	 * @param ids
	 * @return
	 */
	@Override
	public List<TFood> getFoodsWithIds(List<Integer> ids) {
		TFoodExample example = new TFoodExample();
		example.createCriteria().andIdIn(ids);
		return foodMapper.selectByExample(example);
	}
}
