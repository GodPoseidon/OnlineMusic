package com.iflysse.onlinemusic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iflysse.onlinemusic.po.Collect;
import com.iflysse.onlinemusic.po.Song;
import com.iflysse.onlinemusic.service.CollectService;

public class TestCollectServiceImpl {
	CollectService collectService;
	@Before
	public void setUp() throws Exception {
		collectService=new CollectServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getMyCollectList() {
		List<Song> list=new ArrayList<Song>();
		list=collectService.getMyCollectList(1, 1, 10);
		for (Song song : list) {
			System.out.println(song.toString());
		}
	}
	@Test
	public void getTotalPage(){
		int num=collectService.getTotalPage(1, 10);
		System.out.println(num);
	}
	@Test
	public void add(){
		Collect collect=new Collect();
		collect.setSongId(2);
		collect.setUserId(1);
		collectService.add(collect);
	}
	
	@Test
	public void delete(){
		collectService.delete(5);
	}
	

}
