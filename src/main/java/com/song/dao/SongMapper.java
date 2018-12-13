package com.song.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.song.bean.Song;

public interface SongMapper {
    int deleteByPrimaryKey(String id);

    int insert(Song record);

    int insertSelective(Song record);

    Song selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Song record);

    int updateByPrimaryKey(Song record);

	List<Song> findbyOpenidList(@Param(value="pageStart")int pageStart, @Param(value="pageSize")Integer pageSize,@Param(value="openid") String openid,@Param(value="handleState") Integer handleState);

	List<Song> findSongByOpendId(String openid);

	List<Song> findSongList(@Param(value="pageStart")int pageStart, @Param(value="pageSize")Integer pageSize);

	Integer totalSong();

	List<Song> findbyOpenidMessageList(String openid);
}