<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>XD2HandBookStore</title>
  <!--    <link rel="stylesheet" href="css/normalize.css">-->
  <link href="https://fonts.googleapis.com/css?family=Changa+One" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Oswald:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="../css/myDefin/login.css">
  <script src="../js/jquery.min.js"></script>

  <!--    <meta name="viewport" content="width=device-width, initial-scale=1.0"> </head>-->

<body>
<div class="login">
  <div class="login-header">
    <h1><em>Welcome to  </em>XD2HandBookStore</h1>
  </div>
  <div>
    <img class="img" src="/images/photo-1424115087662-5845efc6b366.jpg?raw=true" alt="" />
    <form id="register" action="/userManage/register" method="post">
      <div class="login-form">
        <form:input path="user.name" id="user-name-label" name="userName" type="text" placeholder="Account Name" /><br>
        <form:input  path="user.passwd" id="user-password-label" name="userPasswd" type="password" placeholder="Password" /><br>
        <input id="userPasswd" type="password" placeholder="Confirm your password" /><br>
        <%-- 解决与左边图片不对称的问题 --%>
        <br><br>
        <input type="button" onclick="verify()" value="qucik regist" class="login-button" />
        <br>
        <h6 class="no-access"></h6>
      </div>
    </form>
  </div>

</div>
<script>
    function verify(){
        var passwd = $('#user-password-label');
        var passwdConfirm = $('#userPasswd');
        if(passwd.val === passwdConfirm.val){
            $('#register').submit();
        }
        else alert("your passwd is not confirm");
    }
</script>
</body>