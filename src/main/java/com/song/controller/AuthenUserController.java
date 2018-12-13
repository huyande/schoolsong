package com.song.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.song.bean.Wxuserinfo;
import com.song.bean.ana.Result;
import com.song.bean.param.Authen;
import com.song.service.WxUserInfoService;
import com.song.utils.JacksonUtil;

/**
 * 认证用户 控制类 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/authen")
public class AuthenUserController {
	Logger log = LoggerFactory.getLogger(AuthenUserController.class);
	
	@Autowired
	private WxUserInfoService wxUserInfoService;
	

	/**
	 * 判断是否是认证用户 
	 * 认证用户是否是中卫校区学生
	 * @return
	 */
	@RequestMapping("/isnotAuthen")
	public String isnotAuthen(String openid){
		log.info("判断是否是认证用户 "+openid);
		//查询数据库 查看当前的用户是否是认证的用户
		Boolean isAuthen=wxUserInfoService.isnotAuthen(openid);
		Result<Boolean> reslut= new Result<>();
		reslut.setMessage("用户认证情况");
		reslut.setResult(isAuthen);;
		return JacksonUtil.toJSon(reslut);
	}
	
	
	/**
	 * 更新用户信息 
	 * 用户进入微信小程序认证界面 
	 * 提交表单 更新用户的信息 
	 * http://localhost/authen/putwxuserinfo?openid=oEu4U1mNCvcJr-vWWSbdo7PiQM8I&shoolid=12014245981&profession=%E8%BD%AF%E4%BB%B6%E5%B7%A5%E7%A8%8B&classnum=14%E7%BA%A7%E8%BD%AF%E4%BB%B6%E5%9B%9B%E7%8F%AD&truename=%E8%83%A1%E9%A2%9C%E5%BE%B7
	 * @return
	 */
	@RequestMapping(value="/putwxuserinfo",method=RequestMethod.GET)
	public String putwxuserinfo(Authen authen){
		log.info("更新用户信息 "+authen.toString());
		Wxuserinfo wxuserinfo = wxUserInfoService.findByOpenId(authen.getOpenid());
		//更新用户信息 
		wxuserinfo.setProfession(authen.getProfession());
		wxuserinfo.setSchoolid(authen.getSchoolid());
		wxuserinfo.setClassnum(authen.getClassnum());
		wxuserinfo.setTruename(authen.getTruename());
		Result<Boolean> reslut= new Result<>();
		reslut.setMessage("用户认证情况");
		try {
			wxUserInfoService.updataWxuserInfo(wxuserinfo);
			reslut.setResult(true);
			return JacksonUtil.toJSon(reslut);
		} catch (Exception e) {
			reslut.setResult(false);
			return JacksonUtil.toJSon(reslut);
		}
	}
	
}
