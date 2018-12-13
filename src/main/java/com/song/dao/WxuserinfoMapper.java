package com.song.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.song.bean.Wxuserinfo;

public interface WxuserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wxuserinfo record);

    int insertSelective(Wxuserinfo record);

    Wxuserinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wxuserinfo record);

    int updateByPrimaryKey(Wxuserinfo record);

	Wxuserinfo findByOpenId(String openid);

	List<Wxuserinfo> findWxUserInfoList(@Param(value="pageStart")int pageStart, @Param(value="pageSize")Integer pageSize);

	Integer totalCountWxUser();

	Wxuserinfo isnotAuthen(String openid);
}