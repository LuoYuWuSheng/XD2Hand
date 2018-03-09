package site.luoyu.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.luoyu.service.BooksService;

/**
 * Computer user luoyu
 * Created by 张洋 on 2018/3/9.
 */
@Controller
@RequestMapping("/BooksControl")
public class BooksControl {
    private static Logger logger = LogManager.getLogger(ForLearn.class);

    @Autowired
    BooksService booksService;

}
