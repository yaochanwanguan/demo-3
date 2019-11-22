var USER;
$(".login-btn").on("click", function(){
	var cellphone=$(".cellphone").val();
	var password=$(".password").val();
	var inputCode=$(".inputcode").val();
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
		       if(data.adm=="success"){
		           USER = new Object( data.user);
				  location.href="redirect?page=e-commerce_product.html"
               }else if(data.adm == "failure"){
                   alert("登录失败，请重新登陆!(账号或密码错误)");
				   return;
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
