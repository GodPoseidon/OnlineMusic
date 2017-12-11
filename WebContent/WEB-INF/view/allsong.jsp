<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="base.jsp"%>
<link style="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="script/jquery-1.11/jquery-1.11.1.js"></script>
<script type="text/javascript" src="script/allsong.js"></script>
<title>所有歌曲</title>
</head>
<body>
	<div id="all">
		<div id="head">
			<table border="1">
				<tr>
					<td>序号</td>
					<td>歌名</td>
					<td>专辑</td>
					<td>歌手</td>
					<td>上传人</td>
					<td>上传时间</td>
					<td>操作</td>
				</tr>
				<c:forEach var="item" items="${requestScope.songlist }" varStatus="st">
				<tr>
					<td>${st.index+1 }</td>
					<td>${item.song}</td>
					<td>${item.special}</td>
					<td>${item.singer}</td>
					<td>${item.nname}</td> 
					<td><fmt:formatDate value="${item.upLoadDate }"  pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td><a href="person/play?songid=${item.id}" class="play">播放</a><a href="download?songid=${item.id}">下载</a><a href="#" id="${item.id}" class="collect">收藏</a></td>
				</tr></c:forEach>
			</table>
		</div>
		<div id="middle">
			<span>${requestScope.pageIndex}/${requestScope.totalPage}</span>
		</div>
		<div id="footer">
		<form action="person/allsong" method="post">
		<input type="hidden" id="pageIndex" name="pageIndex" value="${requestScope.pageIndex}">
		<input type="hidden" id="totalPage" value="${requestScope.totalPage}" >
			<a href="#" class="page" id="first">首页</a> 
			<a href="#" class="page" id="previou">上一页</a>
			<a href="#" class="page" id="next">下一页</a> 
			<a href="#" class="page" id="last">尾页</a>
		</form>
		</div>
	</div>
</body>
</html>