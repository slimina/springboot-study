package cn.slimsmart.springboot.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.slimsmart.springboot.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

  @Query("from User u where u.name=:name")
  User findUser(@Param("name") String name);
}
