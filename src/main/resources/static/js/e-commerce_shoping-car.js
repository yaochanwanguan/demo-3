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

$(".content-nav li").on("click", function(event){
    $(".content-nav a").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})
$(function(){
	var id = sessionStorage.getItem("id");
	$.ajax({
		type:"get",
		url:"/cart/usercart",
		data:{
			id:id,
		},
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);	
			var userCart = data.car;
			$("#userCart").html("");
			var txt = "";
			for(var i=0; i<userCart.length;i++){
			txt += `
			<p class="shop">店铺：${userCart[i].name}</p>`
			for(var j=0;j<userCart[i].productlist.length;j++){
			txt+=`
        <ul class="merchandise">
            <li>
                <img src="" alt="图片">
            </li>
            <li>${userCart[i].productlist[j].serviceName}</li>
            <li>$${userCart[i].productlist[j].unitPrice}</li>
            <li>
                <span>-</span>
                <input value="1" />
                <span>+</span>
            </li>
            <li>
                $${userCart[i].productlist[j].sum}
            </li>
            <li>
                <span>删除</span>
            </li>
        </ul>
        `
		}
			}
			txt += `<ul class="price">
            <li>金额合计<span>3242</span></li>
            <li>
                <a href="redirect?page=e-commerce_product">继续购物</a>
                <a href="redirect?page=e-commerce_settlement">去结算</a>
            </li>
        </ul>`
//console.log(txt);
			
			$("#userCart").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
})