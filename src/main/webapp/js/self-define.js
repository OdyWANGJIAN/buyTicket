maxtime = 4*60+59 //半个小时，按秒计算，自己调整!
function getcode() {
    var tele = $("#telephone").val();
    var selectSets = $(".ticket");
    if(selectSets.length!=0){
        $("#codeButton").attr("disabled", true);
        timer = setInterval("CountDown()", 1000);
        $.post("/message/getCode", {telephone: tele}, function (data) {
            var result = JSON.parse(data);
            if (result.code == 1) {
                alert(result.msg);
            } else if (result.code == 0) {
                alert(result.msg);
            }
        });
    }else {
        alert("请先选择座位");
    }
    
}
function CountDown() {
    if (maxtime >= 0) {
        $("#codeButton").css("color","red");
        $("#codeButton").val("重新获取(" + maxtime + ")");
        var val = $("#codeButton").val();
        --maxtime;
    }
    else {
        $("#codeButton").val("获取验证码");
        $("#codeButton").attr("disabled", false);
        clearInterval(timer);
        maxtime=4*60+59;
    }
}

function codeLogin() {
    var code = $("#inputCode").val();
    var tele = $("#telephone").val();
    var filmName = $("#filmName").text();
    var regex = /^[0-9]{6}$/
    if (code.match(regex)) {
        var watchingTime = $("#watchingTime").text();
        var theaterName = $("#theaterName").text();
        var hallName = $("#hallName").text();
        var selectSets = $(".ticket");
        var sets="";
        for (var i=0;i<selectSets.length;i++){
            if (i!=selectSets.length-1){
                sets+=selectSets.eq(i).text()+",";
            }else {
                sets+=selectSets.eq(i).text();
            }
        }
        var sumPrice = $("#sumPrice").text();
       /* alert(filmName+"---"+watchingTime+"---"+theaterName+"----"+hallName+"----"+sumPrice+"----"+sets);*/
        $.post("/message/login",
            {inputCode: code, telephone: tele,movieName:filmName,watchingTime:watchingTime,cinemaName:theaterName,hallName:hallName,totalPrice:sumPrice,selectedSets:sets},
            function (data) {
            if (data == "订单提交成功") {
                alert(tele+"========="+filmName);
                window.location.href = '/cart/showBooking?tele='+tele+'&movieName='+filmName;
            }
            if (data == "订单提交失败") {
                alert("验证码错误");
            }
        });
    } else {
        alert("您的输入有误");
        $("#inputCode").val("");
    }
}
function acquireFocus() {
    $("#teleSpan").text("");
}
function checkTele() {
    var tele = $("#telephone").val();
    var patrn = /^[1]([3]|[5]|[8]){1}[0-9]{9}$/;
    if (tele != "") {
        if (tele.match(patrn)) {
            $("#codeButton").attr("disabled", false);
        } else {
            $("#teleSpan").text("手机号格式错误");
            $("#codeButton").attr("disabled", true);
        }
    } else {
        /*$("#teleSpan").text("请输入手机号");*/
        $("#codeButton").attr("disabled", true);
    }
}
var count = 0;
/*$(".checkbox").click(function () {
 if (this.checked) {
 count++;
 var price = parseFloat($("#originprice").text());
 var sumprice = count * price;
 $("#sumprice").text(sumprice);
 var val = $(this).val();
 var setfirst = $(".set").eq(0).text();
 if (setfirst == "还未选择座位") {
 $(".set").eq(0).text("");
 }
 /!*alert(val);*!/
 var len = $(".set").length;
 for (var i = 0; i < len; i++) {
 var text = $(".set").eq(i).text();
 if (text == "") {
 $(".set").eq(i).text(val);
 break;
 }
 }
 } else {
 count--;
 var price = parseFloat($("#originprice").text());
 var sumprice = count * price;
 $("#sumprice").text(sumprice);
 var dd = $(this).val();
 /!* alert(dd + "被撤销了");*!/
 var len = $(".set").length;
 for (var i = 0; i < len; i++) {
 var text = $(".set").eq(i).text();
 if (text == dd) {
 $(".set").eq(i).text("");
 break;
 }
 }
 }
 });*/
/*
function bookingset() {
    var len = $(".set").length;
    alert("订单提交");
    var orderlist = ",";
    for (var i = 0; i < len; i++) {
        var text = $(".set").eq(i).text();
        if (text != "") {
            orderlist = orderlist + text + ","
        }
    }
    var sum = $("#sumprice").text();
    $.post("/order/saveOrder", {sum: sum, orderlist: orderlist},
        function (data) {
            if (data == "success") {
                window.location.href = "/countdown.html"
            }
        }
    );
}*/
