<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<@shiro.guest>
	亲爱的游客欢迎您！
	</@shiro.guest>
	<@shiro.authenticated>
	您已登录
	</@shiro.authenticated>
	<form method="post">
		<input name="userName">
		<input name="password" type="password">
		<input type="submit" value="登录">
	</form>
</body>
</html>