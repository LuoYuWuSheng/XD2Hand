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
	  <div style="height: 200px">
    <div class="transport"></div>
    <img class="img" src="/images/photo-1424115087662-5845efc6b366.jpg?raw=true" alt="" />
          <%--onkeydown="if(event.keyCode==13){return true;}"--%>
    <form id="loginForm" action="/userManage/login" method="post"
        onsubmit="encodePasswd()">
        <div class="login-form">
            <form:input path="user.name" id="user-name-label" name="userName" type="text" placeholder="用户名" /><br>
            <form:input  path="user.passwd" id="user-password-label" name="userPasswd" type="password" placeholder="密码" /><br>
            <input type="text" placeholder="校验码" /><br>
			<label class="label" style="left: auto">
                <input type="checkbox" />
                记住</label><br><br>
            <input type="button" onkeydown="console.log('12');if(window.event.keyCode=='13'){$('#loginForm').submit()}"
                   onclick="$('#loginForm').submit()" value="登陆" class="login-button" />
            <input type="button" onclick="window.location.href='#'" value="注册" class="login-button" />
            <a>${message}</a>
            <br>
            <h6 class="no-access">seller-relles buyer-reyub</h6>
        </div>
    </form>
</div>

</div>
</body>