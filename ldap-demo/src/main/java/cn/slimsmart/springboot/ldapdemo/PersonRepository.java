package cn.slimsmart.springboot.ldapdemo;

import org.springframework.data.repository.CrudRepository;

import javax.naming.Name;

/**
 * Created by zhutw on 2018/3/5.
 */
public interface PersonRepository extends CrudRepository<Person, Name> {
}
