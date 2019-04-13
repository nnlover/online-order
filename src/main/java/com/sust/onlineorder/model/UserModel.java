package com.sust.onlineorder.model;

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
		UserModel user = getAttr(request, USER);
		if(user == null){
			user = new UserModel();
			user.setId(1);
			user.setUserName("张三");
			user.setPhone("18611921410");
			user.setRank(1);
			setAttr(request,USER, user);
		}
	}

}
