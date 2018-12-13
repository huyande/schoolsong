package com.song.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.bean.Notice;
import com.song.dao.NoticeMapper;
import com.song.service.NoticeService;
@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public Notice getNotice() {
		return noticeMapper.selectByPrimaryKey(1);
	}

	@Override
	public void updataNotice(Notice notice) {
		noticeMapper.updateByPrimaryKey(notice);
	}
	
	
	
}
