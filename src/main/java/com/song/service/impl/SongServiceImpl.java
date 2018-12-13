package com.song.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.bean.Song;
import com.song.dao.SongMapper;
import com.song.service.SongService;

@Service
public class SongServiceImpl implements SongService {
	@Autowired
	private SongMapper songMapper;

	/**
	 * 保存用户提交的数据  
	 */
	@Override
	public int addSong(Song song) {
		return songMapper.insert(song);
	}

	@Override
	public List<Song> findbyOpenidList(Integer page,Integer pageSize,String openid, Integer handleState) {
		return songMapper.findbyOpenidList((page-1)*pageSize,pageSize,openid,handleState);
	}

	@Override
	public Song findBysongId(String id) {
		return songMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteBysongId(String id) {
		songMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Song> findSongByOpendId(String openid) {
		return songMapper.findSongByOpendId(openid);
	}

	@Override
	public List<Song> findSongList(Integer pagestart, Integer pagesize) {
		return songMapper.findSongList((pagestart-1)*pagesize,pagesize);
	}

	@Override
	public Integer totalSong() {
		return songMapper.totalSong();
	}

	@Override
	public int updetaSong(Song song) {
		return songMapper.updateByPrimaryKey(song);
	}

	@Override
	public List<Song> findbyOpenidMessageList(String openid) {
		return songMapper.findbyOpenidMessageList(openid);
	}

}
