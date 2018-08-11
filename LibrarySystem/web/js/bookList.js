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
            "idCard":"10009",
            "borrowingDate":new Date()
        };
        $.post(url,agrs,function (data) {
            alert(data.message);
            console.log(data);
            console.log(data.data);
            $(selector).text(data.data.availableNumber)
        },"JSON");
    });

    $("#loginOut").click(function () {
        var url = "/cancellationReader";

        $.ajax({
            url:url,
            async:true,
            success:function (data) {
                console.log(data);
                window.location.href="/index.jsp";
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
               console.log(XMLHttpRequest);
               console.log(textStatus);
               console.log(errorThrown);
            }
        });

        return false;
    });
});