<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"></meta>
<title>Insert title here</title>
</head>
<body>
    <#list oAuthServices as oAuthService>
  	<a href="${oAuthService.authorizationUrl}">github</a>  
    </#list>
</body>
</html>