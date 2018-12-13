package com.song.bean.param;

public class Authen {

	private String openid;
	
	private String schoolid;
	
	private String profession;
	//年级 班级
	private String classnum;
	
	private String truename;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}


	public String getSchoolid() {
		return schoolid;
	}

	public void setSchoolid(String schoolid) {
		this.schoolid = schoolid;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getClassnum() {
		return classnum;
	}

	public void setClassnum(String classnum) {
		this.classnum = classnum;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	@Override
	public String toString() {
		return "Authen [openid=" + openid + ", schoolid=" + schoolid + ", profession=" + profession + ", classnum="
				+ classnum + ", truename=" + truename + "]";
	}
	
}
