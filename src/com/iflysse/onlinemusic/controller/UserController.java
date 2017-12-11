package com.iflysse.onlinemusic.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iflysse.onlinemusic.po.User;
import com.iflysse.onlinemusic.service.UserService;

@Controller
@Scope("prototype")
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(HttpSession session,String email,String password){
		ModelAndView mv=new ModelAndView("login");
		
		User user=userService.getUser(email, password);
		
		if(user!=null){
			session.setAttribute("CurrentUser", user);
			mv.setViewName("redirect:/index");
		}else{
			String error="账号或密码错误";
			mv.addObject("error", error);
			mv.addObject("account", email);
		}
		return mv;
	}
	
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(){
		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(User user,String password1){
		ModelAndView mv=new ModelAndView("register");
		if(user.getEmail()==""){
			mv.addObject("emailmsg", "邮箱不能为空");
			return mv;
		}
		if(user.getNname()==""){
			mv.addObject("namemsg", "昵称不能为空");
			return mv;
		}
		if(user.getPassword()==""){
			mv.addObject("passwordmsg", "密码不能为空");
			return mv;
		}
		if(password1==""){
			mv.addObject("password1msg", "确认密码不能为空");
			return mv;
		}
		if(!user.getPassword().equals(password1)){
			mv.addObject("pwdmsg", "两次密码不一致");
			return mv;
		}
		
		userService.add(user);
		mv.setViewName("redirect:/login");
		return mv;
	}
	
	@RequestMapping(value="/usercancel")
	public String userCancel(HttpSession session){
		session.removeAttribute("CurrentUser");
		return "redirect:/login";
	}
}
