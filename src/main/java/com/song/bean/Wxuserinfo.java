package com.song.bean;

import java.util.Date;

/**
 * 
 * 
 * @author 
 * 
 * @date 2018-11-29
 */
public class Wxuserinfo {
    private Integer id;

    private String openid;

    private String nickname;

    private String avatarurl;

    private String province;

    private String city;

    private String signtime;

    private Integer gender;

    /**
     * 学号
     */
    private String schoolid;

    /**
     * 专业
     */
    private String profession;

    /**
     * 班级
     */
    private String classnum;

    /**
     * 真实名字
     */
    private String truename;

    /**
     * 0 未认证  1 认证
     */
    private Integer authenstate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }


    public String getSigntime() {
		return signtime;
	}

	public void setSigntime(String signtime) {
		this.signtime = signtime;
	}

	public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid == null ? null : schoolid.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getClassnum() {
        return classnum;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum == null ? null : classnum.trim();
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }

    public Integer getAuthenstate() {
        return authenstate;
    }

    public void setAuthenstate(Integer authenstate) {
        this.authenstate = authenstate;
    }
}