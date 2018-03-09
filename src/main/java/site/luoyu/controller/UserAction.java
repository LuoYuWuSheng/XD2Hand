package site.luoyu.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import site.luoyu.dao.entity.Books;
import site.luoyu.model.BookModel;
import site.luoyu.model.UserModel;
import site.luoyu.service.BooksService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Computer user luoyu
 * Created by 张洋 on 2018/3/7.
 */
@Controller
@RequestMapping("/userAction")
public class UserAction {

    private static final Logger log = LogManager.getLogger(UserAction.class);

    @Autowired
    private BooksService booksService;

    /**
     * 返回发布图书页面
     * @param model
     * @return
     *      上传图书页面
     */
    @RequestMapping("/publishBookPage")
    public String getPublishBookPage(Model model){
        BookModel bookModel = new BookModel();
//        model.addAttribute("book", bookModel);
        return "TileUploadBooks";
    }

    /**
     * 发布用户图书
     * @throws IOException
     */
    @RequestMapping(value = "/publishBook",method = RequestMethod.POST)
    public String publishBookSale(MultipartHttpServletRequest multipartHttpServletRequest, HttpSession session) throws IOException {

        Map<String, MultipartFile> fileMap = multipartHttpServletRequest.getFileMap();
        Map BookParameter = multipartHttpServletRequest.getParameterMap();

        //在数据库中存放所上传图片的路径信息
        List<String> path = null;

        log.info("用户 发布图书销售信息 ");
        UserModel userModel = (UserModel) session.getAttribute("user");
        if(userModel == null)return "redirect:/userManage/loginPage";
        else {
            //上传图片封面，并将路径信息保存到数据库
            path = booksService.uploadCover(multipartHttpServletRequest, userModel, fileMap);
        }
        booksService.publishBook(BookParameter,path, userModel);
        return "redirect:/userAction/MainPage";
    }

    /**
     * 浏览主页面
     * @throws JSONException
     */
    @RequestMapping("/MainPage")
    public String browseMainPage(HttpServletRequest request,Model model) throws JSONException{

//        Pageable pageable = QueryTool.buildPageRequest(0, 12, "price");
        List<Books> pages = booksService.getBooksByPage();
        //jstl只支持基本类型的遍历，不支持iterator
        List<Books> booksList = new ArrayList<>();
        booksList.addAll(pages);
        model.addAttribute("pages",booksList);
        log.info("获得图书列表 针对用户的兴趣进行排序显示");
        return "TileMainPage";
    }

    /**
     * 搜索图书
     * 这里是一个难点，如何分词等问题都值得思考
     */
    @RequestMapping("/searchBooks")
    public void searchBooks(){}


    /**
     * 查看购物车，购物车在Session中
     * @param session
     * @return
     */
    @RequestMapping("/disShopCar")
    public String disShopCar(HttpSession session,Model model){
        return "TileShopCar";
    }
}
