package site.luoyu.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.luoyu.exampleForLearn.RedisCache;
import site.luoyu.exampleForLearn.RedisExample.Receiver;
import site.luoyu.model.UserModel;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Computer user luoyu
 * Created by 张洋 on 2018/3/7.
 */
@Controller
@RequestMapping("/learn")
public class ForLearn {

    private static Logger logger = LogManager.getLogger(ForLearn.class);

    @RequestMapping()
    public String getTestView(Model model) {
        logger.info("记录日志，看日志器是否能够拦截");
        model.addAttribute("User", new UserModel());
        return "test/testForm";
    }

    // TODO: 2017/2/21 Valid 还没有试验完
    @RequestMapping(value = "testForm", produces = "text/plain")
    @ResponseBody
    public String testForm(@Valid UserModel userModel, Errors errors, HttpSession session, HttpServletResponse response) {
        if (errors.hasErrors()) return "test/testForm";
        session.setAttribute("test", "hellow this is my test to test whether Ajax can get session");
        return "用户名：" + userModel.getName() + " 密码:" + userModel.getPasswd();
//        return "用户名：" + user.getName() + " 密码:" + user.getPasswd();
    }

    @RequestMapping("/testJson")
    @ResponseBody
    public UserModel testJson(@RequestBody UserModel userModel, HttpSession session) {
        System.out.println(userModel.getName() + " " + userModel.getPasswd());
        String sessionString = (String) session.getAttribute("test");
        System.out.println(sessionString);
        return userModel;
    }

    private RedisCache cache;

    private Receiver receiver;

    @Autowired
    public void setCache(RedisCache cache) {
        this.cache = cache;
    }

    @Autowired
    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @RequestMapping("/cache")
    public void cache() {
        cache.testCache(1);
        //receiver.redisPut();
        //System.out.println(receiver.redisGet());
    }


}

