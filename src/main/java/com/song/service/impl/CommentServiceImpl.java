package com.song.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.bean.Comment;
import com.song.dao.CommentMapper;
import com.song.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public Comment findcommentBySongid(String songid) {
		return commentMapper.findcommentBySongid(songid);
	}

	@Override
	public int addcomment(Comment comment) {
		return commentMapper.insert(comment);
	}

	@Override
	public List<Comment> findCommentList(Integer pagestart, Integer pagesize) {
		return commentMapper.findCommentList((pagestart-1)*pagesize,pagesize);
	}

	@Override
	public Integer totalContComment() {
		return commentMapper.totalContComment();
	}

	@Override
	public Comment findCommentByid(String commentid) {
		return commentMapper.selectByPrimaryKey(commentid);
	}

}
