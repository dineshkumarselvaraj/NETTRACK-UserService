package com.nettrack.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nettrack.user.bean.UserBean;
import com.nettrack.user.service.UserService;

@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserBean> addUserData(@Valid @RequestBody UserBean user) {
		return new ResponseEntity<>(userService.registerNewUser(user),HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public ResponseEntity<UserBean> login(@Valid @RequestParam String email,@Valid @RequestParam String password) {
		return new ResponseEntity<>(userService.login(email, password),HttpStatus.OK);
	}
	
	@PutMapping("/logout")
	public ResponseEntity<UserBean> logout(@RequestParam long userId) {
		return new ResponseEntity<>(userService.logout(userId),HttpStatus.OK);
	}
}
