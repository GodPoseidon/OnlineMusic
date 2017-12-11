<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="base.jsp"%>
<link rel="stylesheet" href="css/register.css">
<script type="text/javascript" src="script/jquery-1.11/jquery-1.11.1.js"></script>
<script type="text/javascript" src="script/register.js"></script>
<title>注册</title>
</head>
<body>
	<div class="center">
		<form action="register" method="post">
			<div>
				<span>邮&nbsp;&nbsp;箱：</span><input type="text" name="email"
					class="input"><span>${requestScope.emailmsg}</span>
			</div>
			<div>
				<span>昵&nbsp;&nbsp;称: </span><input type="text" name="nname"
					class="input"><span>${requestScope.namemsg}</span>
			</div>
			<div>
				<span>密&nbsp;&nbsp;码：</span><input type="password" name="password"
					class="input"><span>${requestScope.passwordmsg}</span><span>${requestScope.pwdmsg}</span>
			</div>
			<div>
				<span>确认密码：</span><input type="password" name="password1"
					class="input"><span>${requestScope.password1msg}</span>
			</div>
			<div>
				<input type="submit" value="注册" id="btnRegister">
			</div>

		</form>

	</div>
</body>
</html>