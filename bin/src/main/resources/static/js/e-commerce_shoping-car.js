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
//减少
function reducenum(id){
	var e= window.event;
	var buy_num=$(".buy_num").val();
	console.log(service_id,buy_num)
			   $.ajax({
				   type:"POST",
				   url:"/sysuser/number",
				   data:{
					   serviceId:serviceId,
					   buy_num:buy_num,
				   },
				   dataType:"json",
				   success:function(data){
					   if(data.code==1){
						
							$(e.target).next().val($(e.target).next().val()-1)		
							
					   }
				   }
				   
	   })
}

//增加
function addnum(id){
	var e= window.event;
	$(e.target).prev().val(+$(e.target).prev().val()+1);
}
function changenum(id){
	console.log("失焦触发")
	var e= window.event;
	console.log($(e.target).val());
	
}