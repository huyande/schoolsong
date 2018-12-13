package com.song.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.song.bean.Notice;
import com.song.bean.ana.Result;
import com.song.service.NoticeService;
import com.song.utils.JacksonUtil;

@RestController
@RequestMapping("admin/notice")
public class NoticeManagerController {
	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping(value="updataNotice",method=RequestMethod.GET)
	public String updataNotice(String message){
		Notice notice =noticeService.getNotice();
		notice.setContent(message);
		noticeService.updataNotice(notice);
		Result<Boolean> resutl = new Result<>();
		resutl.setMessage("公告消息");
		resutl.setResult(true);
		return JacksonUtil.toJSon(resutl);
	}
}
