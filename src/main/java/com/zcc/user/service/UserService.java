/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月4日
 */
package com.zcc.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcc.user.mapper.UserMapper;
import com.zcc.user.model.User;

/**
 * @author c0z00k8
 *
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> getUser(User user){
		return userMapper.getUser(user);
	}
	
}
