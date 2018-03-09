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
    private Integer stuId;
    private long isbn_id;
    private String pictures;
    private Integer level;
    private Integer recommendStar;
    private Date publishDate;
    private Integer bookTypeId;
    private String typeCodeClass;
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
        this.stuId = book.getUserId();
        this.pictures = book.getPictures();
        this.publishDate = book.getPublishDate();
        this.price = book.getPrice();
    }


    public long getIsbn() {
        return isbn_id;
    }

    public void setIsbn(long isbn) {
        this.isbn_id = isbn;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getRecommendStar() {
        return recommendStar;
    }

    public void setRecommendStar(Integer recommendStar) {
        this.recommendStar = recommendStar;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Integer bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getTypeCodeClass() {
        return typeCodeClass;
    }

    public void setTypeCodeClass(String typeCodeClass) {
        this.typeCodeClass = typeCodeClass;
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

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }
}
