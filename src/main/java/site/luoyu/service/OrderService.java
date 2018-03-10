package site.luoyu.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.luoyu.dao.entity.Books;
import site.luoyu.dao.entity.Orders;
import site.luoyu.dao.mapper.BooksMapper;
import site.luoyu.dao.mapper.OrdersMapper;
import site.luoyu.model.OrderModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Computer user luoyu
 * Created by 张洋 on 2018/3/10.
 */
@Service
public class OrderService {
    private static final Logger log = LogManager.getLogger(BooksService.class);

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    BooksMapper booksMapper;

    @Transactional
    public boolean clearShopCar(List<OrderModel> orderModels){
        for (OrderModel one : orderModels) {
            Orders order = new Orders();
            order.setBookId(one.getBookId());
            order.setSellerId(one.getSellerId());
            order.setBuyerId(one.getBuyerId());
            order.setBookNum(one.getBookNum());
            order.setOrderdate(one.getOrderdate());
            order.setBookTitle(one.getBookTitle());
            order.setBookPicture(one.getBookPicture());
            order.setBookPrice(one.getBookPrice());
            Books book =booksMapper.selectByPrimaryKey(one.getBookId());
            book.setNum(book.getNum()+one.getBookNum());
            booksMapper.updateByPrimaryKey(book);
            ordersMapper.insert(order);
        }
        return true;
    }

    public List<OrderModel> getfinical(){
        List<Orders> orders= ordersMapper.getAll();
        List<OrderModel> orderModels = new ArrayList<>(orders.size());
        for (Orders order : orders) {
            orderModels.add(new OrderModel(order));
        }
        return orderModels;
    }
}
