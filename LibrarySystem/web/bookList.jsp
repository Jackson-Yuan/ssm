<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/8/3
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书展示</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bookList.css">
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="js/bookList.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
<div id="container">
    <div id="header">
        <h3>查询结果</h3>
        <p><var>当前借阅卡号</var>:<var><span id="reader_id">${sessionScope.loginReader.idCard}</span></var><var><span><a
                href="#"
                id="loginOut">退出</a></span></var></p>
    </div>
    <div id="body">
        <c:if test="${!empty requestScope.books}">
            <div id="bookInfoBody">
            <c:forEach var="book" items="${requestScope.books}">
                <div class="bookInfo">
                    <ul>
                        <li>${book.title}</li>
                        <li>${empty book.author ? "无":book.author}</li>
                        <li>${book.press}</li>
                        <li id="${book.ISBN}">${book.availableNumber}</li>
                        <li>
                            <button type="button" class="btn btn-success borrow" value="${book.ISBN}">Borrow</button>
                        </li>
                        <li>
                            <button type="button" class="btn btn-info info" data-toggle="modal" data-target="#myModal">
                                书籍详情
                            </button>
                        </li>
                    </ul>
                </div>
            </c:forEach>
            </div>
            <c:if test="${requestScope.queryInfo.sumPage > 1}">
                <div id="page_operation">
                    <a href="/bookshow?page=1&bookName=${requestScope.queryInfo.bookName}&authorName=${requestScope.queryInfo.authorName}"  class="btn btn-primary btn-lg active" role="button">
                        首页
                    </a>
                    <a href="/bookshow?page=${requestScope.queryInfo.page == 1 ? 1 : requestScope.queryInfo.page - 1}&bookName=${requestScope.queryInfo.bookName}&authorName=${requestScope.queryInfo.authorName}" class="btn btn-default btn-lg active" role="button">
                        上一页
                    </a>
                    <a href="/bookshow?page=${requestScope.queryInfo.page+1}&bookName=${requestScope.queryInfo.bookName}&authorName=${requestScope.queryInfo.authorName}" class="btn btn-default btn-lg active" role="button">
                        下一页
                    </a>
                    <a href="/bookshow?page=${requestScope.queryInfo.sumPage}&bookName=${requestScope.queryInfo.bookName}&authorName=${requestScope.queryInfo.authorName}"  class="btn btn-primary btn-lg active" role="button">
                        尾页
                    </a>
                </div>
            </c:if>
        </c:if>

        <c:if test="${empty requestScope.books}">
            <div id="wrong">
                <p>很遗憾 没有相关书籍</p>
                <a href="/index.jsp">Return</a>
            </div>
        </c:if>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="borrowMessage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="borrowMessageLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
