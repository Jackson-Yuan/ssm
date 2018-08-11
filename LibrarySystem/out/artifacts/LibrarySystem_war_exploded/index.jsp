<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/8/4
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
</head>
<body>
<div id="contaniner">
    <div id="head">
        <h3>图书管理系统<br><a href="addReader.jsp">办理借阅卡</a></h3>
    </div>
    <div id="body">
        <div id="searchBook">
            <p>Search Book</p>
            <form action="${pageContext.request.contextPath}/bookshow" method="get">
                bookName:<input type="text" name="bookName" placeholder="selectAll"><br>
                bookAuthor:<input type="text" name="bookAuthor" placeholder="selectAll"><br>
                <input type="submit" value="Submit">
            </form>
        </div>
        <div id="searchReader">
            <p>Reader Login</p>
            <form action="${pageContext.request.contextPath}/readershow" method="get">
                readerCard:<input type="text" name="readerCard" placeholder="input your IDCARD" id="readerMessage"><br>
                <p id="wrong_message"></p>
                <input type="submit" value="Submit" id="reader_submit">
            </form>
        </div>
    </div>
    <div id="bottom">由zyc家族倾情赞助</div>
</div>
</body>
</html>
