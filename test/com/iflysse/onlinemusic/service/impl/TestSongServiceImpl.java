package com.iflysse.onlinemusic.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iflysse.onlinemusic.po.Song;
import com.iflysse.onlinemusic.service.SongService;

public class TestSongServiceImpl {
	SongService songService;
	@Before
	public void setUp() throws Exception {
		songService=new SongServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getSongList() {
		List<Song> list=new ArrayList<Song>();
		list=songService.getSongList(1, 10);
		for (Song song : list) {
			System.out.println(song.toString());
		}
	}
	
	@Test
	public void getTotalPage(){
		int num=songService.getTotalPage(2);
		System.out.println(num);
	}
	
	@Test
	public void getMySongList() {
		List<Song> list=new ArrayList<Song>();
		list=songService.getMySongList(1, 1, 10);
		for (Song song : list) {
			System.out.println(song.toString());
		}
	}
	@Test
	public void getMyTotalPage() {
		int num=songService.getMyTotalPage(1, 4);
		System.out.println(num);
	}
	
	@Test
	public void getSong(){
		Song song=songService.getSong(1);
		System.out.println(song.toString());
	}
	
	@Test 
	public void update(){
		Song song=new Song();
		song.setSong("11");
		song.setSpecial("1111");
		song.setSinger("111");
		song.setPath(null);
		song.setUpLoadDate(null);
		song.setUserId(1);
		song.setId(5);
		songService.update(song);
	}
	@Test
	public void delete(){
		songService.delete(6);
	}
	@Test 
	public void add(){
		Song song=new Song();
		song.setSong("11");
		song.setSpecial("1111");
		song.setSinger("111");
		song.setPath(null);
		song.setUpLoadDate(null);
		song.setUserId(1);
		songService.add(song);
	}
}
