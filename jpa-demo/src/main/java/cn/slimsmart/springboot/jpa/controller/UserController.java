package cn.slimsmart.springboot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.slimsmart.springboot.jpa.entity.User;
import cn.slimsmart.springboot.jpa.service.UserServie;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServie userServie;
	
	@RequestMapping(value="/findByName/{name}",method = RequestMethod.GET)
	public User sayHello(@PathVariable String name){
		return userServie.findByName(name);
	}
	@RequestMapping(value="",method = RequestMethod.POST)
	public Long save(@RequestBody User user){
		return userServie.addUser(user);
	}
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public List<User> list(){
		return userServie.findList();
	}
}
