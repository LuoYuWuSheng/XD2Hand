package site.luoyu.model;

import org.springframework.stereotype.Component;
import site.luoyu.dao.entity.Books;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by luoyu on 2018/3/7.
 */
@Component
public class BookModel {
    private int bookId;
    private String pictures;
    private Date publishDate;
    private Float price;
    private Integer userId;
    private String title;
    private String subtitle;
    private String detail;
    private Integer num;

    /**
     * 无参数构造函数
     */
    public BookModel() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    //从entity直接构造
    public BookModel(Books book){
        this.bookId = book.getBookId();
        this.userId = book.getUserId();
        this.pictures = book.getPictures();
        this.publishDate = book.getPublishDate();
        this.price = book.getPrice();
        this.detail = book.getDetail();
        this.title = book.getTitle();
        this.subtitle = book.getSubtitle();
        this.num = book.getNum();
    }


    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String formatDate(){
        return new SimpleDateFormat("yyyy-MM-dd").format(publishDate);
    }
}
