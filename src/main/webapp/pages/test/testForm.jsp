<%--
  Created by IntelliJ IDEA.
  User: luoyu
  Date: 2018/3/7
  Time: 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<link >
<head>
    <title>Spring表单测试</title>
    <script src="/js/jquery.min.js"></script>
</head>
<body>
<form:form action="/learn/testForm" method="post" commandName="User">
        <form:errors path="name" element="div"/>
        <input type="text" name="name" value="test">
        <input type="text" name="passwd" value="1234">
        <button type="submit" >提交</button>
    </form:form>
</body>
    <script type="application/javascript">
        function testJson() {
//          测试@RequestBody的代码
            var user={name:"test",passwd:"1234"};
            $.ajax({
                type : 'POST',
                url: '/learn/testJson',
                contentType : 'application/json',
//                加了dataType后返回必须是Json，否则不调success回调
//                dataType : 'json',
                data : JSON.stringify(user),
                success : function callback() {
                    console.log("success")
                },
                error:function () {
                    console.log("返回数据不符合Json格式就是error？？？不理解这里的设计")
                }
            })
        }
    </script>
</html>
