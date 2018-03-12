<%--
  Created by IntelliJ IDEA.
  User: luoyu
  Date: 2018/3/9
  Time: 下午7:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% int index = 1;%>
<div id="wrapper" style="display:block;margin:0 auto;width:80%;">
	<div class=""></div>
	<body>
	<table class="table table-striped">
		<thead>
		<tr>
			<th>序号</th>
			<th>标题</th>
			<th>图片</th>
			<th>购买的时间</th>
			<th>购买的价格</th>
			<th>购买的数量</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${orders}" var="order">
			<tr>
				<td scope="row"><%=index++%></td>
				<td>${order.bookTitle}</td>
				<td><img style="height:100px;" src="${order.bookPicture}"/></td>
				<td>${order.formatDate()}</td>
				<td>${order.bookPrice}</td>
				<td>${order.bookNum}</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="6" style="text-align: right">总计：${money}</td>
			</tr>
		</tbody>
	</table>
	<div class="buttons" style="text-align: center">
		<button type="button" onclick="window.location.href='/userAction/clearShopCar';"
				class="btn">购买</button>
		<button type="button" onclick="window.location.href='/userAction/MainPage';"
				class="btn">退出</button>
	</div>
	</body>
</div>