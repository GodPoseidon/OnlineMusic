package com.iflysse.onlinemusic.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iflysse.onlinemusic.po.Collect;
import com.iflysse.onlinemusic.po.Song;
import com.iflysse.onlinemusic.po.User;
import com.iflysse.onlinemusic.service.CollectService;
import com.iflysse.onlinemusic.service.SongService;

@Controller
@Scope("prototype")
public class SongController {
	@Resource(name="songService")
	private SongService service;
	@Resource(name="collectService")
	private CollectService collectService;
	
	@RequestMapping(value="/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/person/allsong",method=RequestMethod.GET)
	public ModelAndView allSong(){
		ModelAndView mv=new ModelAndView("allsong");
		List<Song> list=service.getSongList(1, 5);
		int totalPage=service.getTotalPage(5);
		
		mv.addObject("totalPage", totalPage);
		mv.addObject("songlist", list);
		mv.addObject("pageIndex", 1);

		return mv;
	}
	
	@RequestMapping(value="/person/allsong",method=RequestMethod.POST)
	public ModelAndView allSong(int pageIndex){
		ModelAndView mv=new ModelAndView("allsong");
		List<Song> list=service.getSongList(pageIndex, 5);
		int totalPage=service.getTotalPage(5);
		mv.addObject("totalPage", totalPage);
		mv.addObject("songlist", list);
		mv.addObject("pageIndex", pageIndex);
		return mv;
	}
	
	@RequestMapping(value="/person/mysongs",method=RequestMethod.GET)
	public ModelAndView mySongs(HttpSession session){
		ModelAndView mv=new ModelAndView("mysongs");
		
		User user=(User)session.getAttribute("CurrentUser");
		List<Song>list=service.getMySongList(user.getId(), 1, 5);
		int totalPage=service.getMyTotalPage(user.getId(), 5);
		mv.addObject("mysonglist", list);
		mv.addObject("pageIndex", 1);
		mv.addObject("totalPage", totalPage);
		return mv;
	}
	
	@RequestMapping(value="/person/mysongs",method=RequestMethod.POST)
	public ModelAndView mySongs(HttpSession session,int pageIndex){
		ModelAndView mv=new ModelAndView("mysongs");
		User user=(User)session.getAttribute("CurrentUser");
		List<Song>list=service.getMySongList(user.getId(),pageIndex, 5);
		int totalPage=service.getMyTotalPage(user.getId(), 5);
		
		mv.addObject("totalPage", totalPage);
		mv.addObject("mysonglist", list);
		mv.addObject("pageIndex", pageIndex);
		
		return mv;
	}
	
	@RequestMapping(value="/person/mycollect",method=RequestMethod.GET)
	public ModelAndView myCollect(HttpSession session){
		ModelAndView mv=new ModelAndView("mycollect");
		User user=(User)session.getAttribute("CurrentUser");
		List<Song> list=(List<Song>)collectService.getMyCollectList(user.getId(), 1, 5);
		int totalPage=collectService.getTotalPage(user.getId(), 5);
		mv.addObject("mycollect", list);
		mv.addObject("pageIndex", 1);
		mv.addObject("totalPage", totalPage);
		return mv;
	}
	
	@RequestMapping(value="/person/mycollect",method=RequestMethod.POST)
	public ModelAndView myCollect(HttpSession session,int pageIndex){
		ModelAndView mv=new ModelAndView("mycollect");
		User user=(User)session.getAttribute("CurrentUser");
		List<Song> list=(List<Song>)collectService.getMyCollectList(user.getId(), pageIndex, 5);
		int totalPage=collectService.getTotalPage(user.getId(), 5);
		mv.addObject("mycollect", list);
		mv.addObject("pageIndex", pageIndex);
		mv.addObject("totalPage", totalPage);
		return mv;
	}
	
	@RequestMapping(value="/person/collectdelete")
	public String collectDelete(int collectid){
		collectService.delete(collectid);
		return "redirect:/person/mycollect";
	}
	
	@RequestMapping(value="/person/edit",method=RequestMethod.GET)
	public ModelAndView edit(int songid){
		ModelAndView mv=new ModelAndView("edit");
		Song song=service.getSong(songid);
		mv.addObject("song", song);
		return mv;
	}
	
	@RequestMapping(value="/person/edit",method=RequestMethod.POST)
	public ModelAndView edit(Song song,HttpSession session){
		ModelAndView mv=new ModelAndView("redirect:/person/mysongs");
		
		User user=(User)session.getAttribute("CurrentUser");
		song.setUserId(user.getId());
		song.setPath(null);
		song.setUpLoadDate(new Date());
		
		service.update(song);
		mv.addObject("song", song);
		return mv;
	}
	
	@RequestMapping(value="/person/songdelete",method=RequestMethod.GET)
	public String songDelete(int songid){
		service.delete(songid);
		return "redirect:/person/mysongs";
	}
	
	@RequestMapping(value="/person/upsong",method=RequestMethod.GET)
	public String upSong(){
		return "upsong";
	}
	
	@RequestMapping(value="/person/upsong",method=RequestMethod.POST)
	public String upSong(HttpSession session,HttpServletRequest request){
		boolean  sucess=processUpload(request);
	if(sucess){
			User user=(User)session.getAttribute("CurrentUser");
			String song=request.getAttribute("song").toString();
			String singer=request.getAttribute("singer").toString();
			String special=request.getAttribute("special").toString();
			String path=request.getAttribute("fileServer").toString();
			Song sg=new Song();
			sg.setSinger(singer);
			sg.setSpecial(special);
			sg.setSong(song);
			sg.setUpLoadDate(new Date());
			sg.setPath(path);
			sg.setUserId(user.getId());
			service.add(sg);
			return "redirect:/person/mysongs";
	}
		return "upsong";
	}
	
	private boolean processUpload(HttpServletRequest request) {
		boolean success = true;
		String message = null;
		// 获取文件需要上传到的路径
		String path = request.getServletContext().getRealPath("/file");
		// 如果此文件夹不存在，则构造此文件夹
		File f = new File(path);
		if (!f.exists()) {
			f.mkdir();
		}
		// 构造出文件工厂，用于存放JSP页面中传递过来的文件
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置上传文件的保存路径
		factory.setRepository(f);
		// 设置缓存大小，如果文件大于缓存大小时，则先把文件放到缓存中
		factory.setSizeThreshold(1 * 1024 * 1024);

		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置可以上传文件大小的上界20MB
		upload.setSizeMax(20 * 1024 * 1024);
		try {
			// 可以上传多个文件
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			for (FileItem item : list) {
				// 获取表单的属性名字
				String name = item.getFieldName();

				if (item.isFormField()) {
					String value = item.getString();
					//解决乱码问题
					value = new String(value.getBytes("iso-8859-1"),"utf-8"); 
					request.setAttribute(name, value);
				} else {
					// 获得文件类型
					String contentType = item.getContentType();
					// 获得文件大小
					long fileSize = item.getSize();
					// 获取路径名
					String value = item.getName();
					// 索引到最后一个反斜杠
					int start = value.lastIndexOf("\\");
					// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
					String filename = value.substring(start + 1);

					if (filename != null && !filename.trim().equals("")) {
						// 如果上传的文件不是图片，那么不上传
						String allImgExt = ".mp3|.wma|";
						String extName = filename.substring(filename.indexOf("."), filename.length());
						if (allImgExt.indexOf(extName + "|") == -1) {
							message = "该文件类型不允许上传。请上传 " + allImgExt
									+ " 类型的文件，当前文件类型为" + extName;
							success = false;
							break;
						}
						request.setAttribute(name, filename);
						// 随机数产生名称
						String newName = System.currentTimeMillis() + extName;
						request.setAttribute(name + "Server", newName);
						// 将文件保存到服务器中
						InputStream in = item.getInputStream();
						// 原文件名
						// OutputStream out = new FileOutputStream(new File(path, filename));
						// 随机数文件名
						OutputStream out = new FileOutputStream(new File(path,
								newName));
						int length = 0;
						byte[] buf = new byte[1024];
						while ((length = in.read(buf)) != -1) {
							out.write(buf, 0, length);
						}
						in.close();
						out.close();
					}
				}
			}
		} catch (FileUploadException e) {
			message = "文件的内容过大，请上传小于20MB的文件" ;
			success = false;
			e.printStackTrace();
		} catch (IOException e) {
			success = false;
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		return success;
	}
	
	@RequestMapping(value="/download")
	public void download(int songid,HttpServletRequest request,HttpServletResponse response){
		Song song=service.getSong(songid);
		String fileName=song.getPath();
		String saveName=song.getSong();
		String str=fileName.substring(fileName.lastIndexOf("."));
		
		processDownload(fileName, saveName+str, request, response);
	}
	
	private boolean processDownload(String fileName, String saveName,
			HttpServletRequest request, HttpServletResponse response) {
		boolean success = true;
		// 获取文件下载所在的路径
		String path = request.getServletContext().getRealPath("/file");
		File fileLoad = new File(path, fileName); // 下载文件
		long fileLength = fileLoad.length(); // 文件大小
		byte[] buffer = new byte[1024]; // 缓冲字节数组
		try {
			response.reset();
			response.setHeader("Content-disposition", "attachment;filename=\""
					+ new String(saveName.getBytes("gb2312"), "ISO-8859-1")	+ "\"");
			response.setContentType("application/octet-stream");
			response.setHeader("Content_Length", String.valueOf(fileLength));

			OutputStream os = response.getOutputStream();
			FileInputStream in = new FileInputStream(fileLoad);
			int hasRead = 0;
			while ((hasRead = in.read(buffer)) != -1) {
				os.write(buffer, 0, hasRead);
			}
			os.flush();
			os.close();
			in.close();
		} catch (IOException e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}
	
	@ResponseBody
	@RequestMapping(value="/person/collectsong",produces="text/html; charset=UTF-8")
	public String collectSong(int songid,HttpSession session){
		User user=(User)session.getAttribute("CurrentUser");
		int num=collectService.getCollectCount(songid,user.getId());
		if(num>0){
			return "已在收藏目录";
		}else{
			Collect collect=new Collect();
			collect.setSongId(songid);
			collect.setUserId(user.getId());
			collectService.add(collect);
			return "收藏成功";
		}
	}
	
	@RequestMapping(value="/person/play",method=RequestMethod.GET)
	public ModelAndView play(int songid,String returnUrl){
		ModelAndView mv=new ModelAndView("play");
		Song song=service.getSong(songid);
		mv.addObject("song", song);
		mv.addObject("returnUrl", returnUrl);
		return mv;
		
	}

	@RequestMapping(value="/person/play",method=RequestMethod.POST)
	public String play(String returnUrl){
		return "redirect:"+returnUrl;
	}
}
