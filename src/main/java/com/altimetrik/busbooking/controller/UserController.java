package com.altimetrik.busbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.busbooking.beans.User;
import com.altimetrik.busbooking.service.UserService;

/**
 * @author Prasath
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/register")
	public String register(@RequestBody User user) {
		return userService.register(user);
	}
	
	@RequestMapping("/update")
	public String update(@RequestBody User user) {
		return userService.update(user);
	}
	
	@RequestMapping("/get")
	public String getUser(@RequestParam String userId) {
		return userService.fetchUser(userId);
	}

}
