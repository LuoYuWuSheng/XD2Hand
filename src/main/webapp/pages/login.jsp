<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>XDBookStore</title>
<!--    <link rel="stylesheet" href="css/normalize.css">-->
    <link href="https://fonts.googleapis.com/css?family=Changa+One" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="../css/myDefin/login.css">
    <script src='<jstl:url value="/js/myFunction.js"/>'></script>
    <script src='<jstl:url value="/js/md5.js"/>'></script>
    <script src='<jstl:url value="/js/jquery.min.js"/> '></script>
<!--    <meta name="viewport" content="width=device-width, initial-scale=1.0"> </head>-->

<body>
  <div class="login">
    <div class="login-header">
      <h1><em>Welcome to  </em>MyBookStore</h1>
    </div>
    <div class="transport">
    </div>
          <%--onkeydown="if(event.keyCode==13){return true;}"--%>
    <form id="loginForm" action="/userManage/login" method="post"
        onsubmit="encodePasswd()">
        <img class="img" src="/images/photo-1424115087662-5845efc6b366.jpg?raw=true" alt="" />
        <div class="login-form">
            <form:input path="user.name" id="user-name-label" name="userName" type="text" placeholder="用户名" /><br>
            <form:input  path="user.passwd" id="user-password-label" name="userPasswd" type="password" placeholder="密码" /><br>
            <input type="text" placeholder="校验码" /><br>
			<label class="label">
                <input type="checkbox" />
                记住</label><br><br>
            <input type="button"
                   onclick="$('#loginForm').submit()" value="登陆" class="login-button" />
            <input type="button" onclick="window.location.href='#'" value="注册" class="login-button" />
            <a>${message}</a>
            <br>
            <h6 class="no-access">seller-relles buyer-reyub</h6>
        </div>
    </form>
</div>
<%--<script type="text/javascript">--%>
    <%--document.onkeydown = function (e) {--%>
        <%--var theEvent = window.event || e;--%>
        <%--var code = theEvent.keyCode || theEvent.which;--%>
        <%--if (code == 13) {--%>
            <%--$("#but1").click();--%>
        <%--}--%>
    <%--}--%>
    <%--$(document).ready(function () {--%>
        <%--$("#but1").click(function () {--%>
            <%--alert("我是enter事件," + "text值:" + $("#text1").val());--%>
        <%--})--%>
        <%--$("#but2").click(function () {--%>
            <%--alert("我是Jquery事件" + "text值:" + $("#text1").val());--%>
        <%--})--%>
    <%--});--%>
<%--</script>--%>
<script type="text/javascript">
    $(document).keypress(function(e) {
        var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
        if (eCode == 13){
            console.log("enter passed");
            //自己写判断操作
            $('#loginForm').submit()
        }
    });
</script>
</body>