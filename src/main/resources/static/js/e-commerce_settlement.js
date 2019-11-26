$(".payment li").eq(1).on("click", function(){
    location.href="redirect?page=e-commerce_order.html";
})

$(function(){
    //初始化界面
    init();
    //选择支付方式
    onClickPay();
})

//初始化
function init(){
    //订单号
    $("#orderNumber").text(getQueryVariable("orderNumber"));
    //创建时间
    $("#createTime").text(new Date().Format("yyyy-MM-dd HH:mm:ss"));
    //订单明细
    $("#pNum").text(getQueryVariable("pNum"));
    //订单总额
    $(".money").text(getQueryVariable("money"));
}

//获得url 上面的参数
function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}

Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "H+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

var pay = null;
//支付订单
function zf(){
    var orderNumber = $("#orderNumber").text();
    $.post("/OrderController/updateOrder",{"pay":pay,"orderNumber":orderNumber},function(){},"json");
}

//单机单选框
function onClickPay(){
    $("input[name=pay]").click(function(){
        console.log(this.checked);
        $(this).prop("check",this.checked);
        pay = this.value;
        console.log(this.value);
    })
}
