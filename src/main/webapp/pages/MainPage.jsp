<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<div>
    <div id="wrapper">
        <aside>
            <div id="search">
                <h1 style="color: #50e3c2; text-align: left;">CATALOG BOOKS</h1>
                <form action="/userAction/search">
                    <input type="text" name="search" placeholder="computer" class="form-control">
                    <button class="btn">Search</button>
                    <%--<h4 style="color: #50e3c2; text-align: left; margin: 20px 0 20px 0;;">PRICE FILTER</h4>--%>
                    <%--<input type="range" min="1" max="100" id="price">--%>
                    <%--<p><span id="show_price">Price:&yen;18</span></p>--%>
                    <%--<button class="btn">Filter</button>--%>
                </form>
                <select id="showWhat" class="form-control" onchange="disNotBuy()">
                    <option value="11">所有商品</option>
                    <option value="12">只看未购买</option>
                </select>

            </div>
            <h4 style="color: #50e3c2; text-align: left; margin: 20px 0 20px 0;">畅销榜</h4>
            <div id="toprate">
                <ul id="best-selling">
                    <%--<li>--%>
                        <%--<a href="/images/books_images/9780081001943.jpg">--%>
                            <%--<img src="/images/books_images/9780081001943.jpg" alt=""/>--%>
                            <%--<h5>Ageing Skin Care</h5>--%>
                            <%--<p><em>ISBN: 0538482389</em></p>--%>
                            <%--<P><span>Price: &yen; 125</span></P>--%>
                        <%--</a>--%>
                    <%--</li>--%>

                    <c:forEach items="${rate}" var="one">
                        <li style="position: relative">
                            <a href="/Books/detail/${one.bookId}">
                                <img style="height: 232px;width: 188px;" src="${one.pictures}" alt=""/>
                                <c:if test="${user !=null }">
                                    <c:if test="${!user.getType() && one.num>0}">
                                    <span class="had">
                                        <b>已购买</b>
                                    </span>
                                    </c:if>
                                </c:if>
                                <h4 style="width: 188px;text-overflow: clip;overflow: hidden;white-space: nowrap;">
                                    <a href="/userAction/MainPage/${one.title}"></a>
                                        ${one.title}
                                </h4>
                                <c:if test="${user != null}">
                                    <c:if test="${user.getType()}">
                                        <p>
                                            <em>已售数量: ${book.num}</em>
                                        </p>
                                    </c:if>
                                    <c:if test="${!user.getType()}">
                                        <hr/>
                                    </c:if>
                                </c:if>
                                <p style="color:red;">
                                <div>价格: &yen;${one.price}</div>
                                </p>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </aside>
        <section class="center">
            <ul id="gallery">
                <c:forEach items="${pages}" var="book">
                    <li style="position: relative">
                        <a href="/Books/detail/${book.bookId}">
                            <img src="${book.pictures}" alt=""/>
                            <c:if test="${user !=null }">
                                <c:if test="${!user.getType() && book.num>0}">
                                    <span class="had">
                                        <b>已购买</b>
                                    </span>
                                </c:if>
                            </c:if>
                            <h4 style="width: 188px;text-overflow: clip;overflow: hidden;white-space: nowrap;">
                                <a href="/userAction/MainPage/${book.title}"></a>
                                    ${book.title}
                            </h4>
                            <c:if test="${user != null}">
                                <c:if test="${user.getType()}">
                                    <p>
                                        <em>已售数量: ${book.num}</em>
                                    </p>
                                    <c:if test="${book.num == 0}">
                                        <button style="position:absolute;bottom:5px;right:15px"
                                                type="button" onclick="window.location.href='/Books/delete/${book.bookId}'"
                                                class="btn">删除</button>
                                    </c:if>
                                </c:if>
                                <c:if test="${!user.getType()}">
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
        <p>&copy; Copyright 2018 XDBookStore by ZY.</p>
    </footer>
</div>