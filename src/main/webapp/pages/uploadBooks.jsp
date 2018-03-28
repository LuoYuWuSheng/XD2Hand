<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- jsp 存在一个解释的过程，只有meta设置utf8是不够的 不加上这句的话会出现乱码--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<body>
<style>
    .inputForm {
        margin-left: 5px;
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
            <li><a href="#">发布</a></li>
            <li><a href="#">Calandar</a></li>
        </ul>
        <p class="footMessage" style="text-align: center">&copy; Copyright 2018 XDBookStore by ZY </p>
    </div>

    <div class="right">
        <%--<div class="number">--%>
            <%--<div class="numberSpan">--%>
                <%--<div class="icon icon1">--%>
                    <%--<img src="/images/icons/accumulation_score.png" alt=""/>--%>
                <%--</div>--%>
                <%--<span class="span1">TOTAL SALES</span>--%>
                <%--<p>$65.8</p>--%>
            <%--</div>--%>
            <%--<div class="numberSpan">--%>
                <%--<div class="icon icon2">--%>
                    <%--<img src="/images/icons/accumulation_score.png" alt=""/>--%>
                <%--</div>--%>
                <%--<span class="span2">NEW QUOTE</span>--%>
                <%--<p>$65.8</p>--%>
            <%--</div>--%>
            <%--<div class="numberSpan">--%>
                <%--<div class="icon icon3">--%>
                    <%--<img src="/images/icons/accumulation_score.png" alt=""/>--%>
                <%--</div>--%>
                <%--<span class="span3">ORDERS</span>--%>
                <%--<p>$65.8</p>--%>
            <%--</div>--%>
            <%--<div class="numberSpan">--%>
                <%--<div class="icon icon4">--%>
                    <%--<img src="/images/icons/accumulation_score.png" alt=""/>--%>
                <%--</div>--%>
                <%--<span class="span4">PROUUCTS</span>--%>
                <%--<p>$65.8</p>--%>
            <%--</div>--%>
        <%--</div>--%>
        <form id="bookForm" style="width: 90%" method="post" enctype="multipart/form-data"
            onsubmit="return checkAndSubmit('/Books/saveEdit');">
            <div style="overflow: auto;margin-top: 20px;width: 100%">
                <div class="inputForm">
                    <input hidden name="bookId" value="${book.bookId}"/>
                    <input hidden name="userId" value="${book.userId}"/>
                    <input hidden name="num" value="${book.num}"/>
                    <label>
                        标题
                        <input id="title" class="form-control" name="title" type="text"
							   placeholder="2-80个字符" value="${book.title}"/>
                    </label>
                    <label>
                        价格
                        <input id="price" type="text" class="form-control" name="price" value="${book.price}">
                    </label>
                    <label>
                        摘要
                        <textarea id="subtitle" class="form-control" name="subtitle" placeholder="2-140个字符">${book.subtitle}</textarea>
                    </label>
					<label>
						详细信息
						<textarea id="detail" class="form-control" name="detail" placeholder="2-1000个字符">${book.detail}</textarea>
					</label>
                </div>
                <div class="categories inputForm">
                    <img id="imageview" style="max-height: 200px;width: 200px;height: 263px;margin: 20px 10px 10px" src="${book.pictures}" alt="">
                    <%-- todo:只是临时的，需要用js实现 并且需要做文件的判断，不是图片文件不允许上传--%>
                    <select style="clear: both;display: block;" id="imgType" name="imgType" onchange="displayFile()">
                        <option value="file">文件上传</option>
                        <option value="url">图片地址</option>
                    </select>
                    <%--<label>--%>
                        <%----%>
                        <%--<input type="radio" name="imgType" value="file" checked="checked"--%>
                               <%--onselect="displayFile(true)">--%>
                    <%--</label>--%>
                    <%--<label>--%>
                        <%----%>
                        <%--<input id="imgType" type="radio" name="imgType" value="url"--%>
                               <%--onselect="displayFile(false)">--%>
                    <%--</label>--%>
                    <div>
                        <input id="file" name="bookCover" type="file" value="上传图片">
                        <input id="url" hidden="hidden" type="text" onchange="changeImage(value)"
                               value="${book.pictures}" name="url" placeholder="请输入url">
                    </div>
                </div>
            </div>
            <div class="buttons">
                <c:if test="${book != null}">
                    <button type="submit" onclick="this.form.action='/Books/saveEdit'"
                            class="btn">保存</button>
                </c:if>
                <c:if test="${book == null}">
                    <button type="submit" onclick="this.form.action='/userAction/publishBook';"
                            class="btn">发布</button>
                </c:if>
                <button href="/userAction/MainPage" class="btn">首页</button>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    $(function() {
        /*原理是把本地图片路径："D(盘符):/image/..."转为"http://..."格式路径来进行显示图片*/
        $("#file").change(function() {
            var $file = $(this);
            var objUrl = $file[0].files[0];
            //获得一个http格式的url路径:mozilla(firefox)||webkit or chrome
            var windowURL = window.URL || window.webkitURL;
            //createObjectURL创建一个指向该参数对象(图片)的URL
            var dataURL;
            dataURL = windowURL.createObjectURL(objUrl);
            $("#imageview").attr("src",dataURL);
        });
    });
    function changeImage(value){
        $("#imageview").attr("src",value);
    }
</script>
</body>
</html>
