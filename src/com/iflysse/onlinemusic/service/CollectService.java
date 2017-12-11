package com.iflysse.onlinemusic.service;

import java.util.List;

import com.iflysse.onlinemusic.po.Collect;
import com.iflysse.onlinemusic.po.Song;

public interface CollectService {
	public List<Song> getMyCollectList(int userId, int pageIndex, int pageSize);

	public int getTotalPage(int userId, int pageSize);

	public void add(Collect collect);

	public void delete(int id);
	
	public int getCollectCount(int  songId,int userId);
}
