package cn.slimsmart.springboot.ehcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "users")
public class UserRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    @Cacheable(key = "#id")
    public String find(String id) {
        logger.info("查询业务服务");
        return id + "-123";
    }

    @CacheEvict(key = "#id")
    public void delete(String id) {
        logger.info("删除业务服务");
    }
}
