package com.sust.onlineorder.robot;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: wangzongyu
 * @Date: 2019/2/16 14:50
 */
public class ShopCollent {


	public static void main(String[] args) throws IOException {
		forShop();
	}

	public static void forShop() throws IOException {
		JSONObject jsonObject = new JSONObject(new JSONTokener(new FileReader(new File("/Users/wzy/personal/love/shop2.txt"))));
		//System.out.println(jsonObject.toString());
		JSONObject data = jsonObject.getJSONObject("data");
		//System.out.println(data.toString());
		JSONArray shopList = data.getJSONArray("shopList");
		//System.out.println(shopList.toString());
		int length = shopList.length();
		System.out.println(length);
		StringBuilder values = new StringBuilder();
		String baseSQL = "INSERT INTO `marketing`.`t_shop`(`shop_name`, `title`, `dispatch_pay`, `dispatch_time`, `assess_rate`, `address`, `dispatch_price`, `salesroom_price`, `business_time`, `main_picture`, `average`, `month_pay`) ";
		for (int i = 0; i < shopList.length(); i++) {
			values.append(baseSQL);
			values.append("VALUES (");

			JSONObject shop = shopList.getJSONObject(i);
			//System.out.println(shop);
			//商家名字
			String shopName = shop.getString("shopName");
			appendVal(values, shopName);
			System.out.println(shopName);
			//商家简介
			appendVal(values, shopName);
			//配送费用
			String shippingFeeTip = shop.getString("shippingFeeTip");
			appendVal(values, stringMatch(shippingFeeTip, "[\\D]+"));
			System.out.println(shippingFeeTip);
			//配送时间
			String deliveryTimeTip = shop.getString("deliveryTimeTip");
			appendVal(values, stringMatch(deliveryTimeTip, "[\\D]+"));
			System.out.println(deliveryTimeTip);
			//评价星级1-5
			int wmPoiScore = shop.getInt("wmPoiScore");
			appendVal(values, wmPoiScore / 10.0);
			System.out.println(wmPoiScore);
			//商家地址
			String address = shop.getString("address");
			appendVal(values, address);
			System.out.println(address);
			//最低价
			String minPriceTip = shop.getString("minPriceTip");
			appendVal(values, stringMatch(minPriceTip, "[\\D]+"));
			System.out.println(minPriceTip);
			//门市价
			appendVal(values, Integer.valueOf(String.valueOf(stringMatch(minPriceTip, "[\\D]+"))) + (int) (Math.random() * 1000 % 20));
			//商家电话

			//营业时间
			String shipping_time = shop.getString("shipping_time");
			appendVal(values, shipping_time);
			System.out.println(shipping_time);

			//商家图片
			String picUrl = shop.getString("picUrl");
			appendVal(values, picUrl);
			System.out.println(picUrl);
			//人均价格
			String averagePriceTip = shop.getString("averagePriceTip");
			appendVal(values, stringMatch(averagePriceTip, "[\\D]+"));
			System.out.println(averagePriceTip);
			//月售
			Lastappend(values, (int) (Math.random() * 1000000 % 3000));
			//店铺类型
		}
		File file = new File("sql/shop_data1.sql");
		FileUtils.write(file, values.toString(), "utf8", true);
	}


	public static void appendVal(StringBuilder builder, Object o) {
		builder.append("'" + o + "'" + ",");
	}

	public static void Lastappend(StringBuilder builder, Object o) {
		builder.append("'" + o + "'" + ")");
		builder.append("; \n");
	}

	public static Object stringMatch(String in, String rex) {
		String[] matchs = in.split(rex);
		for (int i = 0; i < matchs.length; i++) {
			if (!matchs[i].equals("")) {
				return matchs[i];
			}
		}
		return "";
	}

}
