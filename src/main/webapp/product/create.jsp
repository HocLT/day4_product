<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
</head>
<body>
	<h1>Create Product</h1>
	<form action="${pageContext.request.contextPath}/Controller?a=Create" method="post">
		<div>Name: <input name="name"/></div>
		<div>Price: <input name="price"/></div>
		<div><input type="submit" value="Create"/></div>
	</form>
</body>
</html>