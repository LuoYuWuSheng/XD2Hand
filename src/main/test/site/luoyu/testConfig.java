package site.luoyu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import site.luoyu.exampleForLearn.aspect.singer;

/**
 * Computer user luoyu
 * Created by 张洋 on 2018/3/7.
 */
@Configuration
@ImportResource("/testContext.xml")
public class testConfig {
    @Bean
    public singer getSinger() {
        return new singer();
    }
}
