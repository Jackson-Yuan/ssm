<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/8/9
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/edit.css">
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#submit").click(function () {
                var url = "/registerReader";

                var agrs = {
                    idCard:$('input[name = "editCard"]').val(),
                    name:$('input[name = "name"]').val(),
                    age:$('input[name = "age"]').val(),
                    gender:$('input[name = "gender"]:checked').val(),
                    cardState:true,
                    cardDate:new Date()
                };

                $.ajax({
                    url:url,
                    data:agrs,
                    type:"POST",
                    success:function (data) {
                        alert(data.data);
                    },
                    error:function () {
                        alert("failure");
                    }
                });
            });
        });
    </script>
</head>
<body>
<div id="container">
    <div id="header">
        <p>个人信息注册</p>
    </div>
    <div id="body">
        <div id="reader_info">
            <form action="/completeReader" method="post">
                <table>
                    <tr>
                        <td>卡号:</td>
                        <td><input type="text" value="${requestScope.reader.idCard}" name="editCard" ></td>
                    </tr>
                    <tr>
                        <td>姓名:</td>
                        <td><input type="text" value="${requestScope.reader.name}" name="name" ></td>
                    </tr>
                    <tr>
                        <td>年龄:</td>
                        <td><input type="text" value="${requestScope.reader.age}" name="age" ></td>
                    </tr>
                    <tr>
                        <td>性别:</td>
                        <td>
                            <input type="radio" name="gender" value="男">男 &nbsp;
                            <input type="radio" name="gender" value="女">女
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><button type="button" id="submit">注册</button> </td>
                    </tr>
                </table>
            </form>
        </div>
</div>
</body>
</html>
