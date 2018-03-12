package site.luoyu.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import site.luoyu.dao.entity.Books;
import site.luoyu.model.BookModel;
import site.luoyu.model.OrderModel;
import site.luoyu.model.UserModel;
import site.luoyu.service.BooksService;
import site.luoyu.service.OrderService;

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
    private List<OrderModel> orders = new LinkedList<>();
    @Autowired
    private BooksService booksService;

    @Autowired
    OrderService orderService;
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

        Map BookParameter = multipartHttpServletRequest.getParameterMap();
        log.info("用户 发布图书销售信息 ");
        UserModel userModel = (UserModel) session.getAttribute("user");
        if(userModel == null)return "redirect:/userManage/loginPage";
        booksService.publishBook(BookParameter,multipartHttpServletRequest, userModel);
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
        model.addAttribute("rate",booksService.topRate());
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
        model.addAttribute("orders",orders);
        float money = 0;
        for (OrderModel order : orders)
            money+=(order.getBookPrice()*order.getBookNum());
        model.addAttribute("money",money);
        return "TileShopCar";
    }

    @RequestMapping("/addToCar")
    @ResponseBody
    public String addToCar(HttpServletRequest request){
        log.info("添加到购物车");
        int bookId = Integer.parseInt(request.getParameter("id"));
        int num = Integer.parseInt(request.getParameter("num"));
        Books book = booksService.getBookById(bookId);
        OrderModel orderModel = new OrderModel();
        orderModel.setBookId(bookId);
        orderModel.setBookNum(num);
        orderModel.setBookPicture(book.getPictures());
        orderModel.setBookPrice(book.getPrice());
        orderModel.setBookTitle(book.getTitle());
        orderModel.setBuyerId(1);
        orderModel.setOrderdate(new Date(System.currentTimeMillis()));
        orderModel.setSellerId(2);
        orders.add(orderModel);
        return "success";
    }

    @RequestMapping("/clearShopCar")
    public String clearShopCar(){
        orderService.clearShopCar(orders);
        orders.clear();
//        这个需求中没说让跳到哪
        return "redirect:/userAction/MainPage";
    }

    @RequestMapping("/showOrders")
    public String showOrders(Model model){
        List<OrderModel> orders;
        orders = orderService.getfinical();
        float money = 0;
        for (OrderModel order : orders)
            money+=(order.getBookPrice()*order.getBookNum());
        model.addAttribute("orders",orders);
        model.addAttribute("money",money);
        return "TileFinical";
    }

    @RequestMapping("/search")
    public String search(Model model,HttpServletRequest request){
        String name = request.getParameter("search");
        List<Books> booksList = booksService.search(name);
        model.addAttribute("pages",booksList);
        model.addAttribute("rate",booksService.topRate());
        return "TileMainPage";
    }
}
