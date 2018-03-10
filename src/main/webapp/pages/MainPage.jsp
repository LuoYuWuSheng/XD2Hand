<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<div>
    <div id="wrapper">
        <aside>
            <div id="search">
                <h1 style="color: #50e3c2; text-align: left;">CATALOG BOOKS</h1>
                <form action="">
                    <input type="text" placeholder="computer" class="form-control">
                    <select class="form-control">
                        <option value="11">CSS</option>
                        <option value="12">Javascript</option>
                        <option value="13">html</option>
                        <option value="14">jquery</option>
                    </select>
                    <button class="btn">Search</button>
                    <h4 style="color: #50e3c2; text-align: left; margin: 20px 0 20px 0;;">PRICE FILTER</h4>
                    <input type="range" min="1" max="100" id="price">
                    <p><span id="show_price">Price:&yen;18</span></p>
                    <button class="btn">Filter</button>
                </form>

            </div>
            <h4 style="color: #50e3c2; text-align: left; margin: 20px 0 20px 0;">TOP RATED</h4>
            <div id="toprate">
                <ul id="best-selling">
                    <li>
                        <a href="/images/books_images/9780081001943.jpg">
                            <img src="/images/books_images/9780081001943.jpg" alt=""/>
                            <h5>Ageing Skin Care</h5>
                            <p><em>ISBN: 0538482389</em></p>
                            <P><span>Price: &yen; 125</span></P>
                        </a>
                    </li>

                    <li>
                        <a href="/images/books_images/9780080999531.jpg">
                            <img src="/images/books_images/9780080999531.jpg" alt=""/>
                            <h5>Ageing Skin Care</h5>
                            <p><em>ISBN: 0538482389</em></p>
                            <P>Price: &yen; 125</P>
                        </a>
                    </li>

                    <li>
                        <a href="/images/books_images/00796425.jpg">
                            <img src="/images/books_images/00796425.jpg" alt=""/>
                            <h5>Ageing Skin Care</h5>
                            <p><em>ISBN: 0538482389</em></p>
                            <P>Price: &yen; 125</P>
                        </a>
                    </li>
                </ul>
            </div>
        </aside>
        <section class="center">
            <ul id="gallery">
                <c:forEach items="${pages}" var="book">
                    <li>
                        <a href="/Books/detail/${book.bookId}">
                            <img src="${book.pictures}" alt=""/>
                            <h4>
                                <a href="/userAction/MainPage/${book.title}"></a>
                                    ${book.title}
                            </h4>
                            <c:if test="${user != null}">
                                <c:if test="${user.getType()}">
                                    <p>
                                        <em>已售数量: ${book.num}</em>
                                    </p>
                                    <c:if test="${book.num == 0}">
                                        <button style="float: right;margin-right: 10px "
                                                type="button" onclick="window.location.href='/Books/delete/${book.bookId}'"
                                                class="btn">删除</button>
                                    </c:if>
                                </c:if>
                                <c:if test="${user.getType()}">
                                    <hr/>
                                </c:if>
                            </c:if>
                            <p style="color:red;">
                                <div>价格: &yen;${book.price}</div>
                            </p>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </section>
    </div>

    <footer>
        <p>&copy; Copyright 2018 XD2BookStore by ZY.</p>
    </footer>
</div>