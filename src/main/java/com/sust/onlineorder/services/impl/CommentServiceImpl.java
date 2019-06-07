package com.sust.onlineorder.services.impl;

import com.sust.onlineorder.dao.TCommentMapper;
import com.sust.onlineorder.entity.TComment;
import com.sust.onlineorder.entity.TCommentExample;
import com.sust.onlineorder.services.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

	@Override
	public List<TComment> queryByShopIds(List<Integer> shopIds) {
		TCommentExample example = new TCommentExample();
		TCommentExample.Criteria criteria = example.createCriteria();
		criteria.andShopIdIn(shopIds);
		List<TComment> comments = commentMapper.selectByExample(example);
		return comments;
	}
}
