package com.sust.onlineorder.services.impl;

import com.sust.onlineorder.dao.TUserMapper;
import com.sust.onlineorder.entity.TUser;
import com.sust.onlineorder.entity.TUserExample;
import com.sust.onlineorder.services.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangzongyu
 * @Date: 2019/4/14 18:39
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private TUserMapper userMapper;

	@Override
	public boolean insert(TUser user) {
		int insert = userMapper.insert(user);
		return insert > 0 ? true : false;
	}

	@Override
	public TUser selectByName(String name) {
		TUserExample example = new TUserExample();
		example.createCriteria().andUserNameEqualTo(name);
		return userMapper.selectByExample(example).get(0);
	}
}
