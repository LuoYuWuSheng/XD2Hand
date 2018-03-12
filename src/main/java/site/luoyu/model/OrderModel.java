package site.luoyu.model;

import site.luoyu.dao.entity.Orders;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Computer user luoyu
 * Created by 张洋 on 2018/3/10.
 */
public class OrderModel {
    private String orderid;

    private Integer sellerId;

    private Integer buyerId;

    private Integer bookId;

    private String bookTitle;

    private Float bookPrice;

    private Integer bookNum;

    private Date orderdate;

    private String bookPicture;

    public OrderModel() {
    }

    public OrderModel(Orders orders) {
        this.orderid = orders.getOrderid();
        this.sellerId = orders.getSellerId();
        this.buyerId = orders.getBuyerId();
        this.bookId = orders.getBookId();
        this.bookTitle = orders.getBookTitle();
        this.bookPrice = orders.getBookPrice();
        this.bookNum = orders.getBookNum();
        this.orderdate = orders.getOrderdate();
        this.bookPicture = orders.getBookPicture();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle == null ? null : bookTitle.trim();
    }

    public Float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getBookPicture() {
        return bookPicture;
    }

    public void setBookPicture(String bookPicture) {
        this.bookPicture = bookPicture == null ? null : bookPicture.trim();
    }

    public String formatDate(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(orderdate);
    }
}
