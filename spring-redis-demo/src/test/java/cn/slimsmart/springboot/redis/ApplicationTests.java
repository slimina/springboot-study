package cn.slimsmart.springboot.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    @Qualifier("redisTemplateUser")
    private RedisTemplate<String, User> redisTemplateUser;

    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        template.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", template.opsForValue().get("aaa"));
    }

    @Test
    public void test1() throws Exception {
        // 保存对象
        User user = new User("超人", 20);
        redisTemplateUser.opsForValue().set(user.getUsername(), user);

        user = new User("蝙蝠侠", 30);
        redisTemplateUser.opsForValue().set(user.getUsername(), user);

        user = new User("蜘蛛侠", 40);
        redisTemplateUser.opsForValue().set(user.getUsername(), user);

        Assert.assertEquals(20, redisTemplateUser.opsForValue().get("超人").getAge().longValue());
        Assert.assertEquals(30, redisTemplateUser.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(40, redisTemplateUser.opsForValue().get("蜘蛛侠").getAge().longValue());

    }

    @Test
    public void test3() {

        userRepository.find("abc");
        System.out.println(cacheManager.getCache("users").get("abc").get());
        userRepository.modify(new User("abc", 123));
        System.out.println(cacheManager.getCache("users").get("abc").get());

        userRepository.delete("abc");
        System.out.println(cacheManager.getCache("users").get("abc"));
    }

}
