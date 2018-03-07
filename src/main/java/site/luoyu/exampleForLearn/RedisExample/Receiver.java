package site.luoyu.exampleForLearn.RedisExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Computer user luoyu
 * Created by 张洋 on 2018/3/7.
 */
@Component
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    public RedisTemplate<Integer, String> template;

    //    @Autowired
//    public Receiver(CountDownLatch latch) {
//        this.latch = latch;
//    }
//
//    public void receiveMessage(String message) {
//        LOGGER.info("Received <" + message + ">");
//        latch.countDown();
//    }
    public void redisPut() {
        template.opsForValue().set(1, "Redis成功");
    }

    public String redisGet() {
        return template.opsForValue().get(1);
    }
}
