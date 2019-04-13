package com.sust.onlineorder.services.impl;

import com.sust.onlineorder.dao.TAddressMapper;
import com.sust.onlineorder.entity.TAddress;
import com.sust.onlineorder.entity.TAddressExample;
import com.sust.onlineorder.services.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangzongyu
 * @Date: 2019/4/13 14:55
 */
@Service
public class AddressServiceImpl implements AddressService {

	@Resource
	private TAddressMapper addressMapper;

	@Override
	public List<TAddress> getByUserId(Integer userId) {
		TAddressExample example = new TAddressExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return  addressMapper.selectByExample(example);
	}
}
