<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"></meta>
<title>Insert title here</title>
</head>
<body>
<span><font color="red">${errorMessage!}</font></span>
<form action="/register" method="POST">
  <input type="hidden" name="oAuthType" value="${(oAuthInfo.oAuthType)!}"></input>
  <input type="hidden" name="oAuthId" value="${(oAuthInfo.oAuthId)!}"></input>
  <input type="text" name="userName" value="${(oAuthInfo.user.username)!}"></input>
  <input type="password" name="password" ></input>
  <input type="submit" value="提交"></input>
</form>
</body>
</html>