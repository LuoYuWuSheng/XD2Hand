package site.luoyu.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import site.luoyu.model.BoolResult;
import site.luoyu.model.UserModel;
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
        UserModel userModel = new UserModel();
        model.addAttribute("user", userModel);
        return "TileLogin";
    }

    /**
     * 注册 返回注册页面
     */
    @RequestMapping("/registerPage")
    public String getRegisterPage(Model model){
        log.info("进入注册页面");
        UserModel userModelRegister = new UserModel();
        model.addAttribute("user", userModelRegister);
        return "/register";
    }

    /**
     * 用户填好信息后将信息回传保存
     * @param userModel
     *      用户的信息
     * @return
     *      返回注册成功的页面
     */
    @RequestMapping("/register")
    public String register(@Valid UserModel userModel, Model model){
        log.info("确认注册");
        model.addAttribute("user", userModel);
        if(userService.register(userModel))return "redirect:/userAction/MainPage";
        else return "TileRegister";
    }

    //临时调试
    @RequestMapping("/userNameExist")
    public String registerTemp(HttpServletRequest request,Model model){
        UserModel userModel = new UserModel();
        userModel.setName(request.getParameter("username"));
        UserModel registerUserModel = userService.login(userModel);
        BoolResult result = new BoolResult();
        result.setResult(false);
        if (registerUserModel != null){
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
        UserModel userModel = new UserModel();
        userModel.setName(request.getParameter("username"));
        userModel.setPasswd(request.getParameter("userpwd"));
//        User registerUser = userService.login(user);
        BoolResult result = new BoolResult();
        result.setResult(false);
        log.info("确认注册");
        model.addAttribute("user", userModel);
        if(userService.register(userModel))result.setResult(true);
//        else result.setResult(false);
        return "modelJackson";
    }

    /**
     * 登陆
     */
    @RequestMapping("/login")
    public String login(@Validated UserModel userModel, Model model, HttpSession session){
        log.info("用户登陆");
        UserModel loginUserModel = userService.login(userModel);
        if(loginUserModel != null){
            model.addAttribute("user", loginUserModel);
            //将user注入session 保持持久登陆
            session.setAttribute("user", loginUserModel);
            return "redirect:/userAction/MainPage";
        }else {
            model.addAttribute("user", userModel);
            model.addAttribute("message","登录失败！用户名或密码错误");
            return "TileLogin";
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
        UserModel userModel = new UserModel();
        userModel.setName(request.getParameter("username"));
        userModel.setPasswd(request.getParameter("userpwd"));
        UserModel loginUserModel = userService.login(userModel);

        BoolResult login = new BoolResult();
        login.setResult(false);

        if(loginUserModel != null){
            //将user注入session 保持持久登陆
            session.setAttribute("user", loginUserModel);
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
        UserModel userModel = (UserModel) session.getAttribute("user");
        model.addAttribute("user", userModel);
        return "TileProfile";
    }
    /**
     * 编辑个人信息
     */
    @RequestMapping("/editInfo")
    public String editInfo(@Validated UserModel userModel){
        log.info("编辑个人信息");
        userService.updateInfo(userModel);
        return "redirect:/userAction/MainPage";
    }
}
