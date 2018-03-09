<%--
  Created by IntelliJ IDEA.
  User: luoyu
  Date: 2018/3/9
  Time: 上午9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--todo 最好能用模板，把头和尾提出来--%>
<a href="/userAction/MainPage" id="logo">
	<h1> XD2HandBookStore</h1>
</a>
<c:set var="user" scope="session" value="${sessionScope.user}"/>
<div class="login">
	<%--用户已登录的情况--%>
	<c:if test="${user != null}">
		<ul class="login-option">
			<li><img style="max-width: 20px;max-height: 20px" src="/images/icons/head.png"></li>
			<li><a href="/userManage/logout" onfocus="">${user.getName()}</a></li>
			<c:if test="${!user.getType()}">
				<li><a href="#">购物车</a></li>
			</c:if>
			<li><a href="/userManage/logout">退出</a></li>
		</ul>
	</c:if>
	<%--用户未登录的情况--%>
	<c:if test="${user == null}">
		<ul class="login-option">
			<li><a href="/userManage/loginPage">登陆</a></li>
			<li><a href="/userManage/registerPage">注册</a></li>
		</ul>
	</c:if>
</div>
<nav>
	<ul>
		<li><a href="#">首页</a></li>
		<li><a href="#">BLOG</a></li>
		<li><a href="#">SHOP</a></li>
		<li><a href="#">FAQ</a></li>
		<li><a href="#">CONTACT</a></li>
		<c:if test="${user != null}">
			<c:if test="${user.getType()}">
				<li><a href="/userAction/publishBookPage">发布</a></li>
			</c:if>
			<c:if test="${!user.getType()}">
				<li><a href="/userAction/publishBookPage">财务</a></li>
			</c:if>
		</c:if>
	</ul>
</nav>
