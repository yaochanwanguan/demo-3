$(".search-product").on("click", function(){
    $(".search-product").addClass("font-aqua");
    $(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function(){
    $(".search-service").addClass("font-aqua");
    $(".search-product").removeClass("font-aqua");
})

$(".banner a").on("click", function(event){
    $(".banner a").removeClass("border-b");
    $(event.target).addClass("border-b");
})

$(".user-action a").on("click", function(event){
    $(".user-action a").removeClass("bg-gray");
    $(event.target).addClass("bg-gray");
})
function pay(){
    location.href="e-commerce_settlement.html";
}

$(function(){
    $.ajax({
        type: "get",
        url: "/OrderController/queryAll",
        dataType: "json",
        success: function (data) {
            console.log("成功返回的数据", data);
            $(".user_cellphone").html(data.user.user_name);
            $(".cellphone").html(data.user.cellphone);
            $("#totalPrice").html(data.totalPrice);

            $("#orderLists").html("");
            var htmls = "";
            $.each(data.orderList, function () {
                if (this.status == 2) {
                    htmls+= '<div class="orders">\n' +
                        '                <div class="order-num">订单号：'+this.orderNumber+' 下单时间：'+this.createTime+'</div>\n' +
                        '                <ul class="order-details">\n' +
                        '                    <li>\n' +
                        '                        <ul>\n' +
                        '                            <li>'+this.orderContent+'</li>\n' +
                        '                        </ul>\n' +
                        '                    </li>\n' +
                        '                    <li class="font-aqua">'+this.orderMount+'</li>\n'+
                        '                    <li class="font-aqua">已付款</li>\n' +
                        '                    <li>交易完成</li>\n' +
                        '                </ul>\n' +
                        '            </div>';
                }else{
                   htmls+= '<div class="orders">\n' +
                    '                <div class="order-num">订单号：'+this.orderNumber+' 下单时间：'+this.createTime+'</div>\n' +
                    '                <ul class="order-details">\n' +
                    '                    <li>\n' +
                    '                        <ul>\n' +
                    '                            <li>'+this.orderContent+'</li>\n' +
                    '                        </ul>\n' +
                    '                    </li>\n' +
                    '                    <li class="font-aqua">'+this.orderMount+'</li>\n'+
                    '                    <li class="font-aqua">未支付</li>\n' +
                        '                    <li>交易未完成</li>\n' +
                        '                </ul>\n' +
                        '            </div>';
                }
            });
            $("#orderLists").html(htmls);
        },
        error: function (data) {
            console.log("失败后返回的数据", data);
        }
    })


    /*$.get("",{},function(result){
        console.log(result);
        var html = null;
        $.each(result, function () {
            html = '<div class="orders">\n' +
                '                <div class="order-num">订单号：'+this.orderNumber+' 下单时间：'+this.createTime+'</div>\n' +
                '                <ul class="order-details">\n' +
                '                    <li>\n' +
                '                        <img src="'+this.img+'" alt="图片">\n' +
                '                        <ul>\n' +
                '                            <li>'+result.orderContent+'</li>\n' +
                '                            <li>'+result.buy_num+'' +
                '                        </ul>\n' +
                '                        <p>¥500.00</p>\n' +
                '                        <p>1</p>\n' +
                '                    </li>\n' +
                '                    <li class="font-aqua">'+result.orderMount+'</li>\n' +
                '                    <li class="font-aqua">已付款</li>\n' +
                '                    <li>交易完成</li>\n' +
                '                </ul>\n' +
                '            </div>';

        });
        // if(result.status == 2){
        //     html = '<div class="orders"><div class="order-num"><span>订单号：'+result.orderNumber+'</span> 下单时间：'+result.createTime+'</div> <ul class="order-details"> <li> <img src="'+result.img+'" alt="图片"> <ul> <li>'+result.orderContent+'</li> <li>'+result.buy_num+'</li> </ul> <p>'+result.orderMount+'</p> <p>1</p> </li> <li class="font-aqua">'+result.orderMount+'</li> <li class="font-aqua">已付款</li> <li></li> </ul></div>';
        // }else{
        //     html =  '<div class="orders"><div class="order-num"><span>订单号：'+result.orderNumber+'</span> 下单时间：'+result.createTime+'</div> <ul class="order-details"> <li> <img src="'+result.img+'" alt="图片"> <ul> <li>'+result.orderContent+'</li> <li>'+result.buy_num+'</li> </ul> <p>'+result.orderMount+'</p> <p>1</p> </li> <li class="font-aqua">'+result.orderMount+'</li> <li class="font-aqua">未付款</li> <li>未完成</li> </ul></div>'
        // }
        $("#orderLists").html(html);*/
})