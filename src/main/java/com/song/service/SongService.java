package com.song.service;

import java.util.List;

import com.song.bean.Song;

public interface SongService {

	int addSong(Song song);

	List<Song> findbyOpenidList(Integer page,Integer pageSize,String openid, Integer handleState);

	Song findBysongId(String id);

	void deleteBysongId(String id);

	List<Song> findSongByOpendId(String openid);

	List<Song> findSongList(Integer pagestart, Integer pagesize);

	Integer totalSong();

	int updetaSong(Song song);

	List<Song> findbyOpenidMessageList(String openid);

}
