package site.luoyu;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;


/**
 * Created by luoyu on 2018/3/7.
 */

@RunWith(SpringJUnit4ClassRunner.class)
//todo 不加web容器环境会怎样
@WebAppConfiguration()
@ContextConfiguration( locations = {
        "file:src/main/webapp/WEB-INF/applicationContext.xml",
        "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class SpringContext {
    @Autowired
    public WebApplicationContext context;
}
