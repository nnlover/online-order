package com.sust.onlineorder.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: wangzongyu
 * @Date: 2019/5/12 18:18
 */
@Data
@Builder
public class UserAndAddrModel implements Serializable {
	String userName;
	String phone;
	Integer addrId;
	String address;
}
