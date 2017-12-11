package com.iflysse.onlinemusic.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iflysse.onlinemusic.dao.CollectDao;
import com.iflysse.onlinemusic.po.Collect;
import com.iflysse.onlinemusic.po.Song;
import com.iflysse.onlinemusic.service.CollectService;

@Service("collectService")
public class CollectServiceImpl implements CollectService {
	
	@Resource(name="collectDao")
	private CollectDao collectDao ;

	@Override
	public List<Song> getMyCollectList(int userId, int pageIndex, int pageSize) {
		return collectDao.getMyCollectList(userId, (pageIndex-1)*pageSize, pageSize);
	}

	@Override
	public int getTotalPage(int userId, int pageSize) {
		int page = 1;
		int number = collectDao.getTotalCount(userId);
		if (number > pageSize) {
			if (number % pageSize == 0) {
				page = number / pageSize;
			} else {
				page = number / pageSize + 1;
			}
		}
		return page;
	}

	@Override
	public void add(Collect collect) {
		collectDao.add(collect);
	}

	@Override
	public void delete(int id) {
		collectDao.delete(id);
	}

	@Override
	public int getCollectCount(int songId, int userId) {
		return collectDao.getCollectCount(songId, userId);
	}

}
