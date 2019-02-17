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
public class FoodCollent {


	public static void main(String[] args) throws IOException {
		String[] foodInfos = {
				"/Users/wzy/personal/love/food_1.txt",
				"/Users/wzy/personal/love/food_2.txt",
				"/Users/wzy/personal/love/food_3.txt",
				"/Users/wzy/personal/love/food_4.txt",
				"/Users/wzy/personal/love/food_5.txt",
				"/Users/wzy/personal/love/food_6.txt",
				"/Users/wzy/personal/love/food_7.txt",
				"/Users/wzy/personal/love/food_8.txt",
				"/Users/wzy/personal/love/food_9.txt",
				"/Users/wzy/personal/love/food_10.txt",
				"/Users/wzy/personal/love/food_11.txt",
				"/Users/wzy/personal/love/food_12.txt",
				"/Users/wzy/personal/love/food_13.txt",
				"/Users/wzy/personal/love/food_14.txt",
				"/Users/wzy/personal/love/food_15.txt",
				"/Users/wzy/personal/love/food_16.txt",
				"/Users/wzy/personal/love/food_17.txt",
				"/Users/wzy/personal/love/food_18.txt",
				"/Users/wzy/personal/love/food_19.txt",
				"/Users/wzy/personal/love/food_20.txt"
		};
		for(int i=0; i<foodInfos.length; i++) {
			forfood(foodInfos[i], i);
		}
	}

	public static void forfood(String filename, int off) throws IOException {
		JSONObject jsonObject = new JSONObject(new JSONTokener(new FileReader(new File(filename))));
		//System.out.println(jsonObject.toString());
		JSONObject data = jsonObject.getJSONObject("data");
		//System.out.println(data.toString());
		JSONArray categoryList = data.getJSONArray("categoryList");
		//System.out.println(categoryList.toString());
		StringBuilder values = new StringBuilder();
		String baseSQL = "INSERT INTO `marketing`.`t_food`( `shop_id`, `category`, `item_name`, `item_title`, `picture`, `count`, `praise_num`, `month_sale`, `price`, `orgin_price`, `activity_id`)";
		//values.append(baseSQL);
		int offsetShopId = 32 +off;
		for (int i = 2; i < categoryList.length(); i++) {

			JSONObject category = categoryList.getJSONObject(i);
			//目录名
			String categoryName = category.getString("categoryName");
			System.out.println(categoryName);
			values.append("#"+ categoryName +"\n");
			JSONArray spuList = category.getJSONArray("spuList");
			for (int j = 0; j < spuList.length(); j++) {
				JSONObject food = spuList.getJSONObject(j);
				values.append(baseSQL);
				values.append("VALUES (");
				//商家ID
				appendVal(values, offsetShopId);
				//展示目录
				appendVal(values, categoryName);
				//菜名
				appendVal(values, food.getString("spuName"));
				//菜品说明
				appendVal(values, food.getString("spuDesc"));
				//菜品图片，多个以;分割
				appendVal(values, food.getString("bigImageUrl"));
				//库存
				appendVal(values, 9999);
				//赞赏数量
				appendVal(values, food.getInt("praiseNum"));
				//月售
				appendVal(values, food.getInt("saleVolume"));
				//价格
				appendVal(values, food.getInt("currentPrice"));
				//原价
				appendVal(values, food.getInt("originPrice"));
				//参加的活动ID
				Lastappend(values, 0);

				System.out.println(values.toString());
			}
		}
		writeToFile("sql/food_data2.sql",values.toString(),true);

	}

	public static void writeToFile(String filename,String val, boolean isAppend) throws IOException {
		File file = new File(filename);
		FileUtils.write(file, val, "utf8", isAppend);
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
