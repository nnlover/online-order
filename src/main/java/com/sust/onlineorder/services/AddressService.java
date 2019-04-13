package com.sust.onlineorder.services;

import com.sust.onlineorder.entity.TAddress;

import java.util.List;

/**
 * @Author: wangzongyu
 * @Date: 2019/4/13 14:53
 */
public interface AddressService {
	List<TAddress> getByUserId(Integer userId);
}
