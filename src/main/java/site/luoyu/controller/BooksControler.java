package site.luoyu.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import site.luoyu.dao.entity.Books;
import site.luoyu.dao.entity.User;
import site.luoyu.model.UserModel;
import site.luoyu.service.BooksService;

import javax.servlet.http.HttpSession;

/**
 * Computer user luoyu
 * Created by 张洋 on 2018/3/9.
 */
@Controller
@RequestMapping("/Books")
public class BooksControler {
    private static Logger logger = LogManager.getLogger(ForLearn.class);

    @Autowired
    BooksService booksService;

    @RequestMapping("/detail/{bookId}")
    public String getDetail(@PathVariable("bookId") int bookId, Model model){
        logger.info("用户查看商品详情");
        Books book = booksService.getBookById(bookId);
        model.addAttribute("book",book);
        return "TileDetail";
    }

    @RequestMapping("/edit")
    public String editBook(@Validated Books book){
        logger.info("买家编辑商品");
        booksService.updateBook(book);
        return "redirect:/Books/detail/"+book.getBookId();
    }

}
