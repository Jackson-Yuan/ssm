<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/8/12
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/bookList.css">
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="js/selectbook.js"></script>
</head>
<body>
<div id="container">
    <div id="header">
        <p>查询结果</p>
        <p>当前借阅卡号:<span id="reader_id">${sessionScope.loginReader.idCard}</span><span><a href="#" id="loginOut">退出</a></span></p>
    </div>
    <div id="body">
        <c:if test="${!empty requestScope.books}">
            <c:forEach var="book" items="${requestScope.books}">
                <div class="bookInfo">
                    <ul>
                        <li>${book.title}</li>
                        <li>${empty book.author ? "无":book.author}</li>
                        <li>${book.press}</li>
                        <li id="${book.ISBN}">${book.availableNumber}</li>
                        <li><button type="button" class="return" value="${book.ISBN}">Return</button> </li>
                    </ul>
                </div>
            </c:forEach>
        </c:if>

        <c:if test="${empty requestScope.books}">
            <div id="wrong">
                <p>很遗憾 没有借阅书籍</p>
                <a href="/index.jsp">Return</a>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>
