$(".login-btn").on("click", function(){
		var user_name = $(".user_name").val();
		var cellphone = $(".cellphone").val();
		var inputCode = $(".inputcode").val();
		var password = $(".password").val();
		var province = $("#province").val();
		var city = $("#city").val();
		var area = $("#area").val();
		if(user_name == ""){
			alert("用户名为空！");
			return;
		}
		if(cellphone == ""){
			alert("电话号为空！");
			return;
		}
		if(password == ""){
			alert("密码为空！");
			return;
		}
		console.log(user_name, cellphone, password, inputCode,province, city , area);
		$.ajax({
			type:"post",
			url:"/sysuser/userregister",
			data:{
				user_name:user_name,
				cellphone:cellphone,
				inputCode:inputCode,
				password:password,
				province:province,
				city:city,
				area:area
			},
			dataType:"json",
			success:function(data){
				console.log("成功返回的数据",data);	
				if(data.adm == "注册成功"){
					 location.href="redirect?page=e-commerce_login";
					 alert("注册成功");
				}else{
					alert(data.adm);
				}	
			}
		})
	})
	
	$(function(){
	$.ajax({
		type: "post",
		url: "/region/register",
		dataType: "json",
		success: function(data){
			var province = data.province;
			console.log("成功后返回的数据",province);
			$("#province").html("");
			txt="";
			txt +=`<option value="">省</option>`
			for(var i = 0;i<province.length;i++){
				txt +=`<option onclick="provinceId('${province[i].id}')"  value="${province[i].id}">${province[i].name}</option>`
			}
			$("#province").append(txt);
			$("#city").html("");
			txt="";
			txt +=`<option value="">市</option>`
			$("#city").append(txt);
			$("#area").html("");
			txt="";
			txt +=`<option value="">区</option>`
			$("#area").append(txt);
			
		},
		error: function(data){
			console.log("失败后返回的数据",data);
		}
	})
})

function changeprovince(){
	var provinceId = $("#province").val();
	console.log("省",provinceId);
	$.ajax({
		type: "post",
		url: "/region/city",
		data:{
			provinceId:provinceId,
		},
		dataType: "json",
		success: function(data){
			var city = data.city;
			$("#city").html("");
			txt="";
			txt +=`<option value="">市</option>`
			for(var i = 0;i<city.length;i++){
				txt +=`
                        <option class="cityId" value="${city[i].id}">${city[i].name}</option>`
			}
			$("#city").append(txt);
			$("#area").html("");
			txt="";
			txt +=`<option value="">区</option>`
			$("#area").append(txt);
		},
		error: function(data){
			console.log("失败后返回的数据",data);
		}
	})
}


function changecity(){
	var cityId = $("#city").val();
	console.log("市id",cityId);
	$.ajax({
		type: "post",
		url: "/region/area",
		data:{
			cityId:cityId,
		},
		dataType: "json",
		success: function(data){
			var area = data.area;
			$("#area").html("");
			txt="";
			txt +=`<option value="">区</option>`
			for(var i = 0;i<area.length;i++){
				txt +=`
                        <option class="areaId" value="${area[i].id}">${area[i].name}</option>`
			}
			$("#area").append(txt);
			
		},
		error: function(data){
			console.log("失败后返回的数据",data);
		}
	})
}
$(function(){
	var time=new Date().getTime();
	$(".codeimg").attr("src","imgGetCode?t="+time);
})
function imgChange(){
	var time=new Date().getTime();
	$(".codeimg").attr("src","imgGetCode?t="+time);
}

