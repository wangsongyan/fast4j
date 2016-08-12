<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<form method="post" action="${contextPath}/test/submitForm">
		<input type="hidden" name="token" value="${token!}">
		<input name="tel">
		<input name="address">
		<input type="submit" value="提交">
	</form>
</body>
</html>