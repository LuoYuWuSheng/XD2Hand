package site.luoyu.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import site.luoyu.model.BoolResult;
import site.luoyu.model.User;
import site.luoyu.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Computer user luoyu
 * Created by 张洋 on 2018/3/7.
 */

@Controller
@RequestMapping(value = "/userManage")
public class UserManager {

    private static final Logger log = LogManager.getLogger(UserManager.class);

    @Autowired
    private UserService userService;

    /**
     * 返回登录页面
     * @param model
     * @return
     */
    @RequestMapping("/loginPage")
    public String getLoginPage(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "login";
    }

    /**
     * 注册 返回注册页面
     */
    @RequestMapping("/registerPage")
    public String getRegisterPage(Model model){
        log.info("进入注册页面");
        User userRegister = new User();
        model.addAttribute("user",userRegister);
        return "/register";
    }

    /**
     * 用户填好信息后将信息回传保存
     * @param user
     *      用户的信息
     * @return
     *      返回注册成功的页面
     */
    //todo 注册乱码问题
    @RequestMapping("/register")
    public String register(@Valid User user, Model model){
        log.info("确认注册");
        model.addAttribute("user",user);
        if(userService.register(user))return "redirect:/userAction/MainPage";
        else return "register";
    }

    //临时调试
    @RequestMapping("/userNameExist")
    public String registerTemp(HttpServletRequest request,Model model){
        User user = new User();
        user.setName(request.getParameter("username"));
        User registerUser = userService.login(user);
        BoolResult result = new BoolResult();
        result.setResult(false);
        if (registerUser != null){
            result.setResult(true);
        }
        log.info("用户判断注册名称是否存在");
        model.addAttribute(result);
//        if(userService.register(user))return "redirect:/userAction/MainPage";
        return "modelJackson";
    }

    //临时调试
    @RequestMapping("/registerTemp")
    public String registerTempDo(HttpServletRequest request,Model model){
        User user = new User();
        user.setName(request.getParameter("username"));
        user.setPasswd(request.getParameter("userpwd"));
        user.setPhoneNumber(request.getParameter("usertel"));
        user.setEmail(request.getParameter("useremail"));
//        User registerUser = userService.login(user);
        BoolResult result = new BoolResult();
        result.setResult(false);
        log.info("确认注册");
        model.addAttribute("user",user);
        if(userService.register(user))result.setResult(true);
//        else result.setResult(false);
        return "modelJackson";
    }

    /**
     * 登陆
     */
    @RequestMapping("/login")
    public String login(@Validated User user,Model model,HttpSession session){
        log.info("用户登陆");
        User loginUser = userService.login(user);
        if(loginUser != null){
            model.addAttribute("user",loginUser);
            //将user注入session 保持持久登陆
            session.setAttribute("user",loginUser);
            return "redirect:/userAction/MainPage";
        }else {
            model.addAttribute("message","登录失败！用户名或密码错误");
            return "login";
        }
    }

    /**
     * 调试 临时
     * 回去需要看看spring能不能支持直接将用户发送的表单内容转换成对象
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/loginTemp")
    public String loginTmp(HttpServletRequest request, Model model, HttpSession session){
        log.info("用户登陆");
        User user = new User();
        user.setName(request.getParameter("username"));
        user.setPasswd(request.getParameter("userpwd"));
        User loginUser = userService.login(user);

        BoolResult login = new BoolResult();
        login.setResult(false);

        if(loginUser != null){
            //将user注入session 保持持久登陆
            session.setAttribute("user",loginUser);
//            return "modelJackson";
            login.setResult(true);
        }
        model.addAttribute(login);
        return "modelJackson";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        log.info("删除用户信息并退出登陆状态");
        //清除用户在session中的信息
        session.invalidate();
        return "redirect:/userAction/MainPage";
    }

    @RequestMapping("/editInfoPage")
    public String profilePage(Model model, HttpSession session) {
        log.info("用户编辑个人信息 ");
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "profile";
    }
    /**
     * 编辑个人信息
     */
    @RequestMapping("/editInfo")
    public String editInfo(@Validated User user){
        log.info("编辑个人信息");
        userService.updateInfo(user);
        return "redirect:/userAction/MainPage";
    }
}
