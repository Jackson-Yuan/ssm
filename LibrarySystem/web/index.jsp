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
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#submit").click(function () {
                var url = "/registerReader";

                var agrs = {
                    idCard:$('input[name = "idCard"]').val(),
                    name:$('input[name = "name"]').val(),
                    age:$("#age").val(),
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
<div id="contaniner">
    <div id="head">
        <h3>图书管理系统<br><button type="button" class="btn btn-info borrow" data-toggle="modal" data-target="#myModal">
            办理借阅卡
        </button></h3>
    </div>
    <div id="body">
        <div id="searchBook">
            <p>Search Book</p>
            <form action="${pageContext.request.contextPath}/bookshow" method="get">
                bookName:<input type="text" name="bookName" placeholder="selectAll"><br>
                bookAuthor:<input type="text" name="authorName" placeholder="selectAll"><br>
                <input type="submit" value="Submit" id="book_submit">
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
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                <form action="#" method="post">
                    <div class="form-group">
                        <label for="idCard">借阅卡号</label>
                        <input type="text" class="form-control" id="idCard" name="idCard" placeholder="ID">
                    </div>
                    <div class="form-group">
                        <label for="name">姓名</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                    </div>
                    <div class="form-group">
                        <label for="age">年龄</label>
                        <select class="form-control" id="age" name="age">
                            <option value="10">10</option>
                            <option value="20">20</option>
                            <option value="30">30</option>
                            <option value="40">40</option>
                            <option value="50">50</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="gender">性别</label>
                        <div class="radio" id="gender">
                            <label>
                                <input type="radio" name="gender" id="optionsRadios1" value="男">
                                man
                            </label>
                            <label>
                                <input type="radio" name="gender" id="optionsRadios2" value="女">
                                woman
                            </label>
                        </div>
                    </div>
                    <button class="btn btn-primary" id="submit" type="button">注册</button>
                </form>
                <%--在使用到ajax的时候，尽量不要在form内使用button进行提交,点击button时 会先发送ajax请求 但由于在form里 之后会发生action请求 使得ajax请求中断 可以令type为button
                则按钮便不会发送action请求
                --%>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
