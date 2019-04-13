package com.sust.onlineorder.utils;

import com.sust.onlineorder.model.CartModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: wangzongyu
 * @Date: 2019/3/30 16:19
 */
public class SessionUtils {

	public static <T> T getAttr(HttpServletRequest request, String name){
		HttpSession session = request.getSession();
		return   (T)session.getAttribute(name);
	}

	public static void setAttr(HttpServletRequest request, String name, Object val){
		HttpSession session = request.getSession();
		session.setAttribute(name, val);
	}
}
