$(function(){
	$("#btnRegister").click(btnRegister);
	
});

function btnRegister(){
	var flag=true;
	$(".input").each(function(){
		if($(this).val()==""){
			flag=false;
		}
	});
	if(flag==false){
		return flag;
	}
}