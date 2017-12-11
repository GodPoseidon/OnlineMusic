<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登 录</title>
<%@ include file="base.jsp"%>
<script type="text/javascript" src="script/jquery-1.11/jquery-1.11.1.js"></script>
<script type="text/javascript" src="script/login.js"></script>
<link rel="stylesheet" href="css/login.css"></link>
<script type="text/javascript">
	if (window != top) {
		top.location.href = location.href;
	}
</script>
</head>
<body>
	<div class="center">
		<form action="login" method="post">
			<div>
				<span>邮箱：</span> <input type="text" name="email" id="email"
					value="${requestScope.account}"><span>${requestScope.error}</span>
			</div>
			<div>
				<span>密码：</span> <input type="password" name="password"
					id="password"></input><span></span>
			</div>
			<div>
				<input type="submit" value="登 录" id="btnLogin"></input><span><a
					href="register">免费注册</a></span>
			</div>
		</form>
	</div>
</body>
</html>