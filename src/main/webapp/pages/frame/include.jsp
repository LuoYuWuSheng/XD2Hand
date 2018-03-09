<%--
  Created by IntelliJ IDEA.
  User: luoyu
  Date: 2018/3/9
  Time: 上午9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
