<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<body>
<c:set var="user" scope="session" value="${sessionScope.user}"/>
<script type="text/javascript">
    function addToCar() {
        var num = $('#buyNum').val();
        var id = ${book.bookId};
        $.ajax({
            type:"post",
            url:"/userAction/addToCar",
            data:{
                num:num,
                id:id
            },
            success:function () {
                alert("成功添加到购物车")
            },
            error:function () {
                alert("添加失败")
            }
        });
    }
</script>
<div id="wrapper">
    <aside>
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
      <div id="one_book">
        <img id="detailImage" src="${book.pictures}" alt="" />
        <section class="detail_message">
            <h3>${book.title}</h3>
            <p><i>发布日期:${book.formatDate()}</i></p>
            <p style="font-size:22px;color:#EF4E22"><strong>价格: &yen; ${book.price}</strong><span class="stars"></span></p>
            <hr/>
            <ul class="detail_ul">
            <li><span class="dleft">摘要:</span><span class="dright">${book.subtitle}</span></li>
            </ul>
            <%--<form:input path="${Orders.num}"></form:input>--%>
            <c:if test="${user != null}" >
                <div class="buttons" style="margin-top: 200px">
                    <c:if test="${user.getType()}">
                        <button onclick="location='/Books/edit/${book.bookId}'" style="margin-left: 10px;" class="btn">编辑</button>
                    </c:if>
                    <c:if test="${!user.getType()}">
                        <input id="buyNum" type="text" value="1">
                        <input id="id" hidden="hidden" value="${book.bookId}"/>
                        <button style="margin-left: 5px;margin-right: 20px"
                                type="button" onclick="addToCar()" class="btn">加入购物车</button>
                    </c:if>
                </div>
            </c:if>
        </section>
      </div>

      <%--<div class="contact">--%>
        <%--<h1>全 文</h1>--%>
      <%--</div>--%>
        <hr style="margin-top: 30px;margin-bottom: 30px"/>
      <div class="message">
        <ul id="tab">
          <li class="fli" id="first">详情</li>
          <%--<li>Authors</li>--%>
          <%--<li>Table of Contents</li>--%>
        </ul>
        <div id="shade"></div>
        <div id="tab_con">
          <div class="fdiv">
            ${book.detail}
          </div>
          <div>bbbb</div>
          <div>cccc</div>
        </div>

      </div>

    </section>
 </div>

  <footer>
    <p>&copy; Copyright 2018 XDBookStore by ZY.</p>
  </footer>
  <script src="/js/myFunction.js" type="text/javascript"></script>
</body>
</html>
