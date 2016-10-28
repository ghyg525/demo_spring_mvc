package org.yangjie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yangjie.entity.User;
import org.yangjie.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		return "/login.jsp";	
	}
	
	/**
	 * 处理登录请求
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model, ModelMap modelMap, User user, 
			HttpServletRequest request, HttpServletResponse response) {
		if (userService.isUser(user.getUsername(), user.getPassword())) {
			return "/ok.jsp";
		} else {
			model.addAttribute("msg", "username or password error !!");
			return "/login.jsp";	
		}
	}
	
	
}
