package com.song.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.song.bean.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

	Comment findcommentBySongid(String songid);

	List<Comment> findCommentList(@Param(value="pageStart")int pageStart, @Param(value="pageSize")Integer pageSize);

	Integer totalContComment();

}