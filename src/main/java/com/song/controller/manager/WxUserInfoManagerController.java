package com.song.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.song.bean.Wxuserinfo;
import com.song.bean.ana.Result;
import com.song.service.WxUserInfoService;
import com.song.utils.JacksonUtil;

/**
 * 获取微信用户信息 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("admin/wx")
public class WxUserInfoManagerController {
	
	@Autowired
	private WxUserInfoService wxUserInfoService;

	/**
	 * 查询用户 列表 
	 * @param pagestart
	 * @param pagesize
	 * @return
	 */
	@RequestMapping("wxuserlist")
	public String wxuserlist(Integer pagestart,Integer pagesize){
		//分页查询wx 用户信息 
		List<Wxuserinfo> wxUserInfoList = wxUserInfoService.findWxUserInfoList(pagestart, pagesize);
		Integer countWxUser = wxUserInfoService.totalCountWxUser();
		return "{\"rows\":"+JacksonUtil.toJSon(wxUserInfoList)+",\"total\":"+countWxUser+"}";
	}
	
	/**
	 * 后台认证用户 
	 * @return
	 */
	@RequestMapping("authenuser")
	public String authenUser(String openid){
		Wxuserinfo wxuserinfo = wxUserInfoService.findByOpenId(openid);
		//更新用户信息
		wxuserinfo.setAuthenstate(1);
		int count = wxUserInfoService.updateWxUserInfo(wxuserinfo);
		Result<Boolean> result = new Result<>();
		result.setMessage("后台认证用户情况");
		result.setResult(count==1?true:false);
		return JacksonUtil.toJSon(result);
	}
	
	
	/**
	 * 查询用户详情  
	 */
	@RequestMapping("wxuser")
	public String wxuser(String openid){
		Wxuserinfo wxuserinfo = wxUserInfoService.findByOpenId(openid);
		Result<Wxuserinfo> result = new Result<>();
		result.setMessage("用户详情");
		result.setResult(wxuserinfo);
		return JacksonUtil.toJSon(result);
	}
	
	
	
	
	
	

}
