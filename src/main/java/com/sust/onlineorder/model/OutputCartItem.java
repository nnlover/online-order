package com.sust.onlineorder.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: wangzongyu
 * @Date: 2019/3/24 23:06
 */
@Data
public class OutputCartItem implements Serializable {

	private Integer id;

	private Integer shopId;

	private String category;

	private String itemName;

	private String itemTitle;

	private String picture;

	private Integer count;

	private Integer praiseNum;

	private BigDecimal price;

	private BigDecimal orginPrice;

	private Integer activityId;

	private Integer payCount;
}
