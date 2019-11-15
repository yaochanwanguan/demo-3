$(".login-btn").on("click", function(){
	var cellphone=$(".cellphone").val();
	var password=$(".password").val();
	var inputCode=$(".inputcode").val();
	console.log(cellphone,password);
	$.ajax({
		   type:"post",
		   url:"/sysuser/userlogin",
		   data:{
			   cellphone:cellphone,
			   password:password,
			   inputCode:inputCode,
		   },
		   dataType:"json",
		   success:function(data){
			   
			   console.log("成功后返回的数据",data);
			   if(data.adm=="登陆成功"){
				  location.href="redirect?page=e-commerce_product.html"
			   }else{
				   alert(data.adm);
			   }
		   }
	})
	
})
$(function(){
	var time=new Date().getTime();
	$(".codeimg").attr("src","imgGetCode?t="+time);
})
function imgChange(){
	var time=new Date().getTime();
	$(".codeimg").attr("src","imgGetCode?t="+time);
}
