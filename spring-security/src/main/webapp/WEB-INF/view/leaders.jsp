<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leadership Panel</title>
</head>
<body>
	<h2>
		Welcome
		<security:authentication property="principal.username" />
	</h2>
	<hr>

	<p>Message .... posted here for leaders to read.</p>
	<hr>
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
</body>
</html>