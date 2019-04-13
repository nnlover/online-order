package com.sust.onlineorder.model;

import lombok.Data;

import java.io.Serializable;

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

}
