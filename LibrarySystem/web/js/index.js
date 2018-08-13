/**
 * Created by Lenovo on 2018/8/8.
 */
$(document).ready(function () {
    $("#readerMessage").change(function () {
        var value = $(this).val();
        value = $.trim(value);

        if (value !== ""){
            var url = "/validateidCard";

            var agrs = {
                "idCard":value
            };

            $.get(url,agrs,function (data) {
                $("#wrong_message").text(data.data);
            },"JSON");
        }
    });


    $("#reader_submit").click(function () {
        var value = $("#readerMessage").val();
        value = $.trim(value);
        console.log(value);
        if (value === ""){
            alert("请填写卡号");
            return false;
        }else{
            var url = "/validateidCard";

            var flag = 0;
            console.log(flag);
            var agrs = {
                "idCard":value
            };

           $.ajax({
               type:"get",
               url:url,
               data:agrs,
               dataType:"json",/**此项设置表明预期服务端返回的数据格式(返回格式可在浏览器控制台response看)，一般不需要手动写出，如手动指定出现错误，会执行error的函数 ajax函数个设置属性大小写不能忽略*/
               async:false,/**设置此属性是因为,ajax是默认异步请求，回调函数的执行需要时间，可能回调函数还没开始执行,$.ajax方法底下的代码可能先于回调函数执行
                换成false,代表当回调函数执行完,$.ajax方法后的代码才会执行
                */
               success:function (data) {
                   console.log(data.data);
                   /**没有数据响应过来时,时undefined 不是null*/
                   if (data.data !== undefined){
                       alert("考号不存在！");
                       flag = 1;
                   }
               }
           });

            if (flag !== 0) return false;
            // if (flag === 1) return false;
        }
    });


    $("#book_submit").click(function () {
        var flag = 0;
        var url = "/validatebook";
        $.ajax({
            type:"GET",
            url:url,
            async:false,
            success:function (data) {
                if (data.success == false){
                    alert("请先登录!");
                    flag = 1;
                }
            }
        })

        if (flag !== 0) return false;
    });
});