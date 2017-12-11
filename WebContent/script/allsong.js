$(function() {

	$(".play").click(function() {
		var url = $(this).attr("href");

		url += "&returnUrl=" + window.location.href;
		$(this).attr("href", url);
	});

	$(".page").click(pageClick);
	
	//收藏歌曲
	$(".collect").click(function(){
		var a=$(this);
		
		$.ajax({
			type:"get",
			url:"person/collectsong",
			data:{songid:a.attr("id")},
			success:function(data){
				alert(data);
			}
		});
		
		return false;
	});
});

// 分页操作
function pageClick() {
	var pageIndex = $("#pageIndex").val();
	var totalPage = $("#totalPage").val();
	var id = $(this).attr("id");

	if (id == "first") {
		$("#pageIndex").val(1);
		$("form").submit();
	} else if (id == "previou") {
		if (pageIndex > 1) {
			$("#pageIndex").val(parseInt(pageIndex) - 1);
			$("form").submit();
		}
	} else if (id == "next") {
		if (pageIndex < totalPage) {
			$("#pageIndex").val(parseInt(pageIndex) + 1);
			$("form").submit();
		}
	} else if (id == "last") {
		$("#pageIndex").val(parseInt(totalPage));
		$("form").submit();
	}

	return false;
}