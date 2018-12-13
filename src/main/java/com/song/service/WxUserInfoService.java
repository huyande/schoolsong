package com.song.service;

import java.util.List;

import com.song.bean.Wxuserinfo;


public interface WxUserInfoService {

	Wxuserinfo findByOpenId(String openid);

	int addWxUserInfo(Wxuserinfo wxuserinfo);

	List<Wxuserinfo> findWxUserInfoList(Integer page, Integer rows);

	Integer totalCountWxUser();

	Boolean isnotAuthen(String openid);

    void updataWxuserInfo(Wxuserinfo wxuserinfo);

	int updateWxUserInfo(Wxuserinfo wxuserinfo);

}
