package com.sust.onlineorder.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: wangzongyu
 * @Date: 2019/6/7 18:47
 */
@Data
public class ShopModel {

	private Integer id;

	private String shopName;

	private String title;

	private Integer dispatchPay;

	private Integer dispatchTime;

	private BigDecimal assessRate;

	private String address;

	private BigDecimal dispatchPrice;

	private BigDecimal salesroomPrice;

	private String phone;

	private String businessTime;

	private String mainPicture;

	private Integer average;

	private Integer monthPay;

	private Integer shopType;

	//最新的评论
	private String lastComment;
}
