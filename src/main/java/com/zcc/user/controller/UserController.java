/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月4日
 */
package com.zcc.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcc.user.model.User;
import com.zcc.user.service.UserService;

/**
 * @author c0z00k8
 *
 */

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUser")
	@ResponseBody
	public String getUser(){
		User user=new User();
		List<User> users = userService.getUser(user);
		return "success result num :"+ users.size();
	}
	
}
