package com.song.controller.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.song.bean.Song;
import com.song.bean.Wxuserinfo;
import com.song.bean.ana.Result;
import com.song.service.SongService;
import com.song.service.WxUserInfoService;
import com.song.utils.JacksonUtil;
import com.song.vo.SongVo;

/**
 * 点播歌曲 控制层 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("admin/song")
public class SongManagerController {
	//处理点歌信息的
	@Autowired
	private SongService songService;
	
	@Autowired
	private WxUserInfoService wxUserInfoService;
	
	/**
	 * 查询用户点播歌曲列表
	 * @param pagestart
	 * @param pagesize
	 * @return
	 * localhost/admin/song/songlist?pagestart=1&pagesize=3
	 */
	@RequestMapping("songlist")
	public String commentList(Integer pagestart,Integer pagesize){
		List<SongVo> songVos = new ArrayList<>();
		List<Song> songlist=songService.findSongList(pagestart, pagesize);
		for (Song song : songlist) {
			SongVo songVo = new SongVo();
			//查用户信息 
			Wxuserinfo wxuserinfo = wxUserInfoService.findByOpenId(song.getOpenid());
			songVo.setId(song.getId());
			songVo.setOpenid(wxuserinfo.getOpenid());
			songVo.setAvatarurl(wxuserinfo.getAvatarurl());
			songVo.setNickname(wxuserinfo.getNickname());
			songVo.setClassnum(wxuserinfo.getClassnum());
			songVo.setSongname(song.getSongname());
			songVo.setMessage(song.getMessage());
			songVo.setCreatetime(song.getCreatetime());
			songVo.setProfession(wxuserinfo.getProfession());
			songVo.setSchoolId(wxuserinfo.getSchoolid());
			songVo.setTruename(wxuserinfo.getTruename());
			songVo.setStateplay(song.getStateplay());
			
			songVos.add(songVo);
		}
		Integer count = songService.totalSong();
		return "{\"rows\":"+JacksonUtil.toJSon(songVos)+",\"total\":"+count+"}";
	}
	
	/**
	 * 查看提交歌曲详情
	 */
	@RequestMapping("songinfo")
	public String songinfo(String songid){
		Song song = songService.findBysongId(songid);
		SongVo songVo = new SongVo();
		//查用户信息 
		Wxuserinfo wxuserinfo = wxUserInfoService.findByOpenId(song.getOpenid());
		songVo.setId(song.getId());
		songVo.setOpenid(wxuserinfo.getOpenid());
		songVo.setAvatarurl(wxuserinfo.getAvatarurl());
		songVo.setNickname(wxuserinfo.getNickname());
		songVo.setClassnum(wxuserinfo.getClassnum());
		songVo.setSongname(song.getSongname());
		songVo.setMessage(song.getMessage());
		songVo.setCreatetime(song.getCreatetime());
		songVo.setProfession(wxuserinfo.getProfession());
		songVo.setSchoolId(wxuserinfo.getSchoolid());
		songVo.setTruename(wxuserinfo.getTruename());
		songVo.setStateplay(song.getStateplay());
		
		return JacksonUtil.toJSon(songVo);
	}
	
	/**
	 * 审核通过 
	 */
	@RequestMapping("songpass")
	public String songpass(String songid){
		Song song = songService.findBysongId(songid);
		song.setStateplay(1);
		song.setFeedbackmessage("你点播的歌曲通过审核");
		int count = songService.updetaSong(song);
		Result<Boolean> result = new Result<>();
		result.setMessage("审核通过状态");
		result.setResult(count==1?true:false);
		return JacksonUtil.toJSon(result);
	}
	/**
	 * 审核未通过 
	 * 参数 id  和 feedbackmessgae 
	 */
	@RequestMapping("songnotpass")
	public String songnotpass(String songid,String backmesaage){
		Song song = songService.findBysongId(songid);
		song.setStateplay(-1);
		song.setFeedbackmessage(backmesaage);
		int count = songService.updetaSong(song);
		Result<Boolean> result = new Result<>();
		result.setMessage("审核未通过状态");
		result.setResult(count==1?true:false);
		return JacksonUtil.toJSon(result);
	}
	
	
	
	
}
