<%@page import="com.iflysse.onlinemusic.po.Song"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="base.jsp" %>
<link style="text/css" rel="stylesheet" href="css/style.css">
<link style="text/css" rel="stylesheet" href="css/common.css">
<title>Insert title here</title>
</head>
<body>
	<div id="edit">
		<div id="content">
		<form action="person/play" method="post" >
			<div>
				<span>歌曲名称：</span><span>${requestScope.song.song}</span>
			</div>
			<div>
				<span>歌&nbsp;&nbsp;手：</span><span>${requestScope.song.singer}</span>
			</div>
			<input type="hidden" name="returnUrl" value="${requestScope.returnUrl}">
			<div>
				<span>专&nbsp;&nbsp;辑：</span><span>${requestScope.song.special}</span>
			</div>
			<div>
				<embed
					src="css/CuMp3PlayerV1.swf?musicfile=file/${requestScope.song.path}&musictitle=${requestScope.song.song}"
					width="446" height="68" quality="high" swLiveConnect=true
					name="CuPlayer" align="middle" allowScriptAccess="sameDomain"
					type="application/x-shockwave-flash"
					pluginspage="http://www.macromedia.com/go/getflashplayer"
					allowfullscreen="true" /></embed>
			</div>
			<div>
				<input type="submit" value="关 闭">
			</div>
			</form>
		</div>
	</div>
</body>
</html>