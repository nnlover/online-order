package com.sust.onlineorder.services.impl;

import com.sust.onlineorder.dao.TCommentMapper;
import com.sust.onlineorder.entity.TComment;
import com.sust.onlineorder.entity.TCommentExample;
import com.sust.onlineorder.services.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: wangzongyu
 * @Date: 2019/6/7 15:48
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Resource
	TCommentMapper commentMapper;


	@Override
	public Integer insertComment(TComment comment) {

		int insert = commentMapper.insert(comment);
		return insert;
	}
}
