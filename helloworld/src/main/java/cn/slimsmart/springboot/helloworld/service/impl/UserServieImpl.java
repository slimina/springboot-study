package cn.slimsmart.springboot.helloworld.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import cn.slimsmart.springboot.helloworld.entity.User;
import cn.slimsmart.springboot.helloworld.service.UserServie;

@Service
public class UserServieImpl implements UserServie{
	
	private List<User> datas = new LinkedList<User>();
	private AtomicLong idSeed = new AtomicLong(10000);
	
	@Override
	public List<User> findList() {
		return datas;
	}

	@Override
	public String sayHello(long id) {
		for(User user : datas){
			if(id == user.getId()){
				return "hello "+user.getName();
			}
		}
		return "not found";
	}

	@Override
	public Long addUser(User user) {
		user.setId(idSeed.getAndIncrement());
		datas.add(user);
		return user.getId();
	}
}
