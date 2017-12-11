<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="base.jsp" %>
<link style="text/css" rel="stylesheet" href="css/style.css">
<title>上传</title>
</head>
<body>
	<div id="up">
		<div id="content">
		<form action="person/upsong" method="post" enctype="multipart/form-data">
			<div>
				<span>歌曲名称：</span><input type="text" name="song">
			</div>
			<div>
				<span>歌&nbsp;&nbsp;手：</span><input type="text" name="singer">
			</div>
			<div>
				<span>专&nbsp;&nbsp;辑：</span><input type="text" name="special">
			</div>
			<div>
				<span>文件上传：</span><input type="file" name="file"><span
				style="color: red;">${ requestScope.message }</span>
			</div>
			<div>
				<input type="submit" value="上 传">
			</div>
			</form>
		</div>
	</div>
</body>
</html>