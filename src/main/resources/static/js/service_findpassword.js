$(".login-btn font-aqua").on("click", function(){
		var cellphone = $(".cellphone").val();
		var inputCode = $(".inputcode").val();
		var password = $(".password").val();
		var querenpassword=$(".querenpassword").val();
		if(password==querenpassword){
		console.log(cellphone, password, inputCode,querenpassword);
		$.ajax({
			type:"post",
			url:"/sysuser/userfind",
			data:{
				
				cellphone:cellphone,
				inputCode:inputCode,
				password:password,
				querenpassword:querenpassword,
			},
			dataType:"json",
			success:function(data){
				console.log("成功返回的数据",data);	
				if(data.adm == "修改密码成功"){
					 location.href="redirect?page=service_login";
					 alert("修改成功");
				}else{
					alert(data.adm);
				}	
			}
		})
		}else{
			alert("密码不一致，请重新输入！");
		}
	})
	$(function(){
	var time=new Date().getTime();
	$(".codeimg").attr("src","imgGetCode?t="+time);
})
function imgChange(){
	var time=new Date().getTime();
	$(".codeimg").attr("src","imgGetCode?t="+time);
}