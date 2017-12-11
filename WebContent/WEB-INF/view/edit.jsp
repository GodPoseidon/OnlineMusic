<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="base.jsp" %>
<link style="text/css" rel="stylesheet" href="css/style.css">
<title>编辑</title>
</head>
<body>
	<div id="edit">
		<div id="content">
		<form action="person/edit"	method="post">
		<input type="hidden" name="id" value="${requestScope.song.id}">
		<div><span>歌曲名称：</span><input type="text" name="song" value='${requestScope.song.song}' ></div>
		<div><span>歌&nbsp;&nbsp;手：</span><input type="text" name="singer" value='${requestScope.song.singer}'></div>
		<div><span>专&nbsp;&nbsp;辑：</span><input type="text" name="special" value='${requestScope.song.special}'></div>
		<div><input type="submit" value="保 存"></div>
		</form>
		</div>
	</div>
</body>
</html>