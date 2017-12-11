package com.iflysse.onlinemusic.service;

import java.util.List;

import com.iflysse.onlinemusic.po.Song;

public interface SongService {
	public List<Song> getSongList(int pageIndex, int pageSize);

	public int getTotalPage(int pageSize);

	public List<Song> getMySongList(int userId, int pageIndex, int pageSize);

	public int getMyTotalPage(int userId, int pageSize);

	public Song getSong(int id);

	public void update(Song song);

	public void delete(int id);

	public void add(Song song);
}
