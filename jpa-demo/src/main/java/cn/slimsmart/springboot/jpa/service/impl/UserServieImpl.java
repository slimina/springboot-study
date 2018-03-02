package cn.slimsmart.springboot.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.slimsmart.springboot.jpa.dao.UserRepository;
import cn.slimsmart.springboot.jpa.entity.User;
import cn.slimsmart.springboot.jpa.service.UserServie;

@Service
public class UserServieImpl implements UserServie{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findList() {
		return userRepository.findAll();
	}

	@Transactional
	@Override
	public Long addUser(User user) {
		userRepository.save(user);
		return user.getId();
	}

	@Override
	public User findByName(String name) {
		return userRepository.findUser(name);
	}
}
