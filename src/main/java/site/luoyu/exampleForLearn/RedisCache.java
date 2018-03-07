package site.luoyu.exampleForLearn;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Computer user luoyu
 * Created by 张洋 on 2018/3/7.
 */
@Component
@Cacheable
public class RedisCache {
    @CachePut(value = "cacheTest", key = "2")
    public String testCache(int id) {
        return "result";
    }
}

