package com.iflysse.onlinemusic.po;

import java.util.Date;

public class Song {
	private int id;
	private String song;
	private String special;
	private String singer;
	private Date upLoadDate;
	private String path;
	private int userId;
	private int collectId;
	public int getCollectId() {
		return collectId;
	}

	public void setCollectId(int collectId) {
		this.collectId = collectId;
	}

	private String nname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public Date getUpLoadDate() {
		return upLoadDate;
	}

	public void setUpLoadDate(Date upLoadDate) {
		this.upLoadDate = upLoadDate;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", song=" + song + ", special=" + special
				+ ", singer=" + singer + ", upLoadDate=" + upLoadDate
				+ ", path=" + path + ", userId=" + userId + ", nname=" + nname
				+ "]";
	}



}
