<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<html lang="en">
<head>
    <title>个人信息</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Changa+One">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">

    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/normalize.css">
    <link rel="stylesheet" href="/css/responsive.css">
    <link rel="stylesheet" href="/css/myDefin/profile.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%--<script src="/js/bootstrap.min.js" type="text/javascript"></script>--%>
    <%--<script src="/js/jquery.min.js" type="text/javascript"></script>--%>
    <style>
        .inputForm {
            margin-left: 30px;
        }
    </style>
</head>
<body>

<header>
    <a href="/userAction/MainPage" id="logo">
        <h1> XD2HandBookStore</h1>
    </a>
    <div class="login">
        <ul class="login-option">
            <li><a href="/userManage/loginPage">Login</a></li>
            <li><a href="/userManage/registerPage">Register</a></li>
            <li><a href="/userManage/editInfoPage">个人信息页</a></li>
        </ul>
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
    <%--<div class="subMenu">--%>
    <%--<ul>--%>
    <%--<li><a href="#">Profile</a></li>--%>
    <%--<li><a href="#">Account</a></li>--%>
    <%--<li><a href="#">History Record</a></li>--%>
    <%--<li><a href="#">Class Annoucement</a></li>--%>
    <%--</ul>--%>
    <%--</div>--%>
</header>

<div id="wrapper">
    <aside>
        <div class="sidebar-nav">
            <div class="heading" style="width: 80%;max-width: 150px">
                <img src="/images/userHead/tx.JPG">
            </div>
            <div>Susan</div>
            <div>Harrington</div>
        </div>
        <ul class="sidebar-menu">
            <li><a href="#">Books publised</a></li>
            <li><a href="#">Recommended books</a></li>
            <li><a href="#">Teachers recommended books</a></li>
        </ul>
    </aside>

    <section class="center">
        <form:form class="profile-form" action="/userManage/editInfo">
            <div style="overflow: auto">
                <div class="them-label" style="width: 256px;">Public profile</div>
                <div class="inputForm">
                    <h1>Profile picture</h1>
                    <div class="heading" style="width: 100px;float: left">
                        <img src="/images/userHead/tx.JPG">
                    </div>
                    <div style="float: left;margin-left: 50px;margin-top: 35px;">
                        <div class="btn" style="height: auto;width: 110px">
                            <div>upload pictures</div>
                            <input style="-webkit-filter: Opacity(0);float: left" type="file"/>
                        </div>
                        <div>You can also drag or drop a picture from your computer</div>
                    </div>
                </div>
            </div>
            <div class="inputForm">
                <label>
                    User
                    <input type="text" value="Susan" name="user" class="form-control">
                </label>
                <label>
                    First Name
                    <input type="text" value="Susan" name="firstName" class="form-control">
                </label>
                <label>
                    Last Name
                    <input type="text" value="Harrington" name="lastName" class="form-control">
                </label>
                <label>
                    Email
                    <input type="text" value="susan_harrington@email.com" class="form-control">
                </label>
            </div>
            <div class="them-label" style="width: 256px;margin-top: 3em">Update password</div>
            <div class="inputForm">
                <label>
                    Previous password
                    <input type="password" value="1212" name="pre_password" class="form-control">
                </label>
                <label>
                    New Password
                    <input type="password" value="1212" name="new_password" class="form-control">
                </label>
            </div>
            <div style="margin-top: 50px;margin-left: 100px">
                <input class="btn" type="submit" value="submit">
                <button class="btn" href="/userAction/MainPage">Home</button>
            </div>
        </form:form>
    </section>
</div>

<footer>
    <p>&copy; Copyright 2018 XD2BookStore by ZY.</p>
</footer>

</body>
</html>
