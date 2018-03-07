package site.luoyu.dao.entity;

import java.util.Date;

public class Books {
    private Integer bookId;

    private Integer stuId;

    private Long isbn;

    private String pictures;

    private Integer level;

    private Integer recommendstar;

    private Date publishDate;

    private Integer booktypeid;

    private String typecodeClass;

    private Float price;

    private String name;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures == null ? null : pictures.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getRecommendstar() {
        return recommendstar;
    }

    public void setRecommendstar(Integer recommendstar) {
        this.recommendstar = recommendstar;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getBooktypeid() {
        return booktypeid;
    }

    public void setBooktypeid(Integer booktypeid) {
        this.booktypeid = booktypeid;
    }

    public String getTypecodeClass() {
        return typecodeClass;
    }

    public void setTypecodeClass(String typecodeClass) {
        this.typecodeClass = typecodeClass == null ? null : typecodeClass.trim();
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
        this.name = name == null ? null : name.trim();
    }
}