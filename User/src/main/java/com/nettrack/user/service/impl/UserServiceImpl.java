package com.nettrack.user.service.impl;

import org.jboss.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nettrack.user.bean.UserBean;
import com.nettrack.user.entity.User;
import com.nettrack.user.exception.RecordNotFoundException;
import com.nettrack.user.repository.UserRepository;
import com.nettrack.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserBean registerNewUser(UserBean userInfo) {
		logger.info("register method called...");
		User user = new User();
		user.setStatus(1); // By Default status is logged out
		BeanUtils.copyProperties(userInfo, user);
		user = userRepository.save(user);
		userInfo = new UserBean();
		BeanUtils.copyProperties(user, userInfo);
		logger.info("register method Ended...");
		return userInfo;
	}

	@Override
	public UserBean login(String email, String password) {
		logger.info("login method called...");
		User user = new User();
		UserBean userInfo = new UserBean();

		user = userRepository.findByEmail(email);

		if (null != user) {
			logger.info(email + " is a valid Email");
			user = userRepository.findByEmailAndPassword(email, password);
			if (null == user) {
				
			} else {
				logger.info("User Data : " + user.toString());
				if (user.getStatus()==0) {
					logger.info(" User account has been disabled");
					throw new RecordNotFoundException("User Account has been disabled");
				}else {
					user.setStatus(2);// logged in status updated
					user = userRepository.save(user);
				}
				BeanUtils.copyProperties(user, userInfo);
				logger.info("UserInfo Data : " + userInfo.toString());
			}
		} else {
			logger.info(email + " is an invalid Email");
			throw new RecordNotFoundException("Invalid Email");
		}
		logger.info("login method Ended...");
		return userInfo;
	}

	@Override
	public UserBean logout(long userId) {
		logger.info("logout method called...");
		User user = new User();
		UserBean userInfo = new UserBean();

		user = userRepository.findByUserID(userId);

		if(null != user) {
			user.setStatus(1); //logged out status updated
		}
		
		user = userRepository.save(user);
		BeanUtils.copyProperties(user, userInfo);
		
		return userInfo;

	}

	
}
