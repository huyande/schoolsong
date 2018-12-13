package com.song.controller.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.song.bean.Comment;
import com.song.bean.Song;
import com.song.bean.Wxuserinfo;
import com.song.service.CommentService;
import com.song.service.SongService;
import com.song.service.WxUserInfoService;
import com.song.utils.JacksonUtil;
import com.song.vo.CommentVo;
/**
 * 后台管理  用户评价 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("admin/comment")
public class CommentManagerController {
	
	@Autowired 
	private CommentService commentService;
	
	//处理点歌信息的
	@Autowired
	private SongService songService;
	
	@Autowired
	private WxUserInfoService wxUserInfoService;
		
	/**
	 * 查询用户评论列表 
	 * @param pagestart
	 * @param pagesize
	 * @return
	 * localhost/admin/comment/commenlist?pagestart=1&pagesize=3
	 */
	@RequestMapping("commenlist")
	public String commentList(Integer pagestart,Integer pagesize){
		List<CommentVo> commentVos = new ArrayList<>();
		List<Comment> comlist=commentService.findCommentList(pagestart,pagesize);
		for (Comment comment : comlist) {
			CommentVo commentVo = new CommentVo();
			//查歌曲列表
			List<Song> songs= songService.findSongByOpendId(comment.getOpenid());
			//查用户信息 
			Wxuserinfo wxuserinfo = wxUserInfoService.findByOpenId(comment.getOpenid());
			commentVo.setCommentid(comment.getId());
			commentVo.setOpenid(wxuserinfo.getOpenid());
			commentVo.setAvatarurl(wxuserinfo.getAvatarurl());
			commentVo.setNickname(wxuserinfo.getNickname());
			commentVo.setClassnum(wxuserinfo.getClassnum());
			commentVo.setComment(comment.getComment());
			commentVo.setCreatetime(comment.getCreatetime());
			commentVo.setProfession(wxuserinfo.getProfession());
			commentVo.setSchoolId(wxuserinfo.getSchoolid());
			commentVo.setScore(comment.getScore());
			commentVo.setSongs(songs);
			commentVo.setTruename(wxuserinfo.getTruename());
			commentVos.add(commentVo);
		}
		Integer count = commentService.totalContComment();
		return "{\"rows\":"+JacksonUtil.toJSon(commentVos)+",\"total\":"+count+"}";
	}
	/**
	 * 查询 评价详情 
	 * @param commentid
	 * @return
	 */
	@RequestMapping("commeninfo")
	public String commeninfo(String commentid){
		Comment comment =commentService.findCommentByid(commentid);
		CommentVo commentVo = new CommentVo();
		//查歌曲列表
		List<Song> songs= songService.findSongByOpendId(comment.getOpenid());
		//查用户信息 
		Wxuserinfo wxuserinfo = wxUserInfoService.findByOpenId(comment.getOpenid());
		commentVo.setCommentid(comment.getId());
		commentVo.setOpenid(wxuserinfo.getOpenid());
		commentVo.setAvatarurl(wxuserinfo.getAvatarurl());
		commentVo.setNickname(wxuserinfo.getNickname());
		commentVo.setClassnum(wxuserinfo.getClassnum());
		commentVo.setComment(comment.getComment());
		commentVo.setCreatetime(comment.getCreatetime());
		commentVo.setProfession(wxuserinfo.getProfession());
		commentVo.setSchoolId(wxuserinfo.getSchoolid());
		commentVo.setScore(comment.getScore());
		commentVo.setSongs(songs);
		commentVo.setTruename(wxuserinfo.getTruename());
		return JacksonUtil.toJSon(commentVo);
	}
	
	
}
