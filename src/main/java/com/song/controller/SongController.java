package com.song.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.song.bean.Comment;
import com.song.bean.Song;
import com.song.bean.ana.Result;
import com.song.bean.param.SongbackMessage;
import com.song.service.CommentService;
import com.song.service.SongService;
import com.song.utils.JacksonUtil;

/**
 * 微信小程序端 歌曲 控制类  
 * @author Administrator
 *
 */
@RestController
@RequestMapping("song")
public class SongController {
	
	//处理点歌信息的
	@Autowired
	private SongService songService;
	
	//处理评价信息的
	@Autowired
	private CommentService commentService;

	/**
	 * 微信小程序端发布歌曲 将此信息保存到数据库中   
	 * 传来的参数有  
	 * openid
	 * songname
	 * songer
	 * message
	 * localhost/song/addSong?openid=oEu4U1mNCvcJr-vWWSbdo7PiQM8I&songname=take&songer=beyoung&message=点播给软件四班
	 * @param song
	 * @return
	 */
	@RequestMapping("addSong")
	public String addSong(Song song){
		int count =songService.addSong(song);
		Result<Boolean> result = new Result<>();
		result.setMessage("认证用户提交歌曲信息");
		result.setResult(count==1?true:false);
		//返回结果  转化成json 数据 
		return JacksonUtil.toJSon(result);
	}
	
	/**
	 * 获取当前用户发布的信息 
	 * 参数  
	 * openid  用户唯一标识
	 * handleState  处理的状态  切换 已处理 1  和未处理标签 0 分别的请求 
	 * localhost/song/getSongs?openid=oEu4U1mNCvcJr-vWWSbdo7PiQM8I&handleState=1&page=1&pageSize=2
	 * @return
	 */
	@RequestMapping("getSongs")
	public String getSongs(String openid,Integer handleState,Integer page,Integer pageSize){
		List<Song> songList=songService.findbyOpenidList(page,pageSize,openid,handleState);
		return JacksonUtil.toJSon(songList);
	}
	
	
	/**
	 * 查询 点播歌曲详情
	 * 参数  点播歌曲信息 id 
	 * localhost/song/detailSong?id=74d2c8b5-f473-11e8-ae53-a088699c38a7
	 */
	@RequestMapping("detailSong")
	public String detailSong(String id){
		Song song=songService.findBysongId(id);
		return JacksonUtil.toJSon(song);
	}
	
	/**
	 * 删除未播放的点播信息
	 * 参数  点播歌曲信息 id 
	 * localhost/song/deleteSong?id=74d2c8b5-f473-11e8-ae53-a088699c38a7
	 */
	@RequestMapping("deleteSong")
	public String deleteSong(String id){
		songService.deleteBysongId(id);
		Result<Boolean> result = new Result<>();
		result.setMessage("删除未点播的信息");
		result.setResult(true);
		//返回结果  转化成json 数据 
		return JacksonUtil.toJSon(result);
	}
	
	
	/**
	 * 是否已经评价
	 * openid  用户标识
	 * songid 发布歌曲信息的id
	 */
	@RequestMapping("isnotcomment")
	public String addcomment(String songid){
		//先去根据songid 查询 是否由此记录  如果有 返回false  提示 已经评论过 否则跳转到评论页面 
		Comment comment =commentService.findcommentBySongid(songid);
		Result<Boolean> result = new Result<>();
		result.setMessage("还没有为此点播评价");
		if(comment!=null){ //已经有此评价 
			result.setResult(false);
		}else{
			result.setResult(true);
		}
		//返回结果  转化成json 数据 
		return JacksonUtil.toJSon(result);
	}
	
	/**
	 *添加评价
	 * openid  用户标识
	 * songid 发布歌曲信息的id
	 */
	@RequestMapping("addcomment")
	public String addcomment(Comment comment){
		int count = commentService.addcomment(comment);
		Result<Boolean> result = new Result<>();
		result.setMessage("新增评论");
		result.setResult(count==1?true:false);
		//返回结果  转化成json 数据 
		return JacksonUtil.toJSon(result);
	}
	
	/**
	 * 审核后通知给用户的消息
	 * openid  用户标识
	 * songid 发布歌曲信息的id
	 */
	@RequestMapping("messages")
	public String songmessages(String openid){
		List<Song> songList=songService.findbyOpenidMessageList(openid);
		List<SongbackMessage> messages = new ArrayList<>();
		for (Song song : songList) {
			SongbackMessage message = new SongbackMessage();
			message.setMessage(song.getFeedbackmessage());
			message.setSong(song.getSongname());
			message.setTime(song.getCreatetime().split(" ")[0]);
			messages.add(message);
		}
		//返回结果  转化成json 数据 
		return JacksonUtil.toJSon(messages);
	}
	
	
	
	
	
	
	
	
	
}
