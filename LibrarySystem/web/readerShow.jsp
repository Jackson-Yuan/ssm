<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/8/8
  Time: 17:25
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
        <div id="reader_info">
            <table>
                <tr>
                    <td>卡号:</td>
                    <td>${requestScope.loginReader.idCard}</td>
                </tr>
                <tr>
                    <td>姓名:</td>
                    <td>${requestScope.loginReader.name}</td>
                </tr>
                <tr>
                    <td>年龄:</td>
                    <td>${requestScope.loginReader.age}</td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td>${requestScope.loginReader.gender}</td>
                </tr>
                <tr>
                    <td>借阅卡状态:</td>
                    <td>${requestScope.loginReader.cardState}</td>
                </tr>
                <tr>
                    <td>办卡日期:</td>
                    <td>${requestScope.loginReader.cardDate}</td>
                </tr>
            </table>
        </div>
        <div id="reader_operation">
            <a href="index.jsp">Return........</a>
            <c:if test="${requestScope.loginReader.cardState == true}">
                <a href="bookList.jsp">去借阅</a>
            </c:if>
            <a href="/editReader?idCard=${requestScope.loginReader.idCard}">个人信息编辑</a>
        </div>
    </div>
</div>
</body>
</html>
