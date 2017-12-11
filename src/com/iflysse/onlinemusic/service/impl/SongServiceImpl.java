package com.iflysse.onlinemusic.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iflysse.onlinemusic.dao.CollectDao;
import com.iflysse.onlinemusic.dao.SongDao;
import com.iflysse.onlinemusic.po.Song;
import com.iflysse.onlinemusic.service.SongService;
@Service("songService")
public class SongServiceImpl implements SongService {
	@Resource(name="songDao")
	private SongDao songDao;
	@Resource(name="collectDao")
	private CollectDao collectDao;
	
	@Override
	public List<Song> getSongList(int pageIndex, int pageSize) {
		return songDao.getSongList(pageIndex, pageSize);
	}

	@Override
	public int getTotalPage(int pageSize) {
		int page = 0;
		int number = songDao.getTotalCount();
		if(number<pageSize){
			page=1;
		}else{
			if (number % pageSize == 0) {
				page = number / pageSize;
			} else {
				page = number / pageSize + 1;
			}
		}
		return page;
	}

	@Override
	public List<Song> getMySongList(int userId, int pageIndex, int pageSize) {
		return songDao.getMySongList(userId, (pageIndex-1)*pageSize, pageSize);
	}

	@Override
	public int getMyTotalPage(int userId, int pageSize) {
		int page = 0;
		int number = songDao.getMyTotalCount(userId);
		if(number<pageSize){
			page=1;
		}else{
			if (number % pageSize == 0) {
				page = number / pageSize;
			} else {
				page = number / pageSize + 1;
			}
		}
		return page;
	}

	@Override
	public Song getSong(int id) {
		return songDao.getSong(id);
	}

	@Override
	public void update(Song song) {
		songDao.update(song);
	}

	@Override
	public void delete(int id) {
		collectDao.deleteBySongId(id);
		songDao.delete(id);
	}

	@Override
	public void add(Song song) {
		songDao.add(song);
	}

}
