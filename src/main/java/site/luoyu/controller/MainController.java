package site.luoyu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Computer user luoyu
 * Created by 张洋 on 2018/3/7.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping()
    public String homeRedirect() {
        return "redirect:/userAction/MainPage";
    }
}

