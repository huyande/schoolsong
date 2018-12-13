package com.song.bean;

import java.util.Date;

/**
 * 
 * 
 * @author 
 * 
 * @date 2018-11-29
 */
public class Song {
    private String id;

    /**
     * 用户微信的id
     */
    private String openid;

    /**
     * 歌名
     */
    private String songname;

    /**
     * 歌手
     */
    private String songer;

    /**
     * 留言
     */
    private String message;

    /**
     * 0 未播放 1 已点播 -1 未通过
     */
    private Integer stateplay;

    /**
     * 反馈信息
     */
    private String feedbackmessage;

    /**
     * 创建时间
     */
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

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname == null ? null : songname.trim();
    }

    public String getSonger() {
        return songer;
    }

    public void setSonger(String songer) {
        this.songer = songer == null ? null : songer.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Integer getStateplay() {
        return stateplay;
    }

    public void setStateplay(Integer stateplay) {
        this.stateplay = stateplay;
    }

    public String getFeedbackmessage() {
        return feedbackmessage;
    }

    public void setFeedbackmessage(String feedbackmessage) {
        this.feedbackmessage = feedbackmessage == null ? null : feedbackmessage.trim();
    }

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

}