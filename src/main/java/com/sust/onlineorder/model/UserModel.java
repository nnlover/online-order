package com.sust.onlineorder.model;

import com.sust.onlineorder.entity.TUser;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

import static com.sust.onlineorder.constants.UserConts.USER;
import static com.sust.onlineorder.utils.SessionUtils.getAttr;
import static com.sust.onlineorder.utils.SessionUtils.setAttr;

/**
 * @Author: wangzongyu
 * @Date: 2019/3/30 16:29
 */
@Data
public class UserModel implements Serializable {

	private Integer id;
	private String userName;
	private String phone;
	private int rank;
	private Integer selectAddrId;


	public static void setUserSession(HttpServletRequest request) {
		UserModel user;// = getAttr(request, USER);
		user = new UserModel();
		user.setId(1);
		user.setUserName("张三");
		user.setPhone("18611921410");
		user.setRank(1);
		user.setSelectAddrId(1);
		setAttr(request, USER, user);

	}

	public static void setUserSession(HttpServletRequest request, UserModel userModel) {
		setAttr(request, USER, userModel);
	}

	public static UserModel convertFrom(TUser user){
		UserModel userModel = new UserModel();
		userModel.setUserName(user.getUserName());
		userModel.setPhone(user.getPhone());
		userModel.setRank(user.getRank());
		userModel.setId(user.getId());
		return userModel;
	}

	public static void setUserSession(HttpServletRequest request,  Integer addrId) {
		UserModel userModel = getAttr(request, USER);
		userModel.setSelectAddrId(addrId);
		setAttr(request, USER, userModel);
	}

}
