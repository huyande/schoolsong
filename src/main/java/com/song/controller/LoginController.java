package com.song.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.song.bean.Wxuserinfo;
import com.song.bean.ana.Result;
import com.song.service.WxUserInfoService;
import com.song.utils.HttpClientUtil;
import com.song.utils.JacksonUtil;


/**
 * 用户注册 、保存用户
 * @author Administrator
 *
 */
@RestController
public class LoginController {
	Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private WxUserInfoService wxUserInfoService;
	
	
	@Value("${wx.appid}")
	private String appid;
	@Value("${wx.secret}")
	private String secret;
	@Value("${wx.grantType}")
	private String grantType;
	@Value("${wx.sessionHost}")
	private String sessionHost;
	
	/**
	 * 请求微信服务器获取返回的session_key and openid
	 * @param code
	 * @return
	 */
	@RequestMapping("/wxlogin")
	public String wxlogin(String js_code){
		log.info("获取session_key and openid");
		// 定义JackJson 对象
		try {
			String api_url =sessionHost+"?appid="+appid+"&secret="+secret+"&js_code="+js_code+"&grant_type="+grantType ;
			String loginMsg = HttpClientUtil.get(api_url);
			return loginMsg;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	/**
	 * 查询已授权数据库中的数据
	 * 是否由此用户
	 * @return
	 */
	@RequestMapping("/ishasUser")
	public String ishasUser(String openid){
		log.info("查询该用户是否有记录");
		Wxuserinfo wxuserinfo = wxUserInfoService.findByOpenId(openid);
		Result<Boolean> result = new Result<>();
		result.setMessage("查询是否授权");
		if(wxuserinfo!=null){
			result.setResult(true);
			return JacksonUtil.toJSon(result);
		}else{
			result.setResult(false);
			return JacksonUtil.toJSon(result);
		}
	}
	
	/**
	 * 授权此用户 将此用户保存到数据库中 
	 * @return
	 */
	@RequestMapping("/authorizeUser")
	public String authorizeUser(Wxuserinfo wxuserinfo){
		log.info("授权此用户");
		int addcoount = wxUserInfoService.addWxUserInfo(wxuserinfo);
		return (addcoount==0)?"false":"true";
	}
	
	/**
	 * 查询用户信息
	 * @return
	 */
	@RequestMapping("/findUser")
	public String findUser(String openid){
		log.info("查询用户"+openid);
		Wxuserinfo wxuserinfo = wxUserInfoService.findByOpenId(openid);
		return JacksonUtil.toJSon(wxuserinfo);
	}
	
	
}
