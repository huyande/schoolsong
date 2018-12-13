package com.song.service;

import java.util.List;

import com.song.bean.Comment;

public interface CommentService {

	Comment findcommentBySongid(String songid);

	int addcomment(Comment comment);

	List<Comment> findCommentList(Integer pagestart, Integer pagesize);

	Integer totalContComment();

	Comment findCommentByid(String commentid);

}
