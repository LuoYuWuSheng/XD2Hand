<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- jsp 存在一个解释的过程，只有meta设置utf8是不够的 不加上这句的话会出现乱码--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>XD2HandBookStore</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link href="https://fonts.googleapis.com/css?family=Changa+One" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
          rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/myDefin/uploadBooks.css">
    <!-- <link rel="stylesheet" href="../css/responsive.css"> -->
    <link rel="stylesheet" href="/css/responsive.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .inputForm {
            /*margin-left: 5px;*/
            float: left;
            width: 360px;
        }

        .inputForm label {
            margin-top: 10px;
        }

        .buttons {
            margin-top: 50px;
            margin-left: 300px;
            clear: both;
        }

        .buttons button {
            margin-left: 20px;
            margin-right: 20px;
        }
    </style>
</head>
<body>
<header>
    <a href="/userManage/loginPage" id="logo">
        <h1>2HandsBookShoop</h1>
    </a>
    <span class="search"><img src="/images/icons/query.png" alt=""/></span>
    <%--<nav>--%>
    <%--<ul>--%>
    <%--<li><a href="#">HOME</a></li>--%>
    <%--<li><a href="#">BLOG</a></li>--%>
    <%--<li><a href="#">SHOP</a></li>--%>
    <%--<li><a href="#">FAQ</a></li>--%>
    <%--<li><a href="#">CONTACT</a></li>--%>
    <%--<li><a href="/userAction/publishBookPage">UPLOADBOOK</a></li>--%>
    <%--</ul>--%>
    <%--</nav>--%>
</header>
<div id="main">
    <div class="left">
        <div class="selfMeaasge">
            <img src="/images/books_images/9780081006603.jpg" alt=""/>
            <h3>Susan</h3>
            <p>HarringTon</p>
        </div>
        <ul>
            <li><a href="#">Dashbord</a></li>
            <li><a href="#">Message</a></li>
            <li><a href="#">Upload Books</a></li>
            <li><a href="#">Calandar</a></li>
        </ul>
        <p class="footMessage" style="text-align: center">&copy; Copyright 2016 XD2HandBookStore by XDCrater </p>
    </div>

    <div class="right">
        <div class="number">
            <div class="numberSpan">
                <div class="icon icon1">
                    <img src="/images/icons/accumulation_score.png" alt=""/>
                </div>
                <span class="span1">TOTAL SALES</span>
                <p>$65.8</p>
            </div>
            <div class="numberSpan">
                <div class="icon icon2">
                    <img src="/images/icons/accumulation_score.png" alt=""/>
                </div>
                <span class="span2">NEW QUOTE</span>
                <p>$65.8</p>
            </div>
            <div class="numberSpan">
                <div class="icon icon3">
                    <img src="/images/icons/accumulation_score.png" alt=""/>
                </div>
                <span class="span3">ORDERS</span>
                <p>$65.8</p>
            </div>
            <div class="numberSpan">
                <div class="icon icon4">
                    <img src="/images/icons/accumulation_score.png" alt=""/>
                </div>
                <span class="span4">PROUUCTS</span>
                <p>$65.8</p>
            </div>
        </div>
        <form action="/userAction/publishBook" method="post" enctype="multipart/form-data">
            <div style="overflow: auto;margin-top: 20px;width: 10000px">
                <div class="inputForm">
                    <label>
                        Student ID 这里需要系统生成而不该由用户填写
                        <input class="form-control" name="stuId" type="text" value=""/>
                    </label>
                    <label>
                        ISBN 这个应该是必填(necessary)
                        <input class="form-control" name="isbn" type="text" placeholder="9787115145543"/>
                    </label>
                    <label>
                        Title of Book
                        <input class="form-control" name="name" type="text"/>
                    </label>
                    <label>
                        Author 通过isbn查询
                        <input class="form-control" name="author" type="text"/>
                    </label>
                    <label>
                        Book Old Level 图书的新旧程度，0-9数字越大越新
                        <input class="form-control" name="level" type=text/>
                    </label>
                    <label>
                        <%-- todo:price 这里继续做的话可以给出价格建议 或者快速选项，例如这种isbn的书，新书是多少钱，旧书通常要多少钱--%>
                        price
                        <input type="text" class="form-control" name="price" value="">
                    </label>
                    <label>
                        Description 是否该写？
                        <textarea class="form-control" name="description"></textarea>
                    </label>
                </div>
                <div class="categories inputForm">
                    <label for="category">categories</label>
                    <select id="category" class="form-control">
                        <option value="11">CSS</option>
                        <option value="12">Javascript</option>
                        <option value="13">html</option>
                        <option value="14">jquery</option>
                    </select>
                    <img style="max-height: 200px" src="/images/books_images/9780081006603.jpg" alt="">
                    <%-- todo:只是临时的，需要用js实现 并且需要做文件的判断，不是图片文件不允许上传--%>
                    <input name="bookCover" class="btn bookCover" type="file" value="上传图片">
                </div>
            </div>
            <div class="buttons">
                <button type="submit" class="btn">Upload</button>
                <button href="/userAction/MainPage" class="btn">home</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
