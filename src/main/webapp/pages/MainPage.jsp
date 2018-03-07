<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title> XD2HandBookStore</title>
    <link href="https://fonts.googleapis.com/css?family=Changa+One" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
          rel="stylesheet">
    <link rel="stylesheet" href="/css/normalize.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/responsive.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<header>
    <%--todo 最好能用模板，把头和尾提出来--%>
    <a href="/userAction/MainPage" id="logo">
        <h1> XD2HandBookStore</h1>
    </a>
    <div class="login">
        <c:set var="user" scope="session" value="${sessionScope.user}"/>
        <%--用户已登录的情况--%>
        <c:if test="${user != null}">
            <ul class="login-option">
                <li><img style="max-width: 20px;max-height: 20px" src="/images/icons/head.png"></li>
                <li><a href="/userManage/logout" onfocus="">${user.getName()}</a></li>
                <li><a href="/userManage/editInfoPage">个人信息页</a></li>
            </ul>
        </c:if>
        <%--用户未登录的情况--%>
        <c:if test="${user == null}">
            <ul class="login-option">
                <li><a href="/userManage/loginPage">Login</a></li>
                <li><a href="/userManage/registerPage">Register</a></li>
                <li><a href="/userManage/editInfoPage">个人信息页</a></li>
            </ul>
        </c:if>
    </div>
    <nav>
        <ul>
            <li><a href="#">HOME</a></li>
            <li><a href="#">BLOG</a></li>
            <li><a href="#">SHOP</a></li>
            <li><a href="#">FAQ</a></li>
            <li><a href="#">CONTACT</a></li>
            <li><a href="/userAction/publishBookPage">UPLOADBOOK</a></li>
        </ul>
    </nav>
</header>
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
                    <a href="/images/books_images/9780081006603.jpg">
                        <img src="${book.pictures}" alt=""/>
                        <h4>
                            <a href="/userAction/MainPage/${book.name}"></a>
                                ${book.name}
                        </h4>
                        <p>
                            <em>ISBN: ${book.isbn}</em>
                        </p>
                        <p style="color:red;">
                            Price: &yen;${book.price}
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

</body>
</html>