package cn.slimsmart.springboot.helloworld.service;

import java.util.List;

import cn.slimsmart.springboot.helloworld.entity.User;

public interface UserServie {
  String sayHello(long id);

  Long addUser(User user);

  List<User> findList();
}
