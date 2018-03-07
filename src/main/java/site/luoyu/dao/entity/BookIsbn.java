package site.luoyu.dao.entity;

import java.util.Date;

public class BookIsbn {
    private Long isbnId;

    private String isbn10;

    private String isbn13;

    private String title;

    private String image;

    private String author;

    private String translator;

    private String publisher;

    private Date pubdate;

    private String binding;

    private Float price;

    private Short pages;

    public Long getIsbnId() {
        return isbnId;
    }

    public void setIsbnId(Long isbnId) {
        this.isbnId = isbnId;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10 == null ? null : isbn10.trim();
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13 == null ? null : isbn13.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator == null ? null : translator.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding == null ? null : binding.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Short getPages() {
        return pages;
    }

    public void setPages(Short pages) {
        this.pages = pages;
    }
}