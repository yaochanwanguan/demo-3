$(".search-product").on("click", function () {
    $(".search-product").addClass("font-aqua");
    $(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function () {
    $(".search-service").addClass("font-aqua");
    $(".search-product").removeClass("font-aqua");
})
/*$(".login-btn .font-aqua").on("click",function () {
    var newpassword = $(".newpassword").val();
    var renewpassword=$(".renewpassword").val();
    var id = $.cookie("USER")
    if(newpassword == renewpassword){
        $.ajax({
            type:"post",
            url:"/sysuser/updateUser",
            data:{
                id:id,
                querenpassword:renewpassword,
            },
            dataType:"json",
            success:function(data){
                console.log("成功返回的数据",data);
                if(data.adm == "用户设置成功"){
                    location.href="redirect?page=e-commerce_login";
                    alert("用户设置成功");
                }else{
                    alert(data.adm);
                }
            }
        })
    }else{
        alert("密码不一致，请重新输入！");
    }
})*/
$(function(){
    var time=new Date().getTime();
    $(".codeimg").attr("src","imgGetCode?t="+time);
})
$(".banner a").on("click", function (event) {
    $(".banner a").removeClass("border-b");
    $(event.target).addClass("border-b");
})

$(".user-action a").on("click", function (event) {
    $(".user-action a").removeClass("bg-gray");
    $(event.target).addClass("bg-gray");
})
$(".content-nav li").on("click", function (event) {
    $(".content-nav li").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})

$(".content-banner li").eq(0).on("click", function (event) {
    $(".content-banner li").removeClass("border-b1");
    $(event.target).addClass("border-b1");
    $(".change-password").hide();
    $(".account-info").show();
})
$(".content-banner li").eq(1).on("click", function (event) {
    $(".content-banner li").removeClass("border-b1");
    $(event.target).addClass("border-b1");
    $(".change-password").show();
    $(".account-info").hide();
})
