<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
</head>
<body>
	<h1>登录</h1>
	<form action="j_spring_security_check" method="post">
		<table>
			<tr>
				<td>用户:</td>
				<td><input type='text' name='j_username' /></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="_spring_security_remember_me" /></td>
				<td>Don't ask for my password for two weeks</td>
			</tr>
			<tr>
				<td><input name="reset" type="reset" /></td>
				<td><input name="submit" type="submit" /></td>
			</tr>
		</table>
	</form>

</body>
</html>