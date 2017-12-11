<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="base.jsp" %>
<link style="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="script/jquery-1.11/jquery-1.11.1.js"></script>
<script type="text/javascript" src="script/index.js"></script>
<title>主页</title>
</head>
<body>
	<div id="main">
		<div id="head">
			<div class="left">
				<span>欢迎来到我的音乐网站！</span>
			</div>
			<div class="right">
				<a href="usercancel">注销</a>
			</div>
			<div class="clear"></div>

		</div>
		<div id="middle">
		<div>
		<input type="button" value="所有歌曲" id="allSong">
		<input type="button" value="我的歌曲" id="mySong">
		<input type="button" value="我的收藏" id="myCollect">
		</div>
		</div>
		<div id="footer">
		<iframe name="frame" src="person/allsong" frameborder="1" id="iframe"> </iframe>
		</div>
	</div>
</body>
</html>