/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月4日
 */
package com.zcc.user.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zcc.user.model.User;

/**
 * @author c0z00k8
 *
 */
@Component
public interface UserMapper {

	public List<User> getUser(User user);
}
