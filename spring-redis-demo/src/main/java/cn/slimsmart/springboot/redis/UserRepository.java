package cn.slimsmart.springboot.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "users")
public class UserRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    @Cacheable(key = "#name")
    public User find(String name) {
        logger.info("查询业务服务");
        return new User(name, 333);
    }

    @CachePut(key = "#p0.username")
    public User modify(User user) {
        logger.info("更新业务服务");
        return new User(user.getUsername(), 100);
    }


    @CacheEvict(key = "#name")
    public void delete(String name) {
        logger.info("删除业务服务");
    }
}
