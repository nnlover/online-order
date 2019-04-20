package com.sust.onlineorder.services.impl;

import com.sust.onlineorder.dao.TUserMapper;
import com.sust.onlineorder.entity.TUser;
import com.sust.onlineorder.entity.TUserExample;
import com.sust.onlineorder.services.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private TUserMapper userMapper;

	@Override
	public int insert(TUser user) {
		int insert = userMapper.insert(user);

		return user.getId();
	}

	@Override
	public TUser selectByName(String name) {
		TUserExample example = new TUserExample();
		example.createCriteria().andUserNameEqualTo(name);
		return userMapper.selectByExample(example).get(0);
	}

	@Override
	public TUser selectByPhone(String phone, String pwd) {
		TUserExample example = new TUserExample();
		example.createCriteria().
				andPhoneEqualTo(phone).
				andPasswordEqualTo(pwd);
		List<TUser> userList = userMapper.selectByExample(example);
		return userList.size() > 0 ? userList.get(0) : new TUser();
	}
}
