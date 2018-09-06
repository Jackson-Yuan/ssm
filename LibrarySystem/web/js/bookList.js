/**
 * Created by Lenovo on 2018/8/5.
 */
$(document).ready(function () {
    $(".borrow").click(function () {
        var url="/borrowBook";
        var id = this.value;
        var selector = "#"+id;
        var agrs = {
            "ISBN":id,
            "idCard":$("#reader_id").text(),
            "borrowingDate":new Date()
        };
        $.post(url,agrs,function (data) {
            $("#borrowMessage .modal-body").text(data.message);
            $("#borrowMessage").modal();
            console.log(data);
            console.log(data.data);
            $(selector).text(data.data.availableNumber)
        },"JSON");
    });

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

});