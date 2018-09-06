<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/8/9
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/edit.css">
</head>
<body>
<div  id="container">
    <div id="header">
        <p>个人信息编辑</p>
    </div>
    <div id="body">
        <div id="reader_info">
            <form action="/completeReader" method="post">
                <table>
                    <tr>
                        <td>卡号:</td>
                        <td><input type="text" value="${requestScope.reader.idCard}" name="editCard" readonly="readonly"></td>
                    </tr>
                    <tr>
                        <td>姓名:</td>
                        <td><input type="text" value="${requestScope.reader.name}" name="name"></td>
                    </tr>
                    <tr>
                        <td>年龄:</td>
                        <td><input type="text" value="${requestScope.reader.age}" name="age"></td>
                    </tr>
                    <tr>
                        <td>性别:</td>
                        <td>
                            <c:if test="${requestScope.reader.gender eq '男'}">
                                <input type="radio" name="gender" value="男" checked="checked">男 &nbsp;
                                <input type="radio" name="gender" value="女">女
                            </c:if>
                            <c:if test="${requestScope.reader.gender eq '女'}">
                                <input type="radio" name="gender" value="男" >男 &nbsp;
                                <input type="radio" name="gender" value="女" checked="checked">女
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>借阅卡状态:</td>
                        <td>
                            <c:if test="${requestScope.reader.cardState == true}">
                                <input type="radio" name="cardState" value="true" checked="checked">可用 &nbsp;
                                <input type="radio" name="cardState" value="false">不可用
                            </c:if>
                            <c:if test="${requestScope.reader.cardState == false}">
                                <input type="radio" name="cardState" value="true" >可用 &nbsp;
                                <input type="radio" name="cardState" value="false" checked="checked">不可用
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>办卡日期:</td>
                        <td><input type="datetime" name="cardDate" value="${requestScope.reader.cardDate}" readonly="readonly"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Update">
                            <a href="/editpicture.jsp"><button type="button">配置头像</button></a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
