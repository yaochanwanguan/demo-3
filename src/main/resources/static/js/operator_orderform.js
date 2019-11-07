$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})
$(".business-order").on("click", function(){
    $(".main-content").show();
    $("table").show();
    $(".main-sercive").hide();
    $(".business-order").addClass("border-red");
    $(".service-order").removeClass("border-red");
    $(".main-top li").eq(3).text("业务订单");
 	   $.ajax({
 		   type:"post",
 	       url:"/sysuser/orderlist",
 	 /* data:{
 		   id:5,
 	   },*/
 	   dataType:"json",
 	   success:function(data){
 		   console.log("成功返回数据",data);
 		   var orderInfo = data.orderInfo
 		   //$('#table').html("");
 		   var txt="";
 		   for(var i=0;i<orderInfo.length;i++){
 			   txt +=`<tr>
 			   <td>${orderInfo[i].orderNumber}</td>
 			   <td>${orderInfo[i].userBuy}</td>
 			   <td>${orderInfo[i].orderContent}</td>
 			   </tr>`;
 		   }
 		  console.log(txt);
 		   //$('#table').append(txt);
 	   },
 	   error:function(data){
 		   console.log("失败返回数据",data);
 	   }
 	   })
    
})
$(".service-order").on("click", function(){
    $(".main-content").hide();
    $("table").hide();
    $(".main-sercive").show();
    $(".service-order").addClass("border-red");
    $(".business-order").removeClass("border-red");
    $(".main-top li").eq(3).text("服务订单");
})