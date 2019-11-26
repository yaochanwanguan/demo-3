$(".search-product").on("click", function () {
    $(".search-product").addClass("font-aqua");
    $(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function () {
    $(".search-service").addClass("font-aqua");
    $(".search-product").removeClass("font-aqua");
})

$(".banner a").on("click", function (event) {
    $(".banner a").removeClass("border-b");
    $(event.target).addClass("border-b");
})

$(".content-nav li").on("click", function (event) {
    $(".content-nav a").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})

function sendCar(){
    console.log("开始结算");
    $.post("/OrderController/createOrder",{},function(result){
        var urlData = "&orderNumber=" + result.orderNumber + "&createTime=" + result.createTime + "&money=" + result.money + "&pNum=" + result.pNum;
        location = "redirect?page=e-commerce_settlement" + urlData;
    },"json");
}

/*
 * 展示
 */
$(function () {
    var serviceId;
    var num;
    var sum = 0;

    var id = $.cookie("USER");
    $.ajax({
        type: "get",
        url: "/cart/usercart",
        data: {
            id: id,
            serviceId: serviceId,
            num: num,
        },
        dataType: "json",
        success: function (data) {
            console.log("成功返回的数据", data);
            $(".user_cellphone").html(data.user.user_name);
            $(".cartNum").html(data.cartNum);
            $("#totalPrice").html(data.totalPrice);

            $("#userCart").html("");

            // document.getElementById("cartNum").innerText=data.cartNum;
            var htmls = "";
            $.each(data.cartList, function () {
                htmls += '<ul class="merchandise"><li>\n' +
                    '            <li><img src="'+this.product_picture+'" width="50px" height="50px"  alt="图片">' + this.provider_name + '</li>\n' +
                    '            <li>' + this.service_name + '</li>\n' +
                    '            <li>' + this.unit_price + '</li>\n' +
                    '            <li>\n' +
                    '                <span onclick="reducenum(' + this.id + ',1,this)">-</span>\n' +
                    '                <input type="text"  width="90px" id = "buyNum" class="order1" value="' + this.buy_num + '" name="order1"\n' +
                    '                       onblur="reducenum(' + this.id +',3,this)"/>\n' +
                    '                <span onclick="reducenum(' + this.id + ',2,this)">+</span>\n' +
                    '            </li>\n' +
                    '            <li>' + this.sum + '</li>\n' +
                    '            <li>\n' +
                    '                <span onclick="delcart(' + this.id + ')">删除</span>\n' +
                    '            </li></ul>';
            });
            $("#userCart").html(htmls);
        },
        error: function (data) {
            console.log("失败后返回的数据", data);
        }
    })
})


/*
 * 删除
 */
function delcart(serviceId,obj) {
    console.log("删除： " + serviceId);

    var id = sessionStorage.getItem("id");
    $.ajax({
        type: "get",
        url: "/cart/delcart",
        data: {
            serviceId: serviceId,
        },
        dataType: "json",
        success: function (data) {
            console.log("成功返回的数据", data);
            location.reload();
        }

    })
}


/*
 * 减少
 */
function reducenum(cartId, zhuangtai,obj) {

    var id = $.cookie("USER");
    var num = 0;
    if(zhuangtai == 1){
         num = $($(obj).next()).val();
        num = parseInt(num) - 1;
        $($(obj).next()).val(num);
    }else if(zhuangtai == 2){
        num = $($(obj).prev()).val();
        num = parseInt(num) + 1;
        $($(obj).prev()).val(num);
    }else if(zhuangtai == 3){
        num = $(obj).val();
    }


    console.log(num);
    if (num < 1) {
        alert("数量不能小于1");
    } else {
        $.ajax({
            type: "get",
            url: "/cart/reducenum",
            data: {
                id: cartId,
                by_num: num,
                status:"jian",
            },
            dataType: "json",
            success: function (data) {
                console.log("成功返回的数据", data);

            }

        })}
    location.reload();
    }


    /*
     * 增加
     */
    function addnum(cartId, byNum,obj) {

        var id = $.cookie("USER");
        var num = $($(obj).next()).val();
        num = parseInt(num) + 1;
        $($(obj).next()).val(num);
        console.log(num);
        if (num < 1) {
            alert("数量不能小于1");
        } else {
            $.ajax({
                type: "get",
                url: "/cart/reducenum",
                data: {
                    id: cartId,
                    by_num: num,
                    status:"jian",
                },
                dataType: "json",
                success: function (data) {
                    console.log("成功返回的数据", data);
                    $.ajax({

                    });
                }

            })}
    }

    /*
     * 手动输入数量
     */
    function changenum(serviceId) {
        console.log(serviceId);
        var id = sessionStorage.getItem("id");
        var e = window.event;
        console.log($(e.target).val());
        var orderNum = $(e.target).val();
        console.log(orderNum);

        $.ajax({
            type: "get",
            url: "/cart/reducenum",
            data: {
                serviceId: serviceId,
                orderNum: orderNum,
            },
            dataType: "json",
            success: function (data) {
                console.log("成功返回的数据", data);
                $.ajax({
                    type: "get",
                    url: "/cart/usercart",
                    data: {
                        id: id,
                    },
                    dataType: "json",
                    success: function (data) {
                        console.log("成功返回的数据", data);
                        var userCart = data.car;
                        $("#userCart").html("");
                        var txt = "";
                        for (var i = 0; i < userCart.length; i++) {
                            txt += `
					<p class="shop">店铺：${userCart[i].name}</p>`
                            for (var j = 0; j < userCart[i].productlist.length; j++) {
                                txt += `
		        <ul class="merchandise">
		            <li>
		                <img src="" alt="图片">
		            </li>
		            <li>${userCart[i].productlist[j].serviceName}</li>
		            <li>${userCart[i].productlist[j].unitPrice}</li>
		            <li>
		                <span onclick = "reducenum('${userCart[i].productlist[j].serviceId}', '${userCart[i].productlist[j].buyNum}')">-</span>
		                <input class="order1" value="${userCart[i].productlist[j].buyNum}" name="order1" id="order1" onblur="changenum('${userCart[i].productlist[j].serviceId}')"/>
		                <span  onclick = "addnum('${userCart[i].productlist[j].serviceId}', '${userCart[i].productlist[j].buyNum}')">+</span>
		            </li>
		            <li>
		                ${userCart[i].productlist[j].unitPrice * userCart[i].productlist[j].buyNum}
		            </li>
		            <li>
		                <span  onclick = "delcart('${userCart[i].productlist[j].serviceId}')">删除</span>
		            </li>
		        </ul>
		        `
                            }
                        }
                        txt += `<ul class="price">
		            <li>金额合计<span>3242</span></li>
		            <li>
		                <a href="redirect?page=e-commerce_product">继续购物</a>
		                <button href="" >去结算</button>
		            </li>
		        </ul>`
                        //console.log(txt);

                        $("#userCart").html(txt);
                    },
                    error: function (data) {
                        console.log("失败后返回的数据", data);
                    }
                })
            }

        })
    }