package site.luoyu;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import site.luoyu.exampleForLearn.aspect.knight;
import site.luoyu.exampleForLearn.aspect.singer;

/**
 * knight Tester.
 *
 * @author 张洋
 * @version 1.0
 * @since <pre>03/07/2018</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = testConfig.class)
public class knightTest {

    @Autowired
    public knight hero;

    @Test
    public void testFight() throws Exception {
        hero.fight();
    }

} 
