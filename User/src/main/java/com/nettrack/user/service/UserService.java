package com.nettrack.user.service;

import com.nettrack.user.bean.UserBean;


public interface UserService {

	public UserBean registerNewUser(UserBean userInfo);
	
	public UserBean login(String email, String password);

	public UserBean logout(long userId);
}
