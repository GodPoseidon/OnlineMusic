package com.iflysse.onlinemusic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.iflysse.onlinemusic.po.Song;
@Repository
public interface SongDao {
	public List<Song> getSongList(@Param("pageIndex")int pageIndex,@Param("pageSize") int pageSize);

	public int getTotalCount();

	public List<Song> getMySongList(@Param("userId")int userId, @Param("pageIndex")int pageIndex, @Param("pageSize")int pageSize);

	public int getMyTotalCount(int userId);

	public Song getSong(int id);

	public void update(Song song);

	public void delete(int id);

	public void add(Song song);
}
