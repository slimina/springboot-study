package cn.slimsmart.springboot.helloworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.slimsmart.springboot.helloworld.entity.User;
import cn.slimsmart.springboot.helloworld.service.UserServie;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServie userServie;
	
	@RequestMapping(value="/sayHello/{id}",method = RequestMethod.GET)
	public String sayHello(@PathVariable Long id){
		return userServie.sayHello(id);
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
