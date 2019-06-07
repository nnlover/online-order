package com.sust.onlineorder.services;

import com.sust.onlineorder.entity.TComment;

import java.util.List;

/**
 * @Author: wangzongyu
 * @Date: 2019/6/7 15:46
 */
public interface CommentService {

	Integer insertComment(TComment comment);

	List<TComment> queryByShopIds(List<Integer> shopIds);
}
