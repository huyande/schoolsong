package com.song.bean;

import java.util.Date;

/**
 * 
 * 
 * @author 
 * 
 * @date 2018-11-29
 */
public class Comment {
    private String id;

    private String openid;

    /**
     * 评价信息
     */
    private String comment;

    /**
     * 评分信息
     */
    private Integer score;

    /**
     * 点歌歌曲id
     */
    private String songid;

    private String createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getSongid() {
        return songid;
    }

    public void setSongid(String songid) {
        this.songid = songid == null ? null : songid.trim();
    }

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

}