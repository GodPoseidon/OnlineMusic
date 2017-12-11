$(function(){
	$("#btnLogin").click(btnLogin);
});
function btnLogin(){
	var email=$.trim($("#email").val());
	var password=$.trim($("#password").val());
	
	if(email==""||password==""){
		alert("邮箱和密码不能为空");
		return;
	}
}