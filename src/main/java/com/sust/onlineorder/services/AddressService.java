package com.sust.onlineorder.services;

import com.sust.onlineorder.entity.TAddress;

import java.util.List;


public interface AddressService {
	List<TAddress> getByUserId(Integer userId);

	int insert(TAddress tAddress);
}
