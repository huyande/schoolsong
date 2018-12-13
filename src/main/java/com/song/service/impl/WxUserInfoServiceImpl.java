package com.song.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.bean.Wxuserinfo;
import com.song.dao.WxuserinfoMapper;
import com.song.service.WxUserInfoService;


@Service
public class WxUserInfoServiceImpl implements WxUserInfoService {

	@Autowired
	private WxuserinfoMapper wxuserinfoMapper;

	/**
	 * 根据用户的openid 查询用户信息
	 */
	@Override
	public Wxuserinfo findByOpenId(String openid) {
		Wxuserinfo wxuserinfo =wxuserinfoMapper.findByOpenId(openid);
		return wxuserinfo;
	}

	/**
	 * 添加用户
	 */
	@Override
	public int addWxUserInfo(Wxuserinfo wxuserinfo) {
		return wxuserinfoMapper.insert(wxuserinfo);
	}
	
	/**
	 * 查询所有用户信息
	 */
	@Override
	public List<Wxuserinfo> findWxUserInfoList(Integer page, Integer rows) {
		
		return wxuserinfoMapper.findWxUserInfoList((page-1)*rows,rows);
	}

	/**
	 * 查询总数
	 */
	@Override
	public Integer totalCountWxUser() {
		
		return wxuserinfoMapper.totalCountWxUser();
	}

	@Override
	public Boolean isnotAuthen(String openid) {
		Wxuserinfo wxuserinfo = wxuserinfoMapper.isnotAuthen(openid);
		//如果没有查到 则说明是未认证的用户 返回false 否则 返回true 
		return wxuserinfo==null?false:true;
	}

	@Override
	public void updataWxuserInfo(Wxuserinfo wxuserinfo) {
		wxuserinfoMapper.updateByPrimaryKey(wxuserinfo);
	}

	@Override
	public int updateWxUserInfo(Wxuserinfo wxuserinfo) {
		return wxuserinfoMapper.updateByPrimaryKey(wxuserinfo);
	}
	
}
