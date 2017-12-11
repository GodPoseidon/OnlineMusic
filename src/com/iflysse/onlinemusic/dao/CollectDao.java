package com.iflysse.onlinemusic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.iflysse.onlinemusic.po.Collect;
import com.iflysse.onlinemusic.po.Song;

@Repository
public interface CollectDao {
	public List<Song> getMyCollectList(@Param("userId")int userId,@Param("pageIndex") int pageIndex, @Param("pageSize")int pageSize);

	public int getTotalCount(int userId);

	public void add(Collect collect);

	public void delete(int id);

	public void deleteBySongId(int songId); // 隐含
	
	
	public int getCollectCount(@Param("songId")int  songId,@Param("userId")int userId);
}
