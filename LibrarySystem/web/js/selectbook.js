/**
 * Created by Lenovo on 2018/8/12.
 */
$(document).ready(function () {
    $("#loginOut").click(function () {
        var url = "/cancellationReader?time="+ new Date(); /**防止缓存这个链接的响应结果，使得后续的操作无效*/

        $.ajax({
            type:"GET",
            url:url,
            async:true,
            success:function (data) {
                window.location.href="/index.jsp";
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(XMLHttpRequest);
                console.log(textStatus);
                console.log(errorThrown);
                // window.location.href="/index.jsp";
            }
        });

        return false;
    });

    $(".return").click(function () {
        var url="/returnbook";
        var id = this.value;
        var obj = $(this);
        var agrs = {
            "ISBN":id,
            "idCard":$("#reader_id").text(),
            "returnDate":new Date()
        };
        $.post(url,agrs,function (data) {
            /**在ajax函数里面的this表示的是发送的请求对象，而不是按钮*/
            alert(data.message);
           if (data.success === true){
               obj.parent().parent().parent().css({"display":"none"});
           }
        },"JSON");
    });
});
