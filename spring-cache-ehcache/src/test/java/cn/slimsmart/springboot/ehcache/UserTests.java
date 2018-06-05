package cn.slimsmart.springboot.ehcache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {

        userRepository.find("abc");
        System.out.println(cacheManager.getCache("users").get("abc").get());
        userRepository.delete("abc");
        System.out.println(cacheManager.getCache("users").get("abc"));
    }
}
