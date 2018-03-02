package cn.slimsmart.springboot.jpa.service;


import java.util.List;

import cn.slimsmart.springboot.jpa.entity.User;

public interface UserServie {
	Long addUser(User user);
	List<User> findList();
	User findByName(String name);
}
