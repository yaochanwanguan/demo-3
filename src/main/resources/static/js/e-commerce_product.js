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
    $(".content-nav li").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})

$(function () {
<<<<<<< HEAD
	 /*$("#userName").value(USER)*/
=======
>>>>>>> e73093061466a054fd7493cc24cb49c316a8effa
	$.ajax({
		   type:"get",
	       url:"/ServingProduct/ServingProductlist",
	   dataType:"json",
	   success:function(data){
		   console.log("成功返回数据",data);
		   var ServingProductList = data;
		   var txt="";
		  //date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate()
           for(var i=0;i<ServingProductList.length;i++){
               txt +=`<div class="article">
            <img src="${ServingProductList[i].productPicture}" alt="图片" />
            <ul class="article-info">
                <li>${ServingProductList[i].serviceName}</li>
                <li>${ServingProductList[i].serviceInfo}</li>
                <li>${ServingProductList[i].providerName}</li>
            </ul>
            <ul class="article-price">
                <li>${ServingProductList[i].unitPrice}</li>
                <li>
                    <a href="redirect?page=e-commerce_settlement.html">立即购买</a>
                    <span onclick="cartadd('${ServingProductList[i].id}')">加入购物车</span>
                </li>
            </ul>
        </div>
        <hr color="#ededed" size="1">`;


           }
		   $(".content").html(txt);
	   },
	   error:function(data){
		   console.log("失败返回数据",data);
	   }
	   })

})
//加入购物车
function cartadd(serviceId){
	var id = $.cookie("USER");
	console.log("添加商品 ：",serviceId);
	$.ajax({
		type:"get",
					url:"/cart/cartadd",
					data:{
						serviceId:serviceId,
						id:id,
					}, 
					dataType:"json",
					success:function(data){
						console.log("成功返回的数据",data);
						$.ajax({
							type:"get",
							url:"/ServingProduct/ServingProductlist",
							dataType:"json",
							 success:function(data){
								   console.log("成功返回数据",data);
<<<<<<< HEAD
								   alert("添加成功")
=======
								   var ServingProductList = data.ServingProductList
								   var txt="";
								  //date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate()
								   for(var i=0;i<ServingProductList.length;i++){
									   txt +=`<div class="article">
						            <img src="" alt="图片" />
						            <ul class="article-info">
						                <li>${ServingProductList[i].serviceName}</li>
						                <li>${ServingProductList[i].serviceInfo}</li>
						                <li>${ServingProductList[i].providerName}</li>
						            </ul>
						            <ul class="article-price">
						                <li>${ServingProductList[i].unitPrice}</li>
						                <li>
						                    <a href="redirect?page=e-commerce_settlement.html">立即购买</a>
						                    <span onclick="cartadd('${ServingProductList[i].id}')">加入购物车</span>
						                </li>
						            </ul>
						        </div>
						        <hr color="#ededed" size="1">`;
									   
									   
								   }
								   $(".content").html(txt);
>>>>>>> e73093061466a054fd7493cc24cb49c316a8effa
							   },
							   error:function(data){
								   console.log("失败返回数据",data);
								}
						})
					}
	})
}