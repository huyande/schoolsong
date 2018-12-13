package com.song.bean;

import java.util.Date;

/**
 * 
 * 
 * @author 
 * 
 * @date 2018-12-05
 */
public class Notice {
    private Integer id;

    private String content;

    private String createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
    
}