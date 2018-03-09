package site.luoyu.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import site.luoyu.dao.entity.Books;
import site.luoyu.model.BookModel;
import site.luoyu.service.BooksService;

import javax.jws.WebParam;
import java.util.Date;

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
        model.addAttribute("book",new BookModel(book));
        return "TileDetail";
    }

    @RequestMapping("/edit/{bookId}")
    public String editBook(@PathVariable("bookId") int bookId, Model model){
        logger.info("卖家编辑商品");
        model.addAttribute("book",new BookModel(booksService.getBookById(bookId)));
        return "TileUploadBooks";
    }

    @RequestMapping("/saveEdit")
    public String saveEdit(@Validated Books book,MultipartHttpServletRequest multipartHttpServletRequest){
        book.setPublishDate(new Date(System.currentTimeMillis()));
        booksService.updateBook(book);
        return "redirect:/Books/detail/"+book.getBookId();
    }


}
