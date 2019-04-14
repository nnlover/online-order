package com.sust.onlineorder.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

	public static <T> T getAttr(HttpServletRequest request, String name) {
		HttpSession session = request.getSession();
		return (T) session.getAttribute(name);
	}

	public static void setAttr(HttpServletRequest request, String name, Object val) {
		HttpSession session = request.getSession();
		session.setAttribute(name, val);
	}
}
