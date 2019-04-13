package com.sust.onlineorder.services.impl;

import com.sust.onlineorder.dao.TShopMapper;
import com.sust.onlineorder.entity.TShop;
import com.sust.onlineorder.entity.TShopExample;
import com.sust.onlineorder.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

	@Resource
	private TShopMapper shopMapper;

	@Override
	public List<TShop> getShopListByPage() {
		TShopExample example = new TShopExample();
		example.createCriteria().andIdGreaterThan(10);
		return shopMapper.selectByExample(example);
	}

	@Override
	public TShop getShopById(Integer shopId) {
		TShopExample example = new TShopExample();
		example.createCriteria().andIdEqualTo(shopId);
		List<TShop> tShops = shopMapper.selectByExample(example);
		return tShops.get(0);

	}
}
