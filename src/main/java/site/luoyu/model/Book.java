package site.luoyu.model;

import org.springframework.stereotype.Component;
import site.luoyu.dao.entity.Books;

import java.util.Date;

/**
 * Created by luoyu on 2018/3/7.
 */
@Component
public class Book {
    private int bookId;
    private String pictures;
    private Date publishDate;
    private Float price;
    private String name;

    /**
     * 无参数构造函数
     */
    public Book() {
    }

    //从entity直接构造
    public Book(Books book){
        this.bookId = book.getBookId();
        this.pictures = book.getPictures();
        this.publishDate = book.getPublishDate();
        this.price = book.getPrice();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

}
