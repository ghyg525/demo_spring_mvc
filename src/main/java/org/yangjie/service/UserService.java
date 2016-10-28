package org.yangjie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yangjie.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	/**
	 * 按用户名和密码查询用户
	 * @param username
	 */
	public boolean isUser(String username, String password) {
		return userDao.select(username, password) != null;
	}
	
	
}
