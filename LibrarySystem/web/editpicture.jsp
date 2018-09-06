<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/9/2
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/readerShow.css">
    <title>Title</title>
</head>
<body>
<div id="container">
    <div id="header">
        <p>个人用户界面</p>
    </div>
    <div id="body">
       <img src="photo/${sessionScope.loginReader.pictureUrl}">
        <form action="/file" enctype="multipart/form-data" method="post">
            <input type="file" name="file"><br>
            <input type="hidden" name="username" value="${sessionScope.loginReader.idCard}">
            <input type="submit" value="修改">
        </form>
        <span id="wrongmessage">${requestScope.wrongMessage}</span>
    </div>
</div>
</body>
</html>
