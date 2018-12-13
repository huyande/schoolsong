package com.song.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.song.bean.Notice;
import com.song.bean.ana.Result;
import com.song.service.NoticeService;
import com.song.utils.JacksonUtil;

@RestController
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value="getnotice",method=RequestMethod.GET)
	public String getnotice(){
		Notice notice =noticeService.getNotice();
		Result<String> resutl = new Result<>();
		resutl.setMessage("公告消息");
		resutl.setResult(notice.getContent());
		return JacksonUtil.toJSon(resutl);
	}
}
